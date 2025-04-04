package main;

import bomb.Bomb;
import bomb.Stop;
import com.sun.security.jgss.GSSUtil;

public class Main {
    public static void main(String[] args) {

        Bomb[] b1 = new Bomb[3];
        b1[0] = new Bomb("bomba a gas aristotelica");
        b1[1] = new Bomb("bomba a gas nat");
        b1[2] = new Bomb("bomba a gas varisco");

        Stop s1 = new Stop(b1);

        //nome+ vlaore countdown


        for(int i = 0; i< b1.length; i++){
            b1[i].start();
            System.out.println(b1[i].getNome()+" : "+ b1[i].getTime());
        }

        s1.start();

    }
}