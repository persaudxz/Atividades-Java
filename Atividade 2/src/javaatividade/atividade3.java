package javaatividade;

import java.util.Scanner;

public class atividade3 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[][] matriz = new int[2][3];
		int[][] reverso = new int[3][2];
		
		System.out.println("Digite os números da matriz 2x3:");

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("Posição [" + i + "][" + j + "]: ");
				matriz[i][j] = scan.nextInt();
			}
		}

		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				reverso[j][i] = matriz[i][j];
			}
		}
		
		System.out.println("\nMatriz Transposta (3x2):");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(reverso[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
