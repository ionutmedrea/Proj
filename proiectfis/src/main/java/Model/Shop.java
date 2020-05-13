package Model;


import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Componenta> lista = new ArrayList<>(100);
    public void afiseazaComponente(){
        for (Componenta current: lista) {
            System.out.println(current.toString());
        }
    }
}
