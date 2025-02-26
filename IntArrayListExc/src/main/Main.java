package main;
import java.util.ArrayList;
import calcolatrice.CalcolatriceConcreta;
import calcolatrice.Calcolatrice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calcolatrice calc = new CalcolatriceConcreta();
        ArrayList<String> logOperazioni = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean stato = true;
        int scelta = 0;
        boolean stato3 = false;
        while (stato) {
            do {
            stato3 = false;
            System.out.println("\nScegli l'operazione:");
            System.out.println("1) Addizione");
            System.out.println("2) Sottrazione");
            System.out.println("3) Moltiplicazione");
            System.out.println("4) Divisione");
            System.out.println("5) Esci");
            System.out.println("Inserisci scelta: ");

                try {
                    scelta = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("input non valido");
                    stato3 = true;
                }
                sc.nextLine();
            } while (stato3) ;

            if (scelta == 5) {
                stato = false;
                break;
            }
                boolean stato2 = false;
                double num1 = 0;
                double num2 = 0;
                do {
                    stato2 = false;
                    try {
                        System.out.println("Inserisci il primo numero: ");
                        num1 = sc.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("input non valido");
                        stato2 = true;
                    }
                    try {
                        System.out.println("Inserisci il secondo numero: ");
                        num2 = sc.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("input non valido");
                        stato2 = true;
                    }
                    sc.nextLine();
                } while (stato2);

                try {
                    double risultato = 0;
                    String operazione = "";
                    switch (scelta) {
                        case 1:
                            risultato = calc.add(num1, num2);
                            operazione = num1 + " + " + num2 + " = " + risultato;
                            break;
                        case 2:
                            risultato = calc.subtract(num1, num2);
                            operazione = num1 + " - " + num2 + " = " + risultato;
                            break;
                        case 3:
                            risultato = calc.multiply(num1, num2);
                            operazione = num1 + " * " + num2 + " = " + risultato;
                            break;
                        case 4:
                            risultato = calc.divide(num1, num2);
                            operazione = num1 + " / " + num2 + " = " + risultato;
                            break;
                        case 5:
                            stato = false;
                            break;
                        default:
                            operazione = "Operazione non valida";
                            break;
                    }
                    System.out.println("Risultato: " + operazione);
                    logOperazioni.add(operazione);
                } catch (ArithmeticException e) {
                    String errore = "Errore: " + e.getMessage();
                    System.out.println(errore);
                    logOperazioni.add(errore);
                }
            }

            System.out.println("\n--- Log delle operazioni ---");
            for (String s : logOperazioni) {
                System.out.println(s);
            }
        }
    }