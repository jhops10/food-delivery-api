package com.example.food_api.domain.exception;

import java.io.Serial;

public class EntidadeEmUsoException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }
}
