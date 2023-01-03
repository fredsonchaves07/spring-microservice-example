package com.fredsonchaves07.product.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fredsonchaves07.product.dtos.ProdutoCriacaoDTO;
import com.fredsonchaves07.product.dtos.ProdutoDTO;
import com.fredsonchaves07.product.entities.Produto;
import com.fredsonchaves07.product.services.ProdutoService;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("{id}")
    public ProdutoDTO update(@PathVariable Long id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        ProdutoDTO produtoDTO = produtoService.buscarPorId(id);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.convertValue(produtoDTO, JsonNode.class);
        JsonNode patchJsonNode = patch.apply(jsonNode);
        objectMapper.treeToValue(patchJsonNode, ProdutoDTO.class);
    }
}
