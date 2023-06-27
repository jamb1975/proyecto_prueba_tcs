package org.product.r2dbc.postgresql.gateways;


import org.product.r2dbc.postgresql.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface ProductAdapterRepository {


    public Mono<Product> findProductById(Integer productId);
    public Flux<Product> findAllProducts();
    public Mono<Product> create(Product product);
    public Mono<Product> update(Product product);
    public Mono<Void> delete(Integer productId);

}
