package vehicleMng;

public class Moto extends Veicolo{
    private boolean haSideCar;

    public Moto(String marca, String modello, int anno, boolean haSideCar) {
        super(marca, modello, anno);
        this.haSideCar = haSideCar;
    }

    public boolean getHaSideCar() {
        return haSideCar;
    }

    public void setHaSideCar(boolean haSideCar) {
        this.haSideCar = haSideCar;
    }

    @Override
    public String toString() { //invece del metodo descrivi
        String s = "moto: "+super.toString();
        return s +=
                " haSideCar= " + haSideCar;
    }
}
