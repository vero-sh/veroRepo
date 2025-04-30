package main;

import rubrica.FileEditor;
import rubrica.Rubrica;


import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Rubrica r = new Rubrica();
        System.out.println(r.getSavingDir());
        System.out.println(r.getAutoInc());


        System.out.println(FileEditor.read(r.getResourcesPath()));
    }
}