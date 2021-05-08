package Classes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Telas.Telas;

public class Relatorios {
    public void produto(Scanner ler, List<Produto> listaProdutos) throws InterruptedException, IOException {
        Telas tela = new Telas();

        limpa();
        tela.listarProdutos();
        if (listaProdutos.isEmpty())
        {
            System.out.println("Lista de produtos está vazia.");
            sleep(1500);
            limpa();
        }
        else
        {
            System.out.printf("|%-25.25s|\t%-25.25s|\t%-25.25s|\t%-15.15s|\n", "Código", "Produto", "Valor (R$)", "Quantidade");
            System.out.printf("|--------------------------------------------------------------------------------------------------------------|\n");
            for (Produto p : listaProdutos) {
                System.out.printf("|%-25.25s|\t%-25.25s|\t%-25.25s|\t%-15.15s|\n", p.getCodigo(), p.getNome(), p.getValor(), p.getQuantidade());
            }
            System.out.printf("|--------------------------------------------------------------------------------------------------------------|\n");
            DoubleSummaryStatistics dados = listaProdutos.stream()
            .collect(Collectors.summarizingDouble(Produto::getValor));
            System.out.printf("  Valor mínimo: %.2f\t\tValor máximo: %.2f\t\tValor médio: %.2f", dados.getMin(), dados.getMax(), dados.getAverage());

            System.out.printf("\n\n\nENTER para continuar:\t");
            String continuar = ler.nextLine();
            if (continuar.isBlank())
            {
                limpa();
            }
        }
    }
    public void vendasPeriodoDe(Scanner ler, List<Venda> listaVendas) throws InterruptedException, IOException {
        Telas tela = new Telas();
        
        limpa();
        tela.vendasPeriodoDeImprimir();
        if (listaVendas.isEmpty())
        {
            System.out.println("Nenhum venda feita.");
            sleep(1500);
            limpa();
        }
        else
        {
            int loop = -1;
            while (loop != 0)
            {
                limpa();
                tela.vendasPeriodoDeImprimir();
                String dataInicial;
                System.out.printf("Digite a data inicial (\"ENTER\" para a de hoje) ou \"SAIR\", parar:\t");
                dataInicial = ler.nextLine();
                if (dataInicial.equalsIgnoreCase("SAIR"))
                {
                    break;
                }
                else
                {
                    if (dataV(dataInicial) == false)
                    {
                        System.out.println("\nData inválida, formato certo (dd/mm/aaaa)");
                        sleep(2000);
                        limpa();
                    }
                    else
                    {
                        if (dataInicial.isBlank())
                        {
                            DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            dataInicial = formataData.format(LocalDateTime.now());

                            System.out.printf("\nDigite a data final (\"ENTER\" para a de hoje):\t");
                            String dataFinal = ler.nextLine();
                            if (dataV(dataFinal) == false)
                            {
                                limpa();
                                tela.vendasPeriodoDeImprimir();
                                System.out.println("Data inválida, formato certo (dd/mm/aaaa)");
                                sleep(2000);
                                limpa();
                            }
                            else
                            {
                                if (dataFinal.isBlank())
                                {
                                    dataFinal = formataData.format(LocalDateTime.now());

                                    ralatorioVendasDe(listaVendas, dataInicial, dataFinal);
    
                                    System.out.printf("\n\n\nENTER para continuar:\t");
                                    String continuarVendasPe = ler.nextLine();
                                    if (continuarVendasPe.isBlank())
                                    {
                                        limpa();
                                        break;
                                    }
                                }
                                else
                                {
                                    ralatorioVendasDe(listaVendas, dataInicial, dataFinal);
    
                                    System.out.printf("\n\n\nENTER para continuar:\t");
                                    String continuarVendasPe = ler.nextLine();
                                    if (continuarVendasPe.isBlank())
                                    {
                                        limpa();
                                        break;
                                    }
                                }
                            }
                        }
                        else
                        {
                            System.out.printf("\nDigite a data final (\"ENTER\" para a de hoje):\t");
                            String dataFinal = ler.nextLine();
                            if (dataV(dataFinal) == false)
                            {
                                limpa();
                                System.out.println("Data inválida, formato certo (dd/mm/aaaa)");
                                sleep(2000);
                                limpa();
                            }
                            else
                            {
                                if (dataFinal.isBlank())
                                {
                                    DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    dataFinal = formataData.format(LocalDateTime.now());

                                    ralatorioVendasDe(listaVendas, dataInicial, dataFinal);
    
                                    System.out.printf("\n\n\nENTER para continuar:\t");
                                    String continuarVendasPe = ler.nextLine();
                                    if (continuarVendasPe.isBlank())
                                    {
                                        limpa();
                                        break;
                                    }
                                }
                                else
                                {
                                    ralatorioVendasDe(listaVendas, dataInicial, dataFinal);
    
                                    System.out.printf("\n\n\nENTER para continuar:\t");
                                    String continuarVendasPe = ler.nextLine();
                                    if (continuarVendasPe.isBlank())
                                    {
                                        limpa();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void vendasPeriodoConso (Scanner ler, List<Venda> listaVendas) throws InterruptedException, IOException {
        Telas tela = new Telas();

        limpa();
        tela.vendasPeriodoConsoImprimir();
        
        if (listaVendas.isEmpty())
        {
            System.out.println("Nenhum venda feita.");
            sleep(1500);
            limpa();
        }
        else
        {
            int loop = -1;
            while (loop != 0)
            {
                limpa();
                tela.vendasPeriodoConsoImprimir();
                String dataProcurar;
                System.out.printf("Digite a data inicial (\"ENTER\" para a de hoje) ou \"SAIR\", parar:\t");
                dataProcurar = ler.nextLine();
                if (dataProcurar.equalsIgnoreCase("SAIR"))
                {
                    break;
                }
                else
                {
                    if (dataV(dataProcurar) == false)
                    {
                        System.out.println("\nData inválida, formato certo (dd/mm/aaaa)");
                        sleep(2000);
                        limpa();
                    }
                    else
                    {
                        if (dataProcurar.isBlank())
                        {
                            DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            dataProcurar = formataData.format(LocalDateTime.now());

                            ralatorioVendasConso(listaVendas, dataProcurar);
    
                            System.out.printf("\n\n\nENTER para continuar:\t");
                            String continuarVendasPe = ler.nextLine();
                            if (continuarVendasPe.isBlank())
                            {
                                limpa();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private void ralatorioVendasDe(List<Venda> listaVendas, String dataInicial, String dataFinal) throws InterruptedException, IOException {
        Telas tela = new Telas();

        limpa();
        tela.vendasPeriodoDeImprimir();
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("Periodo de vendas de %s a %s\n\n", dataInicial, dataFinal);

        List<Venda> vendasPeriodo = listaVendas.stream()
            .filter(p -> {
                Venda venda = (Venda)p;
                return (venda.getDataVenda().isEqual(LocalDate.parse(dataInicial, formataData)) || venda.getDataVenda().isEqual(LocalDate.parse(dataFinal, formataData))) || (venda.getDataVenda().isBefore(LocalDate.parse(dataFinal, formataData)) && venda.getDataVenda().isAfter(LocalDate.parse(dataInicial, formataData)));
            }).collect(Collectors.toList());
                  
        System.out.printf("|%-25.25s|\t%-30.30s|\t%-20.20s|\t%-20.20s|\t%-20.20s|\n", "Data", "Produto", "Quantidade", "Valor (R$)", "Valor total (R$)");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------|");
        for (Venda venda : vendasPeriodo) {
            System.out.printf("|%-25.25s|\t%-30.30s|\t%-20.20s|\t%-20.20s|\t%-20.20s|\n", venda.getDataVenda().format(formataData), venda.getProduto().getNome(), venda.getQuantVendida(), venda.getProduto().getValor(), venda.getValorTotal());
        }
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------|");
        DoubleSummaryStatistics dadosVendas = vendasPeriodo.stream()
        .collect(Collectors.summarizingDouble(Venda::getValorTotal));
        System.out.printf("  Valor médio desse período: %.2f", dadosVendas.getAverage());
    }

    private void ralatorioVendasConso(List<Venda> listaVendas, String dataProcurar) throws InterruptedException, IOException {
        Telas tela = new Telas();
        limpa();
        tela.vendasPeriodoConsoImprimir();
        
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("Vendas do dia %s\n\n", dataProcurar);

        List<Venda> vendasPeriodo = listaVendas.stream()
            .filter(p -> {
                Venda venda = (Venda)p;
                return (venda.getDataVenda().isEqual(LocalDate.parse(dataProcurar, formataData)));
            }).collect(Collectors.toList());

        IntSummaryStatistics quantTotalVendida = vendasPeriodo.stream()
            .collect(Collectors.summarizingInt(Venda::getQuantVendida));

        DoubleSummaryStatistics valorTotalVendido = vendasPeriodo.stream()
            .collect(Collectors.summarizingDouble(Venda::getValorTotal));

        System.out.printf("|%-25.25s|\t%-30.30s|\t%-20.20s|\n", "Data", "Quantidade total vendida", "Valor total vendido (R$)");
        System.out.println("|-----------------------------------------------------------------------------------|");
        System.out.printf("|%-25.25s|\t%-30.30s|\t%-20.20s|\n", dataProcurar, quantTotalVendida.getSum(), valorTotalVendido.getSum());

        System.out.println("|-----------------------------------------------------------------------------------|");
        DoubleSummaryStatistics maiorVendaFeita = vendasPeriodo.stream()
            .collect(Collectors.summarizingDouble(Venda::getValorTotal));
        System.out.printf("  Maior venda feita: %.2f", maiorVendaFeita.getMax());
    }
    
    public boolean dataV(String data) {
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
    public void sleep(int sleep) throws InterruptedException {
        Thread.sleep(sleep);
    }
    public void limpa() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } 
}