package TestAdapter;

public class Phone {
    // 充电方法，充电需要用到供电方法
    void charging(Target target){
        int v = target.output5V();
        System.out.println("使用成功，方法为"+target.getClass().getSimpleName()+",电压为："+v);
    }
}
