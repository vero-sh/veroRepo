public class Moneta {
    private int valore;

    public Moneta(int valore) {
        this.valore = valore;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    @Override
    public String toString() {
        return "Moneta{" +
                "valore=" + valore +
                '}';
    }
}
