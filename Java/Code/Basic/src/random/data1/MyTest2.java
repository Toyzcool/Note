package random.data1;

/*
@Author: Toyz
@Date: 2019/9/10
@Time: 14:18
@Purpose:比较StringBuilder和StringBuffer，查看同步的源代码
@Related:
*/


public class MyTest2 {
    public static void main(String[] args) {
        // 线程安全
        StringBuffer stringBuffer = new StringBuffer("1abc");
        // 线程不安全
        StringBuilder stringBuilder = new StringBuilder("2abc");
    }
}
