package main;

import rubrica.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Rubrica r = new Rubrica();

        boolean stato = true;
        Contatto c1 = new Contatto("marco", "biffi", new Numero("3515429482", 2), "", "", "");
        r.aggiungiContatto(c1);
        r.stampaRubrica();

       // while(stato){
         //   System.out.println(" 1. Crea contatto\n 2. Cerca contatto\n 3. Elimina contatto 4. Modifica contatto");

       // }

    }
}