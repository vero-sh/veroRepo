package rubrica;

import java.util.ArrayList;

public class Rubrica {
    private ArrayList<Contatto> contatti;

    public Rubrica(){
        contatti = new ArrayList<>(1);
    }
    public boolean aggiungiContatto(Contatto contatto){
        contatti.add(contatto);
        ordina();
        return true;
    }
    private void ordina(){
        Contatto temp;
        for(int i = 0; i<contatti.size() -1; i++){
            if(contatti.get(i).getCognome().compareTo(contatti.get(i+1).getCognome())>0) {
                temp = contatti.get(i);
                contatti.set(i, contatti.get(i+1));
                contatti.set(i+1, temp);
            } else if (contatti.get(i).getCognome().compareTo(contatti.get(i + 1).getCognome()) == 0) {
                if(contatti.get(i).getNome().compareTo(contatti.get(i+1).getNome())>0){
                    temp = contatti.get(i);
                    contatti.set(i, contatti.get(i+1));
                    contatti.set(i+1, temp);
                }
            }

        }
    }
    public Contatto cancellaContatto(Contatto contatto){
        Contatto r;
        if(contatti.contains(contatto)) {
            r = contatti.get(contatti.indexOf(contatto));
            contatti.remove(contatto);
            ordina();
            return r;
        }
        return null;
    }
    public Contatto modificaContatto(Contatto contatto1, Contatto contatto2){
        Contatto t = contatto1;
        if(contatti.contains(contatto1)) {
            contatti.set(contatti.indexOf(contatto1), contatto2);
            ordina();
            return t;

        }
        return null;
    }
    public boolean addNumeroContatto(Contatto contatto, Numero numero){
        Contatto temp;
        if(contatti.contains(contatto)){
            temp = contatti.get(contatti.indexOf(contatto));
            temp.addNumeri(numero);
            contatti.set(contatti.indexOf(contatto), temp);
            return true;
        }
        return false;
    }
    public ArrayList<Contatto> cercaContatto(String ricerca, int tipo) {
        int lengthRicerca;
        ArrayList<Contatto> trovati = new ArrayList<>();
        for (int i = 0; i < contatti.size(); i++) {

            switch (tipo) {
                case 1:
                    lengthRicerca = ricerca.length();
                    if(contatti.get(i).getCognome().length()> lengthRicerca){
                        if(contatti.get(i).getCognome().substring(0, lengthRicerca-1).equals(ricerca))
                            trovati.add(contatti.get(i));
                    } else if(contatti.get(i).getCognome().length() == lengthRicerca){
                        if(contatti.get(i).getCognome().equals(ricerca))
                            trovati.add(contatti.get(i));
                    }
                    break;
                case 2:
                    lengthRicerca = ricerca.length();
                    if(contatti.get(i).getNome().length()> lengthRicerca){
                        if(contatti.get(i).getNome().substring(0, lengthRicerca-1).equals(ricerca))
                            trovati.add(contatti.get(i));
                    } else if(contatti.get(i).getNome().length() == lengthRicerca){
                        if(contatti.get(i).getNome().equals(ricerca))
                            trovati.add(contatti.get(i));
                    }
                    break;
                case 3:
                    for(Numero n : contatti.get(i).getNumeri()) {
                        if (n.getTelefono().equals(ricerca)) {
                            trovati.add(contatti.get(i));
                            break;
                        }
                    }
                    break;
            }

        }
        return trovati;
    }
    public void stampaRubrica(){
        ordina();
        for(int i = 0; i<contatti.size(); i++){
            System.out.println(contatti.get(i).toString());
        }
    }
}
