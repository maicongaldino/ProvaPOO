package Classes;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Telas.Telas;

public class CadastroProdutos {
    public void CadastrarProdutos (Scanner ler, List<Produto> listaProdutos) throws InterruptedException, IOException {
        Telas tela = new Telas();

        limpa();
        int loop = -1;
        while (loop != 0)
        {
            limpa();
            tela.produtosIncluir();
            
            System.out.printf("Digite o nome do produto(\"SAIR\" - Encerrar):\t");
            String nomeAdicionar = ler.nextLine();
            if (nomeAdicionar.equalsIgnoreCase("SAIR"))
            {
                limpa();
                System.out.println("Saindo...");
                sleep(800);
                limpa();
                break;
            }
            else
            {
                System.out.printf("Digite o código do produto:\t");
                int codigoAdicionar = 0;
                codigoAdicionar = verificaCod(ler, codigoAdicionar);
                if (codigoAdicionar == -1)
                {
                    break;
                }
                System.out.printf("Digite o valor do produto:\t");
                double valorProduto;
                try 
                {
                    valorProduto = ler.nextDouble();
                } 
                catch (InputMismatchException e) 
                {
                    System.out.println("\nValor do produto só pode conter números !!!");
                    ler.nextLine();

                    System.out.printf("\n\n\nENTER para continuar:\t");
                    String continuar = ler.nextLine();
                    if (continuar.isBlank())
                    {
                        limpa();
                    }
                    break;
                }
                System.out.printf("Digite a quantidade em estoque:\t");
                int quantAdc = ler.nextInt();
                boolean acheiNome = false;
                boolean acheiCodigo = false;
                ler.nextLine();

                for (Produto p : listaProdutos) {
                    if (p.getNome().equalsIgnoreCase(nomeAdicionar))
                    {
                        acheiNome = true;
                    }
                    if (p.getCodigo() == codigoAdicionar)
                    {
                        acheiCodigo = true;
                    }
                }
                if (acheiNome == true)
                {
                    limpa();
                    System.out.printf("\nNome: %s, já existe na lista, impossivel adicionar !!!\n", nomeAdicionar);
                    sleep(2500);
                    limpa();
                    break;
                }
                else if (acheiCodigo == true)
                {
                    limpa();
                    System.out.printf("\nCódigo: %d, já existe na lista, impossivel adicionar !!!\n", codigoAdicionar);
                    sleep(2500);
                    limpa();
                    break;
                }
                else
                {
                    Produto produto = new Produto(codigoAdicionar, nomeAdicionar, valorProduto, quantAdc);
                    listaProdutos.add(produto);
                }
            }
        }
    }
    public void ConsultaProduto(Scanner ler, List<Produto> listaProdutos) throws InterruptedException, IOException {
        Telas tela = new Telas();

        if (listaProdutos.isEmpty())
        {
            limpa();
            System.out.println("Lista de produtos está vazia.");
            sleep(1500);
            limpa();
        }
        else
        {
            limpa();
            tela.produtosConsultar();

            System.out.printf("Digite o nome que deseja procurar ou \"ENTER\" para ver todos\n\t-->\t");
            String nomeProOuTodos = ler.nextLine();

            if (nomeProOuTodos.isBlank())
            {
                System.out.println("");
                for (Produto p : listaProdutos) {
                    System.out.println(p + "\n");
                }
            }
            else
            {
                boolean acheiNome = false;
                for (Produto p : listaProdutos) {
                    if (p.getNome().contains(nomeProOuTodos))
                    {
                        acheiNome = true;
                        System.out.println("\n" + p + "\n");
                    }
                }
                if (acheiNome == false)
                {
                    System.out.println("\nProduto não encontrado !!!");
                }
            }

            System.out.printf("\n\n\nENTER para continuar:\t");
            String continuar = ler.nextLine();
            if (continuar.isBlank())
            {
                limpa();
            }
        }
    }

    public void removerProduto(Scanner ler, List<Produto> listaProdutos) throws InterruptedException, IOException {
        Telas tela = new Telas();

        limpa();
        tela.removerProduto();

        if (listaProdutos.isEmpty())
        {
            System.out.println("Lista de produtos está vazia.");
            sleep(1500);
            limpa();
        }
        else
        {
            int loop = -1;
            while (loop != 0)
            {
                if (listaProdutos.isEmpty())
                {
                    System.out.println("Lista de produtos está vazia.");
                    sleep(1500);
                    limpa();
                    break;
                }
                else
                {
                    limpa();
                    tela.removerProduto();
    
                    System.out.printf("Digite o código do produto (\"-1\" para sair):\t");
                    int codigoProcurar = 0;
                    codigoProcurar = verificaCod(ler, codigoProcurar);
                    if (codigoProcurar == -1)
                    {
                        break;
                    }
    
                    if (codigoProcurar == -1)
                    {
                        System.out.println("\nSaindo...");
                        sleep(1000);
                        limpa();
                        break;
                    }
                    else
                    {
                        boolean acheiCodigo = false;
                        for (Produto p : listaProdutos) {
                            if (p.getCodigo() == codigoProcurar)
                            {
                                acheiCodigo = true;
                                System.out.printf("\nProduto localizado: Nome: \"%s\". (\"S\" ou \"ENTER\" para remover, outro caractere volta a busca):\t ", p.getNome());
                                String opcaoSNestoque = ler.nextLine();
    
                                if (opcaoSNestoque.equalsIgnoreCase("S") || opcaoSNestoque.isBlank())
                                {
                                    listaProdutos.remove(p);
    
                                    System.out.println("\nProduto:");
                                    System.out.println(p);
                                    System.out.println("\n********** Removido com sucesso **********");
                                    System.out.printf("\n\n\nENTER para continuar:\t");
                                    String continuar = ler.nextLine();
                                    if (continuar.isBlank())
                                    {
                                        limpa();
                                        break;
                                    }
                                }
                                else
                                {
                                    System.out.println("\nOk, voltando...");
                                    sleep(1500);
                                    break;
                                }
                            }
                        }
                        if (acheiCodigo == false)
                        {
                            System.out.printf("\nCódigo %d não existe na lista.", codigoProcurar);
                            sleep(1000);
                            limpa();
                        }
                    }
                }
            }
        }
    }

    public void adicionaEstoque(Scanner ler, List<Produto> listaProdutos) throws InterruptedException, IOException {
        Telas tela = new Telas();

        limpa();
        tela.adicionaQtdEstoque();

        if (listaProdutos.isEmpty())
        {
            System.out.println("Lista de produtos está vazia.");
            sleep(1500);
            limpa();
        }
        else
        {
            int loop = -1;
            while (loop != 0)
            {
                limpa();
                tela.adicionaQtdEstoque();    

                System.out.printf("Digite o código do produto (\"-1\" para sair):\t");
                int codigoProcurar = 0;
                codigoProcurar = verificaCod(ler, codigoProcurar);
                if (codigoProcurar == -1)
                {
                    break;
                }

                if (codigoProcurar == -1)
                {
                    System.out.println("\nSaindo...");
                    sleep(1000);
                    limpa();
                    break;
                }
                else
                {
                    boolean acheiCodigo = false;
                    for (Produto p : listaProdutos) {
                        if (p.getCodigo() == codigoProcurar)
                        {
                            acheiCodigo = true;
                            System.out.printf("\nProduto localizado: Nome: \"%s\". (\"S\" ou \"ENTER\", outro caractere volta a busca):\t ", p.getNome());
                            String opcaoSNestoque = ler.nextLine();

                            if (opcaoSNestoque.equalsIgnoreCase("S") || opcaoSNestoque.isBlank())
                            {
                                System.out.printf("\nDigite quanto deseja adicionar ao estoque:\t");
                                int quantAdcEstoque;
                                try 
                                {
                                    quantAdcEstoque = ler.nextInt();
                                } 
                                catch (InputMismatchException e) 
                                {
                                    System.out.println("\nQuantidade que deseja adicionar só pode conter números !!!");
                                    ler.nextLine();
                
                                    System.out.printf("\n\n\nENTER para continuar:\t");
                                    String continuar = ler.nextLine();
                                    if (continuar.isBlank())
                                    {
                                        limpa();
                                    }
                                    break;
                                }

                                if (quantAdcEstoque == 0)
                                {
                                    limpa();
                                    System.out.println("\nImpossivel adicionar 0 !!!");
                                    sleep(1500);
                                    limpa();
                                    break;
                                }
                                else
                                {
                                    p.adicionaQuant(quantAdcEstoque);

                                    limpa();
                                    System.out.printf("\nFoi adicionado %d no estoque de %s.", quantAdcEstoque, p.getNome());
                                    sleep(2000);
                                    limpa();
                                }
                            }
                            else
                            {
                                System.out.println("\nOk, voltando...");
                                sleep(1500);
                                break;
                            }
                        }
                    }
                    if (acheiCodigo == false)
                    {
                        System.out.printf("\nCódigo %d não existe na lista.", codigoProcurar);
                        sleep(1000);
                        limpa();
                    }
                }
            }
        }
    }
    
    public int verificaCod (Scanner ler, int cod) throws InterruptedException, IOException {
        try
        {
            cod = ler.nextInt(); ler.nextLine();
            return cod;
        }
        catch (InputMismatchException e)
        {
            System.err.println("\nCódigo só pode conter números inteiros !!!");
            ler.nextLine();

            System.out.printf("\n\n\nENTER para continuar:\t");
            String continuar = ler.nextLine();
            if (continuar.isBlank())
            {
                limpa();
            }
        }
        return -1;
    }
    public static void sleep(int sleep) throws InterruptedException {
        Thread.sleep(sleep);
    }
    public static void limpa() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }  
}