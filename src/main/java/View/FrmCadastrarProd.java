package View;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Produto;

public class FrmCadastrarProd extends javax.swing.JFrame {

    public FrmCadastrarProd() {
        initComponents();
        configurarBotaoCadastrar();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JBVoltarCadProd = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        TXTNomeProd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TXTPrecoProd = new javax.swing.JTextField();
        TXTCadegoriaProd = new javax.swing.JTextField();
        TXTTamanhoProd = new javax.swing.JTextField();
        TXTEmbalagemProd = new javax.swing.JTextField();
        JBCadastrarItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setText("Cadastrar Produto");

        JBVoltarCadProd.setText("Voltar");
        JBVoltarCadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarCadProdActionPerformed(evt);
            }
        });

        TXTNomeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTNomeProdActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");
        jLabel3.setText("Preço:");
        jLabel4.setText("Categoria:");
        jLabel5.setText("Tamanho:");
        jLabel6.setText("Embalagem:");

        TXTTamanhoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTTamanhoProdActionPerformed(evt);
            }
        });

        JBCadastrarItem.setFont(new java.awt.Font("Segoe UI", 1, 15));
        JBCadastrarItem.setText("Cadastrar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TXTNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TXTPrecoProd)
                                .addComponent(TXTCadegoriaProd)
                                .addComponent(TXTTamanhoProd)
                                .addComponent(TXTEmbalagemProd))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addComponent(JBCadastrarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(7, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(TXTNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(TXTPrecoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(TXTCadegoriaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(TXTTamanhoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(TXTEmbalagemProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBCadastrarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(197, 197, 197)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                    .addComponent(JBVoltarCadProd)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(9, 9, 9)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(JBVoltarCadProd)
                    .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void JBVoltarCadProdActionPerformed(java.awt.event.ActionEvent evt) {
        FrmMenu menuEstoque = new FrmMenu();
        menuEstoque.setVisible(true);
        dispose();
    }

    private void TXTNomeProdActionPerformed(java.awt.event.ActionEvent evt) {
        // nada
    }

    private void TXTTamanhoProdActionPerformed(java.awt.event.ActionEvent evt) {
        // nada
    }

    private void configurarBotaoCadastrar() {
        JBCadastrarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    String nome = TXTNomeProd.getText();
                    double preco = Double.parseDouble(TXTPrecoProd.getText());
                    String tamanho = TXTTamanhoProd.getText();
                    String embalagem = TXTEmbalagemProd.getText();
                    String nomeCategoria = TXTCadegoriaProd.getText();

                    Categoria cat = new Categoria(nomeCategoria, tamanho, embalagem);
                    CategoriaDAO catDAO = new CategoriaDAO();
                    Categoria categoriaInserida = catDAO.inserir(cat);

                    if (categoriaInserida != null) {
                        Produto p = new Produto(nome, preco, 0, categoriaInserida);
                        ProdutoDAO prodDAO = new ProdutoDAO();
                        prodDAO.inserir(p);
                        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar categoria.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
            }
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmCadastrarProd().setVisible(true);
        });
    }

    // Declarações dos componentes
    private javax.swing.JButton JBCadastrarItem;
    private javax.swing.JButton JBVoltarCadProd;
    private javax.swing.JTextField TXTCadegoriaProd;
    private javax.swing.JTextField TXTEmbalagemProd;
    private javax.swing.JTextField TXTNomeProd;
    private javax.swing.JTextField TXTPrecoProd;
    private javax.swing.JTextField TXTTamanhoProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
}
