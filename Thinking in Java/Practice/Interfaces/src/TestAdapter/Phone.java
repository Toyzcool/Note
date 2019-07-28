package TestAdapter;

public class Phone {
    // 使用Target作为传入参数的原因：只要是接入Target接口的类，都能够作为参数进行电压转换
    void charging(Target target){
        target.output5V();
    }
}
