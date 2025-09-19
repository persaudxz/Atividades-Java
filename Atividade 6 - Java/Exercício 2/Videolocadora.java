package atv2;
import java.util.Scanner;

public class Videolocadora {
	Scanner sc = new Scanner(System.in);
	private String[] filmes = {
		    "O Senhor dos Anéis",
		    "Matrix",
		    "Vingadores: Ultimato",
		    "Jurassic Park",
		    "Interestelar",
		    "Batman: O Cavaleiro das Trevas",
		    "Star Wars: Uma Nova Esperança",
		    "De Volta para o Futuro",
		    "Gladiador",
		    "Toy Story"
		};
		private int[] vezesAlugado = {15, 23, 30, 12, 18, 25, 20, 10, 14, 8};
		private double[] precoLocacao = {4.5, 3.8, 5.0, 4.0, 4.7, 4.3, 3.9, 3.5, 4.2, 3.0};
		private boolean[] alugado = {true, false, true, false, true, false, false, true, false, true};

	
	public void listar() {
		System.out.println("Filme | Vezes Alugado | Preço Locação | Disponibilidade");
		int c = 1;
		for (int i = 0; i < filmes.length; i++) {
			String status = alugado[i] ? "Alugado" : "Não Alugado";
			System.out.println(c + ". " + filmes[i] 
					 			+ " | " + vezesAlugado[i]
					 			+ " | R$" + precoLocacao[i]
					 			+ " | " + status);
			 
			 c++;
		}
	}
	
	public void faturamentoTotal() {
		double faturamento = 0.0;
		for (int i = 0; i < filmes.length; i++) {
			faturamento += precoLocacao[i];
		}
		System.out.println("O faturamento de todos os filmes é de aproximadamente R$" + Math.ceil(faturamento));
	}

	public void filmeMaisAlugado() {
		int MaisAlugado = 0;
		int maiorAluguel = 0;
		
		for (int i = 0; i < filmes.length; i++) {
			if (vezesAlugado[i] > maiorAluguel) {
				maiorAluguel = vezesAlugado[i];
				MaisAlugado = i;
			}
		}
		
		String status = alugado[MaisAlugado] ? "Não" : "Sim";
		
		System.out.println("Filme mais alugado: " + filmes[MaisAlugado]
							+ "\nVezes Alugado: " + vezesAlugado[MaisAlugado]
							+ "\nPreço Locação: " + precoLocacao[MaisAlugado]
							+ "\nDisponível? " + status);
		
	}
	
	public void Alugar() {
		this.listar();
		boolean con = false;
		while (!con) {
			System.out.println("\nQual dos filmes listados você quer alugar? (Digite 0 para retornar)");	
			String alg2;
			int alg = sc.nextInt() - 1;
			if (alg != -1) {
				if (alugado[alg] == true) {
					System.out.println("Filme já alugado! Escolha outro.");
				} else {
					System.out.println("Você deseja mesmo alugar " + filmes[alg] + "? S/N\n");
					alg2 = sc.next().toUpperCase();
					switch (alg2) {
					case "S":
						con = true;
						alugado[alg] = true;
						vezesAlugado[alg]++;
						System.out.println("Alugado!");
						break;
						
					case "N":
						break;
					
					default:
						System.out.println("Opção inválida!");
					}
				}
			} else con = true;
		}
	}
	
	public void Devolver() {
		int c = 1;
		for (int i = 0; i < filmes.length; i++) {
			if (alugado[i]) {
				System.out.println(c + ". " + filmes[i] 
			 			+ " | " + vezesAlugado[i]
			 			+ " | R$" + precoLocacao[i]);
			}
		c++;
		}
		boolean con = false;
		while (!con) {
		System.out.println("\nQue filme você deseja devolver? (0 para retornar)");
		int alg = sc.nextInt() - 1;
		
		if (alg != -1) {
			System.out.println("Você deseja mesmo devolver " + filmes[alg] + "? S/N\n");
			String alg2 = sc.next().toUpperCase();
				switch (alg2) {
				case "S":
					con = true;
					alugado[alg] = false;
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
 