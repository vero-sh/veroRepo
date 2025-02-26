
public class Main {
    public static void main(String[] args) {

        Pila pila = new Pila<Moneta>();

        System.out.println(pila.isEmpty());
        Moneta m1 = new Moneta(2);
        Moneta m2 = new Moneta(1);
        pila.push(m1);
        pila.push(m2);
        System.out.println(pila.isEmpty());
        System.out.println(pila);
        System.out.println(pila.size());
        System.out.println(pila.pop());
        System.out.println(pila);
        System.out.println(pila.size());
    }
}