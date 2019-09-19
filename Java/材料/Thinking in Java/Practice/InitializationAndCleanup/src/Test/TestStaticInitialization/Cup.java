package Test.TestStaticInitialization;


import static util.Print.*;

class Cup {
    Cup(int marker){
        print("Cup("+marker+")");
    }
    void f(int marker){
        print("f("+marker+")");
    }
}
