package Classes;

import java.time.LocalDate;

public class Venda {
    private LocalDate dataVenda;
    private int quantVendida;
    private Produto produto;

    public Venda(LocalDate dataVenda, int quantVendida, Produto produto) {
        setDataVenda(dataVenda);
        setQuantVendida(quantVendida);
        setProduto(produto);
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public double getValorTotal() {
        return produto.getValor() * quantVendida;
    }
    public LocalDate getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
    public int getQuantVendida() {
        return quantVendida;
    }
    public void setQuantVendida(int quantVendida) {
        this.quantVendida = quantVendida;
    }

    @Override
    public String toString() {
        return dataVenda + "\t\t\t" + produto.getNome() + "\t\t" + quantVendida;
    }
}