package esploraRisorse;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class EsploraRisorse {

    private String directoryPath;
    private File directory;

    public EsploraRisorse(String directorypath){
        this.directoryPath = directorypath;
        directory = new File(directorypath);
    }

    public void stampaContenuto() {
        File[] listFiles = directory.listFiles();

        if (listFiles != null) {
            for (File f : listFiles) {
                System.out.println((f.isDirectory() ? "[DIR]" : "[FILE]") + f.getName());
            }
        } else {
            System.out.println("directory vuota");
        }
    }

    public boolean joinDir(String nome){

        return true;
    }

    public boolean backDir(String nome){

        return true;
    }
    public boolean createFile(File file) {
        try{
            if(file.createNewFile()){
                System.out.println("file creato nel percorso: " +file.getAbsolutePath());
                return true;
            }else  {
                System.out.println("file gia esistente in: "+file.getAbsolutePath());
            }

        }catch (IOException e){
            System.out.println("errore nella creazione del file "+ e.getMessage());
        }
        return true;
    }

    public boolean createDir() {
        if(!directory.exists()){
            if(directory.mkdir()){
                System.out.println("directory creata: "+directoryPath);
                return true;
            } else {
                System.out.println("impossibile creare directory");
                return false;
            }

        }else{
            System.out.println("directory esistente esistente");
            return false;
        }
    }
    public boolean deleteFileDir(){

        return true;
    }
    public void showFileInfo(String nome){

    }


}
