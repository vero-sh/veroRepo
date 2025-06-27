package starship;

public class Starship {

    //attributi
    private String nome;
    private String tipo;
    private int baseSpeed;
    private int actualSpeed;

    //costruttore


    public Starship(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        baseSpeed = 1000;
        actualSpeed = baseSpeed;
    }

    public void boostSpeed(int boost){
        actualSpeed += boost;
    }

    @Override
    public String toString() {
        return "Starship{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", velocita base=" + baseSpeed +
                ", velocita attuale=" + actualSpeed +
                '}';
    }

    public void decreaseSpeed(){
        actualSpeed /= 2;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public void setActualSpeed(int actualSpeed) {
        this.actualSpeed = actualSpeed;
    }

    public int getActualSpeed() {
        return actualSpeed;
    }
}
