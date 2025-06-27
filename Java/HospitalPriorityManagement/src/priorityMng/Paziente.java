package priorityMng;

public class Paziente {
    private String nome;
    private String cognome;
    private int priorityLvl;
    private String priorityColor;

    public Paziente(String nome, String cognome, int priorityLvl) {
        this.nome = nome;
        this.cognome = cognome;
        this.priorityLvl = priorityLvl;
        setPriorityColor();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getPriorityLvl() {
        return priorityLvl;
    }

    public void setPriorityLvl(int priorityLvl) {
        this.priorityLvl = priorityLvl;
        setPriorityColor();
    }
    private void setPriorityColor(){
        switch (priorityLvl){
            case 1 -> priorityColor = "verde";
            case 2 -> priorityColor = "giallo";
            case 3 -> priorityColor = "rosso";
        }
    }

    @Override
    public String toString() {
        return "Paziente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", priorityColor='" + priorityColor + '\'' +
                '}';
    }
}
