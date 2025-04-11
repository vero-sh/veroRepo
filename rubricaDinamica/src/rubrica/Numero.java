package rubrica;
public class Numero {
    private String telefono;
    private String tipo;
    public Numero(String telefono, int tipo){
        this.telefono = telefono;
        inizializzaTipo(tipo);
    }
    private void inizializzaTipo(int index){
        tipo = Type.tipi[index];
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Numero" +
                "telefono='" + telefono +
                ", tipo='" + tipo;
    }
}
