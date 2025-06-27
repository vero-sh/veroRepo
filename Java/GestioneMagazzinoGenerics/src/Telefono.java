public class Telefono {
    private String marca;
    private String modello;

    public Telefono(String marca, String modello) {
        this.marca = marca;
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                '}';
    }
}
