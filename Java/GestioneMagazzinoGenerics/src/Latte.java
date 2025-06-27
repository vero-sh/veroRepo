public class Latte {
    private String marca;
    private String scadenza;

    public Latte(String marca, String scadenza) {
        this.marca = marca;
        this.scadenza = scadenza;
    }

    public String getMarca() {
        return marca;
    }

    public String getScadenza() {
        return scadenza;
    }

    @Override
    public String toString() {
        return "Latte{" +
                "marca='" + marca + '\'' +
                ", scadenza='" + scadenza + '\'' +
                '}';
    }
}
