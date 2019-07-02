## FrontEnd

### 二.CSS

### 1.基础

#### 方法

1.使用 选择器{属性:值}

- 元素选择器
- id选择器
- 类选择器

2.基本方法

3.CSS优先级

- style标签与外部文件style.css重复：最后出现的优先
- style标签与style属性重复：style属性优先
- 如果样式上增加"!important"：优先级最高

#### 实现

1.三种选择器

```html
<!-- CSS选择器 -->
<!-- 元素选择器 -->
<style type="text/css">
	p{
		color: red;
	}
	p#p1{
		color: blue;
	}
	p.p2{
		color: green;
	}
</style>
<div>
	<h2>------CSS选择器------</h2>
	<p>通过元素选择器</p>
	<p id="p1">通过ID选择器</p>
	<p class="p2">通过类选择器</p>
</div><HR align=left width="80%" color=E6E6E6 SIZE=2>
```

2.基本方法

```html
<!-- CSS选择器 -->
<!-- 元素选择器 -->
<style type="text/css">
	p{
		color: red;
	}
	p#p1{
		color: blue;
	}
	p.p2{
		color: green;
	}
</style>
<div>
	<h2>------CSS选择器------</h2>
	<p>通过元素选择器</p>
	<p id="p1">通过ID选择器</p>
	<p class="p2">通过类选择器</p>
</div><HR align=left width="80%" color=E6E6E6 SIZE=2>

<!-- 尺寸大小 -->
<style type="text/css">
	p#percentage{
		width: 20%;
		height: 20%;
		background-color: pink;
		color: white;
		text-align: center;
	}
	p#pix{
		width: 180px;
		height: 50px;
		background-color: green;
		color: white;
		text-align: center;
	}
</style>
<div>
	<h2>------尺寸大小------</h2>
	<p id="percentage">按比例设置尺寸</p>
	<p id="pix">按像素设置尺寸</p>
</div><HR align=left width="80%" color=E6E6E6 SIZE=2>

<!-- 背景设计 -->
<style type="text/css">
	div#picDiv{
		background-image: url(pics/background.jpg);
		width: 50%;
		height: 30%;
		text-align: center;
	}
	p#pDiv{
		color: white;
		font-size: 20px;
	}
</style>
	<h2>------背景设计------</h2>
<div id="picDiv">
	<p id="pDiv">背景为图片</p>
</div><HR align=left width="80%" color=E6E6E6 SIZE=2>

<!-- 文本和字体 -->
<!-- 略 -->

<!-- 鼠标样式 -->
<style type="text/css">
	p#wait{
		background-color:#3F4A56;
		color: white;
		cursor: wait;
	}
	p#notAllowed{
		background-color:#3F4A56;
		color: white;
		cursor: not-allowed;
	}
</style>
<h2>------鼠标样式------</h2>
<div>
	<p id="wait">测试鼠标样式条一</p>
	<p id="notAllowed">测试鼠标样式条二</p>
</div><HR align=left width="80%" color=E6E6E6 SIZE=2>

<!-- 表格样式 -->
<style type="text/css">
	table.t1{
		border-collapse: separate;
	}
	table.t2{
		border-collapse: collapse;
	}
</style>
<h2>------表格样式------</h2>
<table class="t1" border="1" width="200px">
	<tr>
		<td>样式一</td>
		<td>样式一</td>
	</tr>
</table>
<br>
<table class="t2" border="1" width="200px">
	<tr>
		<td>样式二</td>
		<td>样式二</td>
	</tr>
</table><HR align=left width="80%" color=E6E6E6 SIZE=2>

<!-- 边框模型，包括内外边框和边距 -->
<!-- 略 -->

<!-- 超链状态 -->
<style type="text/css">
	a:link{color: #ff0000}
	a:visiter{color: #00ff00}
	a:hover{color: #ff00ff}
	a:active{color: #0000ff}
</style>
<div>
	<h2>------超链四种状态------</h2>
	<a href="www.baidu.com">超链接不同4种状态</a>
</div><HR align=left width="80%" color=E6E6E6 SIZE=2>

<!-- 隐藏 -->
<style type="text/css">
	div.d{
		display: none;
	}
	div.v{
		visibility: hidden;
	}
</style>
<div>
	<h2>隐藏两种方法，display不占原空间，visibility占空间仅隐藏</h2>
	<div>div1</div>
	<div class="d">隐藏div2</div>
	<div>div3</div>
	<div class="v">div4</div>
	<div>div5</div>
</div><HR align=left width="80%" color=E6E6E6 SIZE=2>

<!-- 样式优先级 -->
<style type="text/css">
	p#imp{
		color: green !important;
	}
</style>
<div>
	<p id="imp" style="color: red">标签红色，但是优先使用！important样式（绿色）</p>
</div>
```

3.样式优先级

```html
<!-- 样式优先级 -->
<style type="text/css">
	p#imp{
		color: green !important;
	}
</style>
<div>
	<p id="imp" style="color: red">标签红色，但是优先使用！important样式（绿色）</p>
</div>
```

#### 索引

- toyz/Package/FrontEnd/HTML/CSS.html

### 2.布局

#### 方法

1.绝对定位——实现1

- 相当于从原文档删除了
- 对于 "绝对定位的文字" 这个p，其定位了的父容器即 class="absdiv" 的div 
  所以 "绝对定位的文字" 这个p 出现的位置是以这个div 为基础的
- 重叠问题：z-index属性， 当z-index的值越大，就表示放上面，z-index:越小就表示放下面

2.相对定位——实现2

- 位置存在，并会空出来

3.显示方法——实现3

- 隐藏：display:none；
- 块级：display:block；支持换行、调节大小
- 内联：display:inline；没有换行、不支持调节大小
- 内联-块级：inline-block；不换行、支持调节大小

4.其他布局

5.div中内容居中方法：margin:0 auto 设置对象上下间距为0，左右自动

#### 实现

1.绝对定位

```html
<!-- 绝对定位 -->
<h2>-----绝对定位-----</h2>
<style type="text/css">
	p.ads{
		position: absolute;
		left: 50px;
		top: 60px;
	}
</style>
<div>
	<p>正常文字</p>
	<p class="ads">绝对定位</p>
	<p>正常文字</p>
	<p>正常文字</p>
	<p>正常文字</p>
</div>
<!-- 重叠 -->
<h2>-----重叠-----</h2>
<style type="text/css">
	div#up{
		z-index: 1;
		background-color: black;
		position: absolute;
		left: 50px;
		top: 250px;
	}
	div#down{
		z-index: -1;
		background-color: blue;
		position: absolute;
		left: 180px;
		top: 290px;
	}
</style>
<div id="up">
	<p style="color: white">这是z-index: 1的在顶部，黑色</p>
</div>
<div id="down">
	<p style="color: white">这是z-index: -1的在底部，蓝色</p>
</div>
```

2.相对定位

```html
<!-- 相对定位 -->
<style type="text/css">
	p.r{
		position: relative;
		left: 150px;
		top: 50px;
	}
	div.abs{
		position:absolute;
		top: 350px; 
	}
</style>
<div class="abs">
	<h2>-----相对定位-----</h2>
	<p>正常文字</p>
	<p class="r">相对定位</p>
	<p>正常文字</p>
	<p>正常文字</p>
	<p>正常文字</p>
</div>
```

3.显示方式

```html
<!-- 显示方式 -->
<style type="text/css">
	span.toDiv{
		display: block;
		border: 1px solid lightgray;
		margin: 10px;
		width: 200px;
	}
	div.toSpan{
		display: inline;
		border: 1px solid lightgray;
		margin: 10px;
		width: 200px;
	}
	span.inlineBlock{
		display: inline-block;
		border: 1px solid lightgray;
		margin: 10px;
		width: 200px;
	}
</style>
<div>
	<h2>-----显示方式-----</h2>
	<h3>span改造成div</h3>
	<span style="border: 1px solid lightgray ;margin: 10px">未改造的span</span>
	<span class="toDiv">span改造成div</span>

	<h3>div改造成span</h3>
	<div style="border: 1px solid lightgray;margin: 10px;">未改造的div</div>
	<div class="toSpan">改造后的div1，不换行</div>
	<div class="toSpan">改造后的div2，不换行</div>

	<h3>span改造成内联-块级</h3>
	<span class="inlineBlock">改造成内联-块级1</span>
	<span class="inlineBlock">改造成内联-块级2</span>
	<span class="inlineBlock">改造成内联-块级3</span>
</div>
```

4.其他布局

```html
<!-- 绝对定位 -->
<h2>-----绝对定位-----</h2>
<style type="text/css">
	p.ads{
		position: absolute;
		left: 50px;
		top: 60px;
	}
</style>
<div>
	<p>正常文字</p>
	<p class="ads">绝对定位</p>
	<p>正常文字</p>
	<p>正常文字</p>
	<p>正常文字</p>
</div>
<!-- 重叠 -->
<h2>-----重叠-----</h2>
<style type="text/css">
	div#up{
		z-index: 1;
		background-color: black;
		position: absolute;
		left: 50px;
		top: 250px;
	}
	div#down{
		z-index: -1;
		background-color: blue;
		position: absolute;
		left: 180px;
		top: 290px;
	}
</style>
<div id="up">
	<p style="color: white">这是z-index: 1的在顶部，黑色</p>
</div>
<div id="down">
	<p style="color: white">这是z-index: -1的在底部，蓝色</p>
</div>

<!-- 相对定位 -->
<style type="text/css">
	p.r{
		position: relative;
		left: 150px;
		top: 50px;
	}
	div.abs{
		position:absolute;
		top: 350px; 
	}
</style>
<div class="abs">
	<h2>-----相对定位-----</h2>
	<p>正常文字</p>
	<p class="r">相对定位</p>
	<p>正常文字</p>
	<p>正常文字</p>
	<p>正常文字</p>
</div>

<!-- 浮动 -->
<style type="text/css">
	.f{
		float: right;
	}
	div#pane{
		position: absolute;
		top: 600px;
	}
</style>
<div id="pane">
	<div>
		<h2>-----浮动-----</h2>
		<div>正常文字1</div>
		<div class="f">浮动的文字</div>
		<div>正常文字2</div>
		<div>正常文字3</div>
		<div>正常文字4</div>
	</div>

<!-- 显示方式 -->
<style type="text/css">
	span.toDiv{
		display: block;
		border: 1px solid lightgray;
		margin: 10px;
		width: 200px;
	}
	div.toSpan{
		display: inline;
		border: 1px solid lightgray;
		margin: 10px;
		width: 200px;
	}
	span.inlineBlock{
		display: inline-block;
		border: 1px solid lightgray;
		margin: 10px;
		width: 200px;
	}
</style>
<div>
	<h2>-----显示方式-----</h2>
	<h3>span改造成div</h3>
	<span style="border: 1px solid lightgray ;margin: 10px">未改造的span</span>
	<span class="toDiv">span改造成div</span>

	<h3>div改造成span</h3>
	<div style="border: 1px solid lightgray;margin: 10px;">未改造的div</div>
	<div class="toSpan">改造后的div1，不换行</div>
	<div class="toSpan">改造后的div2，不换行</div>

	<h3>span改造成内联-块级</h3>
	<span class="inlineBlock">改造成内联-块级1</span>
	<span class="inlineBlock">改造成内联-块级2</span>
	<span class="inlineBlock">改造成内联-块级3</span>
</div>

<!-- 垂直居中 -->
<style type="text/css">
	div#d{
		border: solid 1px lightgray;
		line-height: 100px;
		margin: 10px;
	}
	div#inside{
		padding: 30 0;
		border: solid 1px lightgray;
	}
	div#table{
		display: table-cell;
		vertical-align: middle;
		height: 200px;
		border: solid 1px lightgray;
	}
</style>
<div>
	<h2>-----垂直居中-----</h2>
	<h3>适合一行居中</h3>
	<div id="d">适合单独一行垂直居中</div>

	<h3>内边距方式居中</h3>
	<div id="inside">内边距居中，多行内容 内边距居中，多行内容 内边距居中，多行内容 内边距居中，多行内容 内边距居中，多行内容 内边距居中，多行内容 内边距居中，多行内容 内边距居中，多行内容 内边距居中，多行内容 </div>

	<h3>table方式的居中</h3>
	<div id="table">居中</div>
</div>

<!-- 左右固定 -->
<style type="text/css">
	.left{
		width: 200px;
		float: left;
		background-color: pink;
	}
	.right{
		width: 200px;
		float: right;
		background-color: pink;
	}
	.center{
		margin: 0 200px;
		background-color: lightblue;
	}
</style>
<div>
	<h2>-----左右固定-----</h2>
	<div class="left">左边固定</div>
	<div class="right">右边固定</div>
	<div class="center">中间自适应</div>
</div>
</div>
```

#### 注意

1.块之间有空格是写代码时回车换行导致的

#### 索引

- toyz/Package/FrontEnd/HTML/CSSLayout.html

### 3.英雄列表——Practice

#### 预期

![ç»ä¹ ææå¾](http://stepimagewm.how2j.cn/2091.png)

#### 实现

1.html

```html
<!DOCTYPE html>
<html>
<head>
	<title>HeroList</title>
	<link type="text/css" rel="styleSheet"  href="file:///Users/toyz/Package/FrontEnd/HTML/PracticeHeroList/css/style.css"/>
</head>
<body>
	<!-- 左列选择模块 -->
	<div class="left">
		<h2>英雄资料</h2>
		<!-- 英雄类型 -->
		<table class="select">
			<tr>
				<td class="td">
					<input type="checkbox" class="checkbox">坦克
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">法师
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">射手
				</td>
			</tr>
			<tr>
				<td class="td">
					<input type="checkbox" class="checkbox">刺客
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">辅助
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">新手
				</td>
			</tr>
			<tr>
				<td class="td">
					<input type="checkbox" class="checkbox">推进
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">打野
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">近战
				</td>
			</tr>
			<tr>
				<td class="td">
					<input type="checkbox" class="checkbox">潜行
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">后期
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">远程
				</td>
			</tr>
		</table>
		<!-- 英雄价格 -->
		<h4>英雄价格</h4>
		<hr class="hr">
		<table class="select">
			<tr>
				<td class="td">
					<input type="checkbox" class="checkbox">6300
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">4800
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">3150
				</td>
			</tr>
			<tr>
				<td class="td">
					<input type="checkbox" class="checkbox">1350
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">450
				</td>
			</tr>
		</table>
		
		<!-- 物品资料 -->
		<h2>物品资料</h2>
		<table class="select">
			<tr>
				<td class="td">
					<input type="checkbox" class="checkbox">生命值
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">攻击速度
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">护甲穿透
				</td>
			</tr>
			<tr>
				<td class="td">
					<input type="checkbox" class="checkbox">暴击
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">法术穿透
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">魔法抗性
				</td>
			</tr>
			<tr>
				<td class="td">
					<input type="checkbox" class="checkbox">法术伤害
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">物理伤害
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">消耗品
				</td>
			</tr>
			<tr>
				<td class="td">
					<input type="checkbox" class="checkbox">韧性
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">法力值
				</td>
				<td class="td">
					<input type="checkbox" class="checkbox">生命偷取
				</td>
			</tr>
		</table>
		<!-- 符文资料 -->
		<h2>符文资料</h2>
	</div>


	<!-- 右边英雄模块 -->
	<div class="right">
		<table class="hero">
			<tr>
				<td class="hero">
					<img class="hero" src="imgs/0.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/1.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/2.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/3.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/4.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/5.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/6.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
			</tr>
			<tr>
				<td class="hero">
					<img class="hero" src="imgs/6.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/7.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/8.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/9.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/10.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/11.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/12.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
			</tr>
			<tr>
				<td class="hero">
					<img class="hero" src="imgs/13.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/14.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/15.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/16.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/17.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/18.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/19.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
			</tr>
			<tr>
				<td class="hero">
					<img class="hero" src="imgs/20.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/41.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/22.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/28.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/24.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/25.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
				<td class="hero">
					<img class="hero" src="imgs/26.jpg">
					<p class="hero">牛头酋长</p>
					<p class="hero">阿利斯塔</p>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
```

2.CSS

```css
body{
	background-color: #686963;
}
/*区块*/
div{
	background-color: #011627;
	position: absolute;
	top: 0;
	color: #FEFCFD;
}
.left{
	width: 30%;
	height: 100%;
	left: 0;
	text-align:center;
}
.right{
	width: 68%;	
	height: 100%;
	right: 0;

}
/*表格*/
table.select{
	font-size: 15px;
	color: #FEFCFD;
	margin:0 auto;
}
td.td{
	text-align: left;;
	width: 120px;
	height: 30px;
}
.checkbox{
	width: 15px;
	height: 15px;
}
.hr{
	width: 80%;
	height:1px;
	border:none;
	border-top:1px dashed #89909F;
}
/*英雄*/
table.hero{
	font-size: 15px;
	color: #F46036;
	margin: 0 auto;
	width: 100%;
}
td.hero{
	float:top;
	width: 14%;
	text-align: center;
}
p.hero{
	margin: 5px auto;
	font-weight: bold;
}
img.hero{
	width: 120px;
	height: 120px;
}
```

#### 注意

1.div居中方法为：text-align:center;

2.table在div中居中的方法为：margin: 0 auto;

3.在table中的td边距可以通过调节width占整个table的width比例调节

#### 索引

- toyz/Package/FrontEnd/HTML/PracticeHeroList/PracticeHeroList.html
- toyz/Package/FrontEnd/HTML/PracticeHeroList/css/style.css