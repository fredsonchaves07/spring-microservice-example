package com.fredsonchaves07.product.services;

import com.fredsonchaves07.product.dtos.ProdutoCriacaoDTO;
import com.fredsonchaves07.product.dtos.ProdutoDTO;
import com.fredsonchaves07.product.entities.Produto;
import com.fredsonchaves07.product.exception.ProdutoNaoEncontrado;
import com.fredsonchaves07.product.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repository;

    @Override
    public ProdutoDTO inserir(ProdutoCriacaoDTO produtoDTO) {
        Produto produto = repository.save(new Produto(produtoDTO.descricao(), produtoDTO.valor()));
        return new ProdutoDTO(produto.getId(), produto.getDescricao(), produto.getValor());
    }

    @Override
    public ProdutoDTO buscarPorId(Long id) {
        Optional<Produto> produto = repository.findById(id);
        if (produto.isEmpty()) throw new ProdutoNaoEncontrado();
        return new ProdutoDTO(produto.get().getId(), produto.get().getDescricao(), produto.get().getValor());
    }
}
