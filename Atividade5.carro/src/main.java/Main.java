public class Main {
    public static void main(String[] args) {
        // Testando Carro
        Carro carro = new Carro("Toyota Corolla", 2020, 50);
        carro.info();
        System.out.println("Custo para encher o tanque: R$" + carro.calcularValorTotal(5.79));

        System.out.println("---------------------------------");

        // Testando ContaBancaria
        ContaBancaria conta = new ContaBancaria("João", 1000);
        conta.depositar(500);
        conta.sacar(300);
        conta.sacar(2000); // teste saque inválido
        System.out.println("Saldo final da conta de " + conta.getTitular() + ": R$" + conta.getSaldo());

        System.out.println("---------------------------------");

        // Testando Produto
        Produto produto = new Produto("Notebook", 3500, 10);
        produto.setPreco(-100); // teste inválido
        produto.setQuantidadeEstoque(-5); // teste inválido
        System.out.println("Produto: " + produto.getNome() + " | Preço: R$" + produto.getPreco() + " | Estoque: " + produto.getQuantidadeEstoque());
    }
}

