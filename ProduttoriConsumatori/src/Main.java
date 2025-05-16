public class Main {
    public static void main(String[] args) throws InterruptedException{
        SharedResources sharedResources = new SharedResources(10);
        Producer p = new Producer(sharedResources);
        Consumer c = new Consumer(sharedResources);
        p.start();
        c.start();
        p.join();
        c.join();
        System.out.println("..END..");

    }
}