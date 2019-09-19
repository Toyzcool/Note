package Test;

class Test{
    static Inter function(){
        return new Inter() {
            @Override public void method() {
                System.out.println("run");
            }
        };
    }
}
