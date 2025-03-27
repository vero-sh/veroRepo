package main;

import eccezioni.*;
import starship.MissionController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        MissionController missionController = new MissionController(8000); // Livello di carburante iniziale 800
        System.out.println("Missione iniziata con l'astronave SGURBA");
        try {
            // Inizia il viaggio con eventi casuali
            missionController.travelWithRandomEvents();
        } catch (SpaceDebrisException e) {
            System.out.println(e.getMessage());
        } catch (SolarstormException e) {
            System.out.println(e.getMessage());
        } catch (OutOfFuelException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Errore: il viaggio è stato interrotto.");
        }

    }
}