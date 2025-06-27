
import java.util.ArrayList;
public class Magazzino <T>{
    private String nome;
    private ArrayList<T> listaProdotti;

    public Magazzino(String nome) {
        this.nome = nome;
        this.listaProdotti = new ArrayList<T>();
    }
    public void addProdotto(T prodotto){
        listaProdotti.add(prodotto);
    }
    public T rimuoviProdotto(int index){
        return listaProdotti.remove(index);
    }
    public void stampaLista(){
        for (int i = 0; i<listaProdotti.size(); i++){
            System.out.println(listaProdotti.get(i));
        }
    }


}
