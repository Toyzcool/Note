## IntermediateJava

### 三.JDBC

### 1.基本操作

#### 方法

1. 导入mysql-jdbc的jar包
2. 连接数据库
3. 写入数据
4. MySQL基本操作：增删改查

#### 实现

```java
package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TestJDBC {

	public static void main(String[] args) {
		/*
		 * 初始化驱动，连接数据库，并写入数据，最后使用try-with-resource关闭
		 */
		try {
			/*
			 * 初始化驱动
			 */
			//驱动类com.mysql.jdbc.Driver，就在mysql-connector-java-8.0.16.jar包中，导入包
			Class.forName("com.mysql.cj.jdbc.Driver");
			//导入成功输出提示
			System.out.println("数据库加载成功");
		try(
				//连接数据库
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
				//新建写sql语句的对象
				Statement s = c.createStatement();
			)
		{
			//新建sql语句
			String sql = "insert into hero values(null,'诺克萨斯',900,120)";
			s.execute(sql);
			System.out.println("数据写入成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
```

2.数据库基本操作：增删改查

```mysql
-- 新建表
CREATE TABLE hero (
  id int(11) AUTO_INCREMENT,
  name varchar(30) ,
  hp float ,
  damage int(11) ,
  PRIMARY KEY (id)
)  DEFAULT CHARSET=utf8;

-- 新增数据
insert into hero values (null, '盖伦', 616, 100)  

-- 修改数据
update hero set hp = 100 where id = 2

-- 查询数据
SELECT * from hero where id = 2

-- 删除数据
DELETE from hero where id = 1
```

3.查询语句需要先有next()方法

```java
package com.JDBC;
/*
 * 事务
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class NewCommit {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
				Statement s = c.createStatement();
				)
		{
			//查询血量语句
			String sqlResearch = "SELECT * from hero where id = 2 ";
			
			//增加血量操作
			String sqlAdd = "UPDATE hero SET hp= hp + 1 where id = 2 ";
			s.execute(sqlAdd);
			System.out.println("加血成功");
			//获取血量
			ResultSet rs = s.executeQuery(sqlResearch);
      //需要有next方法！！！！！
			rs.next();
			float hp1 = rs.getFloat("hp");
			System.out.println("加血后血量为："+hp1);

			//减少血量操作
			String sqlReduce = "UPDATE hero SET hp= hp - 1 where id = 2 ";
			s.execute(sqlReduce);
			System.out.println("减血成功");
			//获取血量
			ResultSet rs2 = s.executeQuery(sqlResearch);
			rs2.next();
			float hp2 = rs2.getFloat("hp");
			System.out.println("减血后血量为："+hp2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
```

#### 注意

1. 需要关闭连接，先关闭Statement，再关闭Connection
2. java中使用查询语句，必须先有next()方法

#### 索引

- toyz/IntermediateJAVA/src/com.JDBC/TestJDBC.java

### 2.预编译Statement

#### 方法

1. 新建SQL语句
2. 新建PreparedStatement对象
3. 用setInt()等方法设置参数
4. 执行

#### 实现

- 包含预编译以及SQL注入式攻击内容

```java
package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class NewPreparedStatement {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		String sql = "INSERT INTO user VALUES(null,?,?)";
		try (
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
				//预编译
//				PreparedStatement ps =  c.prepareStatement(sql);
				//普通编译
				Statement s = c.createStatement();
				)
		{
//            //使用预编译
//            ps.setString(1, "stark");
//            ps.setString(2, "admin");
//			ps.execute();
//			System.out.println("添加完成");
			
			//使用普通编译进行SQL注入攻击
			//获取用户输入
			String inputName = "'盖伦' OR 1=1";
			//新建查询SQL语句
			String sqlAttrack = "SELECT * FROM user where name = "+inputName;
			//执行查询语句
			ResultSet rs = s.executeQuery(sqlAttrack);
			//输出账号是否存在
			while(rs.next()) {
				String userName = rs.getString("password");
				System.out.println(userName);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

```

#### 注意

1. 预编译的优势（相对于Statement）

- 参数设置语句的可读性强
- 性能更好，因为假如需要添加10条内容到数据库，预编译是传一句SQL语句到数据库，之后仅仅是传参数。Statement是传10句SQL语句进行编译，内存占用更大。
- 更加安全，防止SQL注入攻击。因为使用Statement时，'name' or 1=1会造成恒成立，然后输出所有的数据库内容。

2.使用ResultSet()获取执行结果时，executeQuery()的括号中不能带SQL语句——重点

#### 索引

- toyz/IntermediateJAVA/src/com.JDBC/NewPreparedStatement.java

### 3.Execute, ExecuteUpdate, ExcuteQuery

#### 注意

1. 区别

- Execute方法能实现增删改查; ExecuteUpdate无法执行查询; ExcuteQuery只能执行Select语句
- Execute方法返回值为布尔类型，true是查询，false是insert、update、delete；ExecuteUpdate方法返回值为Int类型，返回受到影响的数据数量；ExcuteQuery方法返回值为执行结果封装的结果集对象

### 4.特殊操作

#### 方法

1. 获取自增长id的方法：getGeneratedKeys()
2. 获取表的元数据

#### 实现

1.获取自增长id的方法

```java
package jdbc;
   
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
   
public class TestJDBC {
   
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);          
                ) {
  
            ps.setString(1, "盖伦");
            ps.setFloat(2, 616);
            ps.setInt(3, 100);
   
            // 执行插入语句
            ps.execute();
   
            // 在执行完插入语句后，MySQL会为新插入的数据分配一个自增长id
            // JDBC通过getGeneratedKeys获取该id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                System.out.println(id);
            }
   
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   
    }
}
```

2.获取表的元数据

```java
package jdbc;
  
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  
public class TestJDBC {
  
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");) {
  
            // 查看数据库层面的元数据
            // 即数据库服务器版本，驱动版本，都有哪些数据库等等
  
            DatabaseMetaData dbmd = c.getMetaData();
  
            // 获取数据库服务器产品名称
            System.out.println("数据库产品名称:\t"+dbmd.getDatabaseProductName());
            // 获取数据库服务器产品版本号
            System.out.println("数据库产品版本:\t"+dbmd.getDatabaseProductVersion());
            // 获取数据库服务器用作类别和表名之间的分隔符 如test.user
            System.out.println("数据库和表分隔符:\t"+dbmd.getCatalogSeparator());
            // 获取驱动版本
            System.out.println("驱动版本:\t"+dbmd.getDriverVersion());
  
            System.out.println("可用的数据库列表：");
            // 获取数据库名称
            ResultSet rs = dbmd.getCatalogs();
  
            while (rs.next()) {
                System.out.println("数据库名称:\t"+rs.getString(1));
            }
  
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
}
```

### 5.事务——重点

#### 方法

1. 使用c.setAutoCommit(false)开头，停止自动提交
2. 使用c.commit()作为事务结尾，手动提交

#### 实现

```java
package com.JDBC;
/*
 * 事务
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class NewCommit {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
				Statement s = c.createStatement();
				)
		{
			/*
			 * 使用事务
			 */
			//自动提交关闭
			c.setAutoCommit(false);
			
			//查询血量语句
			String sqlResearch = "SELECT * from hero where id = 2 ";
			
			//增加血量操作
			String sqlAdd = "UPDATE hero SET hp= hp + 1 where id = 2 ";
			s.execute(sqlAdd);
			System.out.println("加血成功");
			//获取血量
			ResultSet rs = s.executeQuery(sqlResearch);
			rs.next();
			float hp1 = rs.getFloat("hp");
			System.out.println("加血后血量为："+hp1);

			//减少血量操作
			String sqlReduce = "UPDATA hero SET hp= hp - 1 where id = 2 ";
			s.execute(sqlReduce);
			System.out.println("减血成功");
			//获取血量
			ResultSet rs2 = s.executeQuery(sqlResearch);
			rs2.next();
			float hp2 = rs2.getFloat("hp");
			System.out.println("减血后血量为："+hp2);
			
			//手动提交
			c.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
```

#### 注意

1. 事务方法比较重要
2. Mysql中，只有当表的类型是INNODB的时候，才支持事务

#### 索引

1. toyz/IntermediateJAVA/src/com.JDBC/NewCommit.java

### 6.ORM

#### 方法

1. 使用java中的对象来对应SQL中的记录
2. 通过查询遍历后，赋值给java中的对象属性

#### 实现

1.NewORM_main.java

```java
package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * ORM(object relationship database mapping)
 * 将数据库中的表格变成java中的对象
 * 关联：Hero.java
 */
public class NewORM_main {

	public static void main(String[] args) {
		Hero hero = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (		
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
				Statement s = c.createStatement();
				)
		{
			//查询数据库中数据
			String sql = "SELECT * FROM hero";
			ResultSet rs = s.executeQuery(sql);
			//将数据赋值给Java对象
			while(rs.next()) {
				hero = new Hero();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float hp = rs.getFloat("hp");
				int damage = rs.getInt("damage");
				hero.id = id;
				hero.name = name;
				hero.hp = hp;
				hero.damage = damage;
				System.out.println(hero.id+hero.name+"hp:"+hero.hp+"damage:"+hero.damage);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

```

2.Hero.java——对应MySQL中的hero表，其中属性相同

```java
package com.JDBC;

public class Hero {
	public int id;
	public String name;
	public float hp;
	public int damage;
}
```

#### 索引

- toyz/IntermediateJAVA/src/com.JDBC/NewORM.java
- toyz/IntermediateJAVA/src/com.JDBC/Hero.java

### 7.DAO——重点

#### 方法

1. 创建DAO接口，用于写方法名，不涉及具体实现
2. 创建HeroDAO类，涉及具体实现方法

- HeroDAO()，类初始化方法用于驱动初始化
- getConnection()，返回连接
- getTotal()，获取总数
- add()，增加数据
- delete()，根据ID删除数据
- update()，更新数据
- get()，查询数据
- list()，分页输出数据

#### 实现

1.DAO.java——接口

```java
package com.JDBC;

import java.util.List;

/*
 * DAO(data access object)
 * 数据库相关的操作都封装在这个接口里面，其他地方看不到JDBC的代码
 * 关联：HeroDAO.java
 */
public interface DAO {
	//增加
	public void add(Hero hero);
	//删除
	public void delete(int id);
	//修改
	public void update(Hero hero);
	//获取
	public Hero get(int id);
	//查询
	public List<Hero> list(int start,int count);
}
```

2.HeroDAO——实现方法

```java
package com.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/*
 * DAO接口的设计类，实现接口DAO
 * 关联：DAO.java
 */
import java.util.List;

public class HeroDAO implements DAO {
	//将驱动的初始化放在当前类的构造方法中
	public HeroDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动初始化成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//提供getConnection方法返回连接
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
	}
	
	//获取数据总数方法
	public int getTotal() {
		int total = 0;
		try (
				Connection c = getConnection();
				Statement s = c.createStatement();
				)
		{
			String sql = "select count(*) from hero";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				total = rs.getInt(1);
			}
			System.out.println("Total:"+total);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	//添加
	public void add(Hero hero) {
		String sql = "insert into hero values(null,?,?,?)";
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				) 
		{
			//创建事务
			c.setAutoCommit(false);
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.execute();
			//获取数据库分配的ID
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				hero.id = id;
			}
			//手动提交
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//根据ID删除
	public void delete(int id) {
		String sql = "delete from hero where id = ?";
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//更新
	public void update(Hero hero) {
		String sql = "update hero set name = ?, hp = ?, damage = ? where id = ?";
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			//创建事务
			c.setAutoCommit(false);
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.setInt(4, hero.id);
			ps.execute();
			//手动提交事务
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取相应ID的hero对象
	public Hero get(int id) {
		String sql = "select * from hero where id = ?";
		Hero hero = null;
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			ps.setInt(1, id);
			//获取
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				hero = new Hero();
				String name = rs.getString("name");
				float hp = rs.getFloat("hp");
				int damage = rs.getInt("damage");
				hero.name = name;
				hero.hp = hp;
				hero.damage = damage;
				hero.id = id;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hero;
	}
	

	//分页输出列表中hero对象
	public List<Hero> list(int start,int count) {
		List<Hero> heros = new ArrayList();
		String sql = "select * from hero order by id desc limit ? , ?";
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			//传值到数据库
			ps.setInt(1, start);
			ps.setInt(2, count);
			//获取数据库返回值
			ResultSet rs = ps.executeQuery();
			//赋值给Hero对象
			while(rs.next()) {
				Hero hero = new Hero();
				int id = rs.getInt("id");
				String name = rs.getString(2);
				float hp = rs.getFloat(3);
				int damage = rs.getInt(4);
				hero.id = id;
				hero.name = name;
				hero.hp = hp;
				hero.damage = damage;
				heros.add(hero);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return heros;
	}

	public static void main(String[] args) {
		HeroDAO hd = new HeroDAO();
		hd.getTotal();
		//测试添加功能
		Hero hero1 = new Hero("VN",500,300);
		hd.add(hero1);
		System.out.println("添加成功");
		//测试删除功能
		hd.delete(2);
		System.out.println("删除成功");
		//测试更新功能
		Hero hero2 = new Hero(32,"NewVN",5000,5000);
		hd.update(hero2);
		System.out.println("更新成功");
		//获取一条数据
		Hero hero3 = hd.get(32);
		System.out.printf("英雄ID为%d的名字为%s,血量为%.1f,攻击为%d\n",hero3.id,hero3.name,hero3.hp,hero3.damage);
		//输出从1到10的英雄
		System.out.println("-----分页输出-----");
		List<Hero> heros = hd.list(1, 40);
		for (Hero hero : heros) {
			System.out.printf("英雄ID为%d的名字为%s,血量为%.1f,攻击为%d\n",hero.id,hero.name,hero.hp,hero.damage);
		}
	}

}

```

#### 注意

1. 添加时，如果使用getGeneratedKeys，需要在执行sql时增加Statement.RETURN_GENERATED_KEYS
2. 实际上就是运用了[练习-ORM](http://how2j.cn/k/jdbc/jdbc-orm/391.html#step2641)中的思路，把数据库相关的操作都封装在这个类里面，其他地方看不到JDBC的代码

#### 索引

- toyz/IntermediateJAVA/src/com.JDBC/Hero.java
- toyz/IntermediateJAVA/src/com.JDBC/DAO.java
- toyz/IntermediateJAVA/src/com.JDBC/HeroDAO.java

### 8.数据库连接池——难点

#### 方法

1. ConnectionPool() 构造方法约定了这个连接池一共有多少连接
2. 在init() 初始化方法中，创建了size条连接。 注意，这里不能使用try-with-resource这种自动关闭连接的方式，因为连接恰恰需要保持不关闭状态，供后续循环使用
3. getConnection， 判断是否为空，如果是空的就wait等待，否则就借用一条连接出去
4. returnConnection， 在使用完毕后，归还这个连接到连接池，并且在归还完毕后，调用notifyAll，通知那些等待的线程，有新的连接可以借用了。

#### 实现

```java
package jdbc;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
  
public class ConnectionPool {
  
    List<Connection> cs = new ArrayList<Connection>();
  
    int size;
  
    public ConnectionPool(int size) {
        this.size = size;
        init();
    }
  
    public void init() {
          
        //这里恰恰不能使用try-with-resource的方式，因为这些连接都需要是"活"的，不要被自动关闭了
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < size; i++) {
                Connection c = DriverManager
                        .getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
  
                cs.add(c);
  
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
  
    public synchronized Connection getConnection() {
        while (cs.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Connection c = cs.remove(0);
        return c;
    }
  
    public synchronized void returnConnection(Connection c) {
        cs.add(c);
        this.notifyAll();
    }
  
}
```

