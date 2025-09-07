public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numeroCompratori = 200;
        int bigliettiDisponibili = 100;

        Botteghino botteghino = new Botteghino(bigliettiDisponibili);

        for (int i = 1; i <= numeroCompratori; i++) {
            Compratore compratore = new Compratore("Compratore-" + i, botteghino);
            compratore.start();
        }

        Thread.sleep(30000);
        System.out.println("\nBiglietti rimanenti: " + botteghino.getBigliettiDisponibili());
    }
}