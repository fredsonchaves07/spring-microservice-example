package com.fredsonchaves07.product.resources;

import com.fredsonchaves07.product.dtos.ProdutoCriacaoDTO;
import com.fredsonchaves07.product.dtos.ProdutoDTO;
import com.fredsonchaves07.product.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoResource {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDTO inserir(@RequestBody ProdutoCriacaoDTO produtoDTO) {
        return produtoService.inserir(produtoDTO);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoDTO buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }
}
