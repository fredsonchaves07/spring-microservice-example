package com.fredsonchaves07.product.services;

import com.fredsonchaves07.product.dtos.ProdutoCriacaoDTO;
import com.fredsonchaves07.product.dtos.ProdutoDTO;
import com.fredsonchaves07.product.entities.Produto;
import com.fredsonchaves07.product.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repository;

    @Override
    public ProdutoDTO inserir(ProdutoCriacaoDTO produtoDTO) {
        Produto produto = repository.save(new Produto(produtoDTO.descricao(), produtoDTO.valor()));
        return new ProdutoDTO(produto.getId(), produto.getDescricao(), produto.getValor());
    }
}
