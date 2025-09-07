import java.util.concurrent.Semaphore;

public class Barriera {
    private static final int numThread =5;
    private static int contatore = 0;
    private static Semaphore semaforoContatore = new Semaphore(1);
    private static Semaphore semaforoBarriera = new Semaphore(0);

    public static void attendi() throws InterruptedException {

        semaforoContatore.acquire();
        contatore++;
        System.out.println(Thread.currentThread().getName() + " incrementa contatore: " + contatore);

        if (contatore < numThread) {
            semaforoContatore.release();
            semaforoBarriera.acquire();
        } else {

            System.out.println("Tutti i thread sono arrivati! Sblocco...");
            semaforoBarriera.release(numThread - 1);
            semaforoContatore.release();
        }

        // Fase 2: Dopo la barriera
        System.out.println(Thread.currentThread().getName() + " prosegue dopo la barriera");
    }
}