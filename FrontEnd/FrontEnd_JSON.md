## FrontEnd

### 四.JSON

### 1.基础方法

#### 方法

1.JSON即对象表示法，一种数据存储方式

2.类似数组，赋值取值与数组相似，同时能够输出数组大小

3.能够和字符串格式双向转换

#### 实现

```html
<!-- JSON -->
<!DOCTYPE html>
<html>
<head>
	<title>JSON简介</title>
	<script type="text/javascript">
		document.write("<h2>-----JSON对象------</h2>");
		// 创建JSON对象
		var hero = {"name":"VN","hp":616};
		document.write("这是一个JSON对象："+hero+"<br>");
		// 输出对象的属性
		document.write("英雄名称为："+hero.name+"<br>");
		document.write("英雄血量为："+hero.hp);
		document.write("<h2>-----JSON数组------</h2>");
		// 数组长度
		var heros = [
			{"name":"VN","hp":616},
			{"name":"EZ","hp":435},
			{"name":"JAX","hp":234},
			{"name":"JINX","hp":324},
		]
		document.write("数组长度为："+heros.length+"<br>")
		// 访问数组
		document.write("数组第4项英雄为："+heros[3].name+"<br>")
		
		// 对象转换
		document.write("<h2>-----对象转换------</h2>");
		document.write("<h3>-----字符串转换成JSON------</h3>");
		// 字符串转换成JSON
		s1 = "{\"name\":\"VN\"";
		s2 = ",\"hp\":616}";
		s3 = s1 + s2;
		document.write("这是一个JSON格式的字符串"+s3);
		document.write("<br>");
		// 通过eval转换
		var heroVN = eval("("+s3+")");
		document.write("这是一个JSON对象: " + heroVN.name+","+heroVN.hp);
		document.write("<br>");

		document.write("<h3>-----JSON转换成字符串------</h3>");
		var hero = {"name":"VN","hp":616};
		document.write("这是一个JSON对象："+hero+"<br>");
		var heroString = JSON.stringify(hero);
		document.write("这是一个JSON字符串："+heroString+"<br>");
	</script>
</head>
<body>

</body>
</html>
```

#### 索引

- Package/FrontEnd/JSON/Hello.html