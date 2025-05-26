/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private Categoria categoria;

    public Produto(String nome, double preco, int quantidade, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }
    public Categoria getCategoria() { return categoria; }

    @Override
    public String toString() {
        return nome + " - R$" + preco + " - Qtde: " + quantidade + " - Categoria: " + categoria;
    }
}


