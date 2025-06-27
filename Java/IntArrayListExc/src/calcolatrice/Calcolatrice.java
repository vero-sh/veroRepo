package calcolatrice;

public interface Calcolatrice {
    public double add(double a, double b);
    public double subtract(double a, double b);
    public double multiply(double a, double b);
    public double divide(double a, double b) throws ArithmeticException;
}
