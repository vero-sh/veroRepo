public class Consumatore extends Thread {
    BufferCircolare bf = new BufferCircolare();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                BufferCircolare.consuma();
                sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
