package com.programming.new_javafx.dbDAO;

import com.programming.new_javafx.db.dbConfig;

import java.sql.*;

// É a persistência de dados. "Data Access Object"
public class DAO {

    private Connection connection = null;
    public DAO(Connection connection) {
        this.connection = connection;
    }

    // Criando um usuário:
    public void creatData(String name, String email) {
        PreparedStatement ps = null;
        try {
            String sql = ("INSERT INTO registro (name, email) VALUES (?, ?)");
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
        }catch (SQLException e) {
            System.out.println("ERRO AO ATUALIZAR OS DADOS: " + e.getMessage());
        } finally {
            dbConfig.closeStatement(ps); // Fechar o PreparedStatement
            dbConfig.closeConnection(); // Fechar a conexão (se necessário)
        }
    }

    // Lendo um usuário:
    public void MostraTabela(){
    Statement comando = null;
    ResultSet resultado = null;
    String registro = "select * from registro";

    try {
        comando = connection.createStatement();
        comando.executeQuery(registro);

        } catch (SQLException e) {
        System.out.println("ERRO AO ATUALIZAR OS DADOS: " + e.getMessage());
    } finally {
            dbConfig.closeResultSet(resultado);
            dbConfig.closeStatement(comando);
        }
    }
}
