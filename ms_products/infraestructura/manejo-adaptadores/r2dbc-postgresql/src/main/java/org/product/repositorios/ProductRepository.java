package org.product.repositorios;

import org.product.r2dbc.postgresql.model.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {
    @Query("SELECT * FROM Products WHERE  ID = :productId")
    public Mono<Product> findProductById(Integer productId);
}
