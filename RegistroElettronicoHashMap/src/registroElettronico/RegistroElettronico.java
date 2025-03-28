package registroElettronico;

import java.util.HashMap;
import java.util.Map;

public class RegistroElettronico {
    private HashMap<String, Studente> registro;

    public RegistroElettronico() {
        registro = new HashMap<>();
    }

    public void addStudente(String matricola, Studente studente){
        if(registro.containsKey(matricola)) registro.put(matricola, studente);
    }
    public void addVoto(String matricola, Voto voto){
        if(registro.containsKey(matricola)) registro.get(matricola).addVoto(voto);
    }
    public void removeVoto(String matricola, Voto voto){
        if(registro.containsKey(matricola)) registro.get(matricola).removeVoto(voto);
    }
    public void removeStudente(String matricola){
        if(registro.containsKey(matricola)) registro.remove(matricola);
    }
    public boolean cercaStudente(String matricola){
        if(registro.containsKey(matricola)) return true;
        return false;
    }
    public void stampaRegistro() {
        for (Map.Entry<String, Studente> entry : registro.entrySet()) {
            System.out.println("Chiave: " + entry.getKey() + ", Valore: " + entry.getValue());
        }
    }
}
