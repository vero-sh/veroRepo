public class Ispettore extends Thread {
    private Magazzino magazzino;

    public Ispettore(Magazzino magazzino) {
        super("Ispettore");
        this.magazzino = magazzino;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(3000);
                magazzino.ispeziona();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
