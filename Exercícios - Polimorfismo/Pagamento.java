class Pagamento {
    public void processarPagamento() {
        System.out.println("Processando pagamento genérico");
    }
}

class PagamentoCartao extends Pagamento {
    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento via cartão de crédito");
    }
}

class PagamentoBoleto extends Pagamento {
    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento via boleto bancário");
    }
}

public class TestePagamento {
    public static void main(String[] args) {
        Pagamento p1 = new PagamentoCartao();
        Pagamento p2 = new PagamentoBoleto();

        p1.processarPagamento();
        p2.processarPagamento();
    }
}
