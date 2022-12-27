package com.fredsonchaves07.product.resources.exception;

import org.springframework.lang.NonNull;

import java.util.Objects;

public record ErroPadrao(@NonNull  String codigo, @NonNull String mensagem, String url) {

    public ErroPadrao(@NonNull String codigo, @NonNull String mensagem, String url) {
        this.codigo = Objects.requireNonNull(codigo);
        this.mensagem = Objects.requireNonNull(mensagem);
        this.url = url;
    }
}
