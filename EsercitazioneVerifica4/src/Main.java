import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "X:\\Users\\veronesi.niccolo\\Documents\\progetti\\veroRepo\\EsercitazioneVerifica4\\src\\input.txt";
        File f = new File(path);

        if(!f.exists()) f.createNewFile();

        BufferedWriter br = new BufferedWriter(new FileWriter(path, false));
        br.write("");

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<5; i++){
            br.append(sc.nextLine()+" ");
        }
        br.close();
    }
}