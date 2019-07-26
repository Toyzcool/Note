package One;

import static util.Print.*;

public class Mouse extends Rodent {
    // 需要实现抽象方法
    @Override
    public void run() {
        print("Mouse is running");
    }
}
