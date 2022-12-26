package com.fredsonchaves07.product.repositories;

import com.fredsonchaves07.product.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
