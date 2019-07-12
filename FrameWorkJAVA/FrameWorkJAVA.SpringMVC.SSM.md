# FrameWorkJAVA.SpringMVC.SSM

## 1.Preparation

### Method

1. import dependency

   ```xml
   <properties>
       <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
       <maven.compiler.source>1.7</maven.compiler.source>
       <maven.compiler.target>1.7</maven.compiler.target>
       <spring.version>5.1.8</spring.version>
       <log4j.version>2.12.0</log4j.version>
       <mysql.version>5.1.38</mysql.version>
       <mybatis.version>3.5.1</mybatis.version>
     </properties>
   <dependencies>
       <!--Spring-->
       <dependency>
         <groupId>org.aspectj</groupId>
         <artifactId>aspectjweaver</artifactId>
         <version>1.7.2</version>
       </dependency>
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-aop</artifactId>
         <version>5.1.8.RELEASE</version>
       </dependency>
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-context</artifactId>
         <version>5.1.8.RELEASE</version>
       </dependency>
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-core</artifactId>
         <version>5.1.8.RELEASE</version>
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
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-test</artifactId>
         <version>5.1.8.RELEASE</version>
         <scope>test</scope>
       </dependency>
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-tx</artifactId>
         <version>5.1.8.RELEASE</version>
       </dependency>
         <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-jdbc</artifactId>
           <version>5.1.8.RELEASE</version>
         </dependency>
   
       <!--log4j-->
       <dependency>
         <groupId>org.apache.logging.log4j</groupId>
         <artifactId>log4j-api</artifactId>
         <version>2.12.0</version>
       </dependency>
       <dependency>
         <groupId>org.apache.logging.log4j</groupId>
         <artifactId>log4j-core</artifactId>
         <version>2.12.0</version>
       </dependency>
       <!--单元测试-->
       <dependency>
         <groupId>junit</groupId>
         <artifactId>junit</artifactId>
         <version>4.11</version>
         <scope>test</scope>
       </dependency>
       <!--mysql-->
       <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
         <version>8.0.16</version>
       </dependency>
       <dependency>
         <groupId>javax.servlet</groupId>
         <artifactId>javax.servlet-api</artifactId>
         <version>4.0.1</version>
         <scope>provided</scope>
       </dependency>
       <dependency>
         <groupId>javax.servlet.jsp</groupId>
         <artifactId>javax.servlet.jsp-api</artifactId>
         <version>2.3.3</version>
         <scope>provided</scope>
       </dependency>
       <dependency>
         <groupId>javax.servlet</groupId>
         <artifactId>jstl</artifactId>
         <version>1.2</version>
       </dependency>
       <!--mybatis-->
       <dependency>
         <groupId>org.mybatis</groupId>
         <artifactId>mybatis</artifactId>
         <version>3.5.1</version>
       </dependency>
       <dependency>
         <groupId>org.mybatis</groupId>
         <artifactId>mybatis-spring</artifactId>
         <version>2.0.1</version>
       </dependency>
       <dependency>
         <groupId>c3p0</groupId>
         <artifactId>c3p0</artifactId>
         <version>0.9.1.2</version>
       </dependency>
       <!--lombok依赖包-->
       <dependency>
         <groupId>org.projectlombok</groupId>
         <artifactId>lombok</artifactId>
         <version>1.18.8</version>
         <scope>provided</scope>
       </dependency>
     </dependencies>
   ```

2. create java package,including Handler,Dao,Service,Domain

3. create log4j2.xml configuration file

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <configuration status="ON">
       <appenders>
           <Console name="Console" target="SYSTEM_OUT">
               <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
           </Console>
       </appenders>
       <loggers>
           <root level="error">
               <appender-ref ref="Console"/>
           </root>
       </loggers>
   </configuration>
   ```

## 2.SpringMVC and Spring

### Method

1.Principle

![](/Users/toyz/Package/Note/FrameWorkJAVA/Spring整合SpringMVC.png)

2.配置监听器

```xml
<!--配置监听器，服务器启动后加载Spring配置文件,默认只加载WEB-INF下的applicaitonContext.xml文件-->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  <!--设置配置文件路径-->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
```

### Resources

- /Users/toyz/Package/FrameWorkJAVA/SpringMVC/SpringMVC.SSM

## 3.SpringMVC/Spring/Mybatis

### Method——重点

![](/Users/toyz/Package/Note/FrameWorkJAVA/SSM流程.png)