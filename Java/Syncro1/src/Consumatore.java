public class Consumatore extends Thread {
    private Magazzino magazzino;

    public Consumatore(String name, Magazzino magazzino) {
        super(name);
        this.magazzino = magazzino;
    }

    @Override
    public void run() {
        try {
            while (true) {
                magazzino.prendi();
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
