package com.fredsonchaves07.product.dtos;

import java.math.BigDecimal;

public record ProdutoDTO(Long id, String descricao, BigDecimal valor) {
}
