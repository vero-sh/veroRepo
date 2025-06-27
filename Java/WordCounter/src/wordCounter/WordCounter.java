package wordCounter;

import java.util.HashMap;

public class WordCounter {
    //ATTRIBUTI

    private HashMap<String, Integer> map;

    //METODI

    //COSTRUTTORE
    public WordCounter() {
        map  = new HashMap<>();
    }

    //CONTA TESTO
    public HashMap<String, Integer> textCount (String text) {
        updateMap(text);
        return map;
    }

    //UPDATE MAP
    private void updateMap (String text) {
        String appoggio = text.replaceAll("[^a-zA-Z0-9]+", " ").toLowerCase();
        String[] parole = appoggio.split(" ");

        for (String p : parole) {
            if (map.containsKey(p)) map.put(p, map.get(p) + 1);
            else map.put(p, 1);
        }
    }
}