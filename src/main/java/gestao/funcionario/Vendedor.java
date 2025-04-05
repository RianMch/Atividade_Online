package gestao.funcionario;

public class Vendedor extends  Funcionario {
    private Double comissao;
    private int quantidadeVendas;
    private double salarioFinal;
    public Vendedor(){}

    public Vendedor(String nome,double salario,double comissao,int quantidadeVendas){
        super(salario,nome);
        this.comissao=verificacaoDeComissao(comissao);
        this.quantidadeVendas=verificacaoDeQuantidadeVendas(quantidadeVendas);

    }

    public double getSalarioFinal() {
        return salarioFinal;
    }

    public void setSalarioFinal(double salarioFinal) {
        this.salarioFinal = salarioFinal;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void setQuantidadeVendas(int quantidadeVendas) {
        this.quantidadeVendas = quantidadeVendas;
    }

    public double verificacaoDeComissao(double salario){
        return salario < 0 ? 0 : salario;
    }
    public int verificacaoDeQuantidadeVendas(int quantidadeVendas){
        return Math.max(quantidadeVendas, 0);
    }
    public double calcularSalarioFinal() {
        return getSalario() + (comissao * quantidadeVendas);
    }

}
