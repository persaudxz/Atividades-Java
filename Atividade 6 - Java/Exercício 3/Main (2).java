package atv3;

import java.util.Scanner;

public class Main {
	private static void inicio() {
		System.out.println("\nBem-vindo(a) à Biblioteca de Livros Java!");
		System.out.println("Escolha uma opção: \n"
						 + "1. Listar Livros Disponíveis\n"
						 + "2. Multa Total Acumulada\n"
						 + "3. Média Dias Atrasados\n"
						 + "4. Emprestar livro\n"
						 + "5. Devolver livro\n"
						 + "0. Encerrar programa\n");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opc;
		boolean program = true;
		
		Biblioteca bib = new Biblioteca();
		inicio();
		
		while (program) {
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				bib.listar();
				break;
				
			case 2:
				bib.multaTotal();
				break;
			
			case 3:
				bib.mediaAtraso();
				break;
			
			case 4:
				bib.emprestar();
				inicio();
				break;
				
			case 5:
				bib.devolver();
				inicio();
				break;

			case 0:
				program = false;
				break;
			
			default:
				System.out.println(opc + " não é uma opção válida!");
				
			}
		}
		
		sc.close();
	}

}
