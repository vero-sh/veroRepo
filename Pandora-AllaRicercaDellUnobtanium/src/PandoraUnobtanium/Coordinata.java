package PandoraUnobtanium;

public class Coordinata {

    private double latitudine, longitudine;
    private String puntiCardinaliLat, puntiCardinaliLong;

    public Coordinata(double latitudine, double longitudine, String puntiCardinaliLat, String puntiCardinaliLong) {
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.puntiCardinaliLat = puntiCardinaliLat;
        this.puntiCardinaliLong = puntiCardinaliLong;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    public String getPuntiCardinaliLat() {
        return puntiCardinaliLat;
    }

    public void setPuntiCardinaliLat(String puntiCardinaliLat) {
        this.puntiCardinaliLat = puntiCardinaliLat;
    }

    public String getPuntiCardinaliLong() {
        return puntiCardinaliLong;
    }

    public void setPuntiCardinaliLong(String puntiCardinaliLong) {
        this.puntiCardinaliLong = puntiCardinaliLong;
    }

    @Override
    public String toString() {
        return "Coordinate(" +
                latitudine + puntiCardinaliLat + ","+
                longitudine + puntiCardinaliLong + ")";
    }
}
