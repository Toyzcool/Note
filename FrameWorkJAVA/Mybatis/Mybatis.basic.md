# Mybatis.basic

## 1. 基本概念

- Mybatis 定义：一种持久层框架，使用java编写
- 作用
  - 封装了jdbc细节，仅需要关注sql语句本身
  - 无需关注注册驱动、创建连接等过程
- 原理：使用ORM思想实现了结果集的封装

#### ORM

- ORM（Object Relationship Mapping） 定义：对象关系映射

- 作用：将数据库中的表和实体类以及实体类的属性建立映射关系

  <!--举例-->

  ```java
  //user表中字段id、name
  
  //对应
  
  //User类中id、name属性
  ```

#### 框架

- 框架 定义：软件开发的一套解决方案，不同框架解决不同问题
- 框架 优势：封装大量细节，能够极简实现功能，大大提升效率

#### 三层架构

- 架构

  1. 表现层：展示数据

  2. 业务层：处理业务需求

  3. 持久层：和数据库交互

     <!--架构图-->

![](assets/SpringMVC.png)

- 持久层解决方案

  - JDBC技术
    - Connection
    - PreparedStatement
    - ResultSet
  - Spring的jdbcTemplate：Spring对jdbc的简单封装
  - Apache的DBUtils

  <!--以上都不是框架，因为都没有明显提升效率，jdbcTemplate和DBUtils仅仅是工具类-->