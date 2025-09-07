
public class Main {
    private static final int N = 5;
    private static final int P = 7;
    private static final int X = 100;

    public static void main(String[] args) {
        Magazzino magazzino = new Magazzino(N, X);


        for (int i = 0; i < P; i++) {
            new Produttore("Produttore-" + i, magazzino).start();
        }


        new Consumatore("Consumatore-1", magazzino).start();
        new Consumatore("Consumatore-2", magazzino).start();


        new Ispettore(magazzino).start();

        System.out.println("Simulazione avviata con " + P + " produttori e magazzino capienza " + N);
    }
}