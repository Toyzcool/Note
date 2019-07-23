package five;

public class TestAll {
    public static void main(String[] args) {
        // public 方法调用，成功，因为任意访问权限
        TestPublic tpub = new TestPublic();
        tpub.pub();
        // protected 方法调用，成功，因为包访问权限
        TestProtected tpro = new TestProtected();
        tpro.pro();
        // private 方法调用，失败
        TestPrivate tpri = new TestPrivate();
        // tpri.pri();
    }
}
