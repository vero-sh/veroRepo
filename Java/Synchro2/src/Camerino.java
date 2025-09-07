import java.util.Random;

public class Camerino {
    private int postiDisponibili;
    private Random random = new Random();

    public Camerino(int posti) {
        this.postiDisponibili = posti;
    }

    public synchronized void entra(Modello modello) throws InterruptedException {

        while (postiDisponibili <= 0) {
            System.out.println(modello.getNome() + " in attesa di entrare nel camerino.");
            wait();
        }
        postiDisponibili--;
        System.out.println(modello.getNome() + " è entrato nel camerino. Posti rimanenti: " + postiDisponibili);


        int tempoPerCambiarsi = random.nextInt(3000) + 1000;
        Thread.sleep(tempoPerCambiarsi);
        System.out.println(modello.getNome() + " ha finito di cambiarsi in " + tempoPerCambiarsi + " ms.");
    }

    public synchronized void esci(Modello modello) {
        postiDisponibili++;
        System.out.println(modello.getNome() + " ha lasciato il camerino. Posti disponibili: " + postiDisponibili);
        notifyAll();
    }
}
