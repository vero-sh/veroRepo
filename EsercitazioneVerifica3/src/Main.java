import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("inserisci 5 righe di testo");
        Scanner sc = new Scanner(System.in);
        String txt = "";
        for(int i = 0; i<5; i++) {
            txt += "\n"+sc.nextLine();
        }
        System.out.println(txt);
        String path = "X:\\Users\\veronesi.niccolo\\Documents\\progetti\\veroRepo\\EsercitazioneVerifica3\\src\\input.txt";
        try {
            FileWriter fr = new FileWriter(path);
            fr.write(txt);
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}