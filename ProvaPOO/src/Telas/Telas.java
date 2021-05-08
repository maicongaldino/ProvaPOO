package Telas;

import java.util.Scanner;

public class Telas {

    public int exibirMenuPrincipal(Scanner ler) {
        System.out.println("\t\t\t↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓\n");
        System.out.println("\t\t\t > > > > - MENU PRINCIPAL - < < < <\n");
        System.out.println("\t\t\t↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑\n");

        System.out.println("1  --  Cadastro de produtos");
        System.out.println("2  --  Relatórios");
        System.out.println("3  --  Realizar venda");
        System.out.println("0  --  Sair");
        System.out.printf("\nOpção:\t");
        int opcao = ler.nextInt();
        return opcao;
    }

    public int cadastroDeProdutos(Scanner ler) {
        System.out.println("\t\t\t↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓\n");
        System.out.println("\t\t\t > > > > - CADASTRO DE PRODUTOS - < < < <\n");
        System.out.println("\t\t\t↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑\n");
        System.out.println("1  --  Consultar");
        System.out.println("2  --  Incluir");
        System.out.println("3  --  Remover");
        System.out.println("4  --  Adicionar quantidade");
        System.out.println("0  --  Voltar ao menu anterior");
        System.out.printf("\nOpção:\t");
        int opcaoCadastro = ler.nextInt();
        return opcaoCadastro;
    }

    public int relatorios(Scanner ler) {
        System.out.println("\t\t\t↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ \n");
        System.out.println("\t\t\t > > > > - RELATÓRIOS - < < < <\n");
        System.out.println("\t\t\t↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ \n");

        System.out.println("1  --  Produtos");
        System.out.println("2  --  Vendas por período - detalhado");
        System.out.println("3  --  Vendas por período - consolidado");
        System.out.printf("0  --  Voltar ao menu anterior\n-->\t");
        int opcaoRelatorio = ler.nextInt();
        return opcaoRelatorio;
    }

    public void listarProdutos() {
        System.out.println("\t\t\t↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ \n");
        System.out.println("\t\t\t > > > > - LISTAR  PRODUTOS - < < < <\n");
        System.out.println("\t\t\t↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ \n");
    }

    public void vendasPeriodoDeImprimir() {
        System.out.println("\t\t\t↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ \n");
        System.out.println("\t\t\t > > > > - VENDAS  PERIODOS - DETALHADO - < < < <\n");
        System.out.println("\t\t\t↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↓ ↓ ↓ \n");
    }

    public void vendasPeriodoConsoImprimir() {
        System.out.println("\t\t\t↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ \n");
        System.out.println("\t\t\t > > > > - VENDAS  PERIODOS - CONSOLIDADO - < < < <\n");
        System.out.println("\t\t\t↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↓ ↓ ↓ ↓ \n");
    }

    public void registroVendas() {
        System.out.println("\t\t\t↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ \n");
        System.out.println("\t\t\t > > > > - REGISTRO  DE VENDAS - < < < <\n");
        System.out.println("\t\t\t↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ \n");
    }

    public void produtosIncluir() {
        System.out.println("\t\t\t↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ \n");
        System.out.println("\t\t\t > > > > - PRODUTOS  INCLUIR - < < < <\n");
        System.out.println("\t\t\t↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ \n");
    }

    public void produtosConsultar() {
        System.out.println("\t\t\t↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓\n");
        System.out.println("\t\t\t > > > > - PRODUTOS  CONSULTAR - < < < <\n");
        System.out.println("\t\t\t↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑\n");
    }

    public void removerProduto() {
        System.out.println("\t\t\t↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓\n");
        System.out.println("\t\t\t > > > > - REMOVER PRODUTO - < < < <\n");
        System.out.println("\t\t\t↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑\n");
    }
    
    public void adicionaQtdEstoque() {
        System.out.println("\t\t\t↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓\n");
        System.out.println("\t\t\t > > > > - ADICIONA QUANTIDADE - ESTOQUE - < < < <\n");
        System.out.println("\t\t\t↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑\n");
    }
}