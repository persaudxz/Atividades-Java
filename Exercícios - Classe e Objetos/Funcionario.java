public class Funcionario
{
    private String nome;
    private double salario;
    private String cargo;
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public double getSalario(){
        return salario;
    }   
    public void setSalario(double salario){
        this.salario = salario;
    }
    public String getCargo(){
        return cargo;
    }
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario();
        
        funcionario1.setNome("João Silva");
        funcionario1.setSalario(3000);
        funcionario1.setCargo("Analista de dados");
        
        System.out.println("Nome: " + funcionario1.getNome());
        System.out.println("Salário: " + funcionario1.getSalario());
        System.out.println("Cargo: " + funcionario1.getCargo());
    }
}

