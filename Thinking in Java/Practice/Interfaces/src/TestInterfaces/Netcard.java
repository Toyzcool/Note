package TestInterfaces;

class Netcard implements PCI{
    public void open(){
        System.out.println("Netcard open");
    }
    public void close(){
        System.out.println("Netcard close");
    }
}
