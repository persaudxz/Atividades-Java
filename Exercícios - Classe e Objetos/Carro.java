public class Carro {

    public String marca;
    public String modelo;
    public int ano;

    public static void main(String[] args) {

        Carro meuCarro = new Carro();

        meuCarro.marca = "Fusca";
        meuCarro.modelo = "1300";
        meuCarro.ano = 1985;

        System.out.println("Marca: " + meuCarro.marca);
        System.out.println("Modelo: " + meuCarro.modelo);
        System.out.println("Ano: " + meuCarro.ano);
    }
}
