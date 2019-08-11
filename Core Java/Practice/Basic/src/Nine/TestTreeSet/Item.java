package Nine.TestTreeSet;

public class Item implements Comparable{
    private String name;
    private int id;

    Item(String name , int id) {
        this.name = name;
        this.id = id;
    }

    @Override public String toString() {
        return "Item{" + "name='" + name + '\'' + ", id=" + id + '}';
    }

    @Override public int compareTo(Object o) {
        Item item = (Item)o;
        return (this.id - item.id) ;
    }
    }
