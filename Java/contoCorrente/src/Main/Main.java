package Main;
import CCmanagement.CCmanagement;
import CCmanagement.SaldoInsufficienteException;
import CCmanagement.CifraNegativaException;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    static CCmanagement CC;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Creazione conto corrente...");
        String n = "";
        boolean stato = true;
        while(stato) {
            try {
                System.out.println("Nome del titolare del contocorrente");
                n = scanner.next();
                CC = new CCmanagement(n);
                int scelta;
                stato = false;
            } catch (InputMismatchException e) {
                System.out.println("input non valido");
                stato = true;
            }
        }
        stato = true;
        int scelta = 0;
        while (stato) {
                System.out.println("conto corrente di " + n + ": ");
                try {
                    System.out.println("1. Preleva\n2. Deposita\n3. Visulizza stato del conto\n4. Esci...");
                    scelta = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("input non valido");
                }
                switch (scelta) {
                    case 1:
                        try {
                            System.out.println("Inserisci cifra da prelevare: ");
                            CC.preleva(scanner.nextDouble());
                            scanner.nextLine();
                        } catch (CifraNegativaException | SaldoInsufficienteException e) {
                            scanner.nextLine();
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("input non valido");
                        }
                        break;
                    case 2:
                        try {
                            System.out.println("inserisci cifra da depositare");
                            CC.deposita(scanner.nextDouble());
                            scanner.nextLine();
                        } catch (CifraNegativaException e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Input non valido");
                        }
                        break;
                    case 3:
                        System.out.println(CC);
                        break;
                    case 4:
                        System.out.println("Esco...");
                        stato = false;
                }
            }

    }
}