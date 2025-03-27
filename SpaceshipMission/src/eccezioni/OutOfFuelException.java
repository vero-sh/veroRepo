package eccezioni;

public class OutOfFuelException extends RuntimeException{
    public OutOfFuelException(String message) {
        super(message);
        System.exit(0);
    }
}
