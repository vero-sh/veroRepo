import java.util.Random;

public class Botteghino {
    private int bigliettiDisponibili;
    private int compratoriAlBotteghino;
    private Random random = new Random();

    public Botteghino(int bigliettiIniziali) {
        this.bigliettiDisponibili = bigliettiIniziali;
        this.compratoriAlBotteghino = 0;
    }


    public synchronized void acquistaBiglietto(Compratore compratore) throws InterruptedException {
        String nome = compratore.getNome();


        while (compratoriAlBotteghino >= 5) {
            System.out.println(nome + " in attesa: troppi compratori al botteghino (" + compratoriAlBotteghino + "/5).");
            wait();
        }

        compratoriAlBotteghino++;
        System.out.println(nome + " è al botteghino. Compratori presenti: " + compratoriAlBotteghino + "/5");

        if (bigliettiDisponibili > 0) {

            int tempoAcquisto = random.nextInt(1500) + 500;
            Thread.sleep(tempoAcquisto);

            bigliettiDisponibili--;
            System.out.println("✅ " + nome + " ha comprato un biglietto! Biglietti rimanenti: " + bigliettiDisponibili);
        } else {
            System.out.println("❌ " + nome + " non ha potuto comprare: biglietti esauriti!");
        }

        compratoriAlBotteghino--;
        System.out.println(nome + " ha lasciato il botteghino. Compratori presenti: " + compratoriAlBotteghino + "/5");

        notifyAll();
    }

    public int getBigliettiDisponibili() {
        return bigliettiDisponibili;
    }
}
