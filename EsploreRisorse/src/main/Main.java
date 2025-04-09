package main;
import java.io.File;
import java.util.Scanner;
import esploraRisorse.EsploraRisorse;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il percorso della directory da esplorare: ");
        String percorso = scanner.nextLine();

        EsploraRisorse esploratore = new EsploraRisorse(percorso);

        // Stampa il contenuto della directory iniziale
        System.out.println("Contenuto della directory:");
        esploratore.stampaContenuto();

        // Funzione per navigare nella directory
        while (true) {
            System.out.print("\nScegli un'azione (join, back, createFile, createDir, delete, showInfo, exit): ");
            String azione = scanner.nextLine();

            switch (azione.toLowerCase()) {
                case "join":
                    System.out.print("Inserisci il nome della directory da entrare: ");
                    String nomeDir = scanner.nextLine();
                    if (esploratore.joinDir(nomeDir)) {
                        esploratore.stampaContenuto();
                    } else {
                        System.out.println("La directory non esiste.");
                    }
                    break;

                case "back":
                    if (esploratore.backDir()) {
                        esploratore.stampaContenuto();
                    } else {
                        System.out.println("Sei già nella directory principale.");
                    }
                    break;

                case "createfile":
                    System.out.print("Inserisci il nome del file da creare: ");
                    String nomeFile = scanner.nextLine();
                    File nuovoFile = new File(esploratore.getDirectoryPath(), nomeFile);
                    esploratore.createFile(nuovoFile);
                    break;

                case "createdir":
                    System.out.print("Inserisci il nome della directory da creare: ");
                    String nomeNuovaDir = scanner.nextLine();
                    esploratore.createDir(nomeNuovaDir);
                    break;

                case "delete":
                    System.out.print("Inserisci il nome del file/directory da eliminare: ");
                    String nomeDaEliminare = scanner.nextLine();
                    if (esploratore.deleteFileDir(nomeDaEliminare)) {
                        System.out.println("File/Directory eliminata.");
                    } else {
                        System.out.println("File/Directory non trovata.");
                    }
                    break;

                case "showinfo":
                    System.out.print("Inserisci il nome del file/directory di cui visualizzare le info: ");
                    String nomeInfo = scanner.nextLine();
                    esploratore.showFileInfo(nomeInfo);
                    break;

                case "exit":
                    System.out.println("Uscita dall'esploratore.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Azione non riconosciuta. Riprova.");
            }
        }
    }
}