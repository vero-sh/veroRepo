import java.io.*;
import java.net.Socket;
public class Client {
    private int port;
    private String host;
    private Socket s;
    private PrintWriter scrivi;

    private BufferedReader leggi;
    public Client(int port, String host) {
        this.port = port;
        this.host = host;
    }
    public void start() throws IOException{
        s = new Socket(host,port);
        leggi = new BufferedReader(new InputStreamReader(s.getInputStream()));
        scrivi = new PrintWriter(s.getOutputStream(), true);
    }
    public String leggi() throws IOException{
        return leggi.readLine();
    }
    public void scrivi(String sms) throws IOException{

    }
}
