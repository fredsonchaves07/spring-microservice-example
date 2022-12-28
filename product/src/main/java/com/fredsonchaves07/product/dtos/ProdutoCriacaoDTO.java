package com.fredsonchaves07.product.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ProdutoCriacaoDTO(@NotEmpty String descricao, @NotNull BigDecimal valor) {
}
