public class ThreadBarriera extends Thread {
    private Barriera barriera;
    private int id;

    public ThreadBarriera(int id, Barriera barriera) {
        super("Thread-" + id);
        this.id = id;
        this.barriera = barriera;
    }

    @Override
    public void run() {
        try {

            System.out.println(getName() + " sta lavorando...");
            Thread.sleep(1000);

            System.out.println(getName() + " è arrivato alla barriera");

            barriera.attendi();

            System.out.println(getName() + " sta lavorando dopo la barriera...");

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
