/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Produto;
import model.Categoria;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(String nome, double preco, int qtd, Categoria categoria) {
        Produto novo = new Produto(nome, preco, qtd, categoria);
        produtos.add(novo);
        System.out.println("Produto adicionado com sucesso.");
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }
}

