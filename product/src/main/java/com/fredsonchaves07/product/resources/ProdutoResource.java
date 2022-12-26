package com.fredsonchaves07.product.resources;

import com.fredsonchaves07.product.dtos.ProdutoCriacaoDTO;
import com.fredsonchaves07.product.dtos.ProdutoDTO;
import com.fredsonchaves07.product.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produto")
public class ProdutoResource {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ProdutoDTO inserir(@RequestBody ProdutoCriacaoDTO produtoDTO) {
        return produtoService.inserir(produtoDTO);
    }
}
