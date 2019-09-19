# EX-助记符

查询：

### 1. ldc

- 用途：将int、float或是String类型的常量值推至栈顶

- 实现

  <!--基本代码-->

  ```java
  public class TestFinal {
      public static void main(String[] args) {
          String s = "ABC";
          System.out.println(s);
      }
  }
  ```

  <!--反编译命令-->

  ```shell
  // 找到class文件所在地址
  cd /Users/space/Documents/Growth/Package/Note/UnderstandingTheJVM/Practice/out/production/Practice/ClassLoader
  // 反编译命令
  javap -c javap -c TestFinal.class
  ```

  <!--输出-->

  ```shell
  Compiled from "TestFinal.java"
  public class ClassLoader.TestFinal {
    public ClassLoader.TestFinal();
      Code:
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
  
    public static void main(java.lang.String[]);
      Code:
         0: ldc           #2                  // String ABC
         2: astore_1
         3: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
         6: aload_1
         7: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        10: return
  }
  
  ```

### 2. bipush

- 用途：将单字节的（-128 - 127）的常量值推至栈顶

### 3. sipush

- 用途：将短整型常量值（-32768 - 32768）的推至栈顶

### 4. iconst_1

- 用途：将int类型1推至栈顶
- 范围：iconst_m1 - iconst_5 <!--m1为 -1 -->

### 5. anewarray

- 用途：创建一个引用类型数组，并将其引用值压入栈顶

### 6. newarray

- 用途：创建一个指定的原始类型（int、float、char等）数组，并将其引用值压入栈顶

### 7. invoke

- 分类
  - invokeinterface:调用接口中的方法（在运行期决定，具体调用的是实现该接口的类的具体方法）
  - invokestatic:调用静态方法
  - invokespecial:调用私有方法、构造方法（init）、父类方法
  - invokevirtual:调用虚方法，运行期动态查找的过程
  - invokedynamic:动态调用方法























