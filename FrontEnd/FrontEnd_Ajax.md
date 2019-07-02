## FrontEnd

### 四.Ajax

### 1.基本原理

#### 方法

1.浏览器端

- 创建XMLHttpRequest对象
- 设置响应函数
- 设置访问页面
- 执行访问

2.服务器端

- 调用响应函数
- 判断是否响应成功
- 获取响应文本
- 显示响应文本

#### 实现

```html
<!DOCTYPE html>
<html>
<head>
	<title>Check Account</title>
	<script type="text/javascript">
		var xmlhttp;
		// 判断函数
		function check(){
			var name =  document.getElementById('name').value;
			var url = "http://how2j.cn/study/checkName.jsp?name="+name;

			// 新建XML对象
			xmlhttp = new XMLHttpRequest();
			// 设置响应函数
			xmlhttp.onreadystatechange = checkResult;
			// 设置访问页面
			xmlhttp.open("GET",url,true);
			// 发出请求
			xmlhttp.send(null);
		}

		// 响应函数
		function checkResult(){
			// 判断响应是否成功，成功则赋值
			if (xmlhttp.readyState == 4 & xmlhttp.status == 200) {
				document.getElementById('checkResult').innerHTML = xmlhttp.responseText;
			}
		}
	</script>
</head>
<body>
	<div>
		<span>输入账号：</span>
		<input type="text" name="name" id="name" onkeyup="check()">
		<span id="checkResult"></span>
	</div>
</body>
</html>
```

#### 注意

1.创建XHR对象

- XHR对象是一个js对象，在用户无感知情况下与服务器进行交互，因此没有刷新效果

2.设置并发出请求

- open函数设置背后的程序，send方法进行实际访问
- GET方法表示无参数需要传递
- POST方法表示需要传递参数，传递格式为：send("user = " + username + "& password = "+password);

3.处理响应信息

- readyState的值有0～4
- status的值有200、404

#### 索引

- Package/FrontEnd/Ajax/CheckAccount.html