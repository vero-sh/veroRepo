public class ListaConcatenata {
    private Nodo testa;

    public ListaConcatenata(Nodo testa){
        this.testa = testa;
    }
    public ListaConcatenata(){
        testa = null;
    }
    public void addNodo(Nodo newNodo){
        Nodo temp;
        if(testa == null){
            testa = newNodo;
        }
        else {
            temp = testa;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNodo);
        }
    }
    @Override
    public String toString(){
        String s = "Lista: ";
        Nodo temp = testa;

        while(temp != null){
            s += " --> "+temp;
            temp = temp.getNext();
        }
        return s;
    }
}
