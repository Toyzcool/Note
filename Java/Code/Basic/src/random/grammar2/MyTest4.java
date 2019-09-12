package random.grammar2;

/*
@Author: Toyz
@Date: 2019/9/11
@Time: 09:51
@Purpose:表达式中的最大数据类型决定了表达式最终结果的数据类型
@Related:
*/


public class MyTest4 {
    public static void main(String[] args) {
        double d = 3.434;
        float f = 23.1f;
        Object obj = d * f;
        if (obj instanceof Float){
            System.out.println("Float");
        }
        if (obj instanceof Double){
            System.out.println("Double");
        }
    }
}
