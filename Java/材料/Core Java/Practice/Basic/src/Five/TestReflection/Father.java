package Five.TestReflection;


public class Father {
    // 成员变量
    private String priFatherName;
    private int priFatherAge;
    public String pubFatherName;
    public int pubFatherAge;

    public Father() { }

    public Father(String priFatherName , int priFatherAge , String pubFatherName ,
        int pubFatherAge) {
        this.priFatherName = priFatherName;
        this.priFatherAge = priFatherAge;
        this.pubFatherName = pubFatherName;
        this.pubFatherAge = pubFatherAge;
    }

    private Father(String priFatherName , int priFatherAge){
        this.priFatherName = priFatherName;
        this.priFatherAge = priFatherAge;
    }
    // 方法
    public void eat(){
        System.out.println("father eat...");
    }
    public void eat(String food){
        System.out.println("father eat..."+food);
    }
    public void edu(){
        System.out.println("father edu...");
    };
    private void run(){
        System.out.println("father run...");
    }
}
