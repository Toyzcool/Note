# 1.Basic

- Definition：Node.js就是运行在服务器端的JavaScript。

- Feature：非阻塞。因为是异步请求，一个请求不会等待另一个请求结束。

- Component

  1. 引入require模块：使用require指令载入Node.js模块。
  2. 创建服务器：服务器可以监听客户端请求，类似于 Apache 、Nginx 等 HTTP 服务器。
  3. 接收请求和响应请求：服务器创建之后，客户端通过浏览器或者终端发送请求，服务器接收请求后响应请求。

- implementation

  ```javascript
  // Node.js三部分展示
  var http = require("http");
  http.createServer(function (request, response){
  	// 发送http请求头部
  	// HTTP 状态值: 200 : OK
      // 内容类型: text/plain
      response.writeHead(200, {'Content-Type':'text/plain'});
      response.end('Hello World\n');
  }).listen(8888);
  
  // 终端打印信息
  console.log('Server running at http://127.0.0.1:8888/');
  ```

  - Path: Basic.js

# 2.Read Eval Print Loop

- Definition(交互解释器)：表示电脑环境。<!--类似于Unix/Linux shell-->

- Purpose：调试JavaScript代码。

- Implementation

  ```shell
  $ node
  > 1 +4
  5
  ```

# 3.回调函数

- Definition：异步编程的直接体现就是回调。完成任务之后就执行回调函数。

- Rules

  ```javascript
  function(name,age,callback){}
  ```

- Implementation

  <!--阻塞与非阻塞比较-->

  ```javascript
  // 阻塞实现
  // 读取文件内容
  var fs = require("fs");
  var data = fs.readFileSync("input.txt");
  console.log(data.toString());
  console.log("End");
  ```

  ```shell
  # output
  Read Successfully
  End
  ```

  ```javascript
  // 非阻塞实现
  var fs = require("fs");
  var data = fs.readFile("input.txt", function(err,data){
  	if (err) return console.error(err);
  	console.log(data.toString());
  });
  console.log("End")
  ```

  ```shell
  # output
  End
  Read Successfully
  ```

  ```shell
  # Analyse
  1.阻塞实现的输出结果，是先输出读取的内容，然后输出结尾；非阻塞实现的输出结果，是先输出结尾，然后输出读取的内容。证明不需要等待读取完成之后才能运行后面的代码。
  ```

  











































