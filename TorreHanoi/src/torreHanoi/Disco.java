package torreHanoi;

public class Disco {
    private int dimensione;

    public Disco(int dimensione) {
        this.dimensione = dimensione;
    }

    public int getDimensione() {
        return dimensione;
    }

    @Override
    public String toString() {
        return "Disco{" +
                "dimensione=" + dimensione +
                '}';
    }
}
