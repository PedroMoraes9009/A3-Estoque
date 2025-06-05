package View;

import dao.ProdutoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Produto;

public class FrmListarProd extends javax.swing.JFrame {

    public FrmListarProd() {
        initComponents();
        carregarProdutosNaTabela();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JBVoltarListarProd = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableListarProd = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setText("Listar Produtos");

        JBVoltarListarProd.setText("Voltar");
        JBVoltarListarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarListarProdActionPerformed(evt);
            }
        });

        JTableListarProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Nome", "Preço", "Categoria", "Tamanho", "Embalagem"
            }
        ));
        jScrollPane1.setViewportView(JTableListarProd);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                    .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(203, 203, 203)
                    .addComponent(jLabel1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(JBVoltarListarProd)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(JBVoltarListarProd)
                    .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void JBVoltarListarProdActionPerformed(java.awt.event.ActionEvent evt) {
        FrmMenu menuEstoque = new FrmMenu();
        menuEstoque.setVisible(true);
        dispose();
    }

    private void carregarProdutosNaTabela() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.listar();

        DefaultTableModel modelo = (DefaultTableModel) JTableListarProd.getModel();
        modelo.setRowCount(0);

        for (Produto p : lista) {
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getPreco(),
                p.getCategoria().getNome(),
                p.getCategoria().getTamanho(),
                p.getCategoria().getEmbalagem()
            });
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmListarProd().setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JButton JBVoltarListarProd;
    private javax.swing.JTable JTableListarProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration
}
