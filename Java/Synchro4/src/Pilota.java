public class Pilota extends Thread {
    private String nome;
    private Spogliatoio spogliatoio;
    private Pista pista;

    public Pilota(String nome, Spogliatoio spogliatoio, Pista pista) {
        this.nome = nome;
        this.spogliatoio = spogliatoio;
        this.pista = pista;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void run() {
        try {
            spogliatoio.entra(this);
            pista.entra(this);
            pista.effettuaGiri(this);
            pista.esci(this);
            spogliatoio.entra(this);
            int tempoCambio = (int) (Math.random() * 800) + 400;
            Thread.sleep(tempoCambio);
            System.out.println(nome + " si è cambiato in " + tempoCambio + " ms.");
            spogliatoio.esci(this);

            System.out.println(nome + " ha completato tutta la gara!");

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("ciao");
    }
}
