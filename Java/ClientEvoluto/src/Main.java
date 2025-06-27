import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket server = new Socket("localhost",12345);
        new Lettura(server).start();
        new Scrittura(server).start();
    }
}