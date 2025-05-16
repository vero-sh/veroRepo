
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Nome del file da cui copiare le info: ");
            String source = sc.nextLine();

            System.out.print("Nome del file su cui scrivere: ");
            String destination = sc.nextLine();

            File destFile = new File(destination);
            if (!destFile.exists()) {
                destFile.createNewFile();
                System.out.println("File di destinazione creato.");
            }


            try (
                    BufferedReader br = new BufferedReader(new FileReader(source));
                    BufferedWriter bw = new BufferedWriter(new FileWriter(destFile))
            ) {
                String line;
                while ((line = br.readLine()) != null) {
                    bw.append(line);
                    bw.newLine();
                }
                System.out.println("Copia completata con successo.");
            }

        } catch (IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        sc.close();
    }
}
