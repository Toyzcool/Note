package TestInterfaces;

// 主板类
public class Mainboard {
    // 运行主板的方法
    void run(){
        System.out.println("Mainboard run");
    }
    // 运行方法
    void use(PCI pci){
        pci.open();
        pci.close();
    }

    // 新增运行声卡的方法-可以删除
    /*void useSoundcard(Soundcard soundcard){
        soundcard.open();
        soundcard.close();
    }*/

    public static void main(String[] args) {
        Mainboard mainboard = new Mainboard();
        // 运行主板
        mainboard.run();
        // 运行
        mainboard.use(new Soundcard());
        mainboard.use(new Netcard());
    }
}
