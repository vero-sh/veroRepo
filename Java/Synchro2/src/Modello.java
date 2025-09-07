public class Modello extends Thread {
    private String nome;
    private Camerino camerino;
    private Passerella passerella;

    public Modello(String nome, Camerino camerino, Passerella passerella) {
        this.nome = nome;
        this.camerino = camerino;
        this.passerella = passerella;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void run() {
        try {
            camerino.entra(this);
            passerella.entra(this);
            passerella.esci(this);
            camerino.esci(this);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
