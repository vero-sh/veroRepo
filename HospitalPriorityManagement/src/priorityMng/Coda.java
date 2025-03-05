package priorityMng;
import StructureQueue.structureQueue;

public class Coda <T> extends structureQueue <T> {
    private String nome;

    public Coda(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String r="Coda per pazienti : "+ nome + "Pazienti: \n";
        //for(int i = 0; i < super)
        return r;
    }
}
