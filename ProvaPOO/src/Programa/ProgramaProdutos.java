package Programa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classes.CadastroProdutos;
import Classes.Produto;
import Classes.RegistroVendas;
import Classes.Relatorios;
import Classes.Venda;
import Telas.Telas;

public class ProgramaProdutos {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner ler = new Scanner (System.in);

        List<Produto> listaProdutos = new ArrayList<Produto>();
        List<Venda> listaVendas = new ArrayList<Venda>();

        CadastroProdutos cp = new CadastroProdutos();
        Relatorios rela = new Relatorios();
        RegistroVendas rv = new RegistroVendas();

        Telas tela = new Telas();

        int opcaoMenu;

        limpa();

        do
        {
            opcaoMenu = tela.exibirMenuPrincipal(ler);
            ler.nextLine();

            switch (opcaoMenu)
            {
                case 1:
                    int opcaoCadastro;
                    do
                    {
                        limpa();
                        opcaoCadastro = tela.cadastroDeProdutos(ler);
                        ler.nextLine();
    
                        switch (opcaoCadastro)
                        {
                            case 1:
                                cp.ConsultaProduto(ler, listaProdutos);
                            break;
                            case 2:
                                cp.CadastrarProdutos(ler, listaProdutos);
                            break;
                            case 3:
                                cp.removerProduto(ler, listaProdutos);
                            break;
                            case 4:
                                cp.adicionaEstoque(ler, listaProdutos);
                            break;
                            case 0:
                                limpa();
                                System.out.println("Voltando ao menu anterior...");
                                sleep(1000);
                                limpa();
                            break;
                            default:
                                limpa();
                                System.out.println("Opção inválida !!!");
                                sleep(1000);
                                limpa();
                            break;
                        }
                    } while(opcaoCadastro != 0);
                break;
                case 2:
                    int opcaoRelatorio;
                    do
                    {
                        limpa();
                        opcaoRelatorio = tela.relatorios(ler);
                        ler.nextLine();
    
                        switch (opcaoRelatorio)
                        {
                            case 1:
                                rela.produto(ler, listaProdutos);
                            break;
                            case 2:
                                rela.vendasPeriodoDe(ler, listaVendas);
                            break;
                            case 3:
                                rela.vendasPeriodoConso(ler, listaVendas);
                            break;  
                            case 0:
                                limpa();
                                System.out.println("Voltando ao menu...");
                                sleep(1000);
                                limpa();
                            break;
                            default:
                                limpa();
                                System.out.println("Opção inválida !!!");
                                sleep(800);
                                limpa();
                            break;
                        }
                    }while (opcaoRelatorio != 0);
                break;
                case 3:
                    rv.registrarVendas(ler, listaProdutos, listaVendas);
                break;
                case 0:
                    limpa();
                    System.out.println("Encerrando o programa...");
                    sleep(1500);
                    limpa();
                break;
                default:
                    limpa();
                    System.out.println("Opção inválida, saindo...");
                    sleep(1500);
                    limpa();
                break;
            }
        } while (opcaoMenu != 0);
        ler.close();
    }

    public static void sleep(int sleep) throws InterruptedException {
        Thread.sleep(sleep);
    }
    public static void limpa() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}