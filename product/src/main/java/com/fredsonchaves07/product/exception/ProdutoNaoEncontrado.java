package com.fredsonchaves07.product.exception;

public class ProdutoNaoEncontrado extends RuntimeException{

    private static final String message = "Produto não encontrado";

    public ProdutoNaoEncontrado() {
        super(message);
    }
}
