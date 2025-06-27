import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{

        File f = new File("C:\\Users\\veron\\Documents\\Progetti\\veroRepo\\EsercitazioneVerifica6\\src\\input.txt");

        if(!f.exists()) f.createNewFile();
        BufferedReader bw = new BufferedReader(new FileReader(f));
        int c = 1;
        int value;

        while ((value = bw.read()) != -1) {
            char car = (char) value;
            if (car == ' ') c++;
        }

        System.out.println("numero parole: "+c);


    }
}