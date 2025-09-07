import java.util.Random;

public class Passerella {
    private int postiDisponibili;
    private Random random = new Random();

    public Passerella(int posti) {
        this.postiDisponibili = posti;
    }

    public synchronized void entra(Modello modello) throws InterruptedException {

        while (postiDisponibili <= 0) {
            System.out.println(modello.getNome() + " in attesa di entrare in passerella.");
            wait();
        }
        postiDisponibili--;
        System.out.println(modello.getNome() + " è entrato in passerella. Posti rimanenti: " + postiDisponibili);


        int tempoPerSfilare = random.nextInt(3000) + 2000;
        Thread.sleep(tempoPerSfilare);
        System.out.println(modello.getNome() + " ha sfilato per " + tempoPerSfilare + " ms.");
    }

    public synchronized void esci(Modello modello) {
        postiDisponibili++;
        System.out.println(modello.getNome() + " ha lasciato la passerella. Posti disponibili: " + postiDisponibili);
        notifyAll();
    }
}
