public class ContaBancaria {

    private String titular;
    private int numeroConta;
    private double saldo;

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();

        conta.setTitular("Maria Silva");
        conta.setNumeroConta(12345);
        conta.setSaldo(1500.75);

        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Número da Conta: " + conta.getNumeroConta());
        System.out.println("Saldo: R$ " + conta.getSaldo());
    }
}
