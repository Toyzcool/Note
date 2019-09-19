package SixTwo;

import SixOne.Ex6Interface;

public class Ex6Base {
    protected class Ex6Inner implements Ex6Interface{
        // 需要有public的构造器，保证其他包中能够创建该类的对象
        public Ex6Inner() {
        }

        @Override public String say() {
            return "Ex6Base.Ex6Inner.say()";
        }
    }
}
