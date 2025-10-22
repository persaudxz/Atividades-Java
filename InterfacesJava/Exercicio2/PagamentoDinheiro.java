public class PagamentoDinheiro implements Pagamento {
    private double valor;

    public PagamentoDinheiro(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularPagamento() {
        return valor * 0.90; // desconto de 10%
    }

    @Override
    public String emitirRecibo() {
        return "Pagamento em Dinheiro: R$" + String.format("%.2f", calcularPagamento());
    }
}
