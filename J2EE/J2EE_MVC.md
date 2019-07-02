## J2EE

### D.MVC

### 1.简介

#### 方法

1.MVC表示模型、视图、控制器的显示方式

2.模型，可以是数据；视图，用来展示数据的容器；控制器，用于把不同数据展示在不同视图上

3.模型比如bean、Dao；控制器比如Servlet；控制器比如jsp

### 2.项目总结——英雄管理页面

#### 方法

1.项目架构

- View——html部分，包括布局框架、获取返回数据的展示、请求发送——核心应用方法：EL标签库
- Controller——Servlet部分，包括将数据库对象显示在View上、接受和返回数据——核心应用方法：HttpServlet方法处理请求
- Model——bean和dao部分，包括数据库对象、数据处理方法实现——核心应用方法：Java语言自定义方法实现、数据库连接

2.其他问题

- 需要HeroEditServlet和HeroUpdataServlet两个Servlet的原因

  HeroEditServlet用来获取需要编辑的对象id，并通过getHero方法来获取到实际的hero对象，并携带此数据，负责跳转到编辑页面；在编辑页面编辑完成后，需要post请求到HeroUpdataServlet，而HeroUpdataServlet用来处理收到的hero数据，并实施hero.updata方法，处理完成后返回英雄列表页

- 标签<a>中的href属性，有空格会出错，因此避免使用空格

#### 索引

- package/J2EE/MVC