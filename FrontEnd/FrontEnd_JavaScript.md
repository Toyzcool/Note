## FrontEnd

### 三.JavaScript

### 1.基础方法

#### 方法

1.调试方法

- alert()，运行到的以上代码没问题
- 运行后，通过浏览器控制台查看错误
- 通过console.log()日志输出

2.变量类型

- Undefined,Boolean,Number,String
- Var,动态类型，会根据赋值自行选择类型
- Typeof,变量类型判断

3.函数

- 格式为function为关键字，print为函数名称，()内为参数列表，{}内部为方法
- 见实现1

4.作用域

- 参数作用域仅仅在函数内部
- 全局变量定义在函数前面，所有函数都可以访问

5.逻辑运算符

- 绝对等于和绝对不等于，===和!===会进行值和类型的判断

#### 实现

1.函数基本方法

```javascript
// 输出函数
function print(message){
	document.write(message);
}
// 计算函数
function calc(x,y){
	return x+y;
}
print(calc(10,20));
```

### 2.Calculator——Practice

#### 预期

实现页面计算器

#### 实现

1.前端——Calculator.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator</title>
<script type="text/javascript" src="hello.js"></script>
</head>
<body>
	<div>
		<input type="text" id="num1">
		<span>+</span>
		<input type="text" id="num2">
		<span>=</span>
		<input type="text" id="res">
		<input type="button" value="计算" onclick="calc()">
	</div>
</body>
</html>
```

2.脚本——Calculator.js

```javascript
// 计算函数
function calc(){
	var num1 = document.getElementById("num1").value;
	var num2 = document.getElementById("num2").value;
	var res = parseInt(num1) + parseInt(num2);
	document.getElementById("res").value = res;
}
```

#### 索引

- Package/FrontEnd/JavaScript/Calculator.html

### 3.InterestCalculate——Practice

#### 预期

利息计算器

#### 实现

1.使用index写前端页面

```html
<!DOCTYPE html>
<html>
<head>
	<title>利息计算器</title>
	<link rel="stylesheet" type="text/css" href="file:///Users/toyz/Package/FrontEnd/JavaScript/PracticeInterestCalculate/style.css"/>
	<script type="text/javascript" src="calc.js"></script>
</head>
<body>
	<div>
		<table>
			<!-- 输入模块 -->
			<tr>
				<td class="item">起始资金</td>
				<td class="date">
					<input type="text" class="input" id="beginMoney"> ¥
				</td>
			</tr>
				<tr>
				<td class="item">每年收益</td>
				<td class="date">
					<input type="text" class="input" id="interest"> %
				</td>
			</tr>
			</tr>
				<tr>
				<td class="item">复利年数</td>
				<td class="date">
					<input type="text" class="input" id="years"> 年
				</td>
			</tr>
			</tr>
				<tr>
				<td class="item">每年追加资金</td>
				<td class="date">
					<input type="text" class="input" id="addMoney"> ¥
				</td>
			</tr>

			<!-- 提交模块 -->
			<tr>
				<td colspan="2" class="item">
					<input type="button" value="计算" onclick="get()" style="width: 50%;margin: 5px;">
				</td>
			</tr>

			<!-- 结果模块 -->
			</tr>
				<tr>
				<td class="item">本金和</td>
				<td class="date">
					<input type="text" class="input" id="benjin"> ¥
				</td>
			</tr>
			</tr>
				<tr>
				<td class="item">利息和</td>
				<td class="date">
					<input type="text" class="input" id="lixi"> ¥
				</td>
			</tr>
			</tr>
				<tr>
				<td class="item">本息和</td>
				<td class="date">
					<input type="text" class="input" id="benxi"> ¥
				</td>
			</tr>
		</table>
	</div>

</body>
</html>
```

2.使用css写前端样式

```css
table{
	border: 1px solid #DFDEDF;
	width: 25%;
	border-collapse: collapse;
	font-size: 13px;
}
td{
	border: 1px solid #DFDEDF;
}
.item{
	text-align: center;
	width: 160px;
}
.date{
	padding: 5px 10px;
	width: 400px;
}
.input{
	width: 80%;
	border-radius: 1px;
}
```

3.使用js写点击事件

```javascript
function get(){
	// 获取输入框中的值
	var beginMoney = parseInt(document.getElementById('beginMoney').value);
	var interest = parseFloat(document.getElementById('interest').value);
	var years = parseInt(document.getElementById('years').value);
	var addMoney = parseInt(document.getElementById('addMoney').value);
	//新建需要赋值的变量
	var benjin = beginMoney ;
	var fuli = (interest/100);
	//计算本金和
	for (var i = 1; i < parseInt(years); i++) {
		benjin = parseInt(benjin) + parseInt(addMoney) ;
	}
	// 计算本息和
	var benxi = beginMoney*Math.pow((1+fuli),years);
	for (var i = years - 1; i >= 1; i--) {
		benxi += addMoney*Math.pow((1+fuli),i);
	}
	var lixi = benxi - benjin;
	//赋值
	document.getElementById('benjin').value = benjin;
	document.getElementById('lixi').value = lixi;
	document.getElementById('benxi').value = benxi;
}
```

#### 索引

- Package/FrontEnd/JavaScript/PracticeInterestCalculate

### 4.对象

略

### 5.BOM（浏览器对象模型）

#### 方法

1.Windows

- 获取文档显示区域的宽度和高度，window.innerWidth
- 获取外部窗体的宽度和高度，window.outerWidth
- 打开一个新窗口，window.open("/")
- 见实现1

2.Navigator

- 浏览器等信息
- 见实现2

3.Screen

- 分辨率等
- 见实现3

4.History

- 返回上一页面
- 返回上上一页面
- 见实现4

5.Location

- 刷新页面
- 返回首页
- 见实现5

6.Pop

- 警告框
- 确认框
- 输入框
- 见实现6

7.计时器

- 函数setInterval(函数名, 重复执行的时间间隔毫秒数 )，重复执行
- 可以设计页面计时器
- 见实现7

#### 实现

1.window方法

```html
<!DOCTYPE html>
<html>
<head>
	<title>Windows方法</title>
	<script type="text/javascript">
		// 文档内部高度和宽度
		document.write("-----文档内部高度和宽度-----");
		document.write("<br>");
		document.write("文档内部高度："+window.innerHeight);
		document.write("<br>");
		document.write("文档内部宽度："+window.innerWidth);
		document.write("<br>");	
		
		// 浏览器外部高度和宽度
		document.write("-----浏览器高度和宽度-----");
		document.write("<br>");
		document.write("浏览器高度："+window.outerHeight);
		document.write("<br>");
		document.write("浏览器宽度："+window.outerWidth);
		document.write("<br>");

		// 新建窗口
		document.write("-----新建窗口-----");
		document.write("<br>");
		function newWindow(){
			myWindow = window.open("/");
		}
	</script>
</head>
<body>
	<!-- 新建窗口按钮 -->
	<button onclick="newWindow()" style="width: 100px;height: 40px;font-size: 16px;background-color: black;color: white;border-radius: 5px;" >新建窗口</button>
</body>
</html>
```

2.Navigator

```html
<!DOCTYPE html>
<html>
<head>
	<title>Navigator方法</title>
	<script type="text/javascript">
		document.write("<p>浏览器产品名称：");
		document.write(navigator.appName + "</p>");
		 
		document.write("<p>浏览器版本号：");
		document.write(navigator.appVersion + "</p>");
		 
		document.write("<p>浏览器内部代码：");
		document.write(navigator.appCodeName + "</p>");
		 
		document.write("<p>操作系统：");
		document.write(navigator.platform + "</p>");
		 
		document.write("<p>是否启用Cookies：");
		document.write(navigator.cookieEnabled + "</p>");
		 
		document.write("<p>浏览器的用户代理报头：");
		document.write(navigator.userAgent + "</p>");
</script>
</head>
<body>

</body>
</html>
```

3.Screen

```html
<html>
<body>
	<script type="text/javascript">
		document.write("用户的屏幕分辨率: ")
		document.write(screen.width + "*" + screen.height)
		document.write("<br />")
		document.write("可用区域大小: ")
		document.write(screen.availWidth + "*" + screen.availHeight)
		document.write("<br />")
	</script>
</body>
</html>
```

4.History

```html
<!DOCTYPE html>
<html>
<head>
	<title>History</title>
	<script type="text/javascript">
		function goBack(){
			history.back();
		}
		function goBackTwice(){
			history.go(-2);
		}
	</script>
</head>
<body>
	<button onclick="goBack()">返回</button>
	<button onclick="goBackTwice()">返回两次</button>
</body>
</html>
```

5.Location

```html
<!DOCTYPE html>
<html>
<head>
	<title>Location</title>
	<script type="text/javascript">
		//基本信息
		document.write("<h2>-----基本信息-----</h2>");
	    function p(s){
		document.write(s);
		document.write("<br>");
		} 
		p("协议 location.protocol:"+location.protocol);
		p("主机名 location.hostname:"+location.hostname);
		p("端口号 (默认是80，没有即表示80端口)location.port:"+location.port);
		 
		p("主机加端口号 location.host: "+location.host);
		p("访问的路径  location.pathname: "+location.pathname);
		 
		p("锚点 location.hash: "+location.hash);
		p("参数列表 location.search: "+location.search);

		// 刷新页面
		document.write("<h2>-----刷新页面-----</h2>");
		var d = new Date();
		document.write(d.getHours());
	    document.write(":");
	    document.write(d.getMinutes());
	    document.write(":");
	    document.write(d.getSeconds());
	    document.write(":");
	    document.write(d.getMilliseconds());
	    document.write("<br>");
	    function refresh(){
	    	location.reload();
	    }

	    //跳转到首页
	    function jump(){
	    	location = '/';
	    }
	</script>
</head>
<body>
	<!-- 刷新页面 -->
	<button onclick="refresh()">刷新页面</button>
	<br>
	<!-- 跳转到首页 -->
	<h2>-----跳转首页-----</h2>
	<button onclick="jump()">跳转首页</button>
</body>
</html>
```

6.Pop

```html
<!DOCTYPE html>
<html>
<head>
	<title>Pop</title>
	<script type="text/javascript">
		//警告框
		function register(){
			alert("注册成功");
		}

		//确认框
		function dele(){
			var d = confirm("是否要删除");
			// alert(typeof d + "" + d)
		}
		function input(){
			var d = prompt("请输入用户名");
			alert("您输入的用户名为"+d)
		}
	</script>
</head>
<body>
	<h2>-----警告框-----</h2>
	<button onclick="register()">注册</button>

	<h2>-----确认框-----</h2>
	<button onclick="dele()">删除</button>

	<h2>-----输入框-----</h2>
	<button onclick="input()">输入</button>
</body>
</html>
```

7.计时器

```html
<!DOCTYPE html>
<html>
<head>
	<title>Timing</title>
	<script type="text/javascript">
		function printTime(){
			var d = new Date();
			var h = d.getHours();
			var m = d.getMinutes();
			var s = d.getSeconds();
			document.getElementById('time').innerHTML = h+":"+m+":"+s
		}
		var t = setInterval(printTime,1000);
	</script>
</head>
<body>
	<div id="time"></div>
</body>
</html>
```

#### 索引

- Package/FrontEnd/JavaScript/BOM