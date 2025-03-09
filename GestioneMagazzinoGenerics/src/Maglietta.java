public class Maglietta {
    private String marca;
    private String taglia;

    public Maglietta(String marca, String taglia) {
        this.marca = marca;
        this.taglia = taglia;
    }

    public String getMarca() {
        return marca;
    }

    public String getTaglia() {
        return taglia;
    }

    @Override
    public String toString() {
        return "Maglietta{" +
                "marca='" + marca + '\'' +
                ", taglia='" + taglia + '\'' +
                '}';
    }
}
