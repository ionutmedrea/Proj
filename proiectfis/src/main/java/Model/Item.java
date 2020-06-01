package Model;

public class Item {

    private String name;
    private int price;
    private int grd;
    
    public Item(String name, int price, int grd) {
        this.name=name;
        this.price=price;
        this.grd=grd;
    }

    public Item(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public int getPrice() { return price;}
    public int getGrd() { return grd;}

    @Override
    public String toString() {
        return "Components{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", grad='" + grd + '\'' +
                '}';
    }

}