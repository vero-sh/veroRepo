package main;
import rubrica.*;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Rubrica rubrica = new Rubrica();

    public static void main(String[] args) {
        int scelta = -1;
        while (scelta != 0) {
            stampaMenuPrincipale();
            scelta = scanner.nextInt();
            scanner.nextLine();  // Consuma il newline lasciato da nextInt()

            switch (scelta) {
                case 1:
                    aggiungiContatto();
                    break;
                case 2:
                    cancellaContatto();
                    break;
                case 3:
                    modificaContatto();
                    break;
                case 4:
                    aggiungiNumeroContatto();
                    break;
                case 5:
                    cercaContatto();
                    break;
                case 6:
                    rubrica.stampaRubrica();
                    break;
                case 0:
                    System.out.println("\nUscita... Grazie per aver usato la rubrica!");
                    break;
                default:
                    System.out.println("\nOpzione non valida. Riprova.");
            }
        }
    }

    private static void stampaMenuPrincipale() {
        System.out.println("\n*****************************************");
        System.out.println("*              Menu Rubrica            *");
        System.out.println("*****************************************");
        System.out.println("* 1. Aggiungi un nuovo contatto        *");
        System.out.println("* 2. Cancella un contatto             *");
        System.out.println("* 3. Modifica un contatto             *");
        System.out.println("* 4. Aggiungi un numero a un contatto *");
        System.out.println("* 5. Cerca un contatto                *");
        System.out.println("* 6. Stampa la rubrica                *");
        System.out.println("* 0. Esci                             *");
        System.out.println("*****************************************");
        System.out.print("Scegli un'opzione: ");
    }

    private static void aggiungiContatto() {
        System.out.println("\n*** Aggiungi un nuovo contatto ***");

        System.out.print("Inserisci il nome: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci il cognome: ");
        String cognome = scanner.nextLine();

        System.out.print("Inserisci il numero di telefono (es. 1234567890): ");
        String telefono = scanner.nextLine();

        System.out.print("Inserisci il tipo del numero (1: Principale, 2: Abitazione, 3: Lavoro): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Consuma il newline

        Numero numero = new Numero(telefono, tipo - 1); // Indici dei tipi partono da 0

        System.out.print("Inserisci l'email: ");
        String email = scanner.nextLine();

        System.out.print("Inserisci l'indirizzo: ");
        String indirizzo = scanner.nextLine();

        System.out.print("Inserisci una nota: ");
        String nota = scanner.nextLine();

        Contatto contatto = new Contatto(nome, cognome, numero, email, indirizzo, nota);
        rubrica.aggiungiContatto(contatto);

        System.out.println("\nContatto aggiunto con successo!");
    }

    private static void cancellaContatto() {
        System.out.println("\n*** Cancella un contatto ***");
        System.out.print("Inserisci il nome del contatto da cancellare: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci il cognome del contatto da cancellare: ");
        String cognome = scanner.nextLine();

        Contatto contatto = new Contatto(nome, cognome, null, "", "", "");
        if (rubrica.cancellaContatto(contatto) != null) {
            System.out.println("\nContatto cancellato con successo!");
        } else {
            System.out.println("\nContatto non trovato.");
        }
    }

    private static void modificaContatto() {
        System.out.println("\n*** Modifica un contatto ***");
        System.out.print("Inserisci il nome del contatto da modificare: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci il cognome del contatto da modificare: ");
        String cognome = scanner.nextLine();

        Contatto contattoEsistente = new Contatto(nome, cognome, null, "", "", "");
        Contatto contattoModificato = new Contatto(nome, cognome, null, "", "", "");

        if (rubrica.modificaContatto(contattoEsistente, contattoModificato) != null) {
            System.out.println("\nContatto modificato con successo!");
        } else {
            System.out.println("\nContatto non trovato.");
        }
    }

    private static void aggiungiNumeroContatto() {
        System.out.println("\n*** Aggiungi un numero a un contatto ***");
        System.out.print("Inserisci il nome del contatto: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci il cognome del contatto: ");
        String cognome = scanner.nextLine();

        Contatto contatto = new Contatto(nome, cognome, null, "", "", "");

        if (rubrica.cercaContatto(nome, 2).contains(contatto)) {
            System.out.print("Inserisci il nuovo numero di telefono: ");
            String telefono = scanner.nextLine();

            System.out.print("Inserisci il tipo del numero (1: Principale, 2: Abitazione, 3: Lavoro): ");
            int tipo = scanner.nextInt();
            scanner.nextLine();  // Consuma il newline

            Numero numero = new Numero(telefono, tipo - 1);
            rubrica.addNumeroContatto(contatto, numero);
            System.out.println("\nNumero aggiunto con successo!");
        } else {
            System.out.println("\nContatto non trovato.");
        }
    }

    private static void cercaContatto() {
        System.out.println("\n*** Cerca un contatto ***");
        System.out.print("Inserisci il nome del contatto da cercare: ");
        String nome = scanner.nextLine();

        System.out.println("Scegli il tipo di ricerca:");
        System.out.println("1. Cognome");
        System.out.println("2. Nome");
        System.out.println("3. Numero di telefono");
        System.out.print("Scegli un'opzione: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Consuma il newline

        var risultati = rubrica.cercaContatto(nome, tipo);
        if (risultati.isEmpty()) {
            System.out.println("\nNessun contatto trovato.");
        } else {
            System.out.println("\nContatti trovati:");
            for (Contatto contatto : risultati) {
                System.out.println(contatto);
            }
        }
    }
}