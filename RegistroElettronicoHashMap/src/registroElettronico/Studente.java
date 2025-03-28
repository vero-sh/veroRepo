package registroElettronico;

import java.util.ArrayList;

public class Studente {

    private ArrayList<Voto> listaVoti;
    private String nome;
    private String cognome;
    private String tel;
    private String email;


    public Studente(String nome, String cognome, String tel, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.tel = tel;
        this.email = email;
        listaVoti = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", tel=" + tel +
                ", email='" + email + '\'' +
                '}'+stampaVoti();
    }

    public String stampaVoti(){
        String s = "lista voti: \n";
        for(int i = 0; i<listaVoti.size(); i++){
            s = listaVoti.get(i)+"\n";
        }
        return s;
    }

    public void addVoto(Voto voto){
        listaVoti.add(voto);
    }
    public void removeVoto(Voto voto){
        if(listaVoti.contains(voto)) listaVoti.remove(voto);
    }

}
