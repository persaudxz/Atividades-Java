public class Empresa {
    private String nome;
    private Cliente[] clientes;
    private Funcionario[] funcionarios;
    private int qtdClientes;
    private int qtdFuncionarios;

    public Empresa(String nome) {
        this.nome = nome;
        this.clientes = new Cliente[5];
        this.funcionarios = new Funcionario[10];
        this.qtdClientes = 0;
        this.qtdFuncionarios = 0;
    }

    public boolean adicionarCliente(String nome, String email) {
        if (qtdClientes < clientes.length) {
            clientes[qtdClientes++] = new Cliente(nome, email);
            return true;
        }
        return false;
    }

    public String exibirClientes() {
        if (qtdClientes == 0) return "Nenhum cliente cadastrado.";
        StringBuilder sb = new StringBuilder("=== Clientes ===\n");
        for (int i = 0; i < qtdClientes; i++) {
            sb.append(clientes[i].toString()).append("\n");
        }
        return sb.toString();
    }

    public boolean adicionarFuncionario(String nome, String cargo, double salario) {
        if (qtdFuncionarios < funcionarios.length) {
            funcionarios[qtdFuncionarios++] = new Funcionario(nome, cargo, salario);
            return true;
        }
        return false;
    }

    public String exibirFuncionarios() {
        if (qtdFuncionarios == 0) return "Nenhum funcionário cadastrado.";
        StringBuilder sb = new StringBuilder("=== Funcionários ===\n");
        for (int i = 0; i < qtdFuncionarios; i++) {
            sb.append(funcionarios[i].toString()).append("\n");
        }
        return sb.toString();
    }

    public double calcularFolhaSalarial() {
        double total = 0;
        for (int i = 0; i < qtdFuncionarios; i++) {
            total += funcionarios[i].getSalario();
        }
        return total;
    }

    public double calcularMediaSalarial() {
        if (qtdFuncionarios == 0) return 0;
        Calculadora calc = new Calculadora();
        double soma = 0;
        for (int i = 0; i < qtdFuncionarios; i++) {
            soma = calc.somar(soma, funcionarios[i].getSalario());
        }
        return calc.multiplicar(soma, 1.0 / qtdFuncionarios);
    }

    public String exibirMediaSalarial() {
        return String.format("Média Salarial: R$ %.2f", calcularMediaSalarial());
    }
}
