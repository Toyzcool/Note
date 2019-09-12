package random.grammar2;

/*
@Author: Toyz
@Date: 2019/9/11
@Time: 08:10
@Purpose:测试操作符会导致多次运算的副作用
@Related:
*/


public class MyTest2 {
    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,3};
        int index = 0;
        int a = 1;
        arrays[index++] += a;
        System.out.println("index:"+index);
        System.out.println("a:"+a);
        for (int array : arrays) {
            System.out.println(array);
        }
    }
}
