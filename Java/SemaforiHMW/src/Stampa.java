import java.util.concurrent.Semaphore;

public class Stampa extends Thread {

    private static Semaphore semaforoDispari = new Semaphore(1);
    private static Semaphore semaforoPari = new Semaphore(0);

    private boolean isDispari;

    public Stampa(boolean isDispari) {
        this.isDispari = isDispari;
    }

    @Override
    public void run(){
        if(isDispari){
            for (int i = 1; i<=20; i+=2) {
                try{
                    semaforoDispari.acquire();
                    System.out.println("dispari: " + i);
                    semaforoPari.release();
                } catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        }else{
            for(int i = 2; i<=20; i+=2){
                try {
                    semaforoPari.acquire();
                    System.out.println("pari: " + i);
                    semaforoDispari.release();
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        }


    }
}
