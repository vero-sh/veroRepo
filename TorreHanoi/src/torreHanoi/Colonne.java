package torreHanoi;
import java.util.ArrayList;
public class Colonne extends Torre{
    private Torre<Disco> t1;
    private Torre<Disco> t2;
    private Torre<Disco> t3;
    private int dimensioneTorre;

    public Colonne(int dimensioneTorre){
        this.dimensioneTorre = dimensioneTorre;
        inizializzaDischi();
    }
    private void inizializzaDischi(){

    }
    public void stampaTorri(){

    }
}
