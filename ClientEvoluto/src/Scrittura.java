import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Scrittura extends Thread{
    private Socket s;
    private PrintWriter out;

    private BufferedReader tastiera;

    public Scrittura(Socket s) throws IOException {
        this.s = s;
        out=  new PrintWriter(s.getOutputStream(),true);
        tastiera = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        String sms;
        while(true){
            try {
                sms = tastiera.readLine();
                out.println(sms);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

