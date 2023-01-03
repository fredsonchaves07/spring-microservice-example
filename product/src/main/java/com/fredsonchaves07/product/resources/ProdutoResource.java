package com.fredsonchaves07.product.resources;

import com.fredsonchaves07.product.dtos.ProdutoCriacaoDTO;
import com.fredsonchaves07.product.dtos.ProdutoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface ProdutoResource {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProdutoDTO inserir(@Valid @RequestBody ProdutoCriacaoDTO produtoDTO);

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retorna o produto")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "404",
                    content = @Content(
                           mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                "Código": "115",
                                                "mensagem: "Produto nao encontrado"
                                            }
                                            """
                            )
                    )
            )
    })
    ProdutoDTO buscarPorId(@PathVariable Long id);
}
