package View;

import dao.CategoriaDAO;
import javax.swing.JOptionPane;
import model.Categoria;

public class FrmCadastrarCategoria extends javax.swing.JFrame {

    public FrmCadastrarCategoria() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastrar Categoria");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jLabel1 = new javax.swing.JLabel("Cadastrar Categoria");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));

        jLabelNome = new javax.swing.JLabel("Nome:");
        jLabelTamanho = new javax.swing.JLabel("Tamanho:");
        jLabelEmbalagem = new javax.swing.JLabel("Embalagem:");

        txtNome = new javax.swing.JTextField();
        txtTamanho = new javax.swing.JTextField();
        txtEmbalagem = new javax.swing.JTextField();

        btnCadastrar = new javax.swing.JButton("Cadastrar");
        btnVoltar = new javax.swing.JButton("Voltar");

        btnCadastrar.addActionListener(e -> cadastrarCategoria());
        btnVoltar.addActionListener(e -> {
            new FrmMenu().setVisible(true);
            dispose();
        });

        setLayout(null);

        jLabel1.setBounds(80, 10, 300, 30);
        jLabelNome.setBounds(30, 60, 80, 20);
        txtNome.setBounds(120, 60, 200, 25);
        jLabelTamanho.setBounds(30, 100, 80, 20);
        txtTamanho.setBounds(120, 100, 200, 25);
        jLabelEmbalagem.setBounds(30, 140, 80, 20);
        txtEmbalagem.setBounds(120, 140, 200, 25);
        btnCadastrar.setBounds(60, 190, 120, 30);
        btnVoltar.setBounds(200, 190, 120, 30);

        add(jLabel1);
        add(jLabelNome);
        add(txtNome);
        add(jLabelTamanho);
        add(txtTamanho);
        add(jLabelEmbalagem);
        add(txtEmbalagem);
        add(btnCadastrar);
        add(btnVoltar);
    }

    private void cadastrarCategoria() {
        String nome = txtNome.getText().trim();
        String tamanho = txtTamanho.getText().trim();
        String embalagem = txtEmbalagem.getText().trim();

        if (nome.isEmpty() || tamanho.isEmpty() || embalagem.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }

        Categoria cat = new Categoria(nome, tamanho, embalagem);
        CategoriaDAO dao = new CategoriaDAO();

        if (dao.inserir(cat) != null) {
            JOptionPane.showMessageDialog(this, "Categoria cadastrada com sucesso!");
            txtNome.setText("");
            txtTamanho.setText("");
            txtEmbalagem.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar categoria.");
        }
    }

    private javax.swing.JLabel jLabel1, jLabelNome, jLabelTamanho, jLabelEmbalagem;
    private javax.swing.JTextField txtNome, txtTamanho, txtEmbalagem;
    private javax.swing.JButton btnCadastrar, btnVoltar;

    public static void main(String[] args) {
        new FrmCadastrarCategoria().setVisible(true);
    }
}
