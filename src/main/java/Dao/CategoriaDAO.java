/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import model.Categoria;
import java.sql.*;

public class CategoriaDAO {

    private static final String INSERT_SQL = 
        "INSERT INTO categoria (nome, tamanho, embalagem) VALUES (?, ?, ?)";

    /**
     * Insere uma nova categoria no banco de dados.
     *
     * @param categoria Objeto Categoria com os dados a serem inseridos.
     * @return Categoria com o ID gerado após a inserção, ou null em caso de falha.
     */
    public Categoria inserir(Categoria categoria) {
        if (categoria == null) {
            System.err.println("Categoria não pode ser nula.");
            return null;
        }

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            preencherParametros(stmt, categoria);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                System.err.println("Nenhuma linha foi inserida.");
                return null;
            }

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    categoria.setId(rs.getInt(1));
                } else {
                    System.err.println("Falha ao obter o ID gerado.");
                    return null;
                }
            }

            return categoria;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir categoria: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Preenche os parâmetros do PreparedStatement com os dados da categoria.
     *
     * @param stmt PreparedStatement com os parâmetros a preencher.
     * @param categoria Objeto Categoria com os dados.
     * @throws SQLException Se ocorrer erro ao definir os parâmetros.
     */
    private void preencherParametros(PreparedStatement stmt, Categoria categoria) throws SQLException {
        stmt.setString(1, categoria.getNome());
        stmt.setString(2, categoria.getTamanho());
        stmt.setString(3, categoria.getEmbalagem());
    }
}
