# FrameWorkJAVA.SpringMVC.FileUpload

## 1.简介

### 方法

#### 1.传统方法

<!--Contronller.java-->

```java
@Controller
@RequestMapping("user")
public class UserHandler {
    /*
    1.传统方式文件上传
     */
    @RequestMapping("fileUpload1")
    public String fileUpload(HttpServletRequest request) throws Exception {
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
}
```

<!--Index.jsp-->

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <%--传统方式上传文件--%>
    <h3>传统方式上传文件</h3>
        <form action="/user/fileUpload1" method="post" enctype="multipart/form-data">
            文件上传：<input type="file" name="Upload"/>
            <input type="submit" value="上传"/>
        </form>
</body>
</html>
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
      public String newFileUpload(HttpServletRequest request, MultipartFile springmvcUpload)
          throws IOException {
          // 确认上传位置
          String path = request.getSession().getServletContext().getRealPath("/uploads/");
          File file = new File(path);
          if (!file.exists()){
              file.mkdirs();
          }
          // 原来的解析工作已经由springmvc的配置文件中的文件解析器完成
          // 获取上传名称
          String fileName = springmvcUpload.getOriginalFilename();
          String uuid = UUID.randomUUID().toString().replace("-", "");
          fileName = uuid+"_"+fileName;
          springmvcUpload.transferTo(new File(path,fileName));
  		    return "success";
      }
  ```

  <!--Index.jsp-->

  ```jsp
  <%--SpringMVC方式上传文件--%>
      <h3>SpringMVC方式上传文件</h3>
      <form action="/user/fileUpload2" method="post" enctype="multipart/form-data">
          文件上传：<input type="file" name="springmvcUpload"/>
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

  













