package management;

class SalaAttesa {
    private int cani = 0;
    private int gatti = 0;

    public synchronized void entraGatto(int id) throws InterruptedException {
        while (cani > 0 || gatti > 0) {
            System.out.println("Animali.Gatto #" + id + " aspetta (cani: " + cani + ", gatti: " + gatti + ")");
            wait();
        }
        gatti++;
        System.out.println("Animali.Gatto #" + id + " entra. Gatti in sala: " + gatti);
    }

    public synchronized void esceGatto(int id) {
        gatti--;
        System.out.println("Animali.Gatto #" + id + " esce. Gatti rimasti: " + gatti);
        notifyAll();
    }

    public synchronized void entraCane(int id) throws InterruptedException {
        while (gatti > 0 || cani >= 4) {
            System.out.println("Animali.Cane #" + id + " aspetta (cani: " + cani + ", gatti: " + gatti + ")");
            wait();
        }
        cani++;
        System.out.println("Animali.Cane #" + id + " entra. Cani in sala: " + cani);
    }

    public synchronized void esceCane(int id) {
        cani--;
        System.out.println("Animali.Cane #" + id + " esce. Cani rimasti: " + cani);
        notifyAll();
    }
}
