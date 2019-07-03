# FrameWorkJAVA.SpringMVC

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


#### 3.步骤——重点

- 概要

  ![](/Users/toyz/Package/Note/FrameWorkJAVA/SpringMVC流程概要.png)

- 详解

  ![](/Users/toyz/Package/Note/FrameWorkJAVA/SpringMVC流程详解.png)

<!--比喻
 1.前端控制器类似电脑上的各种元件，用来接收指令
 2.控制器类似电脑上CPU
 3.视图解析器类似显卡
 4.前端展示类似显示屏
 流程：键盘敲击指令，指令发送到接口，接口分配给CPU进行运算，运算结果传输到显卡，显卡解析完后显示到显示屏上
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
       <servlet>
         <servlet-name>dispatcherServlet</servlet-name>
         <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
         <init-param>
           <param-name>contextConfigLocation</param-name>
           <param-value>classpath:springmvc.xml</param-value>
         </init-param>
     <!--    标记容器在启动的时候就加载这个servlet，数值代表优先级-->
         <load-on-startup>1</load-on-startup>
       </servlet>
       <servlet-mapping>
         <servlet-name>dispatcherServlet</servlet-name>
     <!--    拦截所有请求-->
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

     

### 索引

- /Users/toyz/Package/FrameWorkJAVA/SpringMVC/SpringMVC.Start












