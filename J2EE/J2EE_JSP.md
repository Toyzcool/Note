

## J2EE

### C.JSP

### 1.简介

#### 方法

1.执行过程

- 浏览器打开.jsp文件
- 服务器收到后转译成Servlet类型文件（原因是继承了HttpServlet类）
- 再编译成.class文件
- 服务器执行，并返回结果给浏览器

2.JSP页面元素

![é¡µé¢åç´ ](http://stepimagewm.how2j.cn/1657.png)

### 2.Include

#### 方法

1.Include方法

- 把页面分模块开发，页首、页尾分别使用include来引入，减少重复开发

2.指令Include，动作Include的实现，见实现1

3.指令Include，动作Include区别

- 指令Include中的内容会加入文件中，并生成一个java文件
- 动作Include中的内容不会加入文件中，会单独生成一个java文件，并在服务器返回的响应中插入内容

4.传参

- 指令Include由于会合并生成一个java文件，因为不存在传参
- 动作Include可以传参，引用文件设置值，被引用文件接受请求过来的参数，见实现1

#### 实现

实现1

```jsp
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<!-- 1.输出内容 -->
<%="Hello World" %>
<br>
<%=new Date().toLocaleString()%>

<!-- 2.使用for循环输出 -->
<% 
	List<String> words = new ArrayList();
	words.add("today");
	words.add("is");
	words.add("good");
%>
<table width="200px" align="center" border="1" cellspacing="0">
	<%for(String word : words){%>
		<tr>
			<td align="center"><%= word %> </td>
		</tr>
	<%}%>
</table>
<!-- 指令include -->
<%@ include file="footer.jsp" %>
<!-- 动作include -->
<jsp:include page="footer.jsp" >
	<jsp:param name="year" value="2019"/>
</jsp:include>
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<p style="text-align:center">copyright@<%= request.getParameter("year") %>
	</p>
</body>
</html>
```

#### 索引

- Package/J2EE/JSP/JSP/hello.jsp
- Package/J2EE/JSP/JSP/footer.jsp

### 3.Jump跳转

#### 方法

1.使用客户端跳转

2.使用服务器跳转

#### 实现

1.客户端跳转

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试客户端跳转和服务器跳转</title>
</head>
<body>
	<% response.sendRedirect("hello.jsp"); %>
</body>	
</html>
```

2.服务器跳转

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试客户端跳转和服务器跳转</title>
</head>
<body>
	<jsp:forward page="hello.jsp"/>
</body>
			
</html>
```

#### 索引

- Package/J2EE/JSP/JSP/jump.jsp

### 4.Cookie

#### 方法

1.流程

- 客户端访问setCookie.jsp
- 服务器将用户名保存在cookie中，并发送给客户端
- 客户端保存在本地
- 访问getCookie.jsp
- 提交cookie文件，从cookie获取用户名

#### 实现

1.setCookie.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set Cookie</title>
</head>
<body>
	<%
		Cookie c = new Cookie("name","Toyz");
		c.setMaxAge(24*60*60);
		c.setPath("/");
		response.addCookie(c);
	%>
</body>
</html>
```

2.getCookie.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Cookie</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		if(null != cookies)
			for (int d = 0; d <= cookies.length - 1; d++) {
	            out.print(cookies[d].getName() + ":" + cookies[d].getValue() + "<br>");
				}
	%>
</body>
</html>
```

### 5.Session

#### 方法

1.使用session.setAttribute("name","Session")方法设置session参数

2.使用session.getAttribute()方法获取参数

3.session和cookie关系

- session等于盒子
- cookie等于打开相应盒子的钥匙

### 6.作用域

#### 方法

1.pageContext，为当前页面有效

2.requestContext，为当前请求有效

- 如果使用服务器跳转，则可以传参
- 如果使用客户端跳转，则为两次请求，无法传参

3.sessionContext，为会话有效。打开链接后，无论访问多少页面，都属于同一会话中，因此一直有效

4.applicationContext，所有用户共享。本质为ServletContext接口的实例

#### 实现

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>向作用域设置数据</title>
</head>
<body>
<%
	/* 当前页面 */
	pageContext.setAttribute("name", "PageContextData");

	/* 当前用户所属的会话 */
	pageContext.setAttribute("name", "SessionData",pageContext.SESSION_SCOPE);
	
	/* 全局 */
	pageContext.setAttribute("name", "ApplicationData",pageContext.APPLICATION_SCOPE);
%>
	<!-- 当前页面 -->
	页面数据为：<%= pageContext.getAttribute("name") %>，只能在当前页面访问<br>
	
	<!-- 当前用户所属的会话 -->
	会话数据为：<%= pageContext.getAttribute("name",pageContext.SESSION_SCOPE) %>，可用于页面间数据传递<br>
	
	<!-- 全局 -->
	全局数据为：<%= pageContext.getAttribute("name",pageContext.APPLICATION_SCOPE) %>，所有用户共享<br>
</body>
</html>
```

#### 索引

- Package/J2EE/JSP/JSP/setContext.jsp
- Package/J2EE/JSP/JSP/setRequest.jsp

### 9.隐式

#### 方法

1.JSP一共有9个隐式对象，分别是 

- request,response,out 
- pageContext, session,application 
- page,config,exception

2.隐式不需要显示定义，可以直接使用

### 10.JSTL

#### 方法

1.JSTL为标准标签库，能够像使用HTML标签一样在jsp中开发Java功能

2.具体方法和实现见，实现1

#### 实现

```jsp
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
   
    <!-- 引入使用的JSTL标签库 -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<!-- 引入使用的JSTL标签库,fmt常用于格式化数字 -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>

	<!-- 1.赋值和输出值的方法 -->
	<h3>1.赋值和输出值的方法</h3>
		<!-- 在request作用域中设置值 -->
		<c:set var="name" value="${'JSTLName'}" scope="request" />
		
		<!-- 输出在request中的值 -->
		通过标签获取name:<c:out value="${name}" />
	
	<!-- 2.if逻辑判断 -->
	<h3>2.if逻辑判断</h3>
		<c:set var="hp" value="${10}" scope="request" />
		<!-- if判断 -->
		<c:if test="${hp < 5 }" >
			<p> 英雄血量较低 </p>
		</c:if>
		<c:if test="${!(hp < 5) }">
			<p> 英雄血量健康 </p>
		</c:if>
		
		<%
			pageContext.setAttribute("weapon", null);
		%>
		<c:if test="${empty weapon }">
			<p> 英雄没有武器 </p>
		</c:if>
	
	<!-- 3.choose逻辑判断 -->
	<h3>3.choose逻辑判断</h3>
		<c:set var="hp" value="${8}" scope="request" />
		<c:choose>
			<c:when test="${ hp == 10 }"> <p>英雄满血</p> </c:when>
			<c:when test="${ hp == 9 }"> <p>英雄高血量</p> </c:when>
			<c:when test="${ hp == 1 }"> <p>英雄血量不足</p> </c:when>	
			<c:otherwise><p>英雄血量未知</p></c:otherwise>
		</c:choose>
	
	<!-- 4.forEach -->
	<h3>4.forEach</h3>
	<%
		List<String> heros = new ArrayList();
		heros.add("塔姆");
		heros.add("伊泽瑞尔");
		heros.add("薇恩");
		request.setAttribute("heros", heros);
	%>
	<table width="200px" align="center" border="1" cellspacing="0">
		<tr>
			<td>英雄</td>
			<td>编号</td>
		</tr>
		<c:forEach items="${ heros }" var="hero" varStatus="st" >
		<tr>
			<td> <c:out value="${ st.count }" /></td>
			<td> <c:out value="${ hero }" /></td>
		</tr>
		</c:forEach>
	</table>
	
	<!-- 5.fmt格式化数字 -->
	<h3>5.fmt格式化数字</h3>
	<c:set var="money" value="10" />
	<c:set var="pi" value="23.12121" />
	原数字为10,最少两个小数点：<fmt:formatNumber type="number" value="${ money }" minFractionDigits="2" ></fmt:formatNumber>
	<br>
	原数字为23.12121,最多两个小数点：<fmt:formatNumber type="number" value="${ pi }" maxFractionDigits="2" ></fmt:formatNumber>
	
	<!-- 6.fmt格式化日期 -->
	<h3>6.fmt格式化日期</h3>
	<%
		Date now = new Date();
		pageContext.setAttribute("now", now);
	%>
	<fmt:formatDate value="${ now }" pattern="YYYY年MM月dd日" />
	
	
</body>
</html>
```

#### 索引

- Package/J2EE/JSP/JSP/JSTL.jsp

### 10.EL表达式语言

#### 方法

1.取值

- 使用${name},进行取值，见实现1

2.作用域优先级

- pageContext>request>session>application

3.获取JavaBean属性，只需要通过符号.来获取，实现2

4.改造forEach方法，实现2

5.取参方法，${param.name}

6.条件判断，实现2

- eq相等 ne、neq不相等，
  gt大于， lt小于
  gt大于， lt小于
  gte、ge大于等于 
  lte、le 小于等于 
  not非 mod求模 
  is [not] div by是否能被某数整除 
  is [not] even是否为偶数 
  is [not] odd是否为奇

#### 实现

实现1

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
      <!-- 引入使用的JSTL标签库 -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>

	<!-- 1.取值 -->
	<h3>1.取值</h3>
	<c:set var="name" value="${ 'Toyz' }" scope="request" />
	通过标签获取：<c:out value="${ name }" /><br>
	通过EL获取：${ name }
</body>
</html>
```

实现2

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="bean.*"%>
      <!-- 引入使用的JSTL标签库 -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>

	<!-- 1.取值 -->
	<h3>1.取值</h3>
	<c:set var="name" value="${ 'Toyz' }" scope="request" />
	通过标签获取：<c:out value="${ name }" /><br>
	通过EL获取：${ name }
	
	<!-- 2.获取JavaBean属性 -->
	<h3>2.获取JavaBean属性</h3>
	<%
		Hero hero = new Hero();
		hero.setName("Tooyz");
		hero.setDamage(100);
		request.setAttribute("hero", hero);
	%>
	英雄姓名：${ hero.name } <br>
	英雄攻击力：${ hero.damage }
	
	<!-- 3.EL结合forEach -->
	<h3>3.EL结合forEach</h3>
		<%
			List<String> heros = new ArrayList();
			heros.add("A");
			heros.add("B");
			heros.add("C");
			request.setAttribute("heros", heros);
		%>
		<table width="200px" align="center" border="1" cellspacing="0">
		<tr>
			<td>序号</td>
			<td>名称</td>
		</tr>
		<c:forEach items="${ heros }" var="hero" varStatus="st">
			<tr>
			<td>${ st.count }</td>
			<td>${ hero }</td>
		</tr>
		</c:forEach>
		</table>
	
	<!-- 4.EL表达式eq的用法 -->
	<h3>4.EL表达式eq的用法</h3>
	<%
		request.setAttribute("killNumber", "10");
	%>
	EL表达式eq的用法,运行结果为：${ killNumber ge 10? "超神":"没超神" }
	
	
</body>
</html>
```

Hero.java

```java
package bean;
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









