package management;

import java.util.Random;

class Gatto extends Thread {
    private final SalaAttesa sala;
    private final int id;
    private final Random random = new Random();

    public Gatto(SalaAttesa sala, int id) {
        this.sala = sala;
        this.id = id;
    }

    public void run() {
        try {
            sala.entraGatto(id);
            Thread.sleep(1000 + random.nextInt(2000));
            sala.esceGatto(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

