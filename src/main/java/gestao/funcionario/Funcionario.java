package gestao.funcionario;

public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(){}

    public Funcionario(Double salario, String nome) {
        this.salario = verificacaoDeSalario(salario) ;
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = verificacaoDeSalario(salario) ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double verificacaoDeSalario(double salario){
        return salario < 0 ? 0 : salario;
    }




}
