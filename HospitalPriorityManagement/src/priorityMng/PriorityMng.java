package priorityMng;

public class PriorityMng {
    private Coda <Paziente>[] code;

    public PriorityMng() {
        code = new Coda[] {
                new Coda<Paziente>("Basso"),
                new Coda<Paziente>("Moderato"),
                new Coda<Paziente>("Critico")
        };
    }

    public void addPaziente(Paziente p){
        switch (p.getPriorityLvl()){
            case 1 -> code[0].push(p);
            case 2 -> code[1].push(p);
            case 3 -> code[2].push(p);
        }
    }
    public void removePaziente(Paziente p){
        switch (p.getPriorityLvl()){
            case 1 -> code[0].pop();
            case 2 -> code[1].pop();
            case 3 -> code[2].pop();
        }
    }

    public String stampaCode(){
        String s = "";
        for(int i = 0; i<code.length; i++){
            s+= code[i]+ " ";
        }
        return s;
    }

}
