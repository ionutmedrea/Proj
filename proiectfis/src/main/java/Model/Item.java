package Model;

public class Item {

    protected String name;
    protected int price;
    protected int grd;
    public Item() {

    }

    public Item(String name, int price, int grd) {
        this.name=name;
        this.price=price;
        this.grd=grd;
    }


    public String getName() {
        return name;
    }
    public int getPrice() { return price;}
    public int getGrd() { return grd;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!name.equals(item.name)) return false;
        if (price != item.price) return false;
        if (grd != item.grd) return false;
        return false;
}
    @Override
    public String toString() {
        return "Components{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", grad='" + grd + '\'' +
                '}';
    }


}