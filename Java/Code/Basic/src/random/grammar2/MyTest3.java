package random.grammar2;

/*
@Author: Toyz
@Date: 2019/9/11
@Time: 09:36
@Purpose:测试double类型数据被截尾
@Related:
*/


public class MyTest3 {
    public static void main(String[] args) {
        // 截尾
        double d1 = 2.63;
        Object dToI1 = (int) d1;
        System.out.println(dToI1);

        // 舍入
        double d2 = 2.75;
        Object dToI2 = Math.round(d2);
        System.out.println(dToI2);
    }
}
