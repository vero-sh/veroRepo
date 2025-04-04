package esploraRisorse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class EsploraRisorse {

    private String directoryPath;
    private File directory;

    public EsploraRisorse(String directorypath) {
        this.directoryPath = directorypath;
        directory = new File(directorypath);
    }

    public void stampaContenuto() {
        File[] listFiles = directory.listFiles();

        if (listFiles != null) {
            for (File f : listFiles) {
                System.out.println((f.isDirectory() ? "[DIR] " : "[FILE] ") + f.getName());
            }
        } else {
            System.out.println("directory is empty");
        }
    }

    public boolean joinDir(String nome) {
        directory = new File(directoryPath + '\\' + nome);
        if (directory.exists()) {
            directoryPath = directory.getAbsolutePath();
            return true;
        }
        directory = new File(directoryPath);
        return false;
    }

    public boolean backDir() {
        if (directory.getParent() != null) {
            directoryPath = directory.getParent();
            directory = new File(directoryPath);
            return true;
        }
        return false;
    }

    public boolean createFile(File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("file creato nel percorso: " + file.getAbsolutePath());
                return true;
            } else {
                System.out.println("file already exists: " + file.getAbsolutePath());
            }

        } catch (IOException e) {
            System.out.println("encountered an unrecoverable error " + e.getMessage());
        }
        return true;
    }

    public boolean createDir() {
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("directory created: " + directoryPath);
                return true;
            } else {
                System.out.println("cannot create a new directory");
                return false;
            }

        } else {
            System.out.println("directory already exists");
            return false;
        }
    }

    public boolean deleteFileDir(String nome) {
        File tmp = new File(directoryPath + "\\" +nome);

        if(tmp.exists()) {
            tmp.delete();
            return true;
        }
        return false;
    }

    public void showFileInfo(String nome) {
        File tmp = new File(nome);

        if (tmp.exists()) {
            System.out.println((tmp.isDirectory() ? "[DIR] " : "[FILE] ") + nome + " Path: " + tmp.getAbsolutePath() + " Last modified: " + tmp.lastModified() + " Size: " + tmp.length() + " Permits: " + (tmp.canRead() ? "Read " : "") + (tmp.canWrite() ? "Wright " : "") + (tmp.canExecute() ? "Execute " : ""));
        }else {
            System.out.println("file / directory does not exist or not accessible");
        }

    }
}
