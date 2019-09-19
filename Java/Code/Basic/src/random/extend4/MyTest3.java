package random.extend4;

/*
@Author: Toyz
@Date: 2019/9/19
@Time: 13:21
@Purpose:
@Related:
*/


public class MyTest3 {
    // 空方法
    public void voidMethod(){

    }

    //final常量
    private final boolean FINAL_FLAG_FALSE = false;
    public void constantFalseFlag(){
        if(FINAL_FLAG_FALSE){
            System.out.println("debug log...");
        }
    }

    // 非final
    private boolean  falseFlag= false;
    public void falseFlag(){
        if(falseFlag){
            System.out.println("debug log...");
        }
    }
}
