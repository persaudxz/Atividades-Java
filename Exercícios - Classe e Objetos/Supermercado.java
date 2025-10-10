public class Supermercado {
    String[] nomesProdutos = new String[10];
    double[] precos = new double[10];
    double[] descontos = new double[10];
    int quantidade = 0;

    void adicionarProduto(String nome, double preco, double desconto) {
        if (quantidade < nomesProdutos.length) {
            nomesProdutos[quantidade] = nome;
            precos[quantidade] = preco;
            descontos[quantidade] = desconto;
            quantidade++;
        } else {
            System.out.println("Capacidade máxima atingida.");
        }
    }

    void listarProdutos() {
        System.out.println("\nProdutos disponíveis:");
        for (int i = 0; i < quantidade; i++) {
            double precoComDesconto = precos[i] * (1 - descontos[i]/100);
            System.out.printf("%s - Original: R$%.2f | Com desconto: R$%.2f\n",
                nomesProdutos[i], precos[i], precoComDesconto);
        }
    }

    double calcularTotalComDesconto() {
        double total = 0;
        for (int i = 0; i < quantidade; i++) {
            total += precos[i] * (1 - descontos[i]/100);
        }
        return total;
    }

    String produtoMaiorEconomia() {
        if (quantidade == 0) return null;

        double maiorEconomia = 0;
        String produtoMaisEconomico = nomesProdutos[0];

        for (int i = 0; i < quantidade; i++) {
            double economia = precos[i] * (descontos[i]/100);
            if (economia > maiorEconomia) {
                maiorEconomia = economia;
                produtoMaisEconomico = nomesProdutos[i];
            }
        }
        return produtoMaisEconomico;
    }

    void comprarProduto(String nome) {
        for (int i = 0; i < quantidade; i++) {
            if (nomesProdutos[i].equalsIgnoreCase(nome)) {

                for (int j = i; j < quantidade - 1; j++) {
                    nomesProdutos[j] = nomesProdutos[j + 1];
                    precos[j] = precos[j + 1];
                    descontos[j] = descontos[j + 1];
                }
                quantidade--;
                System.out.println("\nProduto '" + nome + "' comprado e removido.");
                return;
            }
        }
        System.out.println("\nProduto '" + nome + "' não encontrado.");
    }

    void reporProduto(String nome, double preco, double desconto) {
        adicionarProduto(nome, preco, desconto);
        System.out.println("\nProduto '" + nome + "' reposto no estoque.");
    }

    public static void main(String[] args) {
        Supermercado mercado = new Supermercado();

        mercado.adicionarProduto("Arroz", 20.0, 10.0);
        mercado.adicionarProduto("Feijão", 8.0, 5.0);
        mercado.adicionarProduto("Macarrão", 5.0, 0.0);
        mercado.adicionarProduto("Óleo", 7.5, 15.0);

        mercado.listarProdutos();

        System.out.printf("\nTotal com desconto: R$%.2f\n", mercado.calcularTotalComDesconto());

        String maisEconomico = mercado.produtoMaiorEconomia();
        System.out.println("\nProduto com maior economia: " + maisEconomico);

        mercado.comprarProduto("Feijão");
        mercado.listarProdutos();

        mercado.reporProduto("Feijão", 8.0, 5.0);
        mercado.listarProdutos();
    }
}
