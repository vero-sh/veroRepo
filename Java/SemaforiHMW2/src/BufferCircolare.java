import java.util.concurrent.Semaphore;

public class BufferCircolare {

    private static final int N = 5;
    private static int [] buffer = new int[N];
    private static int testa = 0;
    private static int coda = 0;

    private static Semaphore spaziVuoti = new Semaphore(N);
    private static Semaphore spaziPieni = new Semaphore(0);
    private static Semaphore mutex = new Semaphore(1);

    public static void produci(int n) throws InterruptedException {

        spaziVuoti.acquire();
        mutex.acquire();

        buffer[testa] = n;
        testa = (testa + 1) % N;
        System.out.println("prodotto: "+n+ "(testa: "+testa+ ")");
        mutex.release();
        spaziPieni.release();
    }
    public static int consuma() throws InterruptedException {
        spaziPieni.acquire();
        mutex.acquire();

        int n = buffer[coda];
        coda = (coda + 1) % N;
        System.out.println("Consumato: " + n + " (coda: " + coda + ")");

        mutex.release();
        spaziVuoti.release();
        return n;
    }


}
