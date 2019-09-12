package random.data1;/*
@Author: Toyz
@Date: 2019/9/10
@Time: 10:39
@Purpose:测试如果超过基本数据类型范围，显示的值是多少
@Related:
*/


public class MyTest1 {
    public static void main(String[] args) {
        byte s = 127;
        System.out.println(s);
        // 超过上限后，加到0
        for (int j = 0 ; j <= 128 ; j++){
            s++;
        }
        System.out.println(s);
        s = 127;
        // 超过上限后加到再次上限
        for (int j = 0 ; j <= 256; j++){
            s++;
        }
        System.out.println(s);

        System.out.println("==================");
        int n = 2147483647;
        System.out.println(n);
        n++;
        System.out.println(n);
    }
}
