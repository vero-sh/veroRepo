public class Producer extends Thread{
    private SharedResources sharedResources;
    private final int MAX_ITERATION;

    public Producer(SharedResources sharedResources) {
        setName("Producer");
        this.sharedResources = sharedResources;
        MAX_ITERATION = 20;
    }

    @Override
    public void run() {

        for (int i = 0; i < MAX_ITERATION; i++){
            int val = (int) (Math.random() *(100-1)) +1;

            try {
                sharedResources.addValue(val);
            }catch (InterruptedException e){
                System.out.println(getName() + "Interrotto");
            }


        }
    }
}
