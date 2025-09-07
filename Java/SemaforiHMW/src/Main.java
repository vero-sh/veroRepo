public class Main {
    public static void main(String[] args) {
        Stampa threadDispari = new Stampa(true);
        Stampa threadPari = new Stampa(false);

        threadDispari.start();
        threadPari.start();
    }
}