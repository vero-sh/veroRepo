import java.util.concurrent.Semaphore;

public class ThreadLavoratore extends Thread {

    private static final int NUM_POSTAZIONI = 3;
    private static final int NUM_THREAD = 10;

    private static Semaphore semaforo = new Semaphore(NUM_POSTAZIONI);

    private int id;

    public ThreadLavoratore(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + id + " tenta di accedere alla postazione");

            semaforo.acquire();
            System.out.println("Thread " + id + " ha acquisito una postazione. Postazioni disponibili: " + semaforo.availablePermits());

            Thread.sleep(1000);

            System.out.println("Thread " + id + " ha finito di lavorare e libera la postazione");

            semaforo.release();
            System.out.println("Postazioni disponibili dopo rilascio: " + semaforo.availablePermits());

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            semaforo.release();
        }
    }
}
