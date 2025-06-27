package rubrica;

import java.util.ArrayList;

public class Contatto {
    private String nome, cognome, email, indirizzo, nota;
    private ArrayList<Numero> numeri;


    public Contatto (String nome, String cognome, Numero numero, String email, String indirizzo, String nota){
        numeri = new ArrayList<>(1);
        this.nome = nome;
        this.cognome = cognome;
        numeri.add(numero);
        this.email = email;
        this.indirizzo = indirizzo;
        this.nota = nota;
    }
    public void addNumeri(Numero numero){
        numeri.add(numero);
    }
    public Numero deleteNumero(Numero numero){
        if(numeri.contains(numero)&& numeri.size()>1){
            Numero r = numeri.get(numeri.indexOf(numero));
            numeri.remove(numero);
            return r;
        }
        return null;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public ArrayList<Numero> getNumeri() {
        return numeri;
    }

    public void setNumeri(ArrayList<Numero> numeri) {
        this.numeri = numeri;
    }

    @Override
    public String toString() {
        return "Contatto{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", nota='" + nota + '\'' +
                ", numeri=" + numeri +
                '}';
    }
}
