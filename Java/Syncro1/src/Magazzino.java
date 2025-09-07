import java.util.ArrayList;

public class Magazzino {
    private int capacita;
    private int sogliaIspettore;
    private ArrayList<Integer> contenuto;
    private boolean ispettoreInAccesso = false;

    public Magazzino(int capacita, int sogliaIspettore) {
        this.capacita = capacita;
        this.sogliaIspettore = sogliaIspettore;
        this.contenuto = new ArrayList<>();
    }

    public synchronized void metti(int numero) throws InterruptedException {

        while (contenuto.size() >= capacita || ispettoreInAccesso) {
            wait();
        }

        contenuto.add(numero);
        System.out.println(Thread.currentThread().getName() + " ha messo: " + numero + " (Size: " + contenuto.size() + ")");
        notifyAll();
    }

    public synchronized int prendi() throws InterruptedException {

        while (contenuto.isEmpty() || ispettoreInAccesso) {
            wait();
        }

        int numero = contenuto.remove(contenuto.size() - 1);
        System.out.println(Thread.currentThread().getName() + " ha preso: " + numero + " (Size: " + contenuto.size() + ")");
        notifyAll();
        return numero;
    }

    public synchronized void ispeziona() throws InterruptedException {

        ispettoreInAccesso = true;


        int somma = 0;
        for (int num : contenuto) {
            somma += num;
        }

        System.out.println("Ispettore: somma attuale = " + somma);

        if (somma >= sogliaIspettore) {
            System.out.println("Ispettore: SOMMA SUPERATA! Reset magazzino.");
            contenuto.clear();
        } else {
            if (!contenuto.isEmpty()) {
                contenuto.set(0, somma);
                System.out.println("Ispettore: impostato primo slot a " + somma);
            }
        }


        ispettoreInAccesso = false;
        notifyAll();
    }

    public synchronized int getSize() {
        return contenuto.size();
    }
}
