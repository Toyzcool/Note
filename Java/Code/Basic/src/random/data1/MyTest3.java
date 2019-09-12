package random.data1;

/*
@Author: Toyz
@Date: 2019/9/10
@Time: 15:45
@Purpose:
@Related:
*/


import java.util.Arrays;

public class MyTest3 {
    enum E {
        A(1),B(2),C(3);
        // 定义变量
        private int var;
        // 构造方法中，将var值赋给变量
        E(int var) {
            this.var = var;
        }
        // 返回var值的方法
        public int getVar(){
            return var;
        }
    }
    public static void main(String[] args) {
        System.out.println(E.A.getVar());
    }
}
