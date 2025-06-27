package StructureQueue;

import java.util.ArrayList;

public class structureQueue <T>{
    private ArrayList<T> coda;

    public structureQueue() {
        coda = new ArrayList<>();
    }

    public T pop(){
        if(!coda.isEmpty()) return coda.remove(0);
        return null;
    }
    public void push(T element){
        coda.add(element);
    }
    public T top(){
        if(!coda.isEmpty()) return coda.get(0);
        return null;
    }
    public boolean isEmpty(){
        return coda.isEmpty();
    }
    public int size(){
        return coda.size();
    }
    public ArrayList<T> getElements() {
        return coda;
    }
}
