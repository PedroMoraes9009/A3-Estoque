/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 * Representa um produto com nome, preço, quantidade e categoria.
 */
public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private Categoria categoria;

    /**
     * Construtor da classe Produto.
     *
     * @param nome      Nome do produto.
     * @param preco     Preço do produto (deve ser >= 0).
     * @param quantidade Quantidade em estoque (deve ser >= 0).
     * @param categoria Categoria do produto.
     */
    public Produto(String nome, double preco, int quantidade, Categoria categoria) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio.");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não pode ser nula.");
        }

        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return String.format("%s - R$ %.2f - Qtde: %d - Categoria: %s",
                nome, preco, quantidade, categoria);
    }
}
