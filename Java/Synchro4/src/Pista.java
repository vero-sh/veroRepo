public class Pista {
    private int kartDisponibili;

    public Pista() {
        this.kartDisponibili = 4;
    }

    public synchronized void entra(Pilota pilota) throws InterruptedException {
        while (kartDisponibili <= 0) {
            System.out.println(pilota.getNome() + " in attesa per entrare in pista.");
            wait();
        }

        kartDisponibili--;
        System.out.println(pilota.getNome() + " è entrato in pista. Kart rimanenti: " + kartDisponibili);
    }

    public synchronized void esci(Pilota pilota) {
        kartDisponibili++;
        System.out.println(pilota.getNome() + " ha lasciato la pista. Kart disponibili: " + kartDisponibili);
        notifyAll();
    }

    public void effettuaGiri(Pilota pilota) throws InterruptedException {
        System.out.println(pilota.getNome() + " inizia i giri di pista.");

        for (int i = 1; i <= 15; i++) {
            int tempoGiro = (int) (Math.random() * 300) + 200;
            Thread.sleep(tempoGiro);
            System.out.println(pilota.getNome() + " ha completato il giro " + i + " in " + tempoGiro + " ms.");
        }

        System.out.println(pilota.getNome() + " ha completato tutti i 15 giri.");
    }
}