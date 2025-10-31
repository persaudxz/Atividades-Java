class Produto {
    String nome;
    double preco;
    int quantidade;

    public Produto(String nome) {
        this.nome = nome;
        this.preco = 0.0;
        this.quantidade = 0;
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = 0;
    }

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void mostrarInfo() {
        System.out.println("Produto: " + nome + ", Preço: " + preco + ", Quantidade: " + quantidade);
    }
}

public class TesteProduto {
    public static void main(String[] args) {
        Produto p1 = new Produto("Caneta");
        Produto p2 = new Produto("Caderno", 12.50);
        Produto p3 = new Produto("Mochila", 120.0, 5);

        p1.mostrarInfo();
        p2.mostrarInfo();
        p3.mostrarInfo();
    }
}
