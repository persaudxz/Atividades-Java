public class Farmacia {
    String[] nomesMedicamentos = new String[5];
    int[] diasParaVencimento = new int[5];
    double[] precos = new double[5];
    int quantidade = 0; 

    void adicionarMedicamento(String nome, int dias, double preco) {
        if (quantidade < nomesMedicamentos.length) {
            nomesMedicamentos[quantidade] = nome;
            diasParaVencimento[quantidade] = dias;
            precos[quantidade] = preco;
            quantidade++;
        } else {
            System.out.println("Não é possível adicionar mais medicamentos.");
        }
    }

    void mostrarMedicamentos() {
        System.out.println("\nMedicamentos cadastrados:");
        for (int i = 0; i < quantidade; i++) {
            System.out.println(nomesMedicamentos[i] + " | Preço: R$" + precos[i] +
                               " | Dias p/ vencimento: " + diasParaVencimento[i]);
        }
    }

    double calcularMediaDiasParaVencimento() {
        int total = 0;
        for (int i = 0; i < quantidade; i++) {
            total += diasParaVencimento[i];
        }
        return (quantidade > 0) ? (double) total / quantidade : 0;
    }

    void mostrarProximosDeVencer() {
        System.out.println("\nMedicamentos próximos de vencer (menos de 5 dias):");
        for (int i = 0; i < quantidade; i++) {
            if (diasParaVencimento[i] < 5) {
                System.out.println(nomesMedicamentos[i] + " | Dias: " + diasParaVencimento[i]);
            }
        }
    }

    void aplicarDesconto() {
        for (int i = 0; i < quantidade; i++) {
            if (diasParaVencimento[i] < 5) {
                precos[i] = precos[i] / 2;
            }
        }
        System.out.println("\nDesconto aplicado para medicamentos próximos de vencer.");
    }

    void venderMedicamento(String nome) {
        for (int i = 0; i < quantidade; i++) {
            if (nomesMedicamentos[i].equals(nome)) {
                for (int j = i; j < quantidade - 1; j++) {
                    nomesMedicamentos[j] = nomesMedicamentos[j + 1];
                    diasParaVencimento[j] = diasParaVencimento[j + 1];
                    precos[j] = precos[j + 1];
                }
                quantidade--;
                System.out.println("\n" + nome + " vendido com sucesso.");
                return;
            }
        }
        System.out.println("\nMedicamento não encontrado.");
    }

    public static void main(String[] args) {
        Farmacia f = new Farmacia();

        f.adicionarMedicamento("Paracetamol", 10, 20.0);
        f.adicionarMedicamento("Amoxicilina", 3, 50.0);
        f.adicionarMedicamento("Dipirona", 2, 15.0);
        f.adicionarMedicamento("Ibuprofeno", 7, 25.0);

        f.mostrarMedicamentos();

        System.out.printf("\nMédia de dias p/ vencimento: %.2f dias\n", f.calcularMediaDiasParaVencimento());

        f.mostrarProximosDeVencer();

        f.aplicarDesconto();
        f.mostrarMedicamentos();

        f.venderMedicamento("Dipirona");
        f.mostrarMedicamentos();
    }
}
