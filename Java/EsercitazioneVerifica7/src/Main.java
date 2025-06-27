import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        final String path = "C:\\Users\\veron\\Documents\\Progetti\\veroRepo\\EsercitazioneVerifica7\\src\\input.txt";
        File f = new File(path);
        if (!f.exists()) f.createNewFile();

        // Legge da input.txt e salva ogni riga in una HashMap
        HashMap<Integer, String> map = new HashMap<>();
        RandomAccessFile raf = new RandomAccessFile(f, "rwd");
        String line;
        int index = 0;

        while ((line = raf.readLine()) != null) {
            map.put(index, line);
            index++;
        }

        // Mostra all'utente le righe disponibili
        System.out.println("Contenuto attuale del file:");
        for (int i = 0; i < map.size(); i++) {
            System.out.println(i + ": " + map.get(i));
        }

        // Chiede quale riga modificare
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInserisci il numero della riga da modificare: ");
        int rigaDaModificare = sc.nextInt();
        sc.nextLine(); // consuma newline
        if (!map.containsKey(rigaDaModificare)) {
            System.out.println("Riga non valida.");
            return;
        }

        // Chiede il nuovo contenuto
        System.out.print("Inserisci il nuovo contenuto della riga: ");
        String nuovaRiga = sc.nextLine();

        // Modifica la riga nella mappa
        map.put(rigaDaModificare, nuovaRiga);

        // Scrive il nuovo contenuto nel file
        raf.setLength(0); // svuota il file

        for (int i = 0; i < map.size(); i++) {
            raf.writeBytes(map.get(i) + System.lineSeparator());
        }

        raf.close();
        System.out.println("Modifica completata!");
    }
}
