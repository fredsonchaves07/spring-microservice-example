package com.fredsonchaves07.product.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fredsonchaves07.product.dtos.ProdutoDTO;
import com.fredsonchaves07.product.entities.Produto;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ProdutoSerialization extends JsonSerializer<Produto> {

    @Override
    public void serialize(Produto produto, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        ProdutoDTO produtoDTO = new ProdutoDTO(produto.getId(), produto.getDescricao(), produto.getValor());
        jsonGenerator.writeObject(produtoDTO);
    }
}
