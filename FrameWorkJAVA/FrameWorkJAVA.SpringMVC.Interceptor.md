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


#### 4.Several Interceptor

1. the order of execution is depends on the order of allocation.

   ```xml
   <!--配置拦截器-->
       <mvc:interceptors>
           <mvc:interceptor>
               <!--配置哪些访问拦截-->
               <mvc:mapping path="/test/**"/>
               <!--配置哪些访问不拦截-->
               <!--<mvc:exclude-mapping path=""/>-->
               <bean class="com.Interceptor.MyInterceptor1"/>
           </mvc:interceptor>
       </mvc:interceptors>
   
       <!--配置拦截器-->
       <mvc:interceptors>
           <mvc:interceptor>
               <!--配置哪些访问拦截-->
               <mvc:mapping path="/test/**"/>
               <!--配置哪些访问不拦截-->
               <!--<mvc:exclude-mapping path=""/>-->
               <bean class="com.Interceptor.MyInterceptor2"/>
           </mvc:interceptor>
       </mvc:interceptors>
   ```

   - the order is 

     ```
     MyInterceptor1_Pre_Execute
     MyInterceptor2_Pre_Execute
     testInterceptor execute
     MyInterceptor2_Post_Execute
     MyInterceptor1_Post_Execute
     Interceptor Execute
     MyInterceptor2_last_Execute
     MyInterceptor1_last_Execute
     ```

#### 5.Methods

1. preHandler:before Controller

2. postHandler:after Controller,before success.jsp

3. afterCompletion:after success.jsp

   ```java
   public class MyInterceptor1 implements HandlerInterceptor {
       /*
       预处理方法，在handler之前
        */
       public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
           System.out.println("MyInterceptor1_Pre_Execute");
           return true;
       }
       /*
       后处理方法,在success.jsp之前，在handler之后
        */
       public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable
           ModelAndView modelAndView) throws Exception {
           System.out.println("MyInterceptor1_Post_Execute");
       }
       /*
       在success.jsp之后
        */
       public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
           System.out.println("MyInterceptor1_last_Execute");
       }
   }
   ```