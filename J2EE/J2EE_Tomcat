## J2EE

### A.Tomcat

### 1.简介

#### 方法

1.常用指令

- 查看tomcat占用的进程号：ps -ef|grep tomcat
- 根据进程号，查看进程所占用的端口：lsof -n -P | grep PID
- 查看占用指定端口的进程：lsof -i tcp:22
- 没有权限启动：chmod 777  *.sh

1.部署方法

- 在tomcat/Catalina/localhost 中新建name.xml文件，内容为

```xml
<?xml version="1.0" encoding="GBK"?>
<Context docBase="/Users/toyz/Package/J2EE/j2ee/web/" privileged="true">
</Context>
```

- docBase中的内容为需要部署的文件的地址，最后以文件夹结尾
- 最后访问网址：[http://localhost:8080/web/hello](http://localhost:8080/web/hello)

