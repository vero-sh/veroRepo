package bomb;

import java.util.Scanner;

public class Stop extends Thread {

    private Bomb b[];

    public Stop(Bomb b[]) {
        this.b = b;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        new Scanner(System.in).nextLine();
        b[0].interrupt();
        b[1].interrupt();
        b[2].interrupt();
    }
}
