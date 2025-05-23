import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Lettura extends Thread{
    private Socket s;

    private BufferedReader in;

    public Lettura(Socket s) throws IOException {
        this.s = s;
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println(in.readLine()); //leggo dalla socket e stampo a video
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
