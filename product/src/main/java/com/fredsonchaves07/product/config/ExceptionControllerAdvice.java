package com.fredsonchaves07.product.config;

import com.fredsonchaves07.product.exception.ProdutoNaoEncontrado;
import com.fredsonchaves07.product.resources.exception.ErroPadrao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ProdutoNaoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroPadrao erroPadrao(ProdutoNaoEncontrado produtoNaoEncontrado) {
        return new ErroPadrao("ProdutoNaoEncontrado", produtoNaoEncontrado.getMessage(), null);
    }
}
