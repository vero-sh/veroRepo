import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static int port = 12345; //il numero di porta del server in cui è in ascolto

    public static void main(String[] args) throws IOException {
        ServerSocket ss;
        Socket client;
        BufferedReader leggi;
        PrintWriter scrivi;
        String client_sms;

        //creare un canale in ascolto con il client sulla porta selezionata
        ss = new ServerSocket(port);

        System.out.println("Server correttamente in ascolto sulla porta: " + port);

        //crea il canale di comunicazione verso il client
        client = ss.accept();
        leggi = new BufferedReader(new InputStreamReader(client.getInputStream()));
        scrivi = new PrintWriter(client.getOutputStream(), true);

        while ((client_sms = leggi.readLine()) != null) {
            System.out.println("Ricevuto dal client: " + client_sms);
            scrivi.println("Messaggio ricevuto dal server: " + client_sms);
        }

        //chiudo tutti gli stream
        leggi.close();
        scrivi.close();
        client.close();
        ss.close();

        System.out.println("Server spento");
    }
}