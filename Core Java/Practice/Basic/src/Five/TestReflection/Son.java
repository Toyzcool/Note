package Five.TestReflection;

public class Son extends Father {
    // 成员变量
    private String priSonName;
    private int priSonAge;
    public String pubSonName;
    public int pubSonAge;
    // 构造方法
    public Son(String priSonName , int priSonAge , String pubSonName , int pubSonAge) {
        this.priSonName = priSonName;
        this.priSonAge = priSonAge;
        this.pubSonName = pubSonName;
        this.pubSonAge = pubSonAge;
    }

    public Son(){}

    private Son(String priSonName , int priSonAge){
        this.priSonName = priSonName;
        this.priSonAge = priSonAge;
    }

    // 方法
    @Override public void eat(){
        System.out.println("son eat...");
    }
    @Override public void eat(String food){
        System.out.println("son eat..."+food);
    }
    private void run(){
        System.out.println("son run...");
    }

    @Override public String toString() {
        return "Son{" + "priSonName='" + priSonName + '\'' + ", priSonAge=" + priSonAge
            + ", pubSonName='" + pubSonName + '\'' + ", pubSonAge=" + pubSonAge + '}';
    }
}
