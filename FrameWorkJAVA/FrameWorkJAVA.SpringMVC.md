### FrameWorkJAVA.SpringMVC

## 1.简介

### 方法

#### 1.基本概念

- 定义：springMVC是一种web层mvc框架，轻量级的Web框架。用于替代servlet（处理|响应请求，获取表单参数，表单校验等）

- SpringMVC在三层中位置：

  ![](/Users/toyz/Package/Note/FrameWorkJAVA/SpringMVC.png)

- SpringMVC优势
  - 角色划分明确，前端控制器、请求到处理器映射、处理器适配器、视图解析器等
  - 和Spring框架无缝衔接
  - 模块化开发

- SpringMVC与Struts2区别

  - 共同点
    1. 都是表现层框架，基于MVC模型
    2. 底层依赖ServletAPI
    3. 处理请求的机制都是核心控制器

  - 区别
    1. SpringMVC入口是Servlet；Struts入口是Filter
    2. SpringMVC基于方法；Struts基于类，慢于SpringMVC
    3. SpringMVC处理Ajax更方便

- 前端控制器
  - 工作与Servlet相同，是集中访问点，同时负责职责的分配
  - 实现类为：DispatcherServlet

- 控制器
  
- 负责处理请求
  
- 视图解析器
  
  - 接收控制器的传值，并负责呈现响应

#### 2.准备工作

- 使用Maven，见Maven笔记

  <!--约束-->

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns:aop="http://www.springframework.org/schema/aop"
         xmlns:mvc="http://www.springframework.org/schema/mvc"
         xmlns:context="http://www.springframework.org/schema/context"
         xsi:schemaLocation="
             http://www.springframework.org/schema/beans
             http://www.springframework.org/schema/beans/spring-beans.xsd
             http://www.springframework.org/schema/aop
             http://www.springframework.org/schema/aop/spring-aop.xsd
             http://www.springframework.org/schema/mvc
             https://www.springframework.org/schema/mvc/spring-mvc.xsd
             http://www.springframework.org/schema/context
             https://www.springframework.org/schema/context/spring-context.xsd
             ">
  </beans>
  ```

  <!--普通的Servlet流程是：请求-url-pattern-给相应的Servlet处理-->


#### 3.执行流程——重点

- 概要

  ![](/Users/toyz/Package/Note/FrameWorkJAVA/SpringMVC流程概要.png)

- 详解

  ![](/Users/toyz/Package/Note/FrameWorkJAVA/SpringMVC详解.png)

<!--比喻
 1.模拟人躲避子弹
 2.前端控制器：类似眼睛，看到子弹飞过来
 2.处理器映射器：类似大脑，返回一个让头部躲避的执行链
 3.处理器适配器：类似头部，执行躲避的方法
 4.视图解析器：类似摄像机，看到了人在躲避子弹
-->

### 实现

- 配置文件

  1. Maven配置

     <!--pom.xml-->

     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     
     <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
       <modelVersion>4.0.0</modelVersion>
     
       <groupId>SpringMVC</groupId>
       <artifactId>SpringMVC.Start</artifactId>
       <version>1.0-SNAPSHOT</version>
       <packaging>war</packaging>
     
       <name>SpringMVC.Start Maven Webapp</name>
       <!-- FIXME change it to the project's website -->
       <url>http://www.example.com</url>
     
       <properties>
         <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
         <maven.compiler.source>1.7</maven.compiler.source>
         <maven.compiler.target>1.7</maven.compiler.target>
       </properties>
     
       <dependencies>
         <dependency>
           <groupId>junit</groupId>
           <artifactId>junit</artifactId>
           <version>4.11</version>
           <scope>test</scope>
         </dependency>
         <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-web</artifactId>
           <version>5.1.8.RELEASE</version>
         </dependency>
         <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-webmvc</artifactId>
           <version>5.1.8.RELEASE</version>
         </dependency>
       </dependencies>
     
       <build>
         <finalName>SpringMVC.Start</finalName>
         <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
           <plugins>
             <plugin>
               <artifactId>maven-clean-plugin</artifactId>
               <version>3.1.0</version>
             </plugin>
             <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
             <plugin>
               <artifactId>maven-resources-plugin</artifactId>
               <version>3.0.2</version>
             </plugin>
             <plugin>
               <artifactId>maven-compiler-plugin</artifactId>
               <version>3.8.0</version>
             </plugin>
             <plugin>
               <artifactId>maven-surefire-plugin</artifactId>
               <version>2.22.1</version>
             </plugin>
             <plugin>
               <artifactId>maven-war-plugin</artifactId>
               <version>3.2.2</version>
             </plugin>
             <plugin>
               <artifactId>maven-install-plugin</artifactId>
               <version>2.5.2</version>
             </plugin>
             <plugin>
               <artifactId>maven-deploy-plugin</artifactId>
               <version>2.8.2</version>
             </plugin>
           </plugins>
         </pluginManagement>
       </build>
     </project>
     ```

  2. 前端控制器配置

     <!--web.xml-->

     ```xml
     <!DOCTYPE web-app PUBLIC
      "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
      "http://java.sun.com/dtd/web-app_2_3.dtd" >
     <web-app>
       <display-name>Archetype Created Web Application</display-name>
     <!--  配置前端控制器-->
       <servlet>
         <servlet-name>dispatcherServlet</servlet-name>
         <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
         <init-param>
           <param-name>contextConfigLocation</param-name>
     <!--      启动时，就运行springmvc的配置文件-->
           <param-value>classpath:springmvc.xml</param-value>
         </init-param>
     <!--    标记容器在启动的时候就加载这个servlet，数值代表优先级-->
         <load-on-startup>1</load-on-startup>
       </servlet>
       <servlet-mapping>
         <servlet-name>dispatcherServlet</servlet-name>
     <!--    所有请求都由SpringMVC的前端控制器来处理-->
         <url-pattern>/</url-pattern>
       </servlet-mapping>
     </web-app>
     ```

  3. SpringMVC配置

     <!--springmvc.xml-->

     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns:aop="http://www.springframework.org/schema/aop"
            xmlns:mvc="http://www.springframework.org/schema/mvc"
            xmlns:context="http://www.springframework.org/schema/context"
            xsi:schemaLocation="
                http://www.springframework.org/schema/beans
                http://www.springframework.org/schema/beans/spring-beans.xsd
                http://www.springframework.org/schema/aop
                http://www.springframework.org/schema/aop/spring-aop.xsd
                http://www.springframework.org/schema/mvc
                https://www.springframework.org/schema/mvc/spring-mvc.xsd
                http://www.springframework.org/schema/context
                https://www.springframework.org/schema/context/spring-context.xsd
                ">
     
         <!-- 开启注解扫描 -->
         <context:component-scan base-package="org.handler"/>
     
         <!-- 配置视图解析器 -->
         <bean id="internalResourceViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
             <property name="prefix" value="/WEB-INF/pages/"></property>
             <property name="suffix" value=".jsp"></property>
         </bean>
     
         <!-- 开启SpringMVC注解的支持 -->
         <mvc:annotation-driven />
     </beans>
     ```

- 前端网页

  1. 首页

     <!--index.jsp-->

     ```html
     <%@ page contentType="text/html;charset=UTF-8" language="java" %>
     <html>
     <head>
         <title>Hello</title>
     </head>
     <body>
         <a href="hello">开启SpringMVC学习</a>
     </body>
     </html>
     ```

  2. 跳转页面

     <!--success.jsp-->

     ```html
     <%@ page contentType="text/html;charset=UTF-8" language="java" %>
     <html>
     <head>
         <title>Success</title>
     </head>
     <body>
         <h3>入门成功</h3>
     </body>
     </html>
     ```

- 控制器

  1. handler控制器

     <!--org.handler/StartHandler.java-->

     ```java
     package org.handler;
     import org.springframework.stereotype.Controller;
     import org.springframework.web.bind.annotation.RequestMapping;
     // 注解实例化对象
     @Controller
     public class StartHandler {
       // 注解实现请求映射
         @RequestMapping("/hello")
         public String start(){
             System.out.printf("Hello");
             return "success";
         }
     }
     ```


## 2.RequestMapping

### 方法

#### 1.作用

- 实现请求的映射

#### 2.属性及作用

- value/path：指定映射的方法或类——常用
  - **类添加value值，能够区分模块，见实现中的RequestMappingHandler2.java——重点**
- Method：指定请求的类型，默认为get（如果属性为post，则无法执行当前方法）——常用
- params：指定请求需要携带的参数和参数值
- header：指定请求需要携带请求头部

### 实现

- 前端页面

  ```jsp
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
  <head>
      <title>Hello</title>
  </head>
  <body>
  <%--RequestMapping属性--%>
      <%--value、path属性，效果一样--%>
      <h2>RequestMapping属性</h2>
      <h3>value、path属性，效果一样</h3>
      <h4>设计二级value = "/user/testValue",value = "/order/testValue"，用于划分模块</h4>
          <a href="user/testValue">testValue...user</a><br>
          <a href="order/testValue">testValue...order</a>
  
      <%--method属性--%>
      <h3>method属性，预期是请求失败，因为需要是post方法</h3>
      <a href="testMethod">testMethod</a>
  
      <%--params属性--%>
      <h3>params属性,带username属性,而且值必须为Toyz</h3>
      <a href="testParams?username=Toyz">testParams...username</a>
  
      <%--header属性--%>
      <h3>header属性</h3>
      <a href="testHeader">testHeader...accept</a>
  </body>
  </html>
  ```

- 处理器

  <!--RequestMappingHandler.java-->

  ```java
  package org.handler;
  
  import org.springframework.stereotype.Controller;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  
  @Controller
  public class RequestMappingHandler {
  
  //    Value、path属性效果一样，同时可以省略属性名称
  //    设计二级value = "/user/testValue"，用于划分模块,最好是在类中添加value属性——关联RequestMappingHandler2.java
      @RequestMapping("/user/testValue")
      public String testValue(){
          System.out.println("testValue...user");
          return "success";
      }
  
  //   method属性，指定响应的请求类型
  //    因为默认请求类型为get，因此请求失败
      @RequestMapping(value = "testMethod",method = {RequestMethod.POST})
      public String testMethod(){
          System.out.println("testMethod...");
          return "success";
      }
  
  //    params属性，指定必须要传输的参数(username),而且值为Toyz
      @RequestMapping(value = "testParams",params = {"username=Toyz"})
      public String testParams(){
          System.out.println("testParams...username");
          return "success";
      }
  
      //    header属性
      @RequestMapping(value = "testHeader",headers = {"Accept"})
      public String testHeader(){
          System.out.println("testHeader...Accept");
          return "success";
      }
  }
  ```

  <!--RequestMappingHandler2.java-->

  ```java
  package org.handler;
  
  import org.springframework.stereotype.Controller;
  import org.springframework.web.bind.annotation.RequestMapping;
  @Controller
  //    类中添加value = "/order"，用于划分模块
  @RequestMapping("/order")
  public class RequestMappingHandler2 {
  //    测试value值
      @RequestMapping("testValue")
      public String testValue(){
          System.out.println("testValue...oder");
          return "success";
      }
  }
  ```

### 索引

- /Users/toyz/Package/FrameWorkJAVA/SpringMVC/SpringMVC.Basic

## 3.请求参数绑定

### 方法

#### 1.初级绑定方法

1. 请求中直接输入参数名以及值
2. Controller中的方法带参数

<!--ParamHandler.java-->

```java
package org.Param.handler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("param")
public class paramHandler {
    @RequestMapping("testParam")
    public String testParam(String username){
        System.out.printf("Username:"+username);
        return "success";
    }
}
```

<!--param.jsp-->

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Param</title>
</head>
<body>
    <h2>测试参数绑定传递</h2>
    <h3>绑定用户名</h3>
    <a href="param/testParam?username=toyz">测试参数绑定传递</a>
</body>
</html>
```

#### 2.请求参数绑定实体类型——重点

- 新建类，主类和副类（副类作为对象属性注入到主类中），主类和副类实现Serializable接口，实现set和get方法，同时增加toString方法输出对象属性

  <!--Account.java 主类-->

  ```java
  package domin;
  import java.io.Serializable;
  /*
  请求参数绑定把数据装到当前类中,将对象属性User注入
   */
  public class Account implements Serializable {
      public String username;
      public String password;
      public int money;
  //对象属性
      public User user;
  
      public void setUsername(String username) {this.username = username;}
      public void setPassword(String password) {this.password = password;}
      public void setMoney(int money) {this.money = money;}
      public String getUsername() {return username;}
      public String getPassword() {return password;}
      public int getMoney() {return money;}
      public User getUser() {return user;}
      public void setUser(User user) {this.user = user;}
      @Override
      public String toString() {
          return "Account{" +
                  "username='" + username + '\'' +
                  ", password='" + password + '\'' +
                  ", money=" + money +
                  ", user.uname=" + user.uname +
                  ", user.age=" + user.age +
                  '}';
      }
  }
  
  ```

  <!--User.java 副类-->

  ```java
  package domin;
  
  import java.io.Serializable;
  /*
  当前类作为对象属性注入Account中
   */
  public class User implements Serializable {
      public String uname;
      public Integer age;
  
      public String getUname() {return uname;}
      public void setUname(String uname) {this.uname = uname;}
      public Integer getAge() {return age;}
      public void setAge(Integer age) {this.age = age;}
  }
  ```

- 新建前端表单对象，注意对象属性的name值

  <!--param.jsp-->

  ```jsp
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
  <head>
      <title>Param</title>
  </head>
  <body>
      <h3>1.测试参数绑定传递</h3>
      <a href="param/testParam?username=toyz&&password=123">测试参数绑定传递</a>
  
      <h3>2.测试参数绑定把数据封装到JavaBean中</h3>
      <form action="param/savaAccount" method="post">
          姓名：<input type="text" name="username"><br>
          密码：<input type="text" name="password"><br>
          金额：<input type="text" name="money"><br>
          真实姓名：<input type="text" name="user.uname"><br>
          年龄：<input type="text" name="user.age"><br>
          <input type="submit" value="提交">
      </form>
  </body>
  </html>
  ```

  新建Handler，将主类作为参数传入对应方法中

  <!--paramHandler.java-->

  ```java
  package org.Param.handler;
  import domin.Account;
  import org.springframework.stereotype.Controller;
  import org.springframework.web.bind.annotation.RequestMapping;
  @Controller
  @RequestMapping("param")
  public class paramHandler {
  
      /*
      1.请求参数绑定入门
       */
      @RequestMapping("testParam")
      public String testParam(String username,String password){
          System.out.printf("Username:"+username+"  and password:"+password);
          return "success";
      }
  
      /*
      2.请求参数绑定封装到JavaBean中
      */
      @RequestMapping("savaAccount")
      public String saveAccount(Account account){
          System.out.printf("Account封装成功");
          System.out.println(account);
          return "success";
      }
  }
  
  ```



#### 3.请求参数绑定集合类型

- 原理与绑定实体类型一致，但前端请求格式需要变更

  ```jsp
  <h3>3.测试参数绑定把数据封装到Account中,类中存在list和map集合</h3>
          <form action="param/savaAccount" method="post">
              姓名：<input type="text" name="username"><br>
              密码：<input type="text" name="password"><br>
              金额：<input type="text" name="money"><br>
              <%--List集合属性注入--%>
              真实姓名：<input type="text" name="list[0].uname"><br>
              年龄：<input type="text" name="list[0].age"><br>
              <%--Map集合属性注入--%>
              真实姓名：<input type="text" name="map['one'].uname"><br>
              年龄：<input type="text" name="map['one'].age"><br>
              <input type="submit" value="提交">
          </form>
  ```

### 索引

- /Users/toyz/Package/FrameWorkJAVA/SpringMVC/SpringMVC.Basic

### 注意

- 中文乱码问题，使用filter解决编码

  <!--web.xml-->

  ```xml
  <web-app>
    <display-name>Archetype Created Web Application</display-name>
  
    <!--  1.配置过滤器解决中文乱码问题-->
    <filter>
      <filter-name>characterEncodingFilter</filter-name>
      <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
      <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
      </init-param>
    </filter>
    <filter-mapping>
      <filter-name>characterEncodingFilter</filter-name>
      <url-pattern>/*</url-pattern>
    </filter-mapping>
    </web-app>
  ```

- 集合类型数据使用toString方法输出时，预期输出对象属性的内容，需要在对象类型属性中也添加toString方法；不添加时输出对象属性的地址；



## 4.自定义类型转换器

### 方法

- 步骤

  1. 创建类，来实现类型转换逻辑

     ```java
     public class StringToDate implements Converter<String, Date> {
         @Override
     //    s为传进来的参数
         public Date convert(String s) {
             if (s == null){
                 throw new RuntimeException("请输入数据");
             }
             DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
             try {
                 return df.parse(s);
             } catch (ParseException e) {
                 e.printStackTrace();
             }
             return null;
         }
     }
     ```

  2. SpringMVC的配置文件中，加载实现类型转换的类

     ```xml
     <!--开启springmvc注解扫描-->
         <mvc:annotation-driven conversion-service="conversionServiceFactoryBean"/>
     
     
         <!--配置自定义类型转换器-->
         <bean id="conversionServiceFactoryBean" class="org.springframework.context.support.ConversionServiceFactoryBean">
             <property name="converters" >
                 <set>
                     <bean class="utils.StringToDate" />
                 </set>
             </property>
         </bean>
     ```

     

## 5.获取Servlet原生API

### 方法

- 步骤

  1. 编辑Controller

     ```java
      /*
         4.获取原生的Servlet API
         */
         @RequestMapping("getServletAPI")
         public String getServletAPI(HttpServletRequest request, HttpServletResponse response){
             System.out.printf("getServletAPI");
             System.out.println(request);
             System.out.println(response);
             HttpSession httpSession = request.getSession();
             System.out.println(httpSession);
             return "success";
         }
     ```

     


























