package com.programming.new_javafx.db;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class dbConfig {

    private static Connection connection = null;

    public static Connection getConnection() {

        // Verificando se o drive existe.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new bdIntegrityException("Driver JDBC não encontrado" + e.getMessage());
        }

        // Tenta fazer a conexão com o Banco
        if (connection == null) {
            try {
                Properties properties = loadProperties(); // Carregando o SQL
                String url = properties.getProperty("dburl");
                connection = DriverManager.getConnection(url, properties.getProperty("user"),
                        properties.getProperty("password"));
            } catch (SQLException e) {
                throw new bdIntegrityException("Erro ao tentar acessar: " + e.getMessage());
            }
        }
        return connection;
    }
    // Fechando o Banco
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new bdIntegrityException("Ocorreu um erro ao fechar" + e.getMessage());
            }
        }
    }
    // Carregando o nosso properties
    private static Properties loadProperties() {
        try (FileInputStream fileInputStream = new FileInputStream(
            "C:\\Users\\Vivian\\Desktop\\parentes\\company\\New_JavaFX\\" +
                    "src\\main\\resources\\com\\programming\\new_javafx\\BD.properties"
        )) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        } catch (IOException e) {
            throw new bdIntegrityException("Falhou: " + e.getMessage());
        }
    }


    // MÉTODOS PARA FECHAR O STATEMENT E RESULTSET
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new bdIntegrityException(e.getMessage());
            }
        }

    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new bdIntegrityException(e.getMessage());
            }
        }
    }

}
