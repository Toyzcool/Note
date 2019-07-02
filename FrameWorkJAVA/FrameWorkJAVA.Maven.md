# FrameWorkJAVA.Maven

## 1.简介

### 方法

#### 1.基本概念

1.自动化构建工具

- 普通流程是：编译、打包、部署、测试
- 使用Maven可以自动化构建完成

2.配置方式

1. 打开终端输入命令 vim ~/.bash_profile （编辑环境变量配置文件）
2. 按下i，进入编辑模式
3. 在环境变量文件中加上如下的配置
4. 输入 :wq退出并保存当前文件
5. 输入 source .bash_profile，按下Enter键使bash_profile生效
6. 输入 mvn -v，结果如下图所示即表明配置成功

```shell
   export MAVEN_HOME=/Users/kun/Desktop/midongtools/apache-maven-3.5.0 

   export PATH=$PATH:$MAVEN_HOME/bin

   PS:（可以将文件直接拖拽至终端内文件路径便可显示出来）
```

