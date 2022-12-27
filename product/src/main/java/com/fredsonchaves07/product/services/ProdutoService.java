package com.fredsonchaves07.product.services;

import com.fredsonchaves07.product.dtos.ProdutoCriacaoDTO;
import com.fredsonchaves07.product.dtos.ProdutoDTO;

public interface ProdutoService {

    ProdutoDTO inserir(ProdutoCriacaoDTO produtoDTO);

    ProdutoDTO buscarPorId(Long id);
}
