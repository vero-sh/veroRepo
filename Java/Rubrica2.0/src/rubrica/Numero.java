package rubrica;

public class Numero {


    private String numero, tipo;


    public Numero (String numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo + ": " + numero;
    }

}
