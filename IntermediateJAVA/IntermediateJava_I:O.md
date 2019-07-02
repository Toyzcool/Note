## IntermediateJava

### 一.I/O

### 1.数据流

#### 方法

- 使用数据流的writeUTF()和readUTF() 可以进行数据的格式化顺序读写

#### 实现

- DataRead.java

```java
package com.File;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataRead {
	//读取数据方法，注意：datainputstream方法一定要用dataoutputstream写入才能读取，因为带特殊标记
	public static void dataWriter() {
		File fw = new File("/Users/toyz/eclipse-workspace/data.txt");
		System.out.println("-----写入内容-----");
		try(
			FileOutputStream fos = new FileOutputStream(fw);
			DataOutputStream dos = new DataOutputStream(fos);
			)
		{
			int i = 520;
			String s = "You know";
			//写入
			dos.writeInt(i);
			dos.writeUTF(s);
			System.out.println("成功写入："+i+" 和 "+s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void dataReader() {
		File fr = new File("/Users/toyz/eclipse-workspace/data.txt");
		System.out.println("-----文件输出-----");
		System.out.println("文件是否存在："+fr.exists());
		try (			
			FileInputStream fis = new FileInputStream(fr);
			DataInputStream dis = new DataInputStream(fis);
			)
		{
			int i = dis.readInt();
			String s = dis.readUTF();
			System.out.println("读到的数字为："+i);
			System.out.println("读到的字符串为："+s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		dataWriter();
		dataReader();
	}
}
```

#### **注意**

- 使用DataInputStream来读取文件内容时，读取的内容必须是通过DataOutputStream写入的。*原因是使用DataOutputStream写入的内容，会带有特殊标记*

#### 索引

- toyz/IntermediateJAVA/src/com.File

### 2.对象流

#### 方法

- 使用readObject()和writeObject()方法

#### 实现

- ObjectRead.java

```java
package com.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/*
 * 与Hero类关联
 */
public class ObjectRead {

	public static void main(String[] args) {
		Hero h = new Hero("Toyz",356);
		System.out.println("当前英雄为："+h.name);
		/*
		 * 写入
		 */
		//新建文件对象
		System.out.println("-----准备写入对象-----");
		File f = new File("/Users/toyz/eclipse-workspace/hero.txt");
		System.out.println("文件是否存在："+f.exists());
		try
		(
			//创建对象输出流
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//创建对象输入流
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			//对象写入
			oos.writeObject(h);
			System.out.println("-----写入成功-----");
			//对象输出
			Hero h2 = (Hero) ois.readObject();
			System.out.println("英雄名称为："+h2.name);
			System.out.println("英雄血量为："+h2.hp);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

```

- Hero.java

```java
package com.File;

import java.io.Serializable;

public class Hero implements Serializable {
	public String name;
	public int hp;
	public Hero(String name, int hp) {
		super();
		this.name = name;
		this.hp = hp;
	}
}
```

#### 注意

- 对象所对应的类，必须是实现Serializable接口

#### 索引

- toyz/IntermediateJAVA/src/com.File

### 3.总结

#### 流关系图

![æµå³ç³»å¾](http://stepimagewm.how2j.cn/5678.png)

##### 字节流和字符流区别

- 字节流不需要用到缓冲区（内容），是文件直接操作的；

- 字符流需要用到缓冲区，然后在对文件进行操作；

- 在所有的硬盘上保存文件或进行传输的时候都是以字节的方法进行的，包括图片也是按字节完成，而字符是只有在内存中才会形成的，所以使用字节的操作是最多的；

  如果要java程序实现一个拷贝功能，应该选用字节流进行操作（可能拷贝的是图片），并且采用边读边写的方式（节省内存）；

##### 操作流程

1. 使用File类打开文件；
2. 通过字节流或者字符流的子类，确定输出的位置；
3. 进行读写操作；
4. 关闭输入输出；
5. 注意：IO操作一定要关闭