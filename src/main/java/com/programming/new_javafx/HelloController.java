package com.programming.new_javafx;

import com.programming.new_javafx.db.dbConfig;
import com.programming.new_javafx.dbDAO.DAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;


public class HelloController {

    @FXML
    private Button registrar;

    @FXML
    private TextField nome;

    @FXML
    private TextField email;

    public void onBntAction() {
        Connection connection = dbConfig.getConnection();
        DAO dao = new DAO(connection);
        String nomeField = nome.getText();
        String emailFiel = email.getText();
        dao.creatData(nomeField, emailFiel);
    }

}