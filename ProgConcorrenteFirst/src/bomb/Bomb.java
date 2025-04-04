package bomb;
import java.util.Random;

public class Bomb extends Thread {

    private int time;
    private String nome;

    public Bomb(String nome) {
        this.nome = nome; //equivalente a super(name)
        this.time = randomTime();
    }
    public int randomTime(){

        return (int) (Math.random() * 10) +1;
    }

    @Override
    public void run() {
        for(int i = time; i > 0; i--){
            if(!Thread.currentThread().isInterrupted())System.out.println(i+" secondi");
            try{
                sleep(1000);
            }catch (InterruptedException e){
                System.out.println(getName() + " interrotto");
                return;
            }
        }
        System.out.println("boom!");

    }

    public int getTime() {
        return time;
    }

    public String getNome() {
        return nome;
    }
}
