package management;
import java.util.Random;


public class Veterinario {
    public static void main(String[] args) {
        SalaAttesa sala = new SalaAttesa();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            if (random.nextBoolean()) {
                new Cane(sala, i).start();
            } else {
                new Gatto(sala, i).start();
            }

            try {
                Thread.sleep(500); // intervallo tra gli arrivi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

