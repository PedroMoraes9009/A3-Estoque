/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ProdutoController;
import model.Categoria;
import java.util.Scanner;

public class MenuView {
    private ProdutoController controller = new ProdutoController();
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> listarProdutos();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void cadastrarProduto() {
        System.out.print("Nome do produto: ");
        String nome = sc.nextLine();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();
        sc.nextLine();

        // Simples exemplo de categoria
        Categoria cat = new Categoria("Limpeza", "Médio", "Plástico");

        controller.adicionarProduto(nome, preco, qtd, cat);
    }

    private void listarProdutos() {
        var lista = controller.listarProdutos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (var p : lista) {
                System.out.println(p);
            }
        }
    }
}

