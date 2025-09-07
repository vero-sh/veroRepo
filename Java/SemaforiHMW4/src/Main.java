
public class Main {

    public static void main(String[] args) {
        Barriera barriera = new Barriera();


        for (int i = 0; i < 5; i++) {
            ThreadBarriera thread = new ThreadBarriera(i, barriera);
            thread.start();
        }
    }
}