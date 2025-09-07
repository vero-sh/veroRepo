
public class Produttore extends Thread {
    BufferCircolare bf = new BufferCircolare();

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                BufferCircolare.produci(i);
                sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
