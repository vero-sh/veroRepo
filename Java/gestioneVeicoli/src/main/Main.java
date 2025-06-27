package main;

import vehicleMng.Auto;
import vehicleMng.Moto;
import vehicleMng.Rivendita;

public class Main {
    public static void main(String[] args) {

        Rivendita r = new Rivendita("Rivendita1");
        Auto a = new Auto("audi", "a1", 2005, 4);
        Moto m = new Moto("kawasaki", "ninja", 2010, true);


        r.addVeicolo(a);
        r.addVeicolo(m);

        System.out.println(r.read());
        System.out.println(r.readIndex(1));
    }
}