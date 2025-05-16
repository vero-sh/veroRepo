import java.io.*;
import java.net.Socket;
public class Main {

    public static String host = "10.1.30.30";
    public static int port = 12345;
    public static void main(String[] args) throws IOException {
        String sms;
        String risposta;
        Socket socket = new Socket(host, port);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("messaggio da inviare al server: exit per uscire");
        while(!(sms = tastiera.readLine()).equalsIgnoreCase("exit")){

            pw.println(sms);
            risposta = br.readLine();
            System.out.println("risposta server: "+risposta);
        }
        br.close();
        pw.close();
        socket.close();
    }
}