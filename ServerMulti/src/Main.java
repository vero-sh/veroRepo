import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static final int port = 12345;
    public static void main(String[] args) throws IOException, InterruptedException {
        Room room = new Room();
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server up");
        while(true){
            room.addClient(ss.accept()); //restituisce un oggetto Socket verso il client
            System.out.println("Accetto il client");
        }
    }
}