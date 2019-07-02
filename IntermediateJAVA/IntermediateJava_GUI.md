## IntermediateJava

### 四.GUI

### 1.图形界面

#### 方法

1. 新建窗口对象
2. 设置窗口大小和位置
3. 新建按钮对象
4. 设置按钮对象的位置和大小
5. 将按钮对象放入窗口对象
6. 关闭窗口自动结束程序
7. 设置窗口可见

#### 实现

```java
package com.GUI;
import javax.swing.JButton;
/*
 * 基本的内容
 */
import javax.swing.JFrame;

public class TestGUI {
	    public static void main(String[] args) {
	        // 主窗体
	        JFrame f = new JFrame("LoL");
	 
	        // 主窗体设置大小
	        f.setSize(400, 300);
	 
	        // 主窗体设置位置
	        f.setLocation(200, 200);
	 
	        // 主窗体中的组件设置为绝对定位
	        f.setLayout(null);
	 
	        // 按钮组件
	        JButton b = new JButton("一键秒对方基地挂");
	 
	        // 同时设置组件的大小和位置
	        b.setBounds(50, 50, 280, 30);
	 
	        // 把按钮加入到主窗体中
	        f.add(b);
	 
	        // 关闭窗体的时候，退出程序
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        // 让窗体变得可见
	        f.setVisible(true);
	 
	    }
}
```

#### 注意

1. 关闭窗口时需要退出程序
2. 窗口可见需要放在代码后部，不然会先出现窗口后，再移动到指定的位置

#### 索引

- toyz/IntermediateJAVA/src/com.GUI/TestGUI.java

------

### 2.事件监听——重点

#### 方法

1.按钮监听

- Button.addActionListener()
- 重写actionPerformed()方法

2.键盘监听

- Frame.addKeyListener()
- 重写keyReleased()等方法

3.鼠标监听

- Frame.addMouseListener()
- 使用适配器MouseAdapter()
- 只重写需要用到的方法

#### 实现

1.按钮监听

```java
package com.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * 监听按钮动作
 */
@SuppressWarnings("unused")
public class TestButtonListener {

	public static void main(String[] args) {
		//新建窗体
		JFrame f = new JFrame("Test Button");
		//设置窗体大小和位置
		f.setBounds(500, 400, 600, 400);
		f.setLayout(null);
		
		//新建Label对象存放图片
		JLabel lab = new JLabel();
		
		//新建图片并放入Label对象中
		ImageIcon pic = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/shana.png");
		lab.setIcon(pic);
		lab.setBounds(250, 50,pic.getIconWidth(), pic.getIconHeight());
		
		//新建按钮用于隐藏图片
		JButton but = new JButton("Hide Pic");
		but.setBounds(260, 200, 100, 50);
//		but.addActionListener(new ActionListener() {
//			//重写点击动作
//			@Override 
//			public void actionPerformed(ActionEvent e) {
//				lab.setVisible(false);
//			}
//		});
		//特殊表达式
		but.addActionListener((e) -> lab.setVisible(false));
		
		//将组件放入窗体中
		f.add(lab);
		f.add(but);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
	}

}
```

2.键盘监听

```java
package com.GUI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * 键盘监听
 * 功能实现：用键盘控制图片移动
 */
public class TestKeyListener {

	public static void main(String[] args) {
		//新建窗体
		JFrame frame = new JFrame("Test");
		//设置窗体参数
		frame.setBounds(600, 500, 800, 400);
		frame.setLayout(null);
		
		//新建图片
		ImageIcon pic = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/shana.png");
		JLabel lab = new JLabel();
		lab.setIcon(pic);
		lab.setBounds(250, 200, pic.getIconWidth(), pic.getIconHeight());
		
		//组件放入窗体
		frame.add(lab);
		
		//监听键盘动作
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				//左 37
				case 37:
					lab.setLocation(lab.getX()-10,lab.getY());
					break;
				//上 38
				case 38:
					lab.setLocation(lab.getX(),lab.getY()-10);
					break;
				//右 39
				case 39:
					lab.setLocation(lab.getX()+10,lab.getY());
					break;
				//下 40
				case 40:
					lab.setLocation(lab.getX(),lab.getY()+10);
					break;
				}
			}

		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

```

3.鼠标监听

```java
package com.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * 鼠标监听
 * 实现功能：鼠标移到图片，图片就变换位置
 */
public class TestMouseListener {
	public static void main(String[] args) {
		//窗体
		JFrame frame = new JFrame("Test");
		frame.setBounds(600, 500, 800, 400);
		frame.setLayout(null);
		
		//图片
		final JLabel lab = new JLabel();
		ImageIcon image = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/shana.png");
		lab.setIcon(image);
		lab.setBounds(250, 200, image.getIconWidth(), image.getIconHeight());
		frame.add(lab);
		
		//鼠标进入的方法一
//		lab.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			//重写鼠标进入的方法
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				Random r = new Random();
//				int x = r.nextInt(frame.getWidth()-lab.getWidth());
//				int y = r.nextInt(frame.getHeight()-lab.getHeight());
//				lab.setLocation(x, y);
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		//鼠标进入的方法二——使用适配器
		lab.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Random r = new Random();
				int x = r.nextInt(frame.getWidth()-lab.getWidth());
				int y = r.nextInt(frame.getHeight()-lab.getHeight());
				lab.setLocation(x, y);
			}	
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

```

#### 注意

1. 可以运用适配器方法，只重写必要的代码，精简代码，见实现3.鼠标监听的方法二

#### 索引

- toyz/IntermediateJAVA/src/com.GUI/TestButtonListener.java
- toyz/IntermediateJAVA/src/com.GUI/TestKeyListener.java
- toyz/IntermediateJAVA/src/com.GUI/TestMouseListener.java

------

### 3.容器

#### 方法

1.JFrame容器

- 能够最大化，最小化

2.JDialog容器

- 只有关闭按钮
- 需要通过.setTitle()方法设置窗体名称

3.模态框

- 使用.setModal(boolean)方法设置

4.窗体调节大小

- 使用.setResizable(boolean)方法设置

#### 实现

```java
package com.GUI;

import javax.swing.JDialog;
import javax.swing.JFrame;

/*
 * 各种容器
 */
public class TestContainer {

	public static void main(String[] args) {
		//frame窗体
		JFrame frame = new JFrame("Frame");
		frame.setBounds(600,500,800,400);
		//dialog窗体，无放大缩小
		JDialog dialog = new JDialog(frame);
		dialog.setTitle("模态对话框且无法调节大小");
		dialog.setBounds(600, 500, 400, 200);

		//模态窗口，将dialog设置为模态窗口
		dialog.setModal(true);
		
		//将dialog窗口设置为不可调节大小
		dialog.setResizable(false);
		
		frame.setVisible(true);
		dialog.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
	}

}

```

#### 索引

- toyz/IntermediateJAVA/src/com.GUI/TestContainer.java

------

### 4.布局器——重点

#### 方法

1.流式布局器

- FlowLayout()方法
- 会将组件从左到右，从上到下排列

2.分布式布局器

- BorderLayout()方法
- 对组件通过东西南北中的方式定位

3.网格式布局器

- GridLayout()方法
- 指定行列数
- 组件会根据网格进行布局

4.自定义组件大小

- setPreferredSize()方法
- 适用于流式布局器，分布式、网格式不生效

#### 实现　

```java
package com.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestLayout {

	public static void main(String[] args) {
		//新建窗体
		JFrame frameFlow = new JFrame("布局器_FlowLayout");
		JFrame frameBorder = new JFrame("布局器_BorderLayout");
		JFrame frameGrid = new JFrame("布局器_GridLayout");
		frameFlow.setBounds(500,400,800,400);
		frameBorder.setBounds(500,400,800,400);
		frameGrid.setBounds(500,400,800,400);
		//新建按钮，展示布局
		JButton but1 = new JButton("wechat");
		JButton but2 = new JButton("qq");
		JButton but3 = new JButton("weibo");
		JButton but4 = new JButton("facebook");
		JButton but5 = new JButton("google");

		but1.setSize(80, 40);
		but2.setSize(80, 40);
		but3.setSize(80, 40);
		but4.setSize(80, 40);
		but5.setSize(80, 40);

		/*
		 * FlowLayout布局器+setPreferredSize()方法
		 */
		frameFlow.setLayout(new FlowLayout());
		frameFlow.add(but1);
		frameFlow.add(but2);
		frameFlow.add(but3);
		frameFlow.add(but4);
		but4.setPreferredSize(new Dimension(100,50));
		frameFlow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFlow.setVisible(true);

		/*
		 * BorderLayout布局器
		 */
		frameBorder.setLayout(new BorderLayout());
		frameBorder.add(but1,BorderLayout.NORTH);
		frameBorder.add(but2,BorderLayout.SOUTH);
		frameBorder.add(but3,BorderLayout.WEST);
		frameBorder.add(but4,BorderLayout.EAST);
		frameBorder.add(but5,BorderLayout.CENTER);
		//setPreferredSize方法无效
		but5.setPreferredSize(new Dimension(40,50));
		frameBorder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameBorder.setVisible(true);
		
		/*
		 * GridLayout布局器
		 */
		frameGrid.setLayout(new GridLayout(2,3));
		frameGrid.add(but1);
		frameGrid.add(but2);
		frameGrid.add(but3);
		frameGrid.add(but4);
		frameGrid.add(but5);
		frameGrid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGrid.setVisible(true);
		
		
	}

}
```

#### 索引

- toyz/IntermediateJAVA/src/com.GUI/TestLayout.java

------

### 5.组件

#### 方法

1. 标签
2. 按钮
3. 复选框
4. 单选框
5. 按钮组
6. 下拉框
7. 对话框
8. 文本框、密码框
9. 文本域
10. 进度条
11. 文件选择器

#### 实现

```java
package com.GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

/*
 * swing常用组件
 */
public class TestComponent {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(500, 400, 800, 400);
		
		/*
		 * 标签
		 */
		//标签设置
		JLabel label = new JLabel();
		ImageIcon pic = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/shana.png");
		label.setIcon(pic);
		label.setSize(pic.getIconWidth(), pic.getIconHeight());
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.add(label);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		/*
		 * 按钮
		 */
		//略
		
		/*
		 * 复选框
		 */
		//复选框设置
		JCheckBox cb1 = new JCheckBox("Agree");
		JCheckBox cb2 = new JCheckBox("Forced to Agree");
		//选项一默认选中
		cb1.setSelected(true);
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.add(cb1);
//		frame.add(cb2);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		/*
		 * 单选框和选项组
		 */
		//单选框
		JRadioButton rb1 = new JRadioButton("Agree");
		JRadioButton rb2 = new JRadioButton("Disagree");
		//选项一默认选中
		rb1.setSelected(true);
		//选项组实现选项互斥
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.add(rb1);
//		frame.add(rb2);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		/*
		 * 下拉框
		 */
		//下拉框
		String[] hero = new String[] {"red","green","blue"};
		JComboBox cb = new JComboBox(hero);
		
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.add(cb);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		/*
		 * 对话框
		 */
		
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		//对话框——询问
//		JOptionPane op = new JOptionPane();
//		int option = op.showConfirmDialog(frame, "是否同意");
//		if(JOptionPane.OK_OPTION == option) {
//			String name = op.showInputDialog(frame, "enter your name");
//			op.showMessageDialog(frame, "Welcome  "+name);
//		}else if(JOptionPane.CANCEL_OPTION == option) {
//			frame.setVisible(false);
//		}else {
//			frame.setVisible(false);
//		}
		
		/*
		 * 文本框和密码框
		 */
		//文本框设置
		JLabel lab1 = new JLabel("账号：");
		JTextField tf = new JTextField("请输入账号");
		tf.setPreferredSize(new Dimension(100,30));
		JLabel lab2 = new JLabel("密码：");
		JPasswordField pf = new JPasswordField();
		pf.setPreferredSize(new Dimension(100,30));
		
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.add(lab1);
//		frame.add(tf);
//		frame.add(lab2);
//		frame.add(pf);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		/*
		 * 文本域
		 */
		//文本域设置
		JTextArea ta = new JTextArea();
		ta.setPreferredSize(new Dimension(200,150));
		//显示内容
		ta.setText("Come on!\nYou will never forget\n");
		//追加显示
		ta.append("Don't do this");
		//自动换行
		ta.setLineWrap(true);
		
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.add(ta);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		/*
		 * 进度条
		 */
		//进度条设置
		JProgressBar pb = new JProgressBar();
		pb.setPreferredSize(new Dimension(200,40));
		pb.setMaximum(100);
		pb.setValue(50);
		//显示当前进度
		pb.setStringPainted(true);
		
		//窗体设置
		frame.setLayout(new FlowLayout());
		frame.add(pb);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		/*
		 * 打开和保存文件
		 */
		        JFrame f = new JFrame("LOL");
		        f.setLayout(new FlowLayout());
		        JFileChooser fc = new JFileChooser();
		        fc.setFileFilter(new FileFilter() {
		             
		            @Override
		            public String getDescription() {
		                return ".txt";
		            }
					@Override
					public boolean accept(File f) {
						return false;
					}
		        });
		  
		        JButton bOpen = new JButton("打开文件");
		  
		        JButton bSave = new JButton("保存文件");
		  
		        f.add(bOpen);
		        f.add(bSave);
		  
		        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        f.setSize(250, 150);
		        f.setLocationRelativeTo(null);
		  
		        f.setVisible(true);
		          
		        bOpen.addActionListener(new ActionListener() {
		              
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                 int returnVal =  fc.showOpenDialog(f);
		                 File file = fc.getSelectedFile();
		                 if (returnVal == JFileChooser.APPROVE_OPTION) {
		                     JOptionPane.showMessageDialog(f, "计划打开文件:" + file.getAbsolutePath());
		                 }
		                  
		            }
		        });
		        bSave.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                int returnVal =  fc.showSaveDialog(f);
		                File file = fc.getSelectedFile();
		                if (returnVal == JFileChooser.APPROVE_OPTION) {
		                    JOptionPane.showMessageDialog(f, "计划保存到文件:" + file.getAbsolutePath());
		                }
		            }
		        });
		  
		    }
		
	}


```

#### 注意

1. tfPassword.grabFocus()，表示让密码输入框获取焦点
2. 与文本框不同，获取密码框里的内容，推荐使用getPassword，该方法会返回一个**字符数组**，而非字符串

#### 索引

- toyz/IntermediateJAVA/src/com.GUI/TestComponent.java

------

### 6.Pane

#### 方法

1. 基本面板  
2. ContentPane   
3.  SplitPanel——附带练习
4. JScrollPanel    
5. TabbedPanel    
6.  CardLayerout    

#### 实现

```java
package com.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * 常用面板
 */
public class TestPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(400, 300, 800, 400);
		
		/*
		 * JPanel——基本面板
		 */
		/*
		//新建面板1
		JPanel p1 = new JPanel();
		p1.setBounds(200, 10, 300, 60);
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.darkGray);
		//新建放置在面板上的按钮
		JButton b1 = new JButton("Yes");
		JButton b2 = new JButton("No");
		JButton b3 = new JButton("Canel");
		//放置按钮
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		//新建面板2
		JPanel p2 = new JPanel();
		p2.setBounds(200, 200, 300, 60);
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.BLUE);
		//新建放置在面板上的按钮
		JButton b4 = new JButton("Yes");
		JButton b5 = new JButton("No");
		JButton b6 = new JButton("Canel");
		//放置按钮
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		
		//窗体设置
		frame.add(p1);
		frame.add(p2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		*/
		
		/*
		 * ContentPanel
		 */
		//平时通过f.add()向JFrame增加组件，其实是向JFrame上的 ContentPane加东西
		
		/*
		 * SplitPanel
		 */	/*

		//创建基本Panel1
		JPanel pleft = new JPanel();
		pleft.setLayout(new FlowLayout());
		pleft.setBackground(Color.darkGray);
		//新建放置在面板上的按钮
		JButton b1 = new JButton("Yes");
		JButton b2 = new JButton("No");
		JButton b3 = new JButton("Canel");
		//放置按钮
		pleft.add(b1);
		pleft.add(b2);
		pleft.add(b3);
		
		//创建基本Panel2
		JPanel pright = new JPanel();
		pright.setLayout(new FlowLayout());
		pright.setBackground(Color.darkGray);
		//新建放置在面板上的按钮
		JButton b4 = new JButton("Yes");
		JButton b5 = new JButton("No");
		JButton b6 = new JButton("Canel");
		//放置按钮
		pright.add(b4);
		pright.add(b5);
		pright.add(b6);
		
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pleft,pright);
		sp.setDividerLocation(80);
		
		frame.setContentPane(sp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	*/

		
		/*
		 * JScrollPanel
		 */ /*
		//文本域放入滚动面板中
		JTextArea ta = new JTextArea();
		for(int i = 0 ; i < 1000 ; i++) {
			ta.append("Come on!\n");
		}
		ta.setLineWrap(true);
		
		//新建滚动面板
		JScrollPane sp = new JScrollPane(ta);
		
		frame.setContentPane(sp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); */
		
		/*
		 * TabbedPanel
		 */ /*
		//创建基本Panel1
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.darkGray);
		//新建放置在面板上的按钮
		JButton b1 = new JButton("Yes");
		JButton b2 = new JButton("No");
		JButton b3 = new JButton("Canel");
		//放置按钮
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		
		//创建基本Panel2
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.darkGray);
		//新建放置在面板上的按钮
		JButton b4 = new JButton("No");
		JButton b5 = new JButton("Way");
		JButton b6 = new JButton("Canel");
		//放置按钮
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		
		//新建tab面板
		JTabbedPane tp = new JTabbedPane();
		tp.add(p1);
		tp.add(p2);
		tp.setTitleAt(0, "page1");
		tp.setTitleAt(1, "page2");
		
		//窗体设置
		frame.setContentPane(tp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	*/
		
		/*
		 * CardLayerout
		 */
		//新建下拉框并加入面板
		JPanel ComboBoxPane = new JPanel();
		String buttonPanel = "按钮面板";
		String inputPanel = "输入面板";
		String comboBoxItem[] = {buttonPanel,inputPanel};
		JComboBox<String> cb = new JComboBox<String>(comboBoxItem);
		ComboBoxPane.add(cb);
		
		//新建panel作为card
		JPanel card1 = new JPanel();
		card1.add(new JButton("button1"));
		card1.add(new JButton("button2"));
		card1.add(new JButton("button3"));
		
		JPanel card2 = new JPanel();
		card2.add(new JTextField("Input",20));
		
		//新建panel放card
		JPanel cards;
		cards = new JPanel(new CardLayout());
		cards.add(card1,buttonPanel);
		cards.add(card2,inputPanel);
		
		//面板加入窗体
		frame.add(ComboBoxPane,BorderLayout.NORTH);
		frame.add(cards,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
		
		//重写下拉框的监听
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				CardLayout cl = (CardLayout) cards.getLayout();
				cl.show(cards, (String) e.getItem());
			}
		});
		
		
	}

}

```

2.SplitPanel练习

```java
package com.GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/*
 * 练习Panel切换
 * 功能预期：
 * 设计一个像SplitPanel的左右风格的SplitPanel
 * 左边放3个按钮，上面的文字分别是: 盖伦，提莫，安妮
 * 右边默认显示盖伦
 * 当左边按钮点击的时候，右边就会显示对应的图片
 */
public class TestPanelPractice {

	public static void main(String[] args) {
		/*
		 * 步骤
		 * 1.新建窗体
		 * 2.左边Panel，并放入三个按钮
		 * 3.右边三个Panel，分别放入图片
		 * 4.使用SplitPanel分割
		 * 5.写按钮点击的监听动作
		 */
		//新建窗体
		JFrame frame = new JFrame();
		frame.setBounds(400, 300, 800, 400);
		
		/*
		 * 左边Panel
		 */
		JPanel pleft = new JPanel();
		pleft.setBackground(Color.DARK_GRAY);
		pleft.setLayout(new FlowLayout());
		//新建按钮并放入
		JButton but1 = new JButton("盖伦");	
		JButton but2 = new JButton("提莫");
		JButton but3 = new JButton("安妮");
		pleft.add(but1);
		pleft.add(but2);
		pleft.add(but3);
		
		/*
		 * 右边Panel1
		 */
		//新建Label存放图片
		JLabel lab1 = new JLabel();
		ImageIcon image1 = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/gareen.jpg");
		lab1.setIcon(image1);
		//将Label放入Panel
		JPanel pright1 = new JPanel();
		pright1.setBackground(Color.DARK_GRAY);
		pright1.setLayout(new FlowLayout());
		pright1.add(lab1);
		
		/*
		 * 右边Panel2
		 */
		//新建Label存放图片
		JLabel lab2 = new JLabel();
		ImageIcon image2 = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/teemo.jpg");
		lab2.setIcon(image2);
		//将Label放入Panel
		JPanel pright2 = new JPanel();
		pright2.setBackground(Color.DARK_GRAY);
		pright2.setLayout(new FlowLayout());
		pright2.add(lab2);
		
		/*
		 * 右边Panel3
		 */
		//新建Label存放图片
		JLabel lab3 = new JLabel();
		ImageIcon image3 = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/annie.jpg");
		lab3.setIcon(image3);
		//将Label放入Panel
		JPanel pright3 = new JPanel();
		pright3.setBackground(Color.DARK_GRAY);
		pright3.setLayout(new FlowLayout());
		pright3.add(lab3);
		
		/*
		 * CardLayout方法存放Panel
		 */
		JPanel prights = new JPanel(new CardLayout());
		prights.add(pright1,"card1");
		prights.add(pright2,"card2");
		prights.add(pright3,"card3");

		/*
		 * SplitPanel分割
		 */
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pleft, prights);
		sp.setDividerSize(10);
		
		//加入窗体
		frame.setContentPane(sp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		/*
		 * 按钮监听
		 */
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) prights.getLayout();
				cl.show(prights,"card1");
			}
		});
		
		but2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) prights.getLayout();
				cl.show(prights, "card2");
			}
		});
		
		but3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) prights.getLayout();
				cl.show(prights, "card3");
			}
		});
	
	}

}
```

#### 注意

1. 面板和JFrame一样都是容器，不过面板一般用来充当**中间容器**，把组件放在面板上，然后再把面板放在窗体上
2. 通过f.add()向JFrame增加组件，其实是向JFrame上的 ContentPane加东西代码比较复制代码
3. CardLayerout 布局器 很像TabbedPanel，在本例里面上面是一个下拉框，下面是一个CardLayerout 的JPanel
4. JScrollPane中添加组件有两个方法

- 在新建面板对象的时候添加
- 通过.setsetViewportView(组件名称)

#### 索引

- toyz/IntermediateJAVA/src/com.GUI/TestPanel.java

------

### 7.Menu

#### 方法

1. 新建菜单栏，JMenuBar()
2. 新建菜单，JMenu()
3. 新建菜单项，JMenuItem()
4. 窗体中加入菜单栏，frame.setJMenuBar()

#### 实现

```java
package com.GUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * 菜单栏
 */
public class TestMenuBar {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(400, 300, 800, 400);
		
		//新建菜单栏
		JMenuBar menuBar = new JMenuBar();
		
		//新建菜单
		JMenu menu1 = new JMenu("File");
		JMenu menu2 = new JMenu("Edit");
		JMenu menu3 = new JMenu("Source");
		JMenu menu4 = new JMenu("Refactor");
		//新建菜单项
		menu1.add(new JMenuItem("New"));
		menu1.add(new JMenuItem("Open"));
		menu1.addSeparator();
		menu1.add(new JMenuItem("Save"));
		menu1.add(new JMenuItem("Sava As"));
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		
		//加入窗体
		frame.setJMenuBar(menuBar);
		
		//窗体设置
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
```

#### 索引

- toyz/IntermediateJAVA/src/com.GUI/TestMenuBar.java

------

### 8.ToolBar

#### 方法

1. 新建工具栏，JToolBar()
2. 窗体加入工具栏，并布局

#### 实现

```java
package com.GUI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class TestToolBar {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(400, 300, 800, 400);
		
		//新建工具栏
		JToolBar bar = new JToolBar();
		//禁止工具栏移动
		bar.setFloatable(false);
		//新建按钮
		JButton but1 = new JButton(new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/1.jpg"));
		JButton but2 = new JButton(new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/2.jpg"));
		JButton but3 = new JButton(new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/3.jpg"));
		JButton but4 = new JButton(new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/4.jpg"));
		JButton but5 = new JButton(new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/5.jpg"));
		JButton but6 = new JButton(new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/6.jpg"));
		but1.setToolTipText("ADC");
		bar.add(but1);
		bar.add(but2);
		bar.add(but3);
		bar.add(but4);
		bar.add(but5);
		bar.add(but6);
		
		frame.setLayout(new BorderLayout());
		frame.add(bar,BorderLayout.NORTH);

		//窗体设置
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

```

#### 索引

- toyz/IntermediateJAVA/src/com.GUI/TestToolBar.java

------



### 9.Table——重点

#### 方法

1.基本表格

- JTable()方法新建表格
- 使用二元数组存储内容并显示到table中
- 使用ScrollPanel制作滚动表格

2.TableModel实现数据和显示分离

3.TableModel与DAO结合，实现数据库展示与修改，前后端数据互通

- 后端到前端：——TestTableModel_Hero.java
- TableModel中get()方法将数据库中内容取出
- 展示在Table中
- 前端到后端：——TestTableModel_GUI
- 前端增加Input组件，调用DAO中的Add()方法向数据库中添加数据
- 同时用Float.parseFloat(hp)方法判断输入内容合法性

#### 实现

1.从数据库获取数据——TestTableModel_Hero.java

```java
package com.GUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.JDBC.Hero;
import com.JDBC.HeroDAO;

public class TestTableModel_Hero extends AbstractTableModel {
	
	String[] columnName = new String[] {"id","name","hp","damage"};
	public List<Hero> heros = new HeroDAO().list();
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return heros.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Hero h = heros.get(rowIndex);
		if(0 == columnIndex)
			return h.id;
		if(1 == columnIndex)
			return h.name;
		if(2 == columnIndex)
			return h.hp;
		if(3 == columnIndex)
			return h.damage;
		return null;
	}
	//获取每一列名称	
	public String getColumnName(int columnIndex) {
	    return columnName[columnIndex];
	}
}

```

2.前端，并向数据库写数据——TestTableModel_GUI.java

```java
package com.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import com.JDBC.Hero;
import com.JDBC.HeroDAO;

/*
 * 使用TableModel,将数据和显示分离
 */
public class TestTableModel_GUI {

	public static void main(String[] args) {
		//新建窗体
		JFrame frame = new JFrame();
		frame.setBounds(400, 300, 800, 400);
		frame.setLayout(new BorderLayout());

		//新建Label显示选中的英雄
		JLabel lab = new JLabel("未选中英雄");
		JPanel panelDisplay = new JPanel();
		panelDisplay.add(lab);
		
		/*
		 * 新建展示选中内容条
		 */
		//新建TableModel
		TestTableModel_Hero tmh = new TestTableModel_Hero();
		//新建Table
		JTable table = new JTable(tmh);
		JScrollPane sp = new JScrollPane(table);
		//table监听选中的项目
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				Hero h = tmh.heros.get(row);
				lab.setText("选中的英雄："+h.name);
			}
		});

		/*
		 * 新建添加功能
		 */
		//新建输入框
		JTextField nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(80,30));
		JTextField hpField = new JTextField();
		hpField.setPreferredSize(new Dimension(80,30));
		JTextField damageField = new JTextField();
		damageField.setPreferredSize(new Dimension(80,30));
		//新建输入框标签
		JLabel nameLab = new JLabel("Name");
		JLabel hpLab = new JLabel("HP");
		JLabel damageLab = new JLabel("Damage");
		//新建按钮
		JButton submit = new JButton("Submit");
		//新建面板并放入组件
		JPanel panelAdd = new JPanel();
		panelAdd.setLayout(new FlowLayout());
		panelAdd.add(nameLab);
		panelAdd.add(nameField);
		panelAdd.add(hpLab);
		panelAdd.add(hpField);
		panelAdd.add(damageLab);
		panelAdd.add(damageField);
		panelAdd.add(submit);
		
    //新建按钮添加动作
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//初始化数据库驱动
				HeroDAO hd = new HeroDAO();
				//获取输入框中内容
				String name = nameField.getText();
				String hp = hpField.getText();
				String damage = damageField.getText();
				//新建存储对象
				Hero hero = new Hero();
				//判断name是否为空白
				if(name.length() == 0) {
					JOptionPane.showMessageDialog(frame,"Name不能为空");//提示
					nameField.grabFocus();//输入框重新获得聚焦
					return;//需要重新判断
				}
				//判断hp是否为浮点型
				try {
					Float.parseFloat(hp);//将内容转换成float，失败则抛出异常
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "HP需要为数字");//提示
					hpField.grabFocus();
					return;
				}
				//判断damage是否为数字
				try {
					Integer.parseInt(damage);//将内容转换成int，失败则抛出异常
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "Damage需要为数字");
					damageField.grabFocus();
					return;
				}
				//将输入内容赋值给hero对象
				hero.name = name;
				hero.hp = Float.parseFloat(hp);
				hero.damage = Integer.parseInt(damage);
				
				//对象加入数据库
				hd.add(hero);
				//更新table model指针
				tmh.heros = hd.list();
				//刷新页面
				table.updateUI();
			}
		});

		//窗体设置
		frame.add(panelDisplay,BorderLayout.SOUTH);
		frame.add(panelAdd,BorderLayout.NORTH);
		frame.add(sp, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

```

#### 注意

1. TableModel_Hero **继承**AbstractTableModel ，进而**实现**了接口TableModel
2. 图形界面需要**渲染**第一个单元格的数据的时候，就会调用方法TabelModel的getValueAt(0,0) ，把返回值拿到并显示

#### 索引

- toyz/IntermediateJAVA/src/com.GUI/TestTableModel_Hero.java
- toyz/IntermediateJAVA/src/com.GUI/TestTableModel_GUI.java

------

### 10.用户管理系统——Practice

#### 预期

1. 用户管理系统
2. 能够增删改查用户的用户名和密码功能

#### 步骤

1.设计功能面板，包括表格展示、编辑模块

2.设计数据库，包括字段名称、类型

3.编写前端页面，不涉及数据

- 主窗口的窗体、面板、表格、按钮、提示
- 弹出窗口的窗体、面板、表格、按钮、提示
- 布局和大小调节

4.将后端数据联通到前端

- Dao接口写涉及的方法，包括增删改查以及返回整个列表
- 使用UserDAO类继承Dao接口，并在此类中实现具体的方法
- 使用tableModel()继承AbstractTableModel类，在此类中用getValueAt()方法将UserDao.list()获取到的user列表赋值到列表项中
- 前端新建UserTableModel，并新建table类，将值加到到table中

5.编写新增按钮的动作

- 获取用户输入的内容，并判断输入的合法性
- 通过判断后，将输入内容赋值给user对象
- 使用UserDao中的add(user)方法
- 重新将tableModel中users组指针指向UserDao.list()——重点
- 更新页面UI
- 关闭窗口

6.编写删除按钮的动作

- 判断用户是否选中项
- 选中为true时，弹出确认框
- 确认后，通过tableDisplay.getValueAt()获取选中行的id值
- 使用UserDao中的delete(id)方法
- 重新将tableModel中users组指针指向UserDao.list()——重点
- 更新页面UI

7.编写更新按钮的动作

- 判断用户是否选中项
- 选中为true时，弹出更新框
- 通过tableDisplay.getValueAt()获取选中行的id值
- 获取用户输入的内容，并判断输入的合法性
- 通过判断后，将输入内容赋值给user对象
- 使用UserDao中的update(user)方法
- 重新将tableModel中users组指针指向UserDao.list()——重点
- 更新页面UI
- 关闭窗口

#### 实现

1.前端页面——UserInterface.java

```java
package com.Practice.UserManageSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserInterface {

	public static void main(String[] args) {
		//新建窗体
		JFrame frame = new JFrame("用户管理界面");
		frame.setBounds(250, 200, 1000, 500);
		frame.setLayout(new BorderLayout());
		
		/*
		 * 展示模块——数据表格 
		 */
		//新建tablemodel
		UserTableModel utm = new UserTableModel();
		//新增数据展示表格
		JTable tableDisplay = new JTable(utm);
		JScrollPane sp = new JScrollPane(tableDisplay);//将表格放入支持滑动的面板
		
		
		/*
		 * 编辑模块
		 */
		//新建按钮模块
		JPanel panelSet = new JPanel();
		panelSet.setLayout(new FlowLayout());
		JButton butAdd = new JButton("新增");
		butAdd.setPreferredSize(new Dimension(150,40));
		JButton butDelete = new JButton("删除");
		butDelete.setPreferredSize(new Dimension(150,40));
		JButton butUpdate = new JButton("编辑");
		butUpdate.setPreferredSize(new Dimension(150,40));
		panelSet.add(butAdd);
		panelSet.add(butDelete);
		panelSet.add(butUpdate);
		
		/*
		 * 新建添加弹出框组件
		 */
		//添加窗体和面板
		JFrame addFrame = new JFrame("用户添加");
		addFrame.setBounds(600, 350, 300, 180);
		JPanel addPanel = new JPanel();
		addPanel.setLayout(null);
		//第一行——用户名输入
		JLabel labNameAdd = new JLabel("用户名：");
		labNameAdd.setBounds(20,20, 70, 30);
		JTextField tfNameAdd = new JTextField();
		tfNameAdd.setBounds(90, 20, 150, 30);
		addPanel.add(labNameAdd);
		addPanel.add(tfNameAdd);
		//第二行——密码输入
		JLabel labPasswordAdd = new JLabel("密码：");
		labPasswordAdd.setBounds(20, 50, 70, 30);
		JTextField tfPasswordAdd = new JTextField();
		tfPasswordAdd.setBounds(90, 50, 150, 30);
		addPanel.add(labPasswordAdd);
		addPanel.add(tfPasswordAdd);
		//第三行——提示语
		JLabel labTip = new JLabel();
		labTip.setBounds(90, 80, 200, 20);
		labTip.setForeground(Color.RED);;
		addPanel.add(labTip);
		//第四行——提交按钮
		JButton butSubmitAdd = new JButton("确认");
		butSubmitAdd.setBounds(30, 100, 120, 40);
		butSubmitAdd.setForeground(Color.BLUE);
		JButton butCancelAdd = new JButton("取消");
		butCancelAdd.setBounds(150, 100, 120, 40);
		addPanel.add(butSubmitAdd);
		addPanel.add(butCancelAdd);
		//窗体设置
		addFrame.setContentPane(addPanel);
		addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addFrame.setVisible(false);
	
		/*
		 * 新建编辑弹出框组件
		 */
		//新建窗体和面板
		JFrame UpdateFrame = new JFrame("用户修改");
		UpdateFrame.setBounds(600, 350, 300, 200);
		JPanel UpdatePanel = new JPanel();
		UpdatePanel.setLayout(null);
		
		//第一行——展示ID
		JLabel labIdTip = new JLabel("ID为：");
		labIdTip.setBounds(20,10, 40, 30);
		JLabel labId = new JLabel();
		labId.setBounds(90, 10, 150, 30);
		UpdatePanel.add(labIdTip);
		UpdatePanel.add(labId);
		//第二行——用户名输入
		JLabel labNameUpdate = new JLabel("新用户名：");
		labNameUpdate.setBounds(20, 40, 70, 30);
		JTextField tfNameUpdate = new JTextField();
		tfNameUpdate.setBounds(90, 40, 150, 30);
		UpdatePanel.add(labNameUpdate);
		UpdatePanel.add(tfNameUpdate);
		//第三行——密码输入
		JLabel labPasswordUpdate = new JLabel("新密码：");
		labPasswordUpdate.setBounds(20, 70, 70, 30);
		JTextField tfPasswordUpdate = new JTextField();
		tfPasswordUpdate.setBounds(90, 70, 150, 30);
		UpdatePanel.add(labPasswordUpdate);
		UpdatePanel.add(tfPasswordUpdate);
		//第三行——提示语
		JLabel labTipUpdate = new JLabel();
		labTipUpdate.setBounds(90, 100, 200, 20);
		labTipUpdate.setForeground(Color.RED);;
		UpdatePanel.add(labTipUpdate);
		//第四行——提交按钮
		JButton butSubmitUpdate = new JButton("确认");
		butSubmitUpdate.setBounds(30, 120, 120, 40);
		butSubmitUpdate.setForeground(Color.BLUE);
		JButton butCancelUpdate = new JButton("取消");
		butCancelUpdate.setBounds(150, 120, 120, 40);
		UpdatePanel.add(butSubmitUpdate);
		UpdatePanel.add(butCancelUpdate);
		//窗体设置
		UpdateFrame.setContentPane(UpdatePanel);
		UpdateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UpdateFrame.setVisible(false);
		
		/*
		 * 动作模块——添加按钮动作
		 */
		butAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addFrame.setVisible(true);
				UserDAO userDao = new UserDAO();
				User user = new User();
				//判断用户是否确认添加
				butSubmitAdd.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//获取输入框内容
						String name = tfNameAdd.getText();
						String password = tfPasswordAdd.getText();
						//判断输入name是否为空
						if(name.length() == 0) {
							labTip.setText("用户名不能为空");
							tfNameAdd.grabFocus();
							return;					
						}
						//判断密码是否为数字
						try {
							Integer.parseInt(password);
						} catch (Exception e2) {
							labTip.setText("密码需要为纯数字");
							tfPasswordAdd.grabFocus();
							return;
						}
						//将输入的值赋给user对象
						user.name = name;
						user.password = Integer.parseInt(password);
						//清空数据
						labTip.setText(null);
						tfNameAdd.setText(null);
						tfPasswordAdd.setText(null);
						//将user对象加入数据库
						userDao.add(user);
						//更新table model指针
						utm.users = userDao.list();
						//刷新页面
						tableDisplay.updateUI();
						//关闭窗口
						addFrame.setVisible(false);
					}
				});
				//判断用户是否取消添加
				butCancelAdd.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						addFrame.setVisible(false);						
					}
				});
			}
		});
		
		/*
		 * 动作模块——删除按钮动作
		 */
		butDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectInt = tableDisplay.getSelectedRow();
				//判断是否选中的特定行
				if(selectInt == -1) {
					JOptionPane.showMessageDialog(frame, "请选择要删除的项目");
					return;
				}
				int deleteConfirm = JOptionPane.showConfirmDialog(frame, "是否确认删除","确认",JOptionPane.YES_NO_OPTION);
				if(deleteConfirm == JOptionPane.YES_OPTION) {
					//获取选中行的id值
					int selectId = (int) tableDisplay.getValueAt(selectInt,0);
					//新建数据库对象，并执行删除方法
					UserDAO userDao = new UserDAO();
					userDao.delete(selectId);
					//更新table model指针
					utm.users = userDao.list();
					//刷新页面
					tableDisplay.updateUI();
				}
			}
		});
		
		/*
		 * 动作模块——编辑按钮
		 */
		butUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取选中的项
				int selectInt = tableDisplay.getSelectedRow();
				//判断是否选中的特定行
				if(selectInt == -1) {
					JOptionPane.showMessageDialog(frame, "请选择要修改的项目");
					return;
				}
				UpdateFrame.setVisible(true);
				UserDAO userDao = new UserDAO();
				User userUpdate = new User();
				//获取选中行的id值
				int selectId = (int) tableDisplay.getValueAt(selectInt,0);
				String labIdString = selectId+"";
				labId.setText(labIdString);
				//判断用户是否确认修改
				butSubmitUpdate.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {

						//获取输入框内容
						String name = tfNameUpdate.getText();
						String password = tfPasswordUpdate.getText();
						//判断输入name是否为空
						if(name.length() == 0) {
							labTipUpdate.setText("用户名不能为空");
							tfNameUpdate.grabFocus();
							return;					
						}
						//判断密码是否为数字
						try {
							Integer.parseInt(password);
						} catch (Exception e2) {
							labTipUpdate.setText("密码需要为纯数字");
							tfPasswordUpdate.grabFocus();
							return;
						}
						//将输入的值赋给userUpdate对象
						userUpdate.id = selectId;
						userUpdate.name = name;
						userUpdate.password = Integer.parseInt(password);
						//调用更新方法
						userDao.update(userUpdate);
						//刷新指针
						utm.users = userDao.list();
						//刷新页面
						tableDisplay.updateUI();
						//关闭窗口
						UpdateFrame.setVisible(false);
					}
				});
				//判断用户是否取消添加
				butCancelUpdate.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						UpdateFrame.setVisible(false);						
					}
				});
			}
			
		});
		
		
		
		
		/*
		 * 窗体设置
		 */
		frame.add(sp,BorderLayout.NORTH);
		frame.add(panelSet,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}

}
```

2.接口——Dao.java

```java
package com.Practice.UserManageSystem;

import java.util.List;

public interface Dao {
	//新增方法
	public void add(User user) ;
	//删除方法
	public void delete(int id);
	//修改方法
	public void update(User user);
	//获取方法
	public User get(int id);
	//查询方法
	public List<User> list();
	//分页查询方法
	public List<User> list(int start,int count);
}
```

3.实现接口方法——UserDAO.java

```java
package com.Practice.UserManageSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Practice.UserManageSystem.*;


/*
 * 实现DAO中的方法
 */
public class UserDAO implements Dao{
	/*
	 * 将驱动放在构造方法中
	 */
	public UserDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("初始化成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 获取数据连接
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
	}
	
	/*
	 * 增加方法
	 */
	public void add(User user) {
		//编写PreparedStatement语句
		String sql = "insert into user values(null,?,?)";
		//创建连接并传输语句
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				)
		{
			c.setAutoCommit(false);
			//传参数到数据库
			ps.setString(1, user.name);
			ps.setInt(2, user.password);
			ps.execute();
			//获取ID并赋值给user
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				int id = rs.getInt(1);
				user.id = id;
			}
			c.commit();//手动提交
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 删除方法
	 */
	public void delete(int id) {
		String sql = "delete from user where id = ?";
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			ps.setInt(1,id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 更新方法
	 */
	public void update(User user) {
		String sql = "update user set name = ? , password = ? where id = ?";
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			c.setAutoCommit(false);
			ps.setString(1,user.name);
			ps.setInt(2, user.password);
			ps.setInt(3, user.id);
			ps.execute();
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 获取方法
	 */
	public User get(int id) {
		String sql = "Select * from user where id = ?";
		User user = null;
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			c.setAutoCommit(false);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {
				user = new User();//新建用户用于存储查询到的对象
				String name = rs.getString("name");
				int password = rs.getInt("password");
				user.name = name;
				user.password = password;
				c.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/*
	 * 返回整个列表
	 */
	public List<User> list(){
		return list(0,Short.MAX_VALUE);
	}

	/*
	 * 分页返回数据
	 */
	public List<User> list(int start, int count) {
		//新建用户组
		List<User> users = new ArrayList<User>();
		String sql = "select * from user order by id desc limit ? , ?";
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			c.setAutoCommit(false);
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//将获取到的数据库中的user数据赋值给user对象
				User user = new User();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int password = rs.getInt("password");
				user.id = id;
				user.name = name;
				user.password = password;
				//将赋值成功的数据加入用户组
				users.add(user);
			}
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回用户组
		return users;
	}
```

4.用户属性类——User.java

```java
package com.Practice.UserManageSystem;

public class User {
	int id;
	String name;
	int password;
	public User(int id,String name, int password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
}
```

5.连接数据库——UserTableModel.java

```java
package com.Practice.UserManageSystem;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {
	String[] columnItem = new String[] {"ID","Name","Password"};
	
	//获取用户列表
	public List<User> users = new UserDAO().list();
	
	@Override
	public int getRowCount() {
		return users.size();
	}

	@Override
	public int getColumnCount() {
		return columnItem.length;
	}
	
	//获取每一列名称	
	public String getColumnName(int columnIndex) {
	    return columnItem[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		User user = users.get(rowIndex);
		if(0 == columnIndex)
			return user.id;
		if(1 == columnIndex)
			return user.name;
		if(2 == columnIndex)
			return user.password;
		return null;
	}

}
```

#### 索引

- toyz/IntermediateJAVA/src/com.Practice.UserManageSystem

### 11.Swing中的线程

#### 方法

1.Swing中有三种线程

- 初始化线程——前端的生成
- 事件调度线程——按钮动作等
- 长耗时任务——复制文件等

2.事件调度线程

- 单线程，线程安全
- 缺点是线程执行时，无法执行其他操作，所有事件相关的操作都是放在 Event Dispatch Thread
- 可以通过SwingUtilities.isEventDispatchThread()确认当前任务是否是事件调度线程

3.长耗时任务

- 长耗时任务，都放在SwingWorker中，其中有线程池执行，默认有10根线程
- 必须实现方法 doInBackground，在doInBackground中，就可以编写我们的任务，然后执行SwingWorker的execute方法，放在专门的工作线程中去运行

#### 实现

```java
package com.GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/*
 * 三种线程
 * 1.初始化线程
 * 2.事件调度线程
 * 3.长耗时任务线程
 */
public class TestSwingThread {

	public static void main(String[] args) {
		/*
		 * 前端页面
		 */
		JFrame frame = new JFrame();
		frame.setBounds(400, 300, 800, 400);
		frame.setLayout(new FlowLayout());
		//新建按钮
		JButton butDispatchThread = new JButton("使用事件调度线程执行长耗时任务");
		butDispatchThread.setPreferredSize(new Dimension(300,40));
		frame.add(butDispatchThread);
		JButton butSwingWorker = new JButton("使用SwingWorker执行长耗时任务");
		butSwingWorker.setPreferredSize(new Dimension(300,40));
		frame.add(butSwingWorker);
		//新建Label展示当前线程
		JLabel lab = new JLabel();
		lab.setPreferredSize(new Dimension(400,40));
		frame.add(lab);
		//窗体设置
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		
        /*
         * 按钮动作
         */
        //事件调度线程
        butDispatchThread.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lab.setText("当前线程是否是 事件调度线程: " + SwingUtilities.isEventDispatchThread());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
        //SwingWorker
        butSwingWorker.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//新建对象
				SwingWorker worker = new SwingWorker() {

					@Override
					//放置长耗时任务，将放在专门的线程中执行
					protected Object doInBackground() throws Exception {
						Thread.sleep(5000);
						lab.setText("执行这个SwingWorder的线程是：" + Thread.currentThread().getName());
						return null;
					}
				};
				worker.execute();
			}
		});
	}

}
```

#### 索引

- toyz/IntermediateJAVA/src/com.GUI/TestSwingThread.java











