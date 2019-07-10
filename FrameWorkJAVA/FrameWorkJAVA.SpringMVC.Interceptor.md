# FrameWorkJAVA.SpringMVC.Interceptor

### Method

#### 1.Principle

![](/Users/toyz/Package/Note/FrameWorkJAVA/拦截器原理.png)

#### 2.Comparison

- Interceptor and Filter
  1. Filter belongs to Servlet,and projects which belong to JavaWeb can use it;Intercepter only can be use by projects which are belong to SpringMVC
  2. Filter can intercept all the access;Interceptor only intercept access which try to access Controller

#### 3.Allocation

1. create new Interceptor class;

   ```java
   public class MyInterceptor implements HandlerInterceptor {
       public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
           System.out.println("MyInterceptor1 Execute");
           return true;
       }
   }
   ```

2. allocate Interceptor,can choose which accesses are intercepted

   ```xml
   <!--配置拦截器-->
       <mvc:interceptors>
           <mvc:interceptor>
               <!--配置哪些访问拦截-->
               <mvc:mapping path="/test/**"/>
               <!--配置哪些访问不拦截-->
               <!--<mvc:exclude-mapping path=""/>-->
               <bean class="com.Interceptor.MyInterceptor"/>
           </mvc:interceptor>
       </mvc:interceptors>
   ```

   