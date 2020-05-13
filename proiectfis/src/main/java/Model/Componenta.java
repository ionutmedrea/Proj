package Model;
import java.util.ArrayList;

public class Componenta {
    private String name;
    private float price;
    private int gradComp;
    public Componenta(String name, float price,int gradComp){
        this.name=name;
        this.price=price;
        this.gradComp=gradComp;
    }
    public void setPrice(float price){
        this.price=price;
    }
    public String toString(){
        return name + " " + gradComp + "         " +  price;
    }
}
