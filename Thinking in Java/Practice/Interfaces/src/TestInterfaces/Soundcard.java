package TestInterfaces;

public class Soundcard implements PCI{
    public void open(){
        System.out.println("Soundcard open");
    }
    public void close(){
        System.out.println("Soundcard close");
    }
}
