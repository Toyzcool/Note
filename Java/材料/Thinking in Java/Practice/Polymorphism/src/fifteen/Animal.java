package fifteen;

import static util.Print.*;

// base class
class Animal {
    void run(){
        print("Ani Run");
    }
    // 构造函数
    Animal() {
        print("Ani Con before run()");
        run();
        print("Ani Con after run()");
    }
}
