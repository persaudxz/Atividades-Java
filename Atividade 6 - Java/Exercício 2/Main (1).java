package atv2;
import java.util.Scanner;

public class Main {
	private static void inicio() {
		System.out.println("\nBem-vindo(a) à Videolocadora Java!");
		System.out.println("Escolha uma opção: \n"
						 + "1. Listar filmes\n"
						 + "2. Faturamento Total Geral\n"
						 + "3. Filme mais alugado\n"
						 + "4. Alugar filme\n"
						 + "5. Devolver filme\n"
						 + "0. Encerrar programa\n");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opc;
		boolean program = true;
		
		Videolocadora vidloc = new Videolocadora();
		inicio();
		
		while (program) {
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				vidloc.listar();
				break;
				
			case 2:
				vidloc.faturamentoTotal();
				break;
				
			case 3:
				vidloc.filmeMaisAlugado();
				break;
			
			case 4:
				vidloc.Alugar();
				inicio();
				break;
				
			case 5:
				vidloc.Devolver();
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
