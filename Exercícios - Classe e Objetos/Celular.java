
public class Celular
{
    
    public String marca;
    public String modelo;
    public int preco;
    
	public static void main(String[] args) {

    Celular celular1 = new Celular();
    
    celular1.marca = "Xiaomi";
    celular1.modelo = "Redmi 13C";
    celular1.preco = 800;

    System.out.println("Marca: " + celular1.marca);
    System.out.println("Modelo: " + celular1.modelo);
    System.out.println("Preço: " + celular1.preco);
    
	}
}
