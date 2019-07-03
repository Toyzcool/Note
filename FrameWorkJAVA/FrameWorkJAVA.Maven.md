# FrameWorkJAVA.Maven

## 1.简介

### 方法

#### 1.基本概念

1.自动化构建工具

- 普通流程是：编译、打包、部署、测试
- 使用Maven可以自动化构建完成

2.配置方式

1. 打开终端输入命令 vim ~/.bash_profile （编辑环境变量配置文件）
2. 按下i，进入编辑模式
3. 在环境变量文件中加上如下的配置
4. 输入 :wq退出并保存当前文件
5. 输入 source .bash_profile，按下Enter键使bash_profile生效
6. 输入 mvn -v，结果如下图所示即表明配置成功

```shell
   export MAVEN_HOME=/Users/kun/Desktop/midongtools/apache-maven-3.5.0 

   export PATH=$PATH:$MAVEN_HOME/bin

   PS:（可以将文件直接拖拽至终端内文件路径便可显示出来）
```

#### 2.配置SpringMVC

- 创建maven-archetype-webapp骨架

- 选择本地的Maven，并添加参数archetypeCatalog=internal

- 配置pom.xml，注意版本号

  ```xml
  <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <groupId>com.example</groupId>
      <artifactId>maven-springmvc</artifactId>
      <packaging>war</packaging>
      <version>1.0-SNAPSHOT</version>
      <name>maven-springmvc Maven Webapp</name>
      <url>http://maven.apache.org</url>
      <!--项目依赖 -->
      <dependencies>
          <!--日志包-->
          <dependency>
              <groupId>junit</groupId>
              <artifactId>junit</artifactId>
              <version>3.8.1</version>
              <scope>test</scope>
          </dependency>
          <dependency>
              <groupId>org.slf4j</groupId>
              <artifactId>slf4j-log4j12</artifactId>
              <version>1.7.21</version>
          </dependency>
  
          <!--j2ee相关包 servlet、jsp、jstl-->
          <dependency>
              <groupId>javax.servlet</groupId>
              <artifactId>javax.servlet-api</artifactId>
              <version>3.1.0</version>
          </dependency>
          <dependency>
              <groupId>javax.servlet.jsp</groupId>
              <artifactId>jsp-api</artifactId>
              <version>2.2</version>
          </dependency>
          <dependency>
              <groupId>javax.servlet</groupId>
              <artifactId>jstl</artifactId>
              <version>1.2</version>
          </dependency>
  
          <!--mysql驱动包-->
          <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>5.1.35</version>
          </dependency>
  
          <!--spring相关包-->
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
  
          <!--其他需要的包-->
          <dependency>
              <groupId>org.apache.commons</groupId>
              <artifactId>commons-lang3</artifactId>
              <version>3.4</version>
          </dependency>
          <dependency>
              <groupId>commons-fileupload</groupId>
              <artifactId>commons-fileupload</artifactId>
              <version>1.3.1</version>
          </dependency>
      </dependencies>
  
      <build>
          <finalName>maven-springmvc</finalName>
          <resources>
              <!--表示把java目录下的有关xml文件,properties文件编译/打包的时候放在resource目录下-->
              <resource>
                  <directory>${basedir}/src/main/java</directory>
                  <includes>
                      <include>**/*.properties</include>
                      <include>**/*.xml</include>
                  </includes>
              </resource>
              <resource>
                  <directory>${basedir}/src/main/resources</directory>
              </resource>
          </resources>
          <plugins>
              <!--servlet容器 jetty插件-->
              <plugin>
                  <groupId>org.eclipse.jetty</groupId>
                  <artifactId>jetty-maven-plugin</artifactId>
                  <version>9.3.10.v20160621</version>
              </plugin>
          </plugins>
      </build>
  </project>
  ```

  