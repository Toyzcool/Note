package random.grammar2;

/*
@Author: Toyz
@Date: 2019/9/11
@Time: 10:16
@Purpose:使用循环嵌套和label标签实现输出100以内的素数
@Related:
*/


public class MyTest5 {
        public static void main(String[] args) {
            outer:for (int i = 1 ; i < 100 ; i++ ){
                inter:for (int j = 2 ; j < i ; j++ ){
                    if ( i%j == 0){
                        // 退出到指定的循环
                        continue outer; }
                }
                System.out.println(i+"");
            }
        }
}

