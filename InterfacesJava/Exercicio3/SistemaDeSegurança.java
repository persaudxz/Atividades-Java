public class SistemaDeSeguranca implements Autenticavel {
    private final String USUARIO_CORRETO = "admin";
    private final String SENHA_CORRETA = "1234";
    private boolean autenticado = false;

    @Override
    public boolean login(String usuario, String senha) {
        if (usuario.equals(USUARIO_CORRETO) && senha.equals(SENHA_CORRETA)) {
            autenticado = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void logout() {
        autenticado = false;
        System.out.println("Logout realizado com sucesso.");
    }

    public boolean isAutenticado() {
        return autenticado;
    }
}
