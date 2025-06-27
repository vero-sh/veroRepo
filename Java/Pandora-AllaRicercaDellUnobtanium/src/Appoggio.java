import java.util.Random;

// Eccezioni Personalizzate
class AttaccoFallitoException extends Exception {
    public AttaccoFallitoException(String message) {
        super(message);
    }
}

class ArmaMalfunzionanteException extends Exception {
    public ArmaMalfunzionanteException(String message) {
        super(message);
    }
}

class DifesaInsufficienteException extends Exception {
    public DifesaInsufficienteException(String message) {
        super(message);
    }
}

class UnobtaniumEsauritoException extends Exception {
    public UnobtaniumEsauritoException(String message) {
        super(message);
    }
}

// Classe per la gestione delle coordinate
class Coordinata {
    private double latitudine;
    private double longitudine;

    public Coordinata(double latitudine, double longitudine) {
        if (latitudine < -90.0 || latitudine > 90.0) {
            throw new IllegalArgumentException("Latitudine non valida: " + latitudine);
        }
        if (longitudine < -180.0 || longitudine > 180.0) {
            throw new IllegalArgumentException("Longitudine non valida: " + longitudine);
        }
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public void cambiaPosizione(double latitudine, double longitudine) {
        if (latitudine < -90.0 || latitudine > 90.0) {
            throw new IllegalArgumentException("Latitudine non valida: " + latitudine);
        }
        if (longitudine < -180.0 || longitudine > 180.0) {
            throw new IllegalArgumentException("Longitudine non valida: " + longitudine);
        }
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    @Override
    public String toString() {
        return "Lat: " + latitudine + ", Long: " + longitudine;
    }
}

// Classe Avatar (Na'vi)
class Avatar {
    private String nome;
    private String arma;
    private int forzaAttacco;
    private Random random = new Random();

    public Avatar(String nome, String arma, int forzaAttacco) {
        this.nome = nome;
        this.arma = arma;
        this.forzaAttacco = forzaAttacco;
    }

    public String getNome() {
        return nome;
    }

    public void attacca(PostazioneRDA postazione) throws AttaccoFallitoException, ArmaMalfunzionanteException, DifesaInsufficienteException, UnobtaniumEsauritoException {
		if (random.nextDouble() < 0.3) { 
			throw new AttaccoFallitoException(nome + " ha fallito l'attacco!");
		}
		if (random.nextDouble() < 0.2) { 
			throw new ArmaMalfunzionanteException("L'arma di " + nome + " ha smesso di funzionare!");
		}
    
		// Se l'attacco non fallisce e l'arma funziona, il Na'vi attacca
		System.out.println(nome + " attacca con successo usando " + arma + "!");
		postazione.difendi(forzaAttacco);
	}

}

// Classe PostazioneRDA
class PostazioneRDA {
    private Coordinata posizione;
    private int difesa;
    private int unobtaniumRimanente;
    private Random random = new Random();

    public PostazioneRDA(Coordinata posizione, int difesa, int unobtaniumRimanente) {
        this.posizione = posizione;
        this.difesa = difesa;
        this.unobtaniumRimanente = unobtaniumRimanente;
    }

    public void difendi(int forzaAttacco) throws DifesaInsufficienteException, UnobtaniumEsauritoException {
        if (unobtaniumRimanente <= 0) {
            throw new UnobtaniumEsauritoException("Le miniere di Unobtanium sono esaurite!");
        }

        if (forzaAttacco > difesa) {
            cambiaPosizione();
            throw new DifesaInsufficienteException("La difesa della postazione è stata sconfitta!");
        } else {
            difesa -= forzaAttacco;
            unobtaniumRimanente--;
            System.out.println("Postazione RDA ha resistito all'attacco. Nuova difesa: " + difesa + ", Unobtanium rimasto: " + unobtaniumRimanente);
        }
    }

    private void cambiaPosizione() {
        double nuovaLat = random.nextDouble() * 180 - 90;
        double nuovaLong = random.nextDouble() * 360 - 180;
        posizione.cambiaPosizione(nuovaLat, nuovaLong);
        difesa = random.nextInt(50) + 50;
        unobtaniumRimanente = random.nextInt(11) + 1;
        System.out.println("La postazione RDA si è spostata in una nuova posizione: " + posizione);
    }
}

// Classe principale per la simulazione
public class Main {
    public static void main(String[] args) {
        String pandoraEndTitle = 
              "░▒▓███████▓▒░ ░▒▓██████▓▒░░▒▓███████▓▒░░▒▓███████▓▒░ ░▒▓██████▓▒░░▒▓███████▓▒░ ░▒▓██████▓▒░  \n"
            + "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n"
            + "░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n"
            + "░▒▓███████▓▒░░▒▓████████▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░░▒▓████████▓▒░ \n"
            + "░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n"
            + "░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n"
            + "░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░";
		
		String pandoraTitle = 
            "██████╗  █████╗ ███╗   ██╗ ██████  ██████╗ ██████╗  █████╗ \n" +
            "██╔══██╗██╔══██╗████╗  ██║██╔══██╗██╔═══██╗██╔══██╗██╔══██╗\n" +
            "██████╔╝███████║██╔██╗ ██║██║  ██║██║   ██║██████╔╝███████║\n" +
            "██╔═══╝ ██╔══██║██║╚██╗██║██║  ██║██║   ██║██╚══██ ██╔══██║\n" +
            "██║     ██║  ██║██║ ╚████║██████╔╝╚██████╔╝██╔══██╗██║  ██║\n" +
            "╚═╝     ╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝";
			
		String pandoraTitle2 =
			"          _____                    _____                    _____                    _____                   _______                   _____                    _____          \n" +
			"         /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                 /::\\    \\                 /\\    \\                  /\\    \\         \n" +
			"        /::\\    \\                /::\\    \\                /::\\____\\                /::\\    \\               /::::\\    \\               /::\\    \\                /::\\    \\        \n" +
			"       /::::\\    \\              /::::\\    \\              /::::|   |               /::::\\    \\             /::::::\\    \\             /::::\\    \\              /::::\\    \\       \n" +
			"      /::::::\\    \\            /::::::\\    \\            /:::::|   |              /::::::\\    \\           /::::::::\\    \\           /::::::\\    \\            /::::::\\    \\      \n" +
			"     /:::/\\:::\\    \\          /:::/\\:::\\    \\          /::::::|   |             /:::/\\:::\\    \\         /:::/~~\\:::\\    \\         /:::/\\:::\\    \\          /:::/\\:::\\    \\     \n" +
			"    /:::/__\\:::\\    \\        /:::/__\\:::\\    \\        /:::/|::|   |            /:::/  \\:::\\    \\       /:::/    \\:::\\    \\       /:::/__\\:::\\    \\        /:::/__\\:::\\    \\    \n" +
			"   /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\      /:::/ |::|   |           /:::/    \\:::\\    \\     /:::/    / \\:::\\    \\     /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\   \n" +
			"  /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\    /:::/  |::|   | _____    /:::/    / \\:::\\    \\   /:::/____/   \\:::\\____\\   /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\  \n" +
			" /:::/\\:::\\   \\:::\\____\\  /:::/\\:::\\   \\:::\\    \\  /:::/   |::|   |/\\    \\  /:::/    /   \\:::\\ ___\\ |:::|    |     |:::|    | /:::/\\:::\\   \\:::\\____\\  /:::/\\:::\\   \\:::\\    \\ \n" +
			"/:::/  \\:::\\   \\:::|    |/:::/  \\:::\\   \\:::\\____\\/:: /    |::|   /::\\____\\/:::/____/     \\:::|    ||:::|____|     |:::|    |/:::/  \\:::\\   \\:::|    |/:::/  \\:::\\   \\:::\\____\\\n" +
			"\\::/    \\:::\\  /:::|____|\\::/    \\:::\\  /:::/    /\\::/    /|::|  /:::/    /\\:::\\    \\     /:::|____| \\:::\\    \\   /:::/    / \\::/   |::::\\  /:::|____|\\::/    \\:::\\  /:::/    /\n" +
			" \\/_____/\\:::\\/:::/    /  \\/____/ \\:::\\/:::/    /  \\/____/ |::| /:::/    /  \\:::\\    \\   /:::/    /   \\:::\\    \\ /:::/    /   \\/____|:::::\\/:::/    /  \\/____/ \\:::\\/:::/    / \n" +
			"          \\::::::/    /            \\::::::/    /           |::|/:::/    /    \\:::\\    \\ /:::/    /     \\:::\\    /:::/    /          |:::::::::/    /            \\::::::/    /  \n" +
			"           \\::::/    /              \\::::/    /            |::::::/    /      \\:::\\    /:::/    /       \\:::\\__/:::/    /           |::|\\::::/    /              \\::::/    /   \n" +
			"            \\::/____/               /:::/    /             |:::::/    /        \\:::\\  /:::/    /         \\::::::::/    /            |::| \\::/____/               /:::/    /    \n" +
			"             ~~                    /:::/    /              |::::/    /          \\:::\\/:::/    /           \\::::::/    /             |::|  ~|                    /:::/    /     \n" +
			"                                  /:::/    /               |:::/    /            \\::::::/    /             \\::::/    /              |::|   |                   /:::/    /      \n" +
			"                                 /:::/    /               /:::/    /              \\::::/    /               \\::/____/               \\::|   |                  /:::/    /       \n" +
			"                                 \\::/    /                \\::/    /                \\::/____/                 ~~                      \\:|   |                  \\::/    /        \n" +
			"                                  \\/____/                  \\/____/                  ~~                                                \\|___|                   \\/____/         \n";
  
        System.out.println("\n" + "\n" + pandoraTitle2);
		
		Avatar[] avatars = {
            new Avatar("Jake Sully", "Arco", 30),
            new Avatar("Neytiri", "Lancia", 25),
            new Avatar("Tsutey", "Coltello", 20)
        };

        PostazioneRDA postazione = new PostazioneRDA(new Coordinata(10.5, 20.3), 100, 5);

        for (int i = 1; i <= 10; i++) {
            System.out.println("\n--- Raid " + i + " ---");
            for (Avatar avatar : avatars) {
                try {
                    avatar.attacca(postazione);
                    System.out.println(avatar.getNome() + " ha attaccato con successo!");
                } catch (AttaccoFallitoException | ArmaMalfunzionanteException e) {
                    System.out.println(e.getMessage());
                } catch (DifesaInsufficienteException e) {
                    System.out.println("Difesa insufficiente! " + e.getMessage());
                } catch (UnobtaniumEsauritoException e) {
                    System.out.println("Unobtanium esaurito! Postazione spostata.");
                }
                
                try {
                    Thread.sleep(1000); // Pausa tra gli attacchi per simulare il tempo di combattimento
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
		
		System.out.println("\n" + "\n" + pandoraTitle2);
    }
}

