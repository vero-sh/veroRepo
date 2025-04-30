package rubrica;

import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Scanner;

public class Rubrica {

    private HashMap<Integer, Contatto> contatti;
    private int autoInc;
    private String SavingDir;
    private File resourcesPath;
    private Scanner sc;



    public Rubrica () {
        contatti = new HashMap<Integer, Contatto>();
        sc = new Scanner(System.in);
        inizializer();
    }

    private void inizializer() {
        String setupRes;
        String[] setup;

       resourcesPath = new File("src/resources/setup.txt");

        setupRes = FileEditor.read(resourcesPath);

        if (setupRes != null && !setupRes.isEmpty()) {
            setup = setupRes.split("\n");

            if (setup.length >= 2) {
                SavingDir = setup[0].substring(12).trim();
                autoInc = 0;
                try {
                    autoInc = Integer.parseInt(setup[1].substring(14).trim());
                } catch (NumberFormatException e) {

                    System.out.println("Nessun valore di autoInc trovato, impostato a 0");
                }
            } else {
                firstUse();
            }
        } else {
            firstUse();
        }
    }


    private void firstUse () {
        autoInc = 0;


        do {
            System.out.print("Inserisci il percorso assoluto della cartella dove salvare i tuoi contatti: ");
            SavingDir = sc.next();
        } while (!(new File(SavingDir).exists()) && new File(SavingDir).isFile());


        String contenuto = "Saving dir: " + SavingDir + "\nAutInc value: " + autoInc;
        FileEditor.write(resourcesPath ,contenuto);
    }


    public HashMap<Integer, Contatto> getContatti() {
        return contatti;
    }

    public void setContatti(HashMap<Integer, Contatto> contatti) {
        this.contatti = contatti;
    }

    public int getAutoInc() {
        return autoInc;
    }

    public void setAutoInc(int autoInc) {
        this.autoInc = autoInc;
    }

    public String getSavingDir() {
        return SavingDir;
    }

    public void setSavingDir(String savingDir) {
        SavingDir = savingDir;
    }

    public File getResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(File resourcesPath) {
        this.resourcesPath = resourcesPath;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
}
