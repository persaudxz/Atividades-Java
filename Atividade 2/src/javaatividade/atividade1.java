package javaatividade;
import java.util.Scanner;
public class atividade1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		
		int [] [] matriz = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		int [] [] matriz2 = {
				{7, 8, 3},
				{32, 3, 6},
				{2, 4 ,34}
		};
		
		int [][] matrizResultado = new int [3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrizResultado[i][j] = matriz[i][j] + matriz2 [i][j];	 
			};
		};
		System.out.println("Resultado da soma: \n");

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matrizResultado[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
