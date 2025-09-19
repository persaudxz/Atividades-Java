package atv3;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	Scanner sc = new Scanner(System.in);

	private ArrayList<String> livros = new ArrayList<>();
    private ArrayList<Integer> diasAtraso = new ArrayList<>();
    private ArrayList<Double> multaPorDia = new ArrayList<>();
    
    private ArrayList<String> emprestados = new ArrayList<>();
    private ArrayList<Integer> atrasoEmprestados = new ArrayList<>();
    private ArrayList<Double> multaEmprestados = new ArrayList<>();

    public Biblioteca() {
        String[] nomes = {
            "O Hobbit", 
            "Dom Casmurro", 
            "1984", 
            "Clean Code", 
            "O Senhor dos Anéis",
            "Neuromancer", 
            "O Pequeno Príncipe", 
            "Harry Potter e a Pedra Filosofal",
            "A Guerra dos Tronos", 
            "A Revolução dos Bichos"
        };
        int[] dias = {0, 3, 7, 1, 5, 2, 0, 4, 6, 3};
        double[] multas = {0.50, 1.00, 0.75, 1.20, 0.90, 0.60, 0.40, 1.10, 1.50, 0.80};

        for (int i = 0; i < nomes.length; i++) {
            livros.add(nomes[i]);
            diasAtraso.add(dias[i]);
            multaPorDia.add(multas[i]);
        }
    }

	public void listar() {
		System.out.println("Livro | Dias de Atraso | Multa p/ Dia");
		int c = 1;
		for (int i = 0; i < livros.size(); i++) {
			System.out.println(c + ". " + livros.get(i) + " | " + diasAtraso.get(i) + " | R$" + multaPorDia.get(i));
			c++;
		}
	}
	
	public void listarEmp() {
		System.out.println("Livro | Dias de Atraso | Multa p/ Dia");
		int c = 1;
		for (int i = 0; i < emprestados.size(); i++) {
			System.out.println(c + ". " + emprestados.get(i) + " | " + atrasoEmprestados.get(i) + " | R$" + multaEmprestados.get(i));
			c++;
		}
	}

	public void multaTotal() {
		double multa = 0.0;
		for (int i = 0; i < livros.size(); i++) {
			multa += (multaPorDia.get(i) * diasAtraso.get(i));
		}
		System.out.println("A multa a ser paga de todos os livros é de aproximadamente R$" + Math.ceil(multa));
	}

	public void mediaAtraso() {
		double media = 0.0;
		int soma = 0;
		for (int i = 0; i < livros.size(); i++) {
			soma += diasAtraso.get(i);
		}
		media = soma / diasAtraso.size();

		System.out.println("A média de dias atrasados é de " + media + " dias.");
	}

	public void emprestar() {
		this.listar();
		boolean con = false;
		while (!con) {
			System.out.println("\nQual dos livros listados você quer emprestar? (Digite 0 para retornar)");
			String alg2;
			int alg = sc.nextInt() - 1;
			if (alg != -1) {
				System.out.println("Você deseja mesmo emprestar " + livros.get(alg) + "? S/N\n");
				alg2 = sc.next().toUpperCase();
				switch (alg2) {
				case "S":
					con = true;
					emprestados.add(livros.remove(alg));
                    atrasoEmprestados.add(diasAtraso.remove(alg));
                    multaEmprestados.add(multaPorDia.remove(alg));
					System.out.println("Emprestado!");
					break;

				case "N":
					break;

				default:
					System.out.println("Opção inválida!");
				}
			} else con = true;
		}
	}
	
	public void devolver() {
		this.listarEmp();
		boolean con = false;
		while (!con) {
			System.out.println("\nQual dos livros listados você quer devolver? (Digite 0 para retornar)");
			String alg2;
			int alg = sc.nextInt() - 1;
			if (alg != -1) {
				System.out.println("Você deseja mesmo devolver " + emprestados.get(alg) + "? S/N\n");
				System.out.println("Valor da multa: R$" + (atrasoEmprestados.get(alg) * multaEmprestados.get(alg)));
				alg2 = sc.next().toUpperCase();
				switch (alg2) {
				case "S":
					con = true;
					livros.add(emprestados.remove(alg));
                    diasAtraso.add(atrasoEmprestados.remove(alg));
                    multaPorDia.add(multaEmprestados.remove(alg));
					System.out.println("Devolvido!");
					break;

				case "N":
					break;

				default:
					System.out.println("Opção inválida!");
				}
			} else con = true;
		}
	}
}
