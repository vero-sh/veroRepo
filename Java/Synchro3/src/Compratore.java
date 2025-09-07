import java.util.Random;

public class Compratore extends Thread {
    private String nome;
    private Botteghino botteghino;
    private Random random;

    public Compratore(String nome, Botteghino botteghino) {
        this.nome = nome;
        this.botteghino = botteghino;
        this.random = new Random();
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void run() {
        try {
            int tempoArrivo = random.nextInt(5000);
            Thread.sleep(tempoArrivo);

            System.out.println(nome + " arriva al botteghino.");

            botteghino.acquistaBiglietto(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}