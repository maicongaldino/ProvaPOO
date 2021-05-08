package Classes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Telas.Telas;

public class RegistroVendas {
    public void registrarVendas(Scanner ler,List<Produto> listaProdutos, List<Venda> listaVendas) throws InterruptedException, IOException {
        Telas tela = new Telas();

        limpa();

        if (listaProdutos.isEmpty())
        {
            tela.registroVendas();

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
                tela.registroVendas();

                System.out.printf("Digite o código do produto (\"-1\" para sair):\t");
                int codigoVenda = ler.nextInt();
                ler.nextLine();
                if (codigoVenda == -1)
                {
                    System.out.println("\nSaindo...");
                    sleep(1000);
                    limpa();
                    break;
                }
                else
                {
                    boolean temCodigo = false;
                    for (Produto p : listaProdutos) {
                        if (p.getCodigo() == codigoVenda)
                        {
                            temCodigo = true;
                            System.out.printf("\nProduto localizado: Nome: \"%s\". (\"S\" ou \"ENTER\", outro caractere volta a busca):\t ", p.getNome());
                            String opcaoSNvenda = ler.nextLine();

                            if (p.getQuantidade() > 0)
                            {
                                if (opcaoSNvenda.equalsIgnoreCase("S") || opcaoSNvenda.isBlank())
                                {
                                    System.out.printf("\nDigite a data [dd/mm/aaaa] ou \"ENTER\" para a data de hoje:\t");
                                    String dataHoje = ler.nextLine();
                                    if (dataHoje.isBlank())
                                    {
                                        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        String dataHojeAuto = formataData.format(LocalDateTime.now());
                                        System.out.printf("\nDigite a quantidade:\t");
                                        int quantidadeVenda = ler.nextInt();
                                        if (quantidadeVenda <= p.getQuantidade())
                                        {
                                            if (quantidadeVenda == 0)
                                            {
                                                System.out.println("\nImpossivel comprar 0 produtos !!!");
                                                sleep(2000);
                                                limpa();
                                            }
                                            else
                                            {
                                                Venda venda = new Venda(LocalDate.parse(dataHojeAuto, formataData), quantidadeVenda, p);
                                                listaVendas.add(venda);
                                                p.removerQuant(quantidadeVenda);

                                                limpa();
                                                System.out.println("Venda efetuada com sucesso !!!");
                                                sleep(1000);
                                                limpa();
                                                break;
                                            }
                                        }
                                        else
                                        {
                                            limpa();
                                            System.out.println("Impossivel efetuar venda, sem estoque !!!");
                                            sleep(1000);
                                            limpa();
                                            break;
                                        }
                                    }
                                    else
                                    {
                                        if (dataV(dataHoje) == true)
                                        {
                                            DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                            System.out.printf("\nDigite a quantidade:\t");
                                            int quantidadeVenda = ler.nextInt();
                                            if (quantidadeVenda <= p.getQuantidade())
                                            {
                                                if (quantidadeVenda == 0)
                                                {
                                                    System.out.println("\nImpossivel comprar 0 produtos !!!");
                                                    sleep(2000);
                                                    limpa();
                                                }
                                                else
                                                {
                                                    Venda venda = new Venda(LocalDate.parse(dataHoje, formataData), quantidadeVenda, p);
                                                    listaVendas.add(venda);
                                                    p.removerQuant(quantidadeVenda);

                                                    limpa();
                                                    System.out.println("\nVenda efetuada com sucesso !!!");
                                                    sleep(1000);
                                                    limpa();
                                                    break;
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("\nImpossivel efetuar venda, sem estoque !!!");
                                                sleep(1000);
                                                limpa();
                                                break;
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("\nData inválida, formato certo (dd/mm/aaaa)");
                                            sleep(2000);
                                            limpa();
                                        }
                                    }
                                }
                                else
                                {
                                    System.out.println("\nOk, voltando...");
                                    sleep(1000);
                                    break;
                                }
                            }
                            else
                            {
                                System.out.println("\nSem estoque, impossivel compra !!!");
                                sleep(1500);
                                limpa();
                                break;
                            }
                        }
                    }
                    if (temCodigo == false)
                    {
                        System.out.printf("\nCódigo %d não existe na lista.", codigoVenda);
                        sleep(1000);
                        limpa();
                    }
                }
            }
        }
    }

    public static boolean dataV(String data) {
        if(data.matches("\\d{2}/\\d{2}/\\d{4}")){
            try
            {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                sdf.parse(data);
                return true;
            }
            catch (ParseException ex) {
                return false;
            }
        }
        else if (data.isBlank())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void sleep(int sleep) throws InterruptedException {
        Thread.sleep(sleep);
    }
    public static void limpa() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } 
}