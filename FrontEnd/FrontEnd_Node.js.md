# 1.Basic

- Definition：Node.js就是运行在服务器端的JavaScript。

- Feature

  - 非阻塞。因为是异步请求，一个请求不会等待另一个请求结束。
  - 单线程单进程，但是V8引擎提供异步执行回调接口，通过这些接口实现高并发。

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

## 1.1异步执行

- **Principle——important!!!**

  1. 所有同步任务在主线程上执行，形成执行栈（execution context stack）。

  2. 主线程之外还有一个任务队列（task queue）。当异步任务有结果之后，就在执行队列上放置事件。

  3. 当执行栈的任务执行完之后，系统就读取任务队列。相应的异步任务就结束等待，进入执行栈，开始执行。

     <!--主线程执行异步任务时，就是执行对应的回调函数-->

  4. 主线程不断重复第三步。

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

# 4.事件循环

- Feature

  - 基本所有的事件机制都是设计模式中的观察者模式实现。
  - <u>见 1.1异步执行</u>

- Implementation

  ```javascript
  //Node.js 有多个内置的事件，我们可以通过引入 events 模块，并通过实例化 EventEmitter 类来绑定和监听事件
  
  // 引入events模块
  var events = require("events");
  // 创建EventEmitter对象
  var eventEmitter = new events.EventEmitter();
  
  // 创建事件处理程序
  var connectHandler = function connected(){
  	console.log("连接成功")
  
  	// 触发data_received事件
  	eventEmitter.emit('data_received');
  }
  
  // 绑定connection事件处理程序
  eventEmitter.on('connection',connectHandler);
  
  // 创建匿名函数绑定data_received事件
  eventEmitter.on('data_received',function(){
  	console.log('数据接收成功');
  })
  
  // 触发connection事件
  eventEmitter.emit('connection');
  
  console.log('程序执行完成');
  ```

  ```shell
  # output
  连接成功
  数据接收成功
  程序执行完成
  ```

  ```shell
  # Analyse
  1.关系梳理
  	1.connection事件绑定了connectHandler程序。当connection事件触发后，就会执行connectHandler程序。
  	2.connectHandler中触发data_received事件。当connectHandler执行后，就会触发data_received事件。
  	3.data_received事件绑定了匿名的程序。当data_received触发后，将执行匿名的程序。
  2.执行顺序是：connection事件触发——执行connectHandler程序——触发data_received事件——执行匿名程序。
  ```

  











































