# Mybatis.basic2

## 1.CRUD事务

### 添加

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
     - 注意提交事务的语句：session.commit();