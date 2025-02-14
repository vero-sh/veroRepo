package PandoraUnobtanium;

public class Coordinata {
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------ATTRIBUTI---------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    private double latitudine, longitudine;
    private String puntiCardinaliLat, puntiCardinaliLong;

    //------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------METODI----------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    //COSTRUTTORE
    public Coordinata(double latitudine, double longitudine, String puntiCardinaliLat, String puntiCardinaliLong) {
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.puntiCardinaliLat = puntiCardinaliLat;
        this.puntiCardinaliLong = puntiCardinaliLong;
    }

    //GET & SET
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

    //TO STRING
    @Override
    public String toString() {
        return "Coordinate(" +
                latitudine + puntiCardinaliLat +
                ", " + longitudine + puntiCardinaliLong +
                ')';
    }
}
