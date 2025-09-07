public class Main {
    public static void main(String[] args) {
        int numeroModelli = 10;
        int postiCamerino = 3;
        int postiPasserella = 2;

        Camerino camerino = new Camerino(postiCamerino);
        Passerella passerella = new Passerella(postiPasserella);

        for (int i = 1; i <= numeroModelli; i++) {
            Modello modello = new Modello("Modello-" + i, camerino, passerella);
            modello.start();
        }
    }
}