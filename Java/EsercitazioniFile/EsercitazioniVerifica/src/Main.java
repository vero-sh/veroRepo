import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        String path = "X:\\Users\\veronesi.niccolo\\Documents\\progetti\\veroRepo\\EsercitazioniVerifica\\src\\input.txt";

        try {
            FileReader fileReader = new FileReader(path);
            int carattere;

            while ((carattere = fileReader.read()) != -1) {
                System.out.print((char) carattere);
            }
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file: " + e.getMessage());
        }
    }
}
