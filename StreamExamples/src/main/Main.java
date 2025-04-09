package main;

import java.io.*;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("inserisci il path del file da leggere");

        letturaTesto();

    }
    public static void letturaTesto(){
        InputStreamReader isr = new InputStreamReader(System.in);
        int carattere;
        System.out.println("Scrivi una parola: ");

        try {
            while ((carattere = isr.read()) != 10 ){
                System.out.print((char) carattere);
            }
            isr.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void letturaPrimaParola(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int carattere;
        System.out.println("Scrivi una frase: ");
        String riga = "";

        try {
            while ((riga = br.readLine()) != " "){
                System.out.println(riga);
            }
            isr.close();
            br.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
