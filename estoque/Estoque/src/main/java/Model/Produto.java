package model;

/**
 * Representa um produto com nome, preço, quantidade em estoque e categoria.
 */
public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private Categoria categoria;

    public Produto(String nome, double preco, int quantidade, Categoria categoria) {
        if (preco < 0) throw new IllegalArgumentException("Preço não pode ser negativo.");
        if (quantidade < 0) throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public double calcularTotal() {
        return preco * quantidade;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        }
    }

    public void removerEstoque(int quantidade) {
        if (quantidade > 0 && this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade para remover inválida.");
        }
    }

    public void aplicarDesconto(double percentual) {
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Percentual de desconto inválido.");
        }
        preco -= preco * (percentual / 100);
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }
    public Categoria getCategoria() { return categoria; }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + String.format("%.2f", preco) + " (" + quantidade + " unidades)";
    }
}
