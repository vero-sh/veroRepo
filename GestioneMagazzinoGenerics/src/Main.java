

public class Main {
    public static void main(String[] args) {
        Magazzino magazzino = new Magazzino<>("magazzini lafayette");
        magazzino.addProdotto(new Telefono("iphone", "11"));
        magazzino.addProdotto(new Latte("parmalat", "11/01/2025"));
        magazzino.stampaLista();
    }

}