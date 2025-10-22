
public class TesteCalculadora {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        System.out.println("Soma: " + calc.soma(10, 5));
        System.out.println("Subtração: " + calc.subtracao(10, 5));
        System.out.println("Multiplicação: " + calc.multiplicacao(10, 5));
        System.out.println("Divisão: " + calc.divisao(10, 5));
    }
}
