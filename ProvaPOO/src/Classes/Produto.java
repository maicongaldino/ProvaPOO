package Classes;

public class Produto {
    private int codigo;
    private String nome;
    private double valor;
    private int quantidade;

    public Produto (int codigo, String nome, double valor, int quantidade) {
        setCodigo(codigo);
        setNome(nome);
        setValor(valor);
        setQuantidade(quantidade);
    }
    public Produto() {}

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void removerQuant(int quant) {
        quantidade -= quant;
    }
    public void adicionaQuant(int quant) {
        quantidade += quant;
    }

    @Override
    public String toString() {
        return "Nome  =  " + nome + "\nCódigo  =  " + codigo + "\nValor  =  " + valor + " R$" + "\nQuantidade  =  " + quantidade;
    }
}