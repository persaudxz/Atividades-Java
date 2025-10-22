import java.util.Scanner;

public class TesteSeguranca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaDeSeguranca sistema = new SistemaDeSeguranca();

        while (!sistema.isAutenticado()) {
            System.out.print("Usuário: ");
            String usuario = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            if (sistema.login(usuario, senha)) {
                System.out.println("Bem-vindo, " + usuario + "!");
            } else {
                System.out.println("Login ou senha incorretos. Tente novamente.");
            }
        }

        // Simulando logout
        System.out.print("Deseja sair do sistema? (s/n): ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            sistema.logout();
        }

        scanner.close();
    }
}
