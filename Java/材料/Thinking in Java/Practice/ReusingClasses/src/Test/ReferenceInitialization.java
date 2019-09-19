package Test;

public class ReferenceInitialization {
    private Reference1 reference4;
    // 1.在定义对象时初始化引用
    private Reference1 reference1 = new Reference1("1.在定义对象时初始化引用") ;

    ReferenceInitialization(){
        // 2.在类的构造器中初始化引用
        Reference1 reference2 = new Reference1("2.在类的构造器中初始化引用");
    }

    // 4.使用实例初始化
    {
        reference4 = new Reference1("4.使用实例初始化");
    }

    public static void main(String[] args) {
        ReferenceInitialization referenceInitialization = new ReferenceInitialization();
        // 3.需要使用对象时，才初始化引用
        Reference1 reference3 = new Reference1("3.需要使用对象时，才初始化引用");
    }
}
