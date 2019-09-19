package Eight;

public class ThisKey {
    void getMetal(){
        System.out.println("找到金属");
    }
    void MakeKey(){
        getMetal();
        this.getMetal();
    }

    public static void main(String[] args) {
        ThisKey thisKey = new ThisKey();
        thisKey.MakeKey();
    }
}
