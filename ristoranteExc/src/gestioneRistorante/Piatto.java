package gestioneRistorante;

public class Piatto {
    private String nome;
    private int ingredienti;
    private long tempoPrep;

    public Piatto(String nome, int ingredienti, long tempoPrep) {
        this.nome = nome;
        this.ingredienti = ingredienti;
        this.tempoPrep = tempoPrep;
    }

    public String getNome() {
        return nome;
    }

    public int getIngredienti() {
        return ingredienti;
    }

    public long getTempoPrep() {
        return tempoPrep;
    }

    @Override
    public String toString() {
        return "Piatto{" +
                "nome='" + nome + '\'' +
                ", ingredienti=" + ingredienti +
                ", tempoPrep=" + tempoPrep +
                '}';
    }
}
