package main;

import wordCounter.WordCounter;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        WordCounter wc = new WordCounter();
        Scanner sc = new Scanner(System.in);
        String text;

        System.out.println("Inserisci la frase su cui iterare il conteggio: ");
        text = sc.nextLine();

        HashMap<String, Integer> risultato = wc.textCount(text);
        Set<String> keys = risultato.keySet();

        System.out.println("\nTABELLA DELLE ITERAZIONI:");

        for (String key : keys) {
            System.out.println(key + ": " + risultato.get(key));
        }
    }
}