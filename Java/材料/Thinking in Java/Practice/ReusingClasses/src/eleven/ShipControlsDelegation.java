package eleven;
// 代理对象
public class ShipControlsDelegation {
    private String name;
    private ShipControls controls = new ShipControls();

    public ShipControlsDelegation(String name) {
        this.name = name;
    }
    // 代理对象将值传递给底层的controls对象
    public void up(int step){
        controls.up(step);
    }
    public void down(int step){
        controls.down(step);
    }
    public void left(int step){
        controls.left(step);
    }
    public void right(int step){
        controls.right(step);
    }

    public static void main(String[] args) {
        ShipControlsDelegation shipControlsDelegation = new ShipControlsDelegation("delegation1");
        shipControlsDelegation.up(5);
    }
}
