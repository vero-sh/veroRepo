package management;

import java.util.Random;

class Cane extends Thread {
    private final SalaAttesa sala;
    private final int id;
    private final Random random = new Random();

    public Cane(SalaAttesa sala, int id) {
        this.sala = sala;
        this.id = id;
    }

    public void run() {
        try {
            sala.entraCane(id);
            Thread.sleep(1000 + random.nextInt(2000));
            sala.esceCane(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
