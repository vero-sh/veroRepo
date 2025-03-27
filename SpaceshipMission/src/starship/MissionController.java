package starship;
import eccezioni.OutOfFuelException;
import eccezioni.SolarstormException;
import eccezioni.SpaceDebrisException;

import java.util.Scanner;
public class MissionController {

    // Attributi
    private int fuelLevel;
    private Coordinate currentPosition;
    private Starship spaceship;

    private Scanner sc = new Scanner(System.in);

    public MissionController(int fuelLevel) {
        this.fuelLevel = fuelLevel;

        System.out.println("Inserisci coordinata X: ");
        int x = sc.nextInt();
        System.out.println("Inserisci coordinata Y: ");
        int y = sc.nextInt();
        if(x < 0 || y < 0) throw new IllegalArgumentException("Le coordinate non possono essere negative");
        this.currentPosition = new Coordinate(x, y);
        this.spaceship = new Starship("Explorer", "bimotore"); // Definito "Explorer" come nome dell'astronave
    }

    public void travelWithRandomEvents() throws SpaceDebrisException, SolarstormException, InterruptedException, OutOfFuelException {

        while(fuelLevel > 0) {

            // Simula tempo di viaggio
            Thread.sleep(2000);
            currentPosition.setX(currentPosition.getX() + spaceship.getActualSpeed());

            fuelLevel-= spaceship.getActualSpeed();
            showCurrentPosition();
            double p1 = Math.random();
            double p2 = Math.random();

            try {
                if (p1 < 0.3) { // 30% di probabilità di attivare un evento
                    if (p2 < 0.1) { // 10% per i detriti spaziali
                        spaceship.decreaseSpeed();
                        throw new SpaceDebrisException("Detriti incontrati, riduzione velocità in corso...");
                    } else if (p2 < 0.4) { // 30% per la tempesta solare
                        Thread.sleep(3000);
                        spaceship.boostSpeed(1000);
                        throw new SolarstormException("Tempesta solare in corso! Attivazione del boost...");
                    } else { // 60% per l'esaurimento carburante
                        System.out.println("carburante esaurito termino missione");
                        throw new OutOfFuelException("Carburante esaurito! La missione è fallita.");
                    }
                }
            } catch (SpaceDebrisException | SolarstormException | OutOfFuelException e) {
                // Gestisci l'evento ma continua il ciclo
                System.out.println("Evento: " + e.getMessage());
            }
        }
    }

    public void showCurrentPosition() {
        System.out.println("Posizione attuale: " + currentPosition + " | Velocità: " + spaceship.getActualSpeed() + " | Carburante: " + fuelLevel);
    }
}