package Test;

class TestThis {
    String s = "initial value";
    int i;
    // 有参构造器
    TestThis(String s,int i){
        System.out.println("Build s and i");
    }
    // 无参构造器使用this调用
    TestThis(){
        this("This",32);
    }
    public static void main(String[] args) {
        TestThis testThis = new TestThis();
    }
}
