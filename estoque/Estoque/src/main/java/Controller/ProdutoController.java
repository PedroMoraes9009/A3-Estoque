package controller;

import model.Produto;
import model.Categoria;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(String nome, double preco, int qtd, Categoria categoria) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro: nome do produto inválido.");
            return;
        }
        if (preco < 0 || qtd < 0) {
            System.out.println("Erro: preço e quantidade devem ser não negativos.");
            return;
        }
        Produto novo = new Produto(nome, preco, qtd, categoria);
        produtos.add(novo);
        System.out.println("Produto adicionado com sucesso.");
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto buscarProdutoPorNome(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public boolean removerProduto(String nome) {
        Produto produto = buscarProdutoPorNome(nome);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto removido com sucesso.");
            return true;
        } else {
            System.out.println("Produto não encontrado.");
            return false;
        }
    }

    public boolean atualizarProduto(String nome, double novoPreco, int novaQtd) {
        Produto produto = buscarProdutoPorNome(nome);
        if (produto != null) {
            if (novoPreco >= 0) produto.setPreco(novoPreco);
            if (novaQtd >= 0) produto.setQuantidade(novaQtd);
            System.out.println("Produto atualizado com sucesso.");
            return true;
        } else {
            System.out.println("Produto não encontrado.");
            return false;
        }
    }
}
