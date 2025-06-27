package main;

import java.io.*;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("inserisci il path del file da leggere");

        letturaPrimaParola();

    }

    public static void letturaTesto() {
        InputStreamReader isr = new InputStreamReader(System.in);
        int carattere;
        System.out.println("Scrivi una parola: ");

        try {
            while ((carattere = isr.read()) != 10) {
                System.out.print((char) carattere);
            }
            isr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void letturaPrimaParola() {
        InputStreamReader isr = new InputStreamReader(System.in);
        System.out.println("Inserisci una riga di testo:");
        int input;
        try {
            while ((input = isr.read()) != -1) {
                System.out.print((char) input);
                char c = (char) input;

                if (c == ' ') {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
