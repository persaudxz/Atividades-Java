public class PostoCombustivel {
    String[] tiposCombustivel = {"Gasolina", "Etanol", "Diesel"};
    double[] precosLitro = {5.50, 4.00, 3.80};
    int[] litrosDisponiveis = {1000, 500, 800}; 

    void exibirCombustiveis() {
        System.out.println("Combustíveis disponíveis:");
        for (int i = 0; i < tiposCombustivel.length; i++) {
            System.out.printf("%s - R$ %.2f/litro - %d litros disponíveis\n",
                tiposCombustivel[i], precosLitro[i], litrosDisponiveis[i]);
        }
    }

    double valorTotalEstoque() {
        double total = 0;
        for (int i = 0; i < tiposCombustivel.length; i++) {
            total += precosLitro[i] * litrosDisponiveis[i];
        }
        return total;
    }

    void maiorEMenorEstoque() {
        int maiorIndice = 0;
        int menorIndice = 0;

        for (int i = 1; i < litrosDisponiveis.length; i++) {
            if (litrosDisponiveis[i] > litrosDisponiveis[maiorIndice]) {
                maiorIndice = i;
            }
            if (litrosDisponiveis[i] < litrosDisponiveis[menorIndice]) {
                menorIndice = i;
            }
        }

        System.out.println("Maior estoque: " + tiposCombustivel[maiorIndice] + " - " + litrosDisponiveis[maiorIndice] + " litros");
        System.out.println("Menor estoque: " + tiposCombustivel[menorIndice] + " - " + litrosDisponiveis[menorIndice] + " litros");
    }

    void venderCombustivel(String tipo, int litros) {
        for (int i = 0; i < tiposCombustivel.length; i++) {
            if (tiposCombustivel[i].equalsIgnoreCase(tipo)) {
                if (litrosDisponiveis[i] >= litros) {
                    litrosDisponiveis[i] -= litros;
                    double valorVenda = litros * precosLitro[i];
                    System.out.printf("Venda realizada: %d litros de %s por R$ %.2f\n", litros, tipo, valorVenda);
                } else {
                    System.out.println("Estoque insuficiente para a venda.");
                }
                return;
            }
        }
        System.out.println("Combustível não encontrado.");
    }

    void reabastecerCombustivel(String tipo, int litros) {
        for (int i = 0; i < tiposCombustivel.length; i++) {
            if (tiposCombustivel[i].equalsIgnoreCase(tipo)) {
                litrosDisponiveis[i] += litros;
                System.out.println("Reabastecido " + litros + " litros de " + tipo);
                return;
            }
        }
        System.out.println("Combustível não encontrado.");
    }

    public static void main(String[] args) {
        PostoCombustivel posto = new PostoCombustivel();

        posto.exibirCombustiveis();
        System.out.printf("\nValor total em estoque: R$ %.2f\n", posto.valorTotalEstoque());
        posto.maiorEMenorEstoque();

        posto.venderCombustivel("Etanol", 200);
        posto.exibirCombustiveis();

        posto.reabastecerCombustivel("Diesel", 100);
        posto.exibirCombustiveis();
    }
}
