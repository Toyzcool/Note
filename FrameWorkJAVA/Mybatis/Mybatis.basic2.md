# Mybatis.basic2

## 1.CRUD事务

### 方法

- 注意
  - 增删改三个方法底层都是update方法，并且都通过PreparedStatement和execute方法执行

**添加**

- 步骤

  1. 在持久层接口中声明 添加用户方法

     ```java
     public interface IUserDao {
         // the method of add user
         public void saveUser(User user);
     }
     ```

  2. 在映射配置文件中添加 方法的索引

     ```xml
     <?xml version="1.0" encoding="UTF-8" ?>
     <!DOCTYPE mapper
             PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
             "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
     <mapper namespace="random.dao.IUserDao">
         <insert id="saveUser" parameterType="random.domain.User">
             insert into user(username,address,sex,birthday) value (#{username},#{address},#{sex},#{birthday});
         </insert>
     </mapper>
     ```

     <!--解析-->

     - 因为要获取value的值，因此声明格式为：#{变量名称}

  3. 在测试类中，添加提交事务的语句

     ```java
     public class MybatisTest {
         private InputStream inputStream;
         private SqlSession session;
         private IUserDao iUserDao;
     
         /**
          * before the test method
          */
         @Before
         public void init() throws Exception {
             // read configuration file
             inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
             // create factory builder
             SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
             // create factory
             SqlSessionFactory factory = builder.build(inputStream);
             // create session
             session = factory.openSession();
             // create proxy objective
             iUserDao = session.getMapper(IUserDao.class);
         }
     
         /**
          * after the test method
          */
         @After
         public void destory() throws Exception {
             // submit the transactionManager
             session.commit();
             // release source
             session.close();
             inputStream.close();
         }
     
         /**
          * add User to user
          */
         @Test
         public void testAdd(){
             User user = new User();
             user.setUsername("add");
             user.setSex("male");
             user.setBirthday(new Date());
             user.setAddress("B74HO");
             iUserDao.saveUser(user);
         }
     }
     ```

     <!--解析-->

     - 因为使用单元测试，所以将内容分为before和after
     - 注意提交事务的语句：session.commit();也可以设置实现自动提交session = factory.openSession(true);（自动提交在多个事务时会出现问题）

### 实现

- 持久层接口

  <!--IUserDao.java-->

  ```java
  package random.dao;
  import random.domain.User;
  
  import java.util.List;
  
  public interface IUserDao {
      // the method of finding all the user
      public List<User> findAll();
      // the method of add user
      public void saveUser(User user);
      // the method of update user
      public void updateUser(User user);
      // the method of delete user
      public void deleteUser(int id);
      // the method of find user by id
      public User findUser(int id);
      // the method of find user by name 模糊查询
      public List<User> findUsers(String username);
  }
  ```

- 映射配置文件

  <!--IUserDao.xml-->

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE mapper
          PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  <mapper namespace="random.dao.IUserDao">
      <!--find all the users-->
      <select id="findAll" resultType="random.domain.User">
          select * from user;
      </select>
      <!--add user-->
      <insert id="saveUser" parameterType="random.domain.User">
        <!--获取到添加用户的id-->
          <selectKey keyProperty="id" resultType="java.lang.Integer" order="AFTER">
              select last_insert_id();
          </selectKey>
          insert into user(username,address,sex,birthday) value (#{username},#{address},#{sex},#{birthday});
      </insert>
      <!--update user-->
      <update id="updateUser" parameterType="random.domain.User">
          update user set username=#{username}, sex=#{sex}, birthday=#{birthday}, address=#{address} where id=#{id};
      </update>
      <!--delete user-->
      <delete id="deleteUser" parameterType="java.lang.Integer">
          delete from user where id=#{id};
      </delete>
      <!--find user by id-->
      <select id="findUser" parameterType="java.lang.Integer" resultType="random.domain.User">
          select * from user where id=#{id};
      </select>
      <!--find user by name-->
      <select id="findUsers" parameterType="java.lang.String" resultType="random.domain.User">
          select * from user where username like #{username};
      </select>
  </mapper>
  ```

  <!--解析-->

  - 模糊查询有两个方式

    ```java
    // SQL语句
      // 方法一
      select * from user where username like #{username};
      // 方法二
      select * from user where username like '%${value}%';
    // 对应的执行语句
    	// 方法一
      select * from user where username like ?;
      // 方法二
      select * from user where username like '%admin%';
    //因此方法一使用的是PreparedStatement，能够防止SQL注入攻击。方法二是Statement拼接，不推荐使用
    ```

  - 获取到添加用户的id时，需要在添加后执行获取id的操作

    ```xml
    <!--获取到添加用户的id-->
            <selectKey keyProperty="id" resultType="java.lang.Integer" order="AFTER">
                select last_insert_id();
            </selectKey>
    <!--
    1.useGeneratedKeys=true表示使用数据库自动增长的主键
    2.keyProperty设置自增主键返回字段(用户在插入数据之后获取相应主键)
    3.keyColumn用于指定数据库table中的主键
    4.三个属性同时使用时，则可以使用数据库中自增长的主键，并且可以将主键的值返回给keyProperty中写好的字段
    -->
    ```

    

- 测试类

  <!--MybatisTest.java-->

  ```java
  /*
  @Author: Toyz
  @Date: 2019/10/23
  @Time: 19:54
  @Purpose:
  @Related:
  */
  
  import org.apache.ibatis.io.Resources;
  import org.apache.ibatis.session.SqlSession;
  import org.apache.ibatis.session.SqlSessionFactory;
  import org.apache.ibatis.session.SqlSessionFactoryBuilder;
  import org.junit.After;
  import org.junit.Before;
  import org.junit.Test;
  import random.dao.IUserDao;
  import random.domain.User;
  
  import java.io.IOException;
  import java.io.InputStream;
  import java.util.Date;
  import java.util.List;
  
  public class MybatisTest {
      private InputStream inputStream;
      private SqlSession session;
      private IUserDao iUserDao;
      private List<User> users;
  
      /**
       * before the test method
       */
      @Before
      public void init() throws Exception {
          // read configuration file
          inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
          // create factory builder
          SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
          // create factory
          SqlSessionFactory factory = builder.build(inputStream);
          // create session
          session = factory.openSession();
          // create proxy objective
          iUserDao = session.getMapper(IUserDao.class);
      }
  
      /**
       * after the test method
       */
      @After
      public void destory() throws Exception {
          // submit the transactionManager
          session.commit();
          // release source
          session.close();
          inputStream.close();
      }
  
      /**
       * find all the user
       */
      @Test
      public void testFindAll(){
          // execute sql
          List<User> users = iUserDao.findAll();
          // print result
          for (User user : users) {
              System.out.println(user);
          }
      }
  
      /**
       * add User to user
       */
      @Test
      public void testAdd(){
          User user = new User();
          user.setUsername("add");
          user.setSex("male");
          user.setBirthday(new Date());
          user.setAddress("B74HO");
          iUserDao.saveUser(user);
      }
  
      /**
       * update user
       */
      @Test
      public void testUpdate(){
          User user1 = new User();
          user1.setId(6);
          user1.setUsername("update");
          user1.setSex("male");
          user1.setBirthday(new Date());
          user1.setAddress("B7");
          iUserDao.updateUser(user1);
      }
  
      /**
       * dalete user
       */
      @Test
      public void testDelete(){
          iUserDao.deleteUser(5);
      }
  
      /**
       * find user
       */
      @Test
      public void testFind(){
          User user2 = iUserDao.findUser(6);
          System.out.println(user2.toString());
      }
  
      /**
       * find user by username 模糊查询
       */
      @Test
      public void testFindUsers(){
          users = iUserDao.findUsers("%admin%");
          for (User user : users) {
              System.out.println(user.toString());
          }
      }
  }
  ```

### 特殊

1.实体类的包装类对象查询

- 步骤

  1. 创建包装类，添加实体类对象以及基础方法

     <!--QueryVo.java-->

     ```java
     public class QueryVo {
         private User user;
     
         public User getUser() {
             return user;
         }
     
         public void setUser(User user) {
             this.user = user;
         }
     }
     ```

     <!--解析-->

     - 支持添加多个实体类，在实际开发过程中使用频率高

  2. 添加 持久层接口的查询方法

     <!--IUserDao.java-->

     ```java
     // 使用实体类的包装类对象进行查询
         public List<User> findByVo(QueryVo queryVo);
     ```

  3. 添加 映射配置文件中的查询方法

     <!--IUserDao.xml-->

     ```xml
     <!--使用实体类的包装对象进行查询-->
         <select id="findByVo" parameterType="random.domain.QueryVo" resultType="random.domain.User">
             select * from user where username like #{user.username};
         </select>
     ```

     <!--解析-->

     - user.username写法是因为传入参数类型为QueryVo

  4. 测试类

     <!--MybatisTest.java-->

     ```java
     /**
          * 使用实体类的包装类对象进行查询
          */
         @Test
         public void testFindVo(){
             QueryVo queryVo = new QueryVo();
             User user = new User();
             user.setUsername("%update%");
             queryVo.setUser(user);
             users = iUserDao.findByVo(queryVo);
             for (User user1 : users) {
                 System.out.println(user1);
             }
     
         }
     ```

2.封装属性名称与数据库属性名不一致

- 场景：如果封装的属性名和数据库属性名不一致时，采用此方法实现

- 解决方案

  - 第一种：修改查询语句，使用as
  - 第二种：在映射配置文件中使用resultMap方法建立属性对应表

- 实现

  <!--第二种解决方案-->

  ```xml
  <!-- 如果封装的属性名和数据库属性名不一致时，采用此方法实现 -->
      <resultMap id="userMap" type="random.domain.User">
          <id property="id" column="userId"></id>
          <result property="username" column="userName"></result>
      </resultMap>
      <select id="findAll" resultMap="userMap">
          select * from user;
      </select>
     
  ```

  <!--解析-->

  - resultMap的id属性用于sql语句中的resultMap属性，原为resultType
  - resultMap的中的id，中的property属性为java中属性名称，column为数据库中的属性名称

## 2.配置文件

### 方法

1.配置数据源

- 方法

  - 基本配置方法

    ```xml
    <!--(1)基本的配置方法-->
      <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
      <property name="url" value="jdbc:mysql://127.0.0.1:3306/Mybatis"/>
      <property name="username" value="root"/>
      <property name="password" value="Ceshi123"/>
    ```

  - 在标签内部配置

    ```xml
    <!--（2）在标签内部配置连接数据库信息-->
    	<properties resource="jdbcConfig.properties"></properties>
    <!--通过（2）properties标签配置-->
      <property name="driver" value="${jdbc.driver}"/>
      <property name="url" value="${jdbc.url}"/>
      <property name="username" value="${jdbc.username}"/>
      <property name="password" value="${jdbc.password}"/>
    ```

  - 通过属性引用外部配置文件

    ```xml
    <properties url="file:///Users/space/Documents/Growth/Package/FrameWorkJAVA/Mybatis/Mybatis.basic2/src/main/resources/jdbcConfig.properties"></properties>
    <property name="driver" value="${jdbc.driver}"/>
    <property name="url" value="${jdbc.url}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
    ```

2.配置别名

- 方法一：typeAliases属性

  - 作用：type指定实体类的全限定类名，alias是配置的别名，不区分大小写

  - 步骤

    1. 配置文件中添加typeAliases属性

       ```xml
       <!--使用typeAliases配置别名，只能配置domain中类的别名-->
           <typeAliases>
               <!--type指定实体类的全限定类名，alias是配置的别名，不区分大小写-->
               <typeAlias type="random.domain.User" alias="user"/>
           </typeAliases>
       ```

    2. 修改映射配置文件中的配置

       ```xml
       <!--修改前-->
       <select id="findAll" resultType="random.domain.User">
               select * from user;
           </select>
       
       <!--修改后-->
       <select id="findAll" resultType="user">
               select * from user;
           </select>
       ```

- 方法二：package属性

  - 作用：使用package配置别名，包中的所有类的别名都为类名，不区分大小写

  - 步骤

    1. 配置文件中添加package属性

       ```xml
       <!--使用package配置别名，包中的所有类的别名都为类名，不区分大小写-->
               <package name="random.domain"/>
       ```

3.映射配置文件的配置

- 作用：指定dao接口所在包

- 方法一：配置mapper的resource属性

- 方法二：配置package属性

- 实现

  ```xml
      <!--配置映射文件位置-->
      <mappers>
          <!--方法一：指定dao接口的位置-->
          <mapper resource="random/dao/IUserDao.xml"/>
          <!--方法二：指定dao接口所在包，可替代上一条语句-->
          <package name="random.dao"/>
      </mappers>
  ```

  





















