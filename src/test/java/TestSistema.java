import gestao.cadastro.Sistema;
import gestao.funcionario.Funcionario;
import gestao.funcionario.Vendedor;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSistema {

    private List<Funcionario> listaFuncionarios = new ArrayList<>();
    private List<Vendedor> listaVendedors = new ArrayList<>();

    @Test
    public void CadastrarFuncionaComSalarioNegativoTest(){
        listaFuncionarios.add(new Funcionario(-100.0,"Rian"));
        double resulto=listaFuncionarios.get(0).getSalario();

        Assert.assertEquals(0,resulto,0);


    }

    @Test
    public void testverificarSalarioFinalDeVendedorComSalarioNegativo(){
        listaVendedors.add(new Vendedor("v1",-2000.0,0.10,50));
        double resultado=listaVendedors.get(0).calcularSalarioFinal();
        Assert.assertEquals(5,resultado,0);
    }

    @Test
    public void testvendedorComUmaComissãoPorVendaNegativa(){
        listaVendedors.add(new Vendedor("v1",2000.0,-0.10,10));
        double resultado=listaVendedors.get(0).calcularSalarioFinal();
        Assert.assertEquals(2000,resultado,0);
    }

    @Test
    public void testVendedorComUmaQuantidadeDeVendasNegativa(){
        listaVendedors.add(new Vendedor("v1",2000.0,0.10,-10));
        double resultado=listaVendedors.get(0).calcularSalarioFinal();
        Assert.assertEquals(2000,resultado,0);
    }

    @Test
    public  void TestVendedorComumSalárioBaseUmaComissãoPorVendaEUmaQuantidadedeVendasValidaseVerificaroCalculodosaláriofinal(){
        listaVendedors.add(new Vendedor("v1",2000.0,0.10,10));
        double resultado=listaVendedors.get(0).calcularSalarioFinal();
        Assert.assertEquals(2001.0,resultado,0);
    }

    @Test
    public void TestFuncionárioEUmVendedorComOMesmoSalarioBasePoremOVendedorNãoTemNenhumaVendaCompareOsResultadosDoCalculoDoSalarioDeCadaUm(){
        listaVendedors.add(new Vendedor("v1",2000.0,0.10,0));
        double resultadoVendedor=listaVendedors.get(0).calcularSalarioFinal();

        listaFuncionarios.add(new Funcionario(2000.0,"F1"));
        double resultadoFuncionario=listaFuncionarios.get(0).getSalario();
        Assert.assertEquals(resultadoFuncionario,resultadoVendedor,0.001);
    }

    @Test
    public void TestFuncionárioEUmVendedorComOMesmoSalarioBasePoremOVendedorTemDezVendaCompareOsResultadosDoCalculoDoSalarioDeCadaUm(){
        listaVendedors.add(new Vendedor("v1",2000.0,0.10,10));
        double resultadoVendedor=listaVendedors.get(0).calcularSalarioFinal();

        listaFuncionarios.add(new Funcionario(2000.0,"F1"));
        double resultadoFuncionario=listaFuncionarios.get(0).getSalario();
        Assert.assertEquals(2000.0,resultadoFuncionario,0.001);
        Assert.assertEquals(2001.0,resultadoVendedor,0.001);

    }

}
