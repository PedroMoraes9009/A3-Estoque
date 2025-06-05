package View;

import dao.CategoriaDAO;
import model.Categoria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FrmListarCategoria extends JFrame {

    public FrmListarCategoria() {
        initComponents();
        carregarCategorias();
    }

    private void initComponents() {
        setTitle("Listar Categorias");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel titulo = new JLabel("Listar Categorias");
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 24));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        tabela = new JTable(new DefaultTableModel(new Object[]{"Nome", "Tamanho", "Embalagem"}, 0));
        JScrollPane scrollPane = new JScrollPane(tabela);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            new FrmMenu().setVisible(true);
            dispose();
        });

        setLayout(null);

        titulo.setBounds(180, 10, 240, 30);
        scrollPane.setBounds(30, 60, 520, 250);
        btnVoltar.setBounds(240, 320, 100, 30);

        add(titulo);
        add(scrollPane);
        add(btnVoltar);
    }

    private void carregarCategorias() {
        CategoriaDAO dao = new CategoriaDAO();
        List<Categoria> lista = dao.listar(); // Você deve implementar esse método se ainda não tiver

        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setRowCount(0);

        for (Categoria c : lista) {
            model.addRow(new Object[]{c.getNome(), c.getTamanho(), c.getEmbalagem()});
        }
    }

    private JTable tabela;

    public static void main(String[] args) {
        new FrmListarCategoria().setVisible(true);
    }
}
