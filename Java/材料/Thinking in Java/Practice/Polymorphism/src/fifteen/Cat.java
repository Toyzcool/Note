package fifteen;

import static util.Print.*;

class Cat extends Animal{
    private int i = 1;

    Cat(int r) {
        this.i = r;
        print("Cat Con i:"+i);
    }
    @Override
    void run(){
        print("Cat run i:"+i);
    }
}
