package gestao.cadastro;

import gestao.funcionario.Funcionario;
import gestao.funcionario.Vendedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    //Sim Eu usei chat para deixar Bonito, Mais Todos a função fui que fiz

    private List<Funcionario> listaFuncionarios = new ArrayList<>();
    private List<Vendedor> listaVendedors = new ArrayList<>();
    private Scanner leitura = new Scanner(System.in);

    // Menu de opções
    public int menu() {
        String menu = "=== MENU ===\n" +
                "1 - Cadastrar Funcionário\n" +
                "2 - Cadastrar Vendedor\n" +
                "3 - Relatório de Funcionários\n" +
                "4 - Relatório de Vendedores\n" +
                "5 - Sair\n" +
                "Escolha uma opção:";
        System.out.println(menu);
        int opc = Integer.parseInt(leitura.nextLine());
        return opc;
    }

    // Loop principal do sistema
    public void sistema() {
        int opc;
        do {
            opc = menu();
            switch (opc) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    cadastrarVendedor();
                    break;
                case 3:
                    listarFuncionariosCadastrados();
                    break;
                case 4:
                    listarVendedoresCadastrados();
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opc != 5);
    }

    // Cadastro de funcionário
    public void cadastrarFuncionario() {
        System.out.println("Digite o nome do funcionário:");
        String nome = leitura.nextLine();
        System.out.println("Digite o salário do funcionário " + nome + ":");
        double salario = leitura.nextDouble();
        leitura.nextLine();

        listaFuncionarios.add(new Funcionario(salario, nome));
        System.out.println("Funcionário " + nome + " cadastrado com sucesso!");
    }

    // Cadastro de vendedor
    public void cadastrarVendedor() {
        System.out.println("Digite o nome do vendedor:");
        String nome = leitura.nextLine();

        System.out.println("Digite o salário base do vendedor " + nome + ":");
        double salario = leitura.nextDouble();
        leitura.nextLine();

        System.out.println("Digite o valor da comissão por venda:");
        double comissao = leitura.nextDouble();
        leitura.nextLine();

        System.out.println("Digite a quantidade de vendas:");
        int quantidade = leitura.nextInt();
        leitura.nextLine();

        listaVendedors.add(new Vendedor(nome, salario, comissao, quantidade));
        System.out.println("Vendedor " + nome + " cadastrado com sucesso!");
    }

    // Relatório de funcionários
    public void listarFuncionariosCadastrados() {
        if (listaFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        System.out.println("=== Funcionários Cadastrados ===");
        listaFuncionarios.forEach(f -> System.out.println("Nome: " + f.getNome() + " | Salário: R$ " + f.getSalario()));
    }

    // Relatório de vendedores
    public void listarVendedoresCadastrados() {
        if (listaVendedors.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado.");
            return;
        }
        System.out.println("=== Vendedores Cadastrados ===");
        listaVendedors.forEach(v -> System.out.println(
                "Nome: " + v.getNome() +
                        " | Salário Base: R$ " + v.getSalario() +
                        " | Salário Final: R$ " + v.calcularSalarioFinal()
        ));
    }
}

