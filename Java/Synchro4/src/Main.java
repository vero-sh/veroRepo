public class Main {
    public static void main(String[] args) {
        int numeroPiloti = 8;

        Spogliatoio spogliatoio = new Spogliatoio();
        Pista pista = new Pista();


        for (int i = 1; i <= numeroPiloti; i++) {
            Pilota pilota = new Pilota("Pilota-" + i, spogliatoio, pista);
            pilota.start();
        }
    }
}