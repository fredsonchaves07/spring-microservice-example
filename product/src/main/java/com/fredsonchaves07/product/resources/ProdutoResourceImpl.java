package com.fredsonchaves07.product.resources;

import com.fredsonchaves07.product.dtos.ProdutoCriacaoDTO;
import com.fredsonchaves07.product.dtos.ProdutoDTO;
import com.fredsonchaves07.product.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("produto")
public class ProdutoResourceImpl implements ProdutoResource {

    @Autowired
    ProdutoService produtoService;

    @Override
    public ProdutoDTO inserir(@Valid @RequestBody ProdutoCriacaoDTO produtoDTO) {
        return produtoService.inserir(produtoDTO);
    }

    @Override
    public ProdutoDTO buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }
}
