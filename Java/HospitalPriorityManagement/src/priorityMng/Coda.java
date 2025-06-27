package priorityMng;
import StructureQueue.structureQueue;
import java.util.ArrayList;

import java.util.ArrayList;

public class Coda <T> extends structureQueue <T> {
    private String nome;

    public Coda(String nome) {
        super();
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
        String r="Coda per pazienti : "+"livello di criticita': "+ nome + "\n";
        for(T Paziente : super.getElements()) {
            r += Paziente.toString() + "\n";
        }
        return r;
    }
}
