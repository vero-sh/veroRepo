package vehicleMng;

import java.util.ArrayList;
public class Rivendita {

    private String nome;
    private ArrayList<Veicolo> veicoli;

    public Rivendita(String nome) {
        veicoli = new ArrayList<>(1);
        this.nome = nome;
    }

    public void addVeicolo(Veicolo v) {
       veicoli.add(v);
    }

    public String read(){
        String s = "";
        for(int i = 0; i< veicoli.size(); i++){
            s+=veicoli.get(i)+"\n";
        }
        return s;
    }

    public String readIndex(int index){
        return veicoli.get(index).toString();
    }


}

