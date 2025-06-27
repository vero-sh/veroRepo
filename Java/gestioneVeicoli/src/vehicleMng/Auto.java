package vehicleMng;

public class Auto extends Veicolo{
    private int nPorte;

    public Auto(String marca, String modello, int anno, int nPorte) {
        super(marca, modello, anno);
        this.nPorte = nPorte;
    }

    public int getnPorte() {
        return nPorte;
    }

    public void setnPorte(int nPorte) {
        this.nPorte = nPorte;
    }

    @Override
    public String toString() { //invece del metodo descrivi
       String s = "auto: "+super.toString();
        return s +=
                " nPorte= " + nPorte;
    }
}
