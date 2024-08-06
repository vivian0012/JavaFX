package com.programming.new_javafx.db;

import java.io.Serial;

// Criando a própria exceção para o BD
public class bdIntegrityException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public bdIntegrityException(String msg) {
        super(msg);
    }
}
