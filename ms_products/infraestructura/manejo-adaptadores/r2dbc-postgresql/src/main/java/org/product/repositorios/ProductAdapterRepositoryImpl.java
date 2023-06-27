package org.product.repositorios;

import org.product.r2dbc.postgresql.gateways.ProductAdapterRepository;
import org.product.r2dbc.postgresql.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public class ProductAdapterRepositoryImpl implements ProductAdapterRepository
{
    private final ProductRepository productRepository;

    public ProductAdapterRepositoryImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Mono<Product> create(Product product){
        return productRepository.save(product).log();
    }

    @Override
    public Mono<Product> update(Product product) {
        return productRepository.findProductById(product.getId())
                .map(prodEdit -> prodEdit.toBuilder().nombre(product.getNombre()).precio(product.getPrecio()).build()).log()
                .flatMap(prodUppdate -> productRepository.save(prodUppdate)).log();
    }

    public Mono<Void> delete(Integer productId){
         return productRepository.deleteById(productId);
    }

    @Override
    public Mono<Product> findProductById(Integer productId) {
        return productRepository.findProductById(productId);
    }

    public Flux<Product> findAllProducts(){
            return productRepository.findAll();
    }
}
