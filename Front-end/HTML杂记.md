# HTML杂记

1.document.getElementById和$(#id)区别

- document.getElementById获取到的是js对象

- $(#id)获取到的是jq对象

- 因为获取到的对象不同，因此只能使用相应对象的方法

- 互相转化：

   jquery -> js对象

      jQuery： $("#id") $("#id").eq(0)
   
              js:   $("#id")[0]     $("#id").get(0)    $("#id").eq(0)[0]   $("#id").eq(0).get(0)

   js对象 -> jquery

            js:  Document.getElementsByClassName('className')

  2.标签<a>中的href属性，有空格会出错

2.span标签中文字自动换行

```css
span{
  // 固定宽度
	width: 800px;
	word-wrap: break-word;
}
```

3.hover后缓慢变换

```css
a.return-button button:hover{
	transition-duration: 500ms;
}
```

