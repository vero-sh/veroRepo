public class Produttore extends Thread {
    private Magazzino magazzino;

    public Produttore(String name, Magazzino magazzino) {
        super(name);
        this.magazzino = magazzino;
    }

    @Override
    public void run() {
        try {
            while (true) {

                int numero = (int) (Math.random() * 50) * 2;
                magazzino.metti(numero);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
