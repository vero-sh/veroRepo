package registroElettronico;

public class Voto {
    private double voto;
    private String data;
    private String tipo;

    public Voto(double voto, String data, String tipo) {
        this.voto = voto;
        this.data = data;
        this.tipo = tipo;
    }

    public double getVoto() {
        return voto;
    }

    public void setVoto(double voto) {
        this.voto = voto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "voto: "+voto+ ", data: "+data+ ", tipo ( pratico / scritto / orale ): ";
    }
}
