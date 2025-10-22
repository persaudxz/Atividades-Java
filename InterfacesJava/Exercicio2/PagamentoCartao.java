public class PagamentoCartao implements Pagamento {
    private double valor;

    public PagamentoCartao(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularPagamento() {
        return valor * 1.05; // adiciona 5%
    }

    @Override
    public String emitirRecibo() {
        return "Pagamento com Cartão: R$" + String.format("%.2f", calcularPagamento());
    }
}
