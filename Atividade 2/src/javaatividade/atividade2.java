package javaatividade;

import java.util.Scanner;

public class atividade2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		String [] [] matriz = {
				{"usuario1", "3434"},
				{"aluno", "7777"},
				{"nicolas", "5637"},
				{"usuario3", "3454"},
				{"aluno2", "7328"},
				{"heron", "5623"}
		};
		
		System.out.println("Digite seu login: ");
		String login = scan.nextLine();
		System.out.println("Digite sua senha de quatro números: ");
		String senha = scan.nextLine();
		
		boolean acessoLiberado = false;

        for (int i = 0; i < matriz.length; i++) {
            if (login.equals(matriz[i][0]) && senha.equals(matriz[i][1])) {
                acessoLiberado = true;
                break;
            }
        }

        if (acessoLiberado) {
            System.out.println("Acesso liberado!");
        } else {
            System.out.println("Acesso negado!");
        }
	}

}
