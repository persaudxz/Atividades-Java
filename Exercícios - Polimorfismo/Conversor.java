class Conversor {

    public double converter(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public double converter(int km) {
        return km * 0.621371;
    }

    public String converter(String texto) {
        return texto.toUpperCase();
    }
}

public class TesteConversor {
    public static void main(String[] args) {
        Conversor conv = new Conversor();

        System.out.println(conv.converter(25.0));   // Celsius -> Fahrenheit
        System.out.println(conv.converter(10));     // Km -> Milhas
        System.out.println(conv.converter("olá"));  // Texto -> Maiúsculas
    }
}
