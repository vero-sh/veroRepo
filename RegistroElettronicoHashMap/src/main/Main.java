package main;

import registroElettronico.RegistroElettronico;
import registroElettronico.Studente;
import registroElettronico.Voto;

public class Main {
    public static void main(String[] args) {

        RegistroElettronico registroElettronico = new RegistroElettronico();

        registroElettronico.addStudente("a", new Studente("Marco", "biffi", "320365480" , "marcobiffi@gmail.com"));
        registroElettronico.addStudente("ab", new Studente("Giulia", "Rossi", "327654321", "giuliarossi@example.com"));
        registroElettronico.addStudente("abc", new Studente("Luca", "Verdi", "335987654", "lucaverdi@example.com"));
        registroElettronico.addStudente("abcd", new Studente("Sara", "Gialli", "324578910", "saragialli@example.com"));
        registroElettronico.addStudente("abcde", new Studente("Anna", "Neri", "321654987", "annaneri@example.com"));

        registroElettronico.addVoto("abc", new Voto(5, "11/03/25", "Orale"));
        registroElettronico.addVoto("ab", new Voto(3, "15/03/25", "Scritto"));
        registroElettronico.addVoto("abcd", new Voto(7, "20/03/25", "Progetto"));
        registroElettronico.addVoto("abcde", new Voto(6.25, "25/03/25", "Interrogazione"));
        registroElettronico.addVoto("a", new Voto(4.75, "30/03/25", "Esame Finale"));


    }
}