# FrameWorkJAVA.SpringMVC

## 1.简介

### 方法

#### 1.定义

springMVC是一种web层mvc框架，用于替代servlet（处理|响应请求，获取表单参数，表单校验等）

#### 2.准备工作

- 导入jar包

- 导入

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

- 配置Spring MVC的入口 **DispatcherServlet**，把所有的请求都提交到该Servlet

  <!--因为需要将所有请求都交给Spring MVC处理，而不是Servlet处理-->

  <!--普通的Servlet流程是：请求-url-pattern-给相应的Servlet处理-->

- 如果需要将请求内容分开处理，分别交给Spring MVC和Servlet处理

#### 3.步骤

- 

























