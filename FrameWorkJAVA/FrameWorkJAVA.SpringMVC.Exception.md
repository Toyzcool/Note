# FrameWorkJAVA.SpringMVC.Exception

### 方法

#### 1.原理及步骤

![](/Users/toyz/Package/Note/FrameWorkJAVA/SpringMVC异常处理流程.jpg)

### 实现

- 异常模拟器

  <!--ErrorHandler.java-->

  ```java
  @Controller
  @RequestMapping("exception")
  public class ErrorHandler {
      @RequestMapping("testException")
      public String testException() throws SysException{
          System.out.println("testException.....");
          // 模拟异常
          try {
              int a = 10/0;
          } catch (Exception e){
              e.printStackTrace();
              throw new SysException("查询了所有用户");
          }
          return "success";
      }
  }
  ```

- 异常处理器

  <!--SysExceptionResolver-->

  ```java
  public class SysExceptionResolver implements HandlerExceptionResolver {
      @Override public ModelAndView resolveException(HttpServletRequest httpServletRequest ,
          HttpServletResponse httpServletResponse , Object o , Exception ex) {
          // 获取到异常对象
          SysException e = null;
          if (ex instanceof SysException ){
              e = (SysException) ex;
          }else {
              e = new SysException("系统维护中");
          }
          // 创建ModelAndView对象，用于传值和跳转
          ModelAndView mv = new ModelAndView();
          mv.addObject("errorMsg",e.getMessage());
          mv.setViewName("error");
          return mv;
      }
  }
  ```

- 异常类（定义异常）

  <!--SysException-->

  ```java
  import lombok.Data;
  @Data
  public class SysException extends Exception{
      private String message;
  
      public SysException(String message) {
          this.message = message;
      }
  }
  ```

- 配置异常处理器

  <!--springmvc.xml-->

  ```xml
   <!--配置异常处理器-->
      <bean id="sysExceptionResolver" class="com.Exception.SysExceptionResolver"/>
  ```

### 索引

- /Users/toyz/Package/FrameWorkJAVA/SpringMVC/SpringMVC.Exception

