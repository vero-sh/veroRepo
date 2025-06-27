package calcolatrice;

public class CalcolatriceConcreta implements Calcolatrice {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws ArithmeticException {
        if(b == 0) {
            throw new ArithmeticException("Divisione per zero non permessa");
        }
        return a / b;
    }
}

