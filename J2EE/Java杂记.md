# Java杂记

1.无法生成.class文件

- 在eclipse中开启build automatically
- 确认项目的build path配置正确
- 确认导入的jar包正确
- 确认java的父级文件夹为source folder

2.Tomcat部署时，没有可选的tomcat版本

- 下载Eclipse JST Server Adapters，下载http://download.eclipse.org/releases/kepler
- 注意eclipse版本，需要是支持Java EE

3.Java里面String，StringBuffer，StringBuilder的区别和联系

- String是不可变的。<!--比如对String内容修改，两个String类型相加，则会新建String用来存储结果，其他的会被回收-->

- 字符串拼接的+，底层是使用 StringBuffer 或者 StringBuilder 来完成

- StringBuffer 是线程安全和同步的而 StringBuilder 则不是线程安全和非同步的即可，同时因为 StringBuffer 是线程线程安全的，所以它的性能低于 StringBuilder 类

- 因此使用规则为：

  （1）如果你要求字符串不可变，那么应该选择 String 类

  （2）如果你需要字符串可变并且是线程安全的，那么你应该选择 StringBuffer 类

  （3）如果你要求字符串可变并且不存在线程安全问题，那么你应该选择 StringBuilder 类

4.占位符查询

![](/Users/toyz/Desktop/屏幕快照 2019-06-20 下午8.51.48.png)

5.String.format方法

- ```java
  String formatted = String.format("%s今年%d岁。", "小李", 30); // "小李今年30岁。
  ```

- 这个方法第一个参数是格式串，后面的参数都是格式串的参数，用于替换格式串中的占位符。
- 占位符以 "%x" 的形式表示，不同的参数类型要用不同的字母。后面会具体介绍。
- `String.format()` 返回值类型为字符串，也就是格式化的结果。

6.通过地址访问部署在Server上的文件，可以省略项目名的方法

- 1.修改server.xml文件：将path中的项目名删除
  <Context docBase="Dynamic" path="/项目名" reloadable="true" source="org.eclipse.jst.jee.server:Dynamic"/></Host>改为<Context docBase="Dynamic" path="/" reloadable="true" source="org.eclipse.jst.jee.server:Dynamic"/></Host>
- 2.修改项目ProperProperties：右键项目-ProperProperties-Web Project Setting-Context root中的内容修改为/

7.数据库取数据

- 由于数据库取数据，和数组一样，初始值是0；需要和id区分

8.Eclipse项目部署在Tomcat方法

- 通过eclipse中的run and remove，动态
- 将Web项目打包成war包，并移动到Tomcat中的Webapps，静态

9.Serializable接口

- 一个类只有实现了Serializable接口，才能被序列化
- Serializable接口只是一个空接口，用来标记那些类可以被序列化
- 序列化的情况
  1. 当你想把的内存中的对象写入到硬盘的时候；
  2. 当你想用套接字在网络上传送对象的时候；
  3. 当你想通过RMI传输对象的时候；