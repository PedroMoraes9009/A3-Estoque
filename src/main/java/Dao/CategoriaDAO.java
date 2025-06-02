/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import model.Categoria;
import java.sql.*;

public class CategoriaDAO {

    /**
     * Insere uma nova categoria no banco de dados.
     * 
     * @param categoria Objeto Categoria com os dados a serem inseridos.
     * @return Categoria com o ID gerado após inserção, ou null em caso de falha.
     */
    public Categoria inserir(Categoria categoria) {
        String sql = "INSERT INTO categoria (nome, tamanho, embalagem) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getTamanho());
            stmt.setString(3, categoria.getEmbalagem());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        categoria.setId(rs.getInt(1));
                    }
                }
            } else {
                System.err.println("Nenhuma linha foi inserida.");
                return null;
            }

            return categoria;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir categoria: " + e.getMessage());
            e.printStackTrace(); // Opcional: mostra o stack trace completo
            return null;
        }
    }
}
