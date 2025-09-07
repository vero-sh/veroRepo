
public class Main {

    public static void main(String[] args) {
        // Crea la barriera condivisa
        Barriera barriera = new Barriera();

        // Crea e avvia i thread
        for (int i = 0; i < 5; i++) {
            ThreadBarriera thread = new ThreadBarriera(i, barriera);
            thread.start();
        }
    }
}