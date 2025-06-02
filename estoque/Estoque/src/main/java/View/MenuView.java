package view;

import controller.ProdutoController;
import model.Categoria;

import java.util.Scanner;

public class MenuView {
    private final ProdutoController controller = new ProdutoController();
    private final Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("0. Sair");
            opcao = lerInt("Escolha: ");

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> listarProdutos();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }

    private void cadastrarProduto() {
        System.out.println("\n--- CADASTRO DE PRODUTO ---");
        String nome = lerLinha("Nome do produto: ");
        double preco = lerDouble("Preço: ");
        int qtd = lerInt("Quantidade: ");

        String nomeCat = lerLinha("Nome da categoria: ");
        String tamanho = lerLinha("Tamanho (Pequeno/Médio/Grande): ");
        String embalagem = lerLinha("Embalagem (Lata/Vidro/Plástico): ");

        if (!validarTamanho(tamanho) || !validarEmbalagem(embalagem)) {
            System.out.println("Tamanho ou embalagem inválidos.");
            return;
        }

        Categoria categoria = new Categoria(nomeCat, tamanho, embalagem);
        controller.adicionarProduto(nome, preco, qtd, categoria);
        System.out.println("Produto cadastrado com sucesso.");
    }

    private void listarProdutos() {
        var lista = controller.listarProdutos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("\n--- LISTA DE PRODUTOS ---");
            for (var produto : lista) {
                System.out.println(produto);
            }
        }
    }

    // ========= UTILIDADES DE ENTRADA =========

    private String lerLinha(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine().trim();
    }

    private int lerInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número decimal válido.");
            }
        }
    }

    private boolean validarTamanho(String tamanho) {
        return tamanho.equalsIgnoreCase("Pequeno") ||
               tamanho.equalsIgnoreCase("Médio") ||
               tamanho.equalsIgnoreCase("Grande");
    }

    private boolean validarEmbalagem(String embalagem) {
        return embalagem.equalsIgnoreCase("Lata") ||
               embalagem.equalsIgnoreCase("Vidro") ||
               embalagem.equalsIgnoreCase("Plástico");
    }
}
