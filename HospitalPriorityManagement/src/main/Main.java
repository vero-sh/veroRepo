package main;
import priorityMng.PriorityMng;
import priorityMng.Paziente;

public class Main {
    public static void main(String[] args) {

        PriorityMng prontosoccorso = new PriorityMng();

        Paziente p1 = new Paziente("marco", "biffi", 2);
        Paziente p2 = new Paziente("luca", "crippa", 3);
        Paziente p3 = new Paziente("asdad", "gchaaw", 1);
        Paziente p4 = new Paziente("chaa", "kjkfs", 3);
        Paziente p5 = new Paziente("sca", "gg", 1);
        Paziente p6 = new Paziente("marco", "biffi", 2);

        prontosoccorso.addPaziente(p1);
        prontosoccorso.addPaziente(p2);
        prontosoccorso.addPaziente(p3);
        prontosoccorso.addPaziente(p4);
        prontosoccorso.addPaziente(p5);
        prontosoccorso.addPaziente(p6);

        System.out.println(prontosoccorso.stampaCode());

        prontosoccorso.removePaziente(p3);
        prontosoccorso.removePaziente(p5);
        prontosoccorso.removePaziente(p2);
        System.out.println(prontosoccorso.stampaCode());
    }
}