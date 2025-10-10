public class Livro
{
    
    public String titulo;
    public String autor;
    public int anoPublicacao;
    
	public static void main(String[] args) {
		
	Livro livro1 = new Livro();
	
	livro1.titulo = "Bleach";
	livro1.autor = "Tite Kubo";
	livro1.anoPublicacao = 2004;
	
	System.out.println("Título do livro: " + livro1.titulo);
	System.out.println("Autor do livro: " + livro1.autor);
	System.out.println("Ano de publicação: " + livro1.anoPublicacao);
		
	}
};
