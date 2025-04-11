import java.util.List;
import java.util.ArrayList;
public class Rubrica {

    List<Contatto> contatti;

    public Rubrica() {
        contatti = new ArrayList<>();
    }
    public boolean aggiungiContatto(Contatto contatto){
        contatti.add(contatto);
        ordina();
        return true;
    }
    private void ordina(){
        Contatto temp;
        for(int i = 0; i<contatti.size(); i++){
            if(contatti.get(i).getNome().compareTo(contatti.get(i+1).getNome())>0) {
                temp = contatti.get(i);
                contatti.set(i, contatti.get(i+1));
                contatti.set(i+1, temp);
            } else if (contatti.get(i).getNome().compareTo(contatti.get(i + 1).getNome()) == 0) {
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

}
