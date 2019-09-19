package One;

import static util.Print.*;

// 抽象类
public abstract class Rodent {
    // 抽象方法
    public abstract void run();

    // 普通方法
    public void say(){
        print("Rodent say");
    }
}
