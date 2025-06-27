package StructureQueue;

import priorityMng.Paziente;

public class codaAereo <T> extends structureQueue <T> {

    private structureQueue<T> nome = new structureQueue<>();
    public codaAereo(){

    }
    public void stampa(){
        for(int i = 0; i<nome.size(); i++){
            System.out.println(nome.get(i));
        }
    }

}
