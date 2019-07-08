# FrameWorkJAVA.SpringMVC.FileUpload

## 1.简介

### 方法

#### 1.传统方法

<!--Contronller.java-->

```java
/*
   1.传统方式文件上传
    */
    @RequestMapping("fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        // 使用fileupload组件进行上传
        // 上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断该路径是否存在，不存在则新建文件夹
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        // 解析request对象，获取上传项目并指定存储位置
        DiskFileItemFactory factory = new DiskFileItemFactory();    // 将请求消息实体中的每个项目封装成对象
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);   // 创建一个上传工具，指定使用缓存区和临时文件位置
        // 解析request
        List<FileItem> items = servletFileUpload.parseRequest(request);
        // 遍历对象
        for (FileItem item:items
        ) {
            //  获取上传文件夹名称
            String fileName = item.getName();
            //  获取一个唯一id值，赋值给文件名，保证文件名的唯一性
            String uuid = UUID.randomUUID().toString().replace("-", "");
            fileName = uuid+"_"+fileName;
            //  保存文件
            item.write(new File(path,fileName));
            //  清除缓存中文件
            item.delete();
        }
        return "success";
    }
```

<!--Index.jsp-->

```jsp
<%--1.传统方式上传文件--%>
    <h3>1.传统方式上传文件</h3>
    <form action="/file/fileUpload1" method="post" enctype="multipart/form-data">
        文件上传：<input type="file" name="upload"/>
        <input type="submit" value="上传"/>
    </form>
```

#### 2.SpringMVC方法

- 核心点：使用框架提供的文件解析器，完成请求中文件的解析

- 注意点：处理器中获取的 MultipartFile对象名称需要和前端js中上传组件的name值保持一致

  <!--Contronller.java-->

  ```java
   /*
      2.Springmvc方式上传文件
       */
      @RequestMapping("fileUpload2")
      // MultipartFile的参数名称需要和前端提交的name一致
      public String fileUpload2(HttpServletRequest request, MultipartFile upload)
          throws IOException {
          // 确认上传位置
          String path = request.getSession().getServletContext().getRealPath("/uploads/");
          File file = new File(path);
          if (!file.exists()){
              file.mkdirs();
          }
          // 原来的解析工作已经由springmvc的配置文件中的文件解析器完成
          // 获取上传名称
          String fileName = upload.getOriginalFilename();
          String uuid = UUID.randomUUID().toString().replace("-", "");
          fileName = uuid+"_"+fileName;
          upload.transferTo(new File(path,fileName));
          return "success";
      }
  ```

  <!--Index.jsp-->

  ```jsp
  <%--2.SpringMVC方式上传文件--%>
      <h3>2.SpringMVC方式上传文件</h3>
      <form action="/file/fileUpload2" method="post" enctype="multipart/form-data">
          文件上传：<input type="file" name="upload"/>
          <input type="submit" value="上传"/>
      </form>
  ```

  <!--springmvc.xml-->

  ```xml
  <!--配置文件解析器-->
      <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
          <!--限制上传文件大小为10M-->
          <property name="maxUploadSize" value="10485760" />
      </bean>
  ```

#### 3.跨服务器上传

- 注意点：需要在tomcat服务器的web.xml文件中增加可读写的许可

  ```xml
  <servlet>
      <servlet-name>default</servlet-name>
      <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>
      <init-param>
          <param-name>debug</param-name>
          <param-value>0</param-value>
      </init-param>
      // 允许读写
      <init-param>
          <param-name>readonly</param-name>
          <param-value>false</param-value>
      </init-param>
      <init-param>
          <param-name>listings</param-name>
          <param-value>false</param-value>
      </init-param>
      <load-on-startup>1</load-on-startup>
  </servlet>
  ```

- 核心点：需要连接服务器

  <!--Contronller.java-->

  ```java
   /*
      3.跨服务器上传文件
       */
      // MultipartFile的参数名称需要和前端提交的name一致
      @RequestMapping("fileUpload3")
      public String FileUpload3(MultipartFile upload) throws IOException {
          // 定义上传服务器路径
          String path = "http://localhost:9090/uploads/";
  
          // 原来的解析工作已经由springmvc的配置文件中的文件解析器完成
          // 获取上传名称
          String fileName = upload.getOriginalFilename();
          String uuid = UUID.randomUUID().toString().replace("-", "");
          fileName = uuid+"_"+fileName;
  
          // 创建客户端对象
          Client client = Client.create();
          // 连接图片上传服务器
          WebResource webResource = client.resource(path + fileName);
          // 上传文件
          webResource.put(upload.getBytes());
          return "success";
      }
  ```

  <!--Index.jsp-->

  ```jsp
  <%--3.跨服务器上传文件--%>
      <h3>3.跨服务器上传文件</h3>
      <form action="/file/fileUpload3" method="post" enctype="multipart/form-data">
          文件上传：<input type="file" name="upload"/>
          <input type="submit" value="上传"/>
      </form>
  ```

  









