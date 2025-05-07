import java.io.*;

public class Main {
    public static void main(String[] args) {
        String path = "X:\\Users\\veronesi.niccolo\\Documents\\progetti\\veroRepo\\EserciazioneVerifica2\\src\\input.txt";

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bf = new BufferedReader(fileReader);
            String line = "";

            while ((line = bf.readLine()) != null){
                System.out.print(line);
            }

        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
        }
    }
}