## J2EE

### B.Servlet

### 1.简介

#### 方法

1.流程

- html网页的form形式提交请求，action为login，method为post
- tomcat收到请求，通过web.xml文件查找到/login路径，匹配到LoginServlet类
- 调用LoginServlet中的doPost方法
- Servlet工作完成
- tomcat拿到response后，通过HTTP传输协议到html
- 见实现1

2.Get方式的情况

- Form的默认提交方式
- 通过超链接访问
- 通过输入网址访问
- ajax指定使用get方式

3.Post方式的情况

- Form指定使用post方式
- ajax指定使用post方式

4.Service()，用于判断使用get还是post方式，在doGet和doPost方式前会先调用此方式

5.Servlet是什么？——important重要！

- Servlet类似Java中的一个类，用于处理tomcat分发过来的数据，不直接和客户端交互
- 核心包括三个方法，init(),service(),destory()
- init方法为：初始化时需要做什么
- service方法为：收到请求后需要做什么
- destroy方法为：销毁后需要做什么

#### 实现

1.实现1

- Login.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		账号: <input type="text" name="name"> <br>
		密码: <input type="password" name="password"> <br>
		<input type="submit" value="登录">
	</form>

</body>
</html>
```

- Web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app>
 	<servlet>
        <servlet-name>LoginServlet</servlet-name>
        <servlet-class>LoginServlet</servlet-class>
    </servlet>
 
    <servlet-mapping>
        <servlet-name>LoginServlet</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>  
    
</web-app>
```

- LoginServlet.java

```java
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String html = null;
        if ("admin".equals(name) && "123".equals(password))
            html = "<div style='color:green'>success</div>";
        else
            html = "<div style='color:red'>fail</div>";
        PrintWriter pw = response.getWriter();
        pw.println(html);
        
    }
}
```

#### 注意

1.由于init仅仅在tomcat建立时运行一次，因此希望类的内容修改能够随时更新，则需要设置web.xml文件中的reloadable="trues"

#### 索引

- Users/toyz/Package/J2EE/LoginServlet.java
- Users/toyz/Package/J2EE/Web.xml
- Users/toyz/Package/J2EE/Login.html

### 2.跳转

#### 方法

1.跳转分为服务器跳转和客户端跳转

2.服务器跳转

- 服务器调用Servlet方法
- 确认账号密码正确
- 在服务器内容打开success.html

3.客户端跳转

- 服务器调用Servlet方法
- 确认账号密码正确
- 服务器发给浏览器信息，让浏览器打开的success.html
- 访问success.html
- 服务器将将网页内容发送给浏览器

#### 实现

1.LoginServlet.java

```java
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if ("admin".equals(name) && "123".equals(password))
        	request.getRequestDispatcher("success.html").forward(request,response);
        else
            response.sendRedirect("fail.html");
        
    }
}
```

#### 注意

- 服务器跳转，网址不会改变；客户端跳转，网址将变为fail.html

#### 索引

- Users/toyz/Package/J2EE/LoginServlet.java

### 3.Request常见方法

#### 方法

1.种类一

- request.getRequestURL(): 浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有)"
- request.getRequestURI(): 浏览器发出请求的资源名部分，去掉了协议和主机名" 
- request.getQueryString(): 请求行中的参数部分，只能显示以get方式发出的参数，post方式的看不到
- request.getRemoteAddr(): 浏览器所处于的客户机的IP地址
- request.getRemoteHost(): 浏览器所处于的客户机的主机名
- request.getRemotePort(): 浏览器所处于的客户机使用的网络端口
- request.getLocalAddr(): 服务器的IP地址
- request.getLocalName(): 服务器的主机名
- request.getMethod(): 得到客户机请求方式一般是GET或者POST

2.获取页面参数

- request.getParameter(): 是常见的方法，用于获取单值的参数
- request.getParameterValues(): 用于获取具有多值的参数，比如注册时候提交的 "hobits"，可以是多选的。
- request.getParameterMap(): 用于遍历所有的参数，并返回Map类型。

3.获取头部信息

- request.getHeader() 获取浏览器传递过来的头信息。 
  比如getHeader("user-agent") 可以获取浏览器的基本资料，这样就能判断是firefox、IE、chrome、或者是safari浏览器
- request.getHeaderNames() 获取浏览器所有的头信息名称，根据头信息名称就能遍历出所有的头信息

#### 实现

1.register.html

```html
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册</title>
	</head>
	
	<body>
		<form action="register" method="get">
			账号：<input type="text" name="name"><br>
			爱好：<br>
			<input type="checkbox" name="hobits" value="LOL">LOL<br>
			<input type="checkbox" name="hobits" value="Dota">Dota<br>
			<input type="submit" value="注册">
		</form>

	</body>
</html>
```

2.Web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app>
    
    <!-- RegisterServlet -->
    <servlet>
    	<servlet-name>RegisterServlet</servlet-name>
    	<servlet-class>RegisterServlet</servlet-class>	
    </servlet>
    
    <servlet-mapping>
    	<servlet-name>RegisterServlet</servlet-name>
    	<url-pattern>/register</url-pattern>
    </servlet-mapping>
    
    
</web-app>
```

3.RegisterRervlet.java

```java
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class RegisterServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        System.out.println("获取单值参数name:" + request.getParameter("name"));
 
        String[] hobits = request.getParameterValues("hobits");
        System.out.println("获取具有多值的参数hobits: " + Arrays.asList(hobits));
 
        System.out.println("通过 getParameterMap 遍历所有的参数： ");
        Map<String, String[]> parameters = request.getParameterMap();
 
        Set<String> paramNames = parameters.keySet();
        for (String param : paramNames) {
            String[] value = parameters.get(param);
            System.out.println(param + ":" + Arrays.asList(value));
        }
 
    }
 
}
```

#### 注意

- 中文乱码，需要在Servlet中增加语句

  ```java
  request.setCharacterEncoding("UTF-8"); 
  ```

  

#### 索引

- Users/toyz/Package/J2EE/register.html
- Users/toyz/Package/J2EE/Web.xml
- Users/toyz/Package/J2EE/RegisterServlet.java

### 4.response用法

#### 方法

1.设置响应内容

- 通过 response.getWrite(),获取一个PrintWrite的对象
- 然后使用该对象的println(),append(),write(),format()等等方法
- 见实现1

2.设置响应格式

- 使用response.setContentType("text/html");
- 当("text/html")中浏览器无法识别，比如更换成("text/lol")，就将调用下载。此方法用于下载功能

3.设置响应编码

- response.setContentType("text/html; charset=UTF-8");发送到浏览器内容和通知浏览器都是utf-8编码
- response.setCharacterEncoding("UTF-8");仅仅发送到浏览器内容是utf-8编码

4.设置不使用缓存

- response.setDateHeader("Expires",0 );

  response.setHeader("Cache-Control","no-cache");

  response.setHeader("pragma","no-cache");

#### 实现

1.响应内容

```java
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	 
public class HelloServlet extends HttpServlet{
	public void init(ServletConfig config) {
		System.out.println("Init of Servlet");
	}
	public void service(HttpServletRequest request, HttpServletResponse response){   
		try {
			//设置缓冲区中使用的编码为UTF-8
			response.setCharacterEncoding("UTF-8");
			//设置浏览器接受内容时所使用的编码方式
			response.setContentType("text/html;charset = UTF-8");
			
			response.getWriter().println("<h1>Hello Servlet!</h1>");
	        response.getWriter().println(new Date());
	        
	        PrintWriter pw = response.getWriter();
	        pw.println("<h2>使用response的getWriters</h2>");
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}s   
}
```

#### 注意

- 中文乱码，需要在Servlet中增加

  ```java
  //设置缓冲区中使用的编码为UTF-8
  response.setCharacterEncoding("UTF-8");
  //设置浏览器接受内容时所使用的编码方式
  response.setContentType("text/html;charset = UTF-8");
  ```

#### 索引

- Users/toyz/Package/J2EE/HelloServlet.java

### 5.上传文件

#### 方法——待重新学习

1.[http://how2j.cn/k/servlet/servlet-upload/587.html#nowhere](http://how2j.cn/k/servlet/servlet-upload/587.html#nowhere)

#### 实现

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
  
public class UploadPhotoServlet extends HttpServlet {
  
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
  
        String filename = null;
        try {
        	// 配置上传参数
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            // 设置上传文件的大小限制为1M
            factory.setSizeThreshold(1024 * 1024);
            
            List items = null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
  
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                
                // 判断表单是否为普通类型，不是则为其他类型
                if (!item.isFormField()) {

                    // 根据时间戳创建头像文件
                    filename = System.currentTimeMillis() + ".jpg";
                    
                    //通过getRealPath获取上传文件夹，如果项目在e:/project/j2ee/web,那么就会自动获取到 e:/project/j2ee/web/uploaded
                    String photoFolder =request.getServletContext().getRealPath("uploaded");
                    
                    File f = new File(photoFolder, filename);
                    f.getParentFile().mkdirs();
  
                    // 通过item.getInputStream()获取浏览器上传的文件的输入流
                    InputStream is = item.getInputStream();

                    // 复制文件
                    FileOutputStream fos = new FileOutputStream(f);
                    byte b[] = new byte[1024 * 1024];
                    int length = 0;
                    while (-1 != (length = is.read(b))) {
                        fos.write(b, 0, length);
                    }
                    fos.close();

                } else {
                    System.out.println(item.getFieldName());
                    String value = item.getString();
                    value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                    System.out.println(value);
                }
            }
             
            String html = "<img width='200' height='150' src='uploaded/%s' />";
            response.setContentType("text/html");
            PrintWriter pw= response.getWriter();
             
            pw.format(html, filename);
             
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
```

#### 索引

- Users/toyz/Package/J2EE/UploadPhotoServlet.java

### 6.动态Web项目

#### 方法

1.Servlet建立流程

- 新建Dynamic Web project，同时添加Target runtime
- runtime中添加响应的tomcat版本，选择tomcat所在的地址——如果没有相应的tomcat版本，下载Eclipse JST Server Adapters或者检查eclipse是否为JavaEE版本
- 新建类，包名可以为空（方便输入地址时，只需要加上 项目名/类名）
- 在WebContent/WEB-INF/lib中添加Servlet的包
- 新建web.xml文件，编写映射
- 右键项目，run as 选择在Server
- 启动tomcat（如果端口被占用，则使用lsof -i tcp:22查询占用端口的应用，并使用kill pid来结束占用端口的进程）
- 在浏览器输入[http://127.0.0.1:8080/Dynamic/hello](http://127.0.0.1:8080/Dynamic/hello)
- 错误处理时，查看eclipse中的Markers来排错

#### 注意

1.通过地址访问部署在Server上的文件，可以省略项目名的方法

- 1.修改server.xml文件：将path中的项目名删除
  <Context docBase="Dynamic" path="/项目名" reloadable="true" source="org.eclipse.jst.jee.server:Dynamic"/></Host>改为<Context docBase="Dynamic" path="/" reloadable="true" source="org.eclipse.jst.jee.server:Dynamic"/></Host>
- 2.修改项目ProperProperties：右键项目-ProperProperties-Web Project Setting-Context root中的内容修改为/

### 7.使用Servlet进行CRUD开发

#### 方法

1.程序设计

- 简单的增删改查
- 新建前端页面，使用Form表单提交
- 新建.xml文件，设计前端请求映射到指定类方法
- 新建Java类，用于处理请求，并返回特定跳转链接，或使用getWriter().write(html)方法

2.Java类中写html语言

- 使用StringBuffer类中的append方法，添加html语言
- 使用String.format()方法给属性赋值
- 使用getWriter().write(html)展示出页面

#### 实现

1.addHero.html

```html
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加英雄</title>
	</head>
	
	<body>
		<h2>新增英雄</h2>
		<form action="addHero" method="post">
			名字：<input type="text" name="name"><br>
			血量：<input type="text" name="hp"><br>
			伤害：<input type="text" name="damage"><br>
			<input type="submit" value="增加">
		</form>
	</body>
</html>
```

2.Hero.java

```java
package servlet;

public class Hero {
	public int id;
	public String name;
	public float hp;
	public int damage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}

```

3.HeroDAO.java

```java
package servlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * 数据库的增删改查方法具体实现
 */

public class HeroDAO{
	// 构造方法初始化驱动
	public HeroDAO(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("初始化驱动成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//提供getConnection方法返回连接
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
	}
	
	// 获取数据总数
	public int getTotal() {
		int total = 0;
		try (
				Connection c = getConnection();
				Statement s = c.createStatement();
				)
		{
			String sql = "select count(*) from hero";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}
			System.out.println("Total："+total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
		
	// 增加
	public void add(Hero hero) {
		String sql = "insert into hero value(null,?,?,?)";
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				) 
		{
			c.setAutoCommit(false);
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.execute();
			// 获取数据库分配的id
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				hero.id = id;
			}
			c.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		};
	};
		
	// 删除
	public void delete(int id) {
		String sql = "delete from hero where id = ?";
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			c.setAutoCommit(false);
			ps.setInt(1, id);
			ps.execute();
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
		
	// 修改
	public void update(Hero hero) {
		String sql = "update hero set name = ? , hp = ? , damage = ? where id = ?";
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql)
				)
		{
			c.setAutoCommit(false);
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.setInt(4, hero.id);
			ps.execute();
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
		
	// 获取
	public Hero get(int id) {
		String sql = "select * from hero where id = ?";
		Hero hero = null;
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)	 
		{
			c.setAutoCommit(false);
			ps.setInt(1, id);
			c.commit();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 hero = new Hero();
				 String name = rs.getString("name");
				 float hp = rs.getFloat("hp");
				 int damage = rs.getInt("damage");
				 hero.name = name;
				 hero.hp = hp;
				 hero.damage = damage;
				 hero.id = id;
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hero;
	};
	
	public List<Hero> list() {
        return list(0, Short.MAX_VALUE);
    }

	// 查询
	public List<Hero> list(int start,int count){
		List<Hero> heros = new ArrayList<Hero>();
		String sql = "select * from hero order by id desc limit ? , ?";
		try (
				Connection c =  getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			c.setAutoCommit(false);
			ps.setInt(1, start);
			ps.setInt(2, count);
			c.commit();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
	};
}

```

4.HeroListServlet.java

```java
package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HeroListServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置浏览器接受内容时所使用的编码方式
		response.setContentType("text/html;charset = UTF-8");
		// 获取英雄列表
		List<Hero> heros = new HeroDAO().list();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table align='center' border='1' cellspacing='0'>");
		sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td><td>update</td><td>delete</td></tr>");
		
		String trForm = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td><td><a href = 'editHero?id=%d'>update</a></td><td><a href = 'deleteHero?id=%d'>delete</a></td></tr>";
		for (Hero hero : heros) {
			String tr = String.format(trForm, hero.getId(),hero.getName(),hero.getHp(),hero.getDamage(), hero.getId(),hero.getId());
			sb.append(tr);
		}
		sb.append("</table>");
		
		response.getWriter().write(sb.toString());
	}
}

```

5.HeroAddServlet

```java
package servlet;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HeroAddServlet extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		// 对客户端请求进行重现编码
		request.setCharacterEncoding("UTF-8");
		Hero hero = new Hero();
		hero.setName(request.getParameter("name")); 
		hero.setHp(Float.parseFloat(request.getParameter("hp")));
		hero.setDamage(Integer.parseInt(request.getParameter("damage")));
		new HeroDAO().add(hero);
		response.sendRedirect("/listHero");
	};
}
```

6.HeroDeleteServlet.java

```java
package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HeroDeleteServlet extends HttpServlet {
	protected void service(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		// 对客户端请求进行重现编码
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id")) ;
		new HeroDAO().delete(id);
		
		response.sendRedirect("/listHero");
	}
}

```

7.HeroEditServlet

```java
package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HeroEditServlet extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id")) ;
		
		// 获取需要更新的英雄
		Hero hero = new HeroDAO().get(id);
		
		StringBuffer format = new StringBuffer();
		response.setContentType("text/html; charset=UTF-8");
		
		// 提交修改的表格
		format.append(" <Form action='updateHero' method='post'> ");
		format.append(" 名字：<input type='text' name='name' value='%s'> <br> ");
		format.append(" 血量：<input type='text' name='hp' value='%f'> <br> ");
		format.append(" 攻击：<input type='text' name='damage' value='%d'> <br> ");
		format.append(" <input type='hidden' name='id' value='%d'> <br> ");	// 用于传输ID
		format.append(" <input type='submit' value='提交'> <br> ");
		format.append(" </form> ");
		String html = String.format(format.toString(),hero.getName(),hero.getHp(),hero.getDamage(),hero.getId());
		
		response.getWriter().write(html);
	}
}
```

8.HeroUpdateServlet

```java
package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HeroUpdateServlet extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 新建英雄对象
		Hero hero = new Hero();
		
		// 获取英雄各个属性,并使用赋值方法
		hero.setId(Integer.parseInt(request.getParameter("id")));
		hero.setName(request.getParameter("name")); 
		hero.setHp(Float.parseFloat(request.getParameter("hp")));
		hero.setDamage(Integer.parseInt(request.getParameter("damage")));
		
		new HeroDAO().update(hero);
		
		response.sendRedirect("/listHero");
	}
}

```

9.web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app>
  
    <servlet>
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>HelloServlet</servlet-class>
    </servlet>
  
    <servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
  	
  	<!-- 获取英雄列表 -->
  	<servlet>
        <servlet-name>HeroListServlet</servlet-name>
        <servlet-class>servlet.HeroListServlet</servlet-class>
    </servlet>
 
    <servlet-mapping>
        <servlet-name>HeroListServlet</servlet-name>
        <url-pattern>/listHero</url-pattern>
    </servlet-mapping> 
    
    <!-- 增加英雄 -->
     <servlet>
        <servlet-name>HeroAddServlet</servlet-name>
        <servlet-class>servlet.HeroAddServlet</servlet-class>
    </servlet>
 
    <servlet-mapping>
        <servlet-name>HeroAddServlet</servlet-name>
        <url-pattern>/addHero</url-pattern>
    </servlet-mapping>
    
     <!-- 删除英雄 -->
     <servlet>
        <servlet-name>HeroDeleteServlet</servlet-name>
        <servlet-class>servlet.HeroDeleteServlet</servlet-class>
    </servlet>
 
    <servlet-mapping>
        <servlet-name>HeroDeleteServlet</servlet-name>
        <url-pattern>/deleteHero</url-pattern>
    </servlet-mapping>
    
    <!-- 编辑英雄 -->
     <servlet>
        <servlet-name>HeroEditServlet</servlet-name>
        <servlet-class>servlet.HeroEditServlet</servlet-class>
    </servlet>
 
    <servlet-mapping>
        <servlet-name>HeroEditServlet</servlet-name>
        <url-pattern>/editHero</url-pattern>
    </servlet-mapping>
    
    <!-- 编辑英雄 -->
     <servlet>
        <servlet-name>HeroUpdateServlet</servlet-name>
        <servlet-class>servlet.HeroUpdateServlet</servlet-class>
    </servlet>
 
    <servlet-mapping>
        <servlet-name>HeroUpdateServlet</servlet-name>
        <url-pattern>/updateHero</url-pattern>
    </servlet-mapping>
    
</web-app>
```

#### 注意

1.Servlet编写html代码易用性较差，因此考虑用JSON

2.当前内容学习目的是掌握底层的处理逻辑

#### 索引

- Users/toyz/Package/J2EE/Dynamic

#### 8.使用JSON格式传输数据