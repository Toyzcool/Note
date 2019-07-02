## IntermediateJava

### 二.MultiThread

### 1.启动线程

#### 方法

1. 继承Tread类，调用start()方法；
2. 使用Runnable接口，调用Thread的start()方法；
3. 使用匿名类，Thread类中重写run()方法；

#### 实现

方法一：新建MultiThread类，继承Tread方法

```java
package MultiThread;
/*
 * 多线程方法一，重写run方法
 */
public class KillThread extends Thread {
	
	private Hero h1;
	private Hero h2;
	
	public KillThread(Hero h1, Hero h2) {
		super();
		this.h1 = h1;
		this.h2 = h2;
	}
	
	public void run() {
		while(!h2.isDead()) {
			h1.attackHero(h2);
		}
	}
}
```

方法二：新建Battle类，使用Runnable接口，调用Thread的start()方法

```java
package MultiThread;

public class Battle implements Runnable {
	
	private Hero h1;
	private Hero h2;
	
	
	public Battle(Hero h1, Hero h2) {
		super();
		this.h1 = h1;
		this.h2 = h2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!h2.isDead()) {
			h1.attackHero(h2);
		}
	}
}
```

方法三：使用匿名类，Thread类中重写run()方法

```java
package MultiThread;

public class TestThread {

	public static void main(String[] args) {
		
		//新建英雄对象
		Hero gailun = new Hero("gailun",500,90);
		Hero vn = new Hero("vn",450,70);
		Hero ez = new Hero("ez",420,80);
		Hero jinx = new Hero("jinx",400,80);
		
		/*
		 * 使用单线程攻击方法
		 */
//		System.out.println("-----以下为单线程攻击方法------");
//		while(!vn.isDead()){
//			gailun.attackHero(vn);
//		}
//		while(!jinx.isDead()) {
//			ez.attackHero(jinx);
//		}
		
		/*
		 * 多线程攻击方法一,继承Thread类——KillThread.java
		 */
		System.out.println("-----以下为多线程 攻击方法一-----");
		KillThread kt1 = new KillThread(gailun, vn);
		kt1.start();
		KillThread kt2 = new KillThread(ez, jinx);
		kt2.start();
		
		/*
		 * 多线程攻击方法二，使用Runnable接口——Battle.java
		 */
		System.out.println("-----以下为多线程 攻击方法二-----");
		Battle b1 = new Battle(gailun,vn);
		new Thread(b1).start();
		Battle b2 = new Battle(ez,jinx);
		new Thread(b2).start();
		
		/*
		 * 多线程攻击方法三，使用匿名类
		 */
		System.out.println("-----以下为多线程 攻击方法三-----");
		Thread t1 = new Thread() {
			public void run() {
				while(!vn.isDead()) {
					gailun.attackHero(vn);
				}
			}
		};
		t1.start();
		Thread t2 = new Thread() {
			public void run() {
				while(!jinx.isDead()) {
					ez.attackHero(jinx);
				}
			}
		};
		t2.start();
	}
}
```

#### 注意

- 启动线程是start()方法，run()并不能启动一个新的线程
- 实现Runnable接口，并不能启动或者说实现一个线程。Runnable接口，并不能代表一个线程。Runnable接口和线程是两个不同的概念
- 区别：继承Thread，是多个线程各自完成任务；使用Runnable接口，是多个线程完成一个任务
- 因此，大部分情况下使用Runnable方法更加简单

#### 索引

- toyz/IntermediateJAVA/src/com.MultiThread

### 2.线程方法

#### 方法

1.线程暂停——sleep()

- 使当前线程停顿固定时间

2.加入线程——join()

- 使用join()的对象一，将使主线程进入等待池，等待对象一完成后，再往下运行
- 如果在对象一运行前或同时运行的有其他对象在运行，则这些其他对象不受影响，继续运行
- 验证方式可见实现中的加入线程部分

3.线程优先级——setPriority(Thread.MAX_PRIORITY)

- 括号中填数字（1～10）或Thread.MAX_PRIORITY、Thread.MIN_PRIORITY

4.临时暂停——yield()

- 暂停当前正在执行的线程对象，并执行其他线程
- 可能无效，因为程序选择器可能重新选到被临时暂停的线程

5.守护线程——setDaemon()

- 当仅剩下守护线程时，程序终止
- 用于日志和性能统计工作

#### 实现

```java
package MultiThread;
/*
 * 多线程的各种方法
 */
public class ThreadMethods {

	public static void main(String[] args) {
		//新建英雄对象
		Hero gailun = new Hero("gailun",500,90);
		Hero vn = new Hero("vn",450,70);
		Hero ez = new Hero("ez",420,80);
		Hero jinx = new Hero("jinx",400,80);
		Hero test1 = new Hero("test1",420,80);
		Hero test2 = new Hero("test2",400,80);
		
		/*
		 * 线程暂停的方法
		 * 涉及变量（t1）
		 */
		Thread t1 = new Thread() {
			public void run() {
				int time = 0;
				while(true) {
					try {
						//暂停一秒
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.printf("你已经玩游戏 %d 秒了 %n",time++);
				}
			}
		};
		t1.start();
		
		/*
		 * 加入线程的方法
		 * t2和t3同时运行，此时t2使用join()方法，主线程进入等待池，等t2完成后，t4才执行
		 * 涉及变量（t2\t3\t4）
		 */
		//定义线程和匿名方法
		Thread t2 = new Thread() {
			public void run() {
				while(!vn.isDead()) {
					gailun.attackHero(vn);
				}
			}
		};
		Thread t3 = new Thread() {
			public void run() {
				while(!jinx.isDead()) {
					ez.attackHero(jinx);
				}
			}
		};
		
		//同时启动t2和t3，使其并行
		t2.start();
		t3.start();
		
		//代码执行到这里，一直是main线程在运行
		try {
			//主线程进入等待池，t3不受影响，依旧运行
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//证明主线程进入等待池,t4将在t2完成后，才能运行
		Thread t4 = new Thread() {
			public void run() {
				while(!test2.isDead()) {
					test1.attackHero(test2);
				}
			}
		};
		t4.start();
		
		/*
		 * 线程优先级
		 * 涉及变量（t5\t6）
		 */
		Thread t5 = new Thread() {
			public void run() {
				while(!vn.isDead()) {
					gailun.attackHero(vn);
				}
			}
		};
		Thread t6 = new Thread() {
			public void run() {
				while(!jinx.isDead()) {
					ez.attackHero(jinx);
				}
			}
		};
		t5.setPriority(Thread.MAX_PRIORITY);
		t6.setPriority(Thread.MIN_PRIORITY);
		t5.start();
		t6.start();
		
		/*
		 * 临时暂停
		 * 涉及变量（t7\t8）
		 */
		Thread t7 = new Thread() {
			public void run() {
				while(!vn.isDead()) {
					gailun.attackHero(vn);
				}
			}
		};
		Thread t8 = new Thread() {
			public void run() {
				while(!jinx.isDead()) {
					//暂停，但是可能无效，因为让步线程依旧可能被程序选中执行
					Thread.yield();
					ez.attackHero(jinx);
				}
			}
		};
		t7.setPriority(5);
		t8.setPriority(5);
		t7.start();
		t8.start();
		
		/*
		 * 守护线程
		 * 当仅剩下守护线程时，程序终止。经常用于日志和性能统计工作
		 * 涉及变量(threadDaemon\t9)
		 */
		
		//守护线程，用于计算程序运行时间
		Thread threadDaemon = new Thread() {
			public void run() {
			int time = 0;
			while(true) {
				try {
					//暂停一秒
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("你已经玩游戏 %d 秒了 %n",time++);
			}
		}
		};
		threadDaemon.setDaemon(true);
		threadDaemon.start();
		//主要进程
		Thread t9 = new Thread() {
			public void run() {
				while(!vn.isDead()) {
					gailun.attackHero(vn);
				}
			}
		};
		t9.start();
		
	}

}
```

#### 注意

- t.join()方法只会使主线程进入等待池并等待t线程执行完毕后才会被唤醒，并不影响同一时刻处在运行状态的其他线程

#### 索引

toyz/IntermediateJAVA/src/com.MultiThread/ThreadMethods.java

### 3.Synchronized同步

#### 方法

1. 使用synchronized修饰方法，使用方法时将直接占用使用此方法的对象
2. 使用synchronized占用someObject对象

#### 实现

1.synchronized修饰方法

```java
package MultiThread;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Concurrency 问题使用synchronized()方法解决——Hero.java中的hurt()和recover()方法
 */
public class Synchronized {

	public static void main(String[] args) {
		//用于使用synchronized对象
		final Object someObject = new Object();
		
		//新建英雄对象
		Hero hero = new Hero("VN",10000);
		System.out.printf("英雄VN初始血量为：%.0f %n",hero.hp);
		
		//新建1000个hurt()线程和1000个recover()线程
		int n = 10000;
		Thread[] tHurt = new Thread[n];
		Thread[] tRecover = new Thread[n];
		
		//循环建立10000个hurt()方法，使用方法时锁住对象
		for(int i = 0 ; i < n ; i ++ ) {
			Thread t = new Thread() {
				public void run() {
						hero.hurt();
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			};
			t.start();
			tHurt[i] = t;
		}
		
		//循环建立10000个recover()方法，使用方法时锁住对象
		for(int i = 0 ; i < n ; i++ ) {
			Thread t = new Thread() {
				//可以将synchronized关键词写到recover()方法名称中！！！
				public void run() {
						hero.recover();
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
				}
			};
			t.start();
			tRecover[i] = t;
		}
		
		//等待线程全部完成
		for (Thread t : tHurt) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (Thread t : tRecover) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//打印最后血量
		System.out.printf("最终血量为：%.0f",hero.hp);
	}

}
```

```java
package MultiThread;
/*
 * 创建英雄和英雄动作
 */
public class Hero {
	public String name;
	public float hp;
	//定义英雄攻击力
	public int damage;
	
	public Hero(String name, float hp, int damage) {
		super();
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}
	public Hero(String name, float hp) {
		super();
		this.name = name;
		this.hp = hp;
	}
	
	//新建英雄伤害方法——Synchronized.java
	public synchronized void hurt() {
		this.hp -= 1 ;
	}
	//新建英雄回血方法——Synchronized.java
	public synchronized void recover() {
		this.hp += 1 ;
	}
}

```

2.使用synchronized占用someObject对象

```java
package multiplethread;
   
import java.awt.GradientPaint;
 
import charactor.Hero;
   
public class TestThread {
   
    public static void main(String[] args) {
 
        final Object someObject = new Object();
         
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 10000;
          
        int n = 10000;
  
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];
          
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                     
                    //任何线程要修改hp的值，必须先占用someObject
                    synchronized (someObject) {
                        gareen.recover();
                    }
                     
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
              
        }
          
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                    //任何线程要修改hp的值，必须先占用someObject
                    synchronized (someObject) {
                        gareen.hurt();
                    }
                     
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }
          
        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
          
        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量是 %.0f%n", n,n,gareen.hp);
          
    }
       
}
```

#### 注意

- 当前内容为重点学习内容
- 如果一个类，其**方法都是有synchronized修饰的**，那么该类就叫做**线程安全的类**

#### 索引

- toyz/IntermediateJAVA/src/com.MultiThread/Hero.java
- toyz/IntermediateJAVA/src/com.MultiThread/Synchronized.java

### 4.线程安全的类

#### 方法

- 通过工具类Collections.synchronized…将非线程安全类的转化成线程安全的类
- 包括HashSet,LinkedList,HashMap等非线程安全的类都可转换

#### 实现

```java
package multiplethread;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
public class TestThread {
    
    public static void main(String[] args) {
      	//非线程安全的类
        List<Integer> list1 = new ArrayList<>();
      	//线程安全的类
        List<Integer> list2 = Collections.synchronizedList(list1);
    }
        
}
```

#### 注意

1. StringBuffer 是线程安全的；StringBuilder 是非线程安全的

- 所以当进行大量字符串拼接操作的时候，如果是单线程就用StringBuilder会更快些，如果是多线程，就需要用StringBuffer 保证数据的安全性

### 5.线程的交互

#### 方法

- 使用wait()来使线程暂时释放锁定对象，等待notify()信号
- 通过notify()/notifyAll()通知wait的线程重新复苏

#### 实现

```java
package MultiThread;
/*
 * 线程间的交互
 * 实现要求：掉血速度大于回血，当掉血到1时，暂停掉血，启动回血后，再启动掉血
 */
public class WaitAndNotify {

	public static void main(String[] args) {
		//新建英雄对象
		Hero hero = new Hero("盖伦",200);
		//掉血线程
		Thread t1 = new Thread() {
			public void run() {
				//无限循环掉血
				while(true) {
					hero.hurtWait();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		
		//回血线程
		Thread t2 = new Thread() {
			public void run() {
				while(true) {
					hero.recoverNotify();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t2.start();
	}

}

```

```java
package MultiThread;
/*
 * 创建英雄和英雄动作
 */
public class Hero {
	public String name;
	public float hp;
	//定义英雄攻击力
	public int damage;
	
	public Hero(String name, float hp, int damage) {
		super();
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}
	public Hero(String name, float hp) {
		super();
		this.name = name;
		this.hp = hp;
	}
	
	//新建英雄掉血方法，需要暂停占用——WaitAndNotify.java
	public synchronized void hurtWait() {
		//当血量为1时，暂停占用掉血方法
		if(hp == 1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		hp -= 1;
		System.out.println("掉血，目前血量："+hp);
	}
	
	//新建英雄回血方法，回血后通知其他进程已回血完毕——WaitAndNotify.java
	public synchronized void recoverNotify() {
		hp += 1;
		this.notify();
		System.out.println("回血，目前血量："+hp);
	}
}
```

#### 注意

- wait方法和notify方法，并**不是Thread线程上的方法**，它们是Object上的方法
- 调用wait是有前提条件的，一定是在synchronized块里，否则就会出错
- wait()与sleep()的区别，简单来说wait()会释放对象锁而sleep()不会释放对象锁

#### 索引

- toyz/IntermediateJAVA/src/com.MultiThread/Hero.java
- toyz/IntermediateJAVA/src/com.MultiThread/WaitAndNotify.java

### 6.Lock对象

#### 方法

1. 新建Lock对象，并指向ReentrantLock类
2. 使用TryLock方法，获取lock状态
3. 线程交互

- 新建lock对象，然后获取condition对象，使用condition对象的await和signal方法

#### 实现

1.新建Lock对象，并指向ReentrantLock类

```java
package MultiThread;
/*
 * lock和trylock进行线程占用
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
	
	//获取时间方法 
	public static String now() {
	        return new SimpleDateFormat("HH:mm:ss").format(new Date());
	    }
	
	 //输出日志方法
	public static void log(String msg) {
	        System.out.printf("%s %s %s %n", now() , Thread.currentThread().getName() , msg);
	    }
	    
	public static void main(String[] args) {
		//新建Lock对象
		Lock lock = new ReentrantLock();
		
		//新建线程一
		Thread t1 = new Thread() {
			public void run() {
				try {
					log("线程启动");
					log("试图占用");
					//占用锁住对象
					lock.lock();
					log("占用成功");
					log("进行5秒业务操作");
					Thread.sleep(5000);
				}catch (Exception e) {
					e.printStackTrace();
				} finally {
					log("释放");
					//释放对象
					lock.unlock();
				}

			}
		};
		//启动线程
		t1.start();
		
		try {
			//让t1线程先运行2秒
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//新建t2线程
		Thread t2 = new Thread() {
			public void run() {
				try {
					log("线程启动");
					log("试图占用");
					
					//占用锁住对象
					lock.lock();
					log("占用成功");
					log("进行5秒业务操作");
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					log("释放");
					//释放对象
					lock.unlock();
				}
			}
		};
		t2.start();
	}

}

```

2.使用TryLock方法

```java
package MultiThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
	
	//获取时间方法 
	public static String now() {
	        return new SimpleDateFormat("HH:mm:ss").format(new Date());
	        }
	
	 //输出日志方法
	public static void log(String msg) {
	        System.out.printf("%s %s %s %n", now() , Thread.currentThread().getName() , msg);
	        }
	
	public static void main(String[] args) {
		//新建Lock对象
		Lock lock = new ReentrantLock();
		
		//新建线程1
		Thread t1 = new Thread() {
			public void run() {
				//新建用于保存lock是否被锁的状态变量
				boolean locked = false;

				//获取锁的状态
				try {
					log("启动");
					log("试图占用");
					//试图占用，尝试1秒
					locked = lock.tryLock(1, TimeUnit.SECONDS);
					//如果locked为真，则占用成功
					if(locked) {
						log("占用成功");
						lock.lock();
						Thread.sleep(5000);
					}else {
						log("占用失败");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(locked) {
					log("释放");
					lock.unlock();
					}
				}
			}
		};
		t1.start();
		
//		//让t1先运行2秒
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		//新建线程2
		Thread t2 = new Thread() {
			public void run() {
				boolean locked = false;
				try {
					log("启动");
					log("试图占用");
					locked = lock.tryLock(1,TimeUnit.SECONDS);
					if(locked) {
						log("占用成功");
						lock.lock();
						Thread.sleep(5000);
					}else {
						log("占用失败");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					if(locked) {
						log("释放");
						lock.unlock();
					}
				}
			}
		};
		t2.start();
	
	}

}
```

3.线程间用condition对象的方法交互

```java
package MultiThread;
/*
 * 线程交互
 * 类似于synchronized中的wait()和notify()方法
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadInteraction {
	//获取时间方法 
	public static String now() {
	        return new SimpleDateFormat("HH:mm:ss").format(new Date());
	        }
	
	 //输出日志方法
	public static void log(String msg) {
	        System.out.printf("%s %s %s %n", now() , Thread.currentThread().getName() , msg);
	        }
	
	public static void main(String[] args) {
		//新建Lock对象
		Lock lock = new ReentrantLock();
		//通过lock对象获得condition对象，以后调用condition方法的await和signal方法
		Condition condition = lock.newCondition();
		
		//新建线程1
		Thread t1 = new Thread() {
			public void run() {
				try {
					log("启动");
					log("试图占用");
					lock.lock();
					log("占用对象5秒");
					Thread.sleep(5000);
					log("短暂释放lock对象");
					//短暂释放lock对象，等待通知
					condition.await();
					//再此占用后再占用对象5秒
					log("重新占用对象,并再次占用5秒");
					lock.lock();
					Thread.sleep(5000);
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					log("占用结束");
					lock.unlock();
				}
			}
		};
		t1.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//新建线程2
		Thread t2 = new Thread() {
			public void run() {
				try {
					log("启动");
					log("试图占用对象");
					lock.lock();
					log("占用对象5秒");
					Thread.sleep(5000);
					//占用完成后通知其他线程可继续
					condition.signal();
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					log("占用结束");
					lock.unlock();
				}
			}
		};
		t2.start();
	}

}

```

#### 注意

1. Synchronized和Lock的区别

- Synchronized是关键词，内置的语言实现；Lock是代码层面的实现
- Synchronized不可中断，容易死锁；Lock是可中断锁，使用tryLock方法能够在规定时间内放弃
- Synchronized在同步完成或异常时自动释放；Lock不可自动释放，必须使用unlock方法，忘记使用会造成死锁

### 7.原子性

#### 注意

1. 原子性操作为不可中断的操作

- 原子性操作，比如int i = 0;
- 非原子性操作：i++; 因为i++分成三步：赋值，加，再赋值

- 