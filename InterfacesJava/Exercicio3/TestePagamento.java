public class TestePagamento {
    public static void main(String[] args) {
        double valor = 100.00;

        Pagamento pagamentoCartao = new PagamentoCartao(valor);
        Pagamento pagamentoDinheiro = new PagamentoDinheiro(valor);

        System.out.println(pagamentoCartao.emitirRecibo());
        System.out.println(pagamentoDinheiro.emitirRecibo());
    }
}
