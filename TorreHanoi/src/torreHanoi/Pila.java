package torreHanoi;

import java.util.ArrayList;

public class Pila<T> {
    private ArrayList<T> pila;

    public Pila(){
        pila = new ArrayList<T>();
    }

    public void push(T elemento){
        pila.add(elemento);
    }

    public T pop(){
        if(!pila.isEmpty()) return pila.remove((pila.size()-1));
        return null;
    }
    public T top(){
        if(!pila.isEmpty()) return pila.get(pila.size()-1);
        return null;
    }
    public boolean isEmpty(){
        if(pila.isEmpty()) return true;
        return false;
    }
    public int size(){
        return pila.size();
    }

    @Override
    public String toString() {
        return "torreHanoi.Pila{"+ pila +
                '}';
    }

}
