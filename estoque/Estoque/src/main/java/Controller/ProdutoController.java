/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProdutoDAO;
import dao.CategoriaDAO;
import model.Produto;
import model.Categoria;
import java.util.List;

public class ProdutoController {
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private CategoriaDAO categoriaDAO = new CategoriaDAO();

    public void adicionarProduto(String nome, double preco, int qtd, Categoria categoria) {
        categoria = categoriaDAO.inserir(categoria);
        Produto novo = new Produto(nome, preco, qtd, categoria);
        produtoDAO.inserir(novo);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.listar();
    }
}

