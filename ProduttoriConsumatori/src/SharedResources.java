import java.util.ArrayList;
import java.util.List;

public class SharedResources extends Thread{
    private List<Integer> buffer;
    private final int MAX;


    public SharedResources() {
        buffer = new ArrayList<>();
        this.MAX = 10;
    }

    public SharedResources(int capacity) {
        buffer = new ArrayList<>();
        this.MAX = capacity;
    }

    public synchronized void addValue(int val) throws InterruptedException{
        if(buffer.size() == MAX) {
            System.out.println(Thread.currentThread().getName() + " aspetta ( "+buffer.size() +" )" );
            wait();
        }

        buffer.add(val);
        System.out.println(Thread.currentThread().getName() + " ha inserito: "+val+ "(length : "+buffer.size()+" )");
        notify();
    }

    public synchronized void getValue() throws InterruptedException {
        if(buffer.size() == 0) {
            System.out.println();
            System.out.println(Thread.currentThread().getName() + " aspetta ( "+buffer.size() +" )" );
            wait();
        }
        System.out.println("ha levato "+buffer.remove(0));
        notify();

    }
}
