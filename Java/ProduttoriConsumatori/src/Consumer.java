import java.util.ArrayList;
import java.util.List;

public class Consumer extends Thread{

    private SharedResources sharedResources;
    public Consumer(SharedResources sharedResources) {
        setName("Consumer");
        this.sharedResources = sharedResources;
    }

    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            try {
                sharedResources.getValue();
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName()+" interrotto");
            }
        }

    }
}
