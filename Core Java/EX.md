# EX

## 1.关键字

### 1.1 transient

- 用途：阻止对象序列化
- 场景：当对象实现Serilizable接口，属性和方法将被序列化（写入字节序列到目标文件）。如果存在敏感内容，预期是不能被序列化，因此使用transient关键字，来防止被修饰的对象被序列化

### 1.2 volatile

- 用途：使变量具有可见性，被修饰的变量不允许线程内部缓存和重排序，即直接修改内存

  <!--可见性：可见性，是指线程之间的可见性，一个线程修改的状态对另一个线程是可见的-->

- 注意

  - volatile只能让修饰内容具有可见性，但不能保证它具有原子性

    <!--原子性：不可分割性，比如 a=0；（a非long和double类型） 这个操作是不可分割的，那么我们说这个操作时原子操作。再比如：a++； 这个操作实际是a = a + 1；是可分割的，所以他不是一个原子操作。非原子操作都会存在线程安全问题，需要我们使用同步技术（sychronized）来让它变成一个原子操作-->

## 2.助记符

### 2.1 ldc

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

### 2.2 bipush

- 用途：将单字节的（-128 - 127）的常量值推至栈顶

### 2.3 sipush

- 用途：将短整型常量值（-32768 - 32768）的推至栈顶

### 2.4 iconst_1

- 用途：将int类型1推至栈顶
- 范围：iconst_m1 - iconst_5 <!--m1为 -1 -->

### 2.5 anewarray

- 用途：创建一个引用类型数组，并将其引用值压入栈顶

### 2.6 newarray

- 用途：创建一个指定的原始类型（int、float、char等）数组，并将其引用值压入栈顶