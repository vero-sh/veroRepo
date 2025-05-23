import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread{
    private Socket s;
    private BufferedReader in;
    private PrintWriter out;
    private Room stanza;

    public Client(Socket s, Room stanza) throws IOException, InterruptedException {
        this.s = s;
        this.stanza = stanza;
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(),true);
        this.start();
        sleep(100);
        send("Benvenuto nella room 4AI");
    }

    public void send(String sms){
        out.println(sms);
    }

    @Override
    public void run() {
        String sms;
        //rimane in ascolto che qualcuno scriva
        try {
            while(true) {
                sms = in.readLine();
                System.out.println("Client "+s.getInetAddress()+" :"+sms);
                if(sms.equalsIgnoreCase("abbandona")){
                    stanza.abbandona(this);
                    sms = "Il client "+ s.getInetAddress() +" lascia la comunicazione";
                    in.close();
                    out.close();
                    s.close();
                }
                stanza.trasmetti(sms, this);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

