
public class Main {
    public static void main(String[] args) {

        Produttore p = new Produttore();
        Consumatore c = new Consumatore();

        p.start();
        c.start();

    }
}