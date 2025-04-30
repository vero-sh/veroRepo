package rubrica;

import java.io.*;

public class FileEditor {

    public static void write (File f, String contenuto) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            bw.write(contenuto); //Riempie stream
            bw.flush(); //Scrive sul file
            System.out.println("Sto scrivendo:" + contenuto);
            bw.close();
        } catch (IOException e ) {
            throw new RuntimeException(e);
        }
    }

    public static String read(File f) {
        String srt = "";
        String riga;
        boolean firstLine = true;

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            while ((riga = br.readLine()) != null) {
                if (!firstLine) srt += "\n";
                srt += riga;
                firstLine = false;
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return srt;
    }

    public static File[] readContatti (String dir) {
        File cartellaContatti = new File(dir);

        if (cartellaContatti.exists() && cartellaContatti.isDirectory()) return cartellaContatti.listFiles();

        return null;
    }

}
