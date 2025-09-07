public class Spogliatoio {
    private int postiDisponibili;

    public Spogliatoio() {
        this.postiDisponibili = 2;
    }

    public synchronized void entra(Pilota pilota) throws InterruptedException {

        while (postiDisponibili <= 0) {
            System.out.println(pilota.getNome() + " in attesa per entrare negli spogliatoi.");
            wait();
        }

        postiDisponibili--;
        System.out.println(pilota.getNome() + " è entrato negli spogliatoi. Posti rimanenti: " + postiDisponibili);

        int tempoSpogliatoio = (int) (Math.random() * 1000) + 500;
        Thread.sleep(tempoSpogliatoio);

        System.out.println(pilota.getNome() + " ha indossato tuta e casco in " + tempoSpogliatoio + " ms.");
    }

    public synchronized void esci(Pilota pilota) {
        postiDisponibili++;
        System.out.println(pilota.getNome() + " è uscito dagli spogliatoi. Posti disponibili: " + postiDisponibili);
        notifyAll();
    }
}
