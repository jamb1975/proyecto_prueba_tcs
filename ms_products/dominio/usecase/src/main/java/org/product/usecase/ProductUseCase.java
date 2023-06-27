package org.product.usecase;

import org.product.r2dbc.postgresql.gateways.ProductAdapterRepository;
import org.product.r2dbc.postgresql.gateways.ProductUseCaseRepository;
import org.product.r2dbc.postgresql.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Service
public class ProductUseCase implements ProductUseCaseRepository {

    private final ProductAdapterRepository productAdapterRepository;

    public ProductUseCase(ProductAdapterRepository productAdapterRepository){
        this.productAdapterRepository = productAdapterRepository;
    }


    @Override
    public Mono<ServerResponse> create(ServerRequest request) {
      return  request.bodyToMono(Product.class).log()
                .flatMap(prod ->productAdapterRepository.create(prod)).log()
              .flatMap(prodCreate -> ServerResponse.ok().bodyValue(prodCreate))
              .onErrorResume(e -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).bodyValue(e.getMessage()));

    }

    @Override
    public Mono<ServerResponse> update(ServerRequest request) {
        return  request.bodyToMono(Product.class).log()
                .flatMap(prod ->productAdapterRepository.update(prod))
                .flatMap(prodUpdate -> ServerResponse.status(202).bodyValue(prodUpdate))
                .onErrorResume(e -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).bodyValue(e.getMessage()));

    }

    @Override
    public Mono<ServerResponse> delete(ServerRequest request) {
     return
             productAdapterRepository.delete(Integer.valueOf(request.pathVariable("productId")))
                .then()
                .then(ServerResponse.noContent().build())
                     .onErrorResume(e -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).bodyValue(e.getMessage()));
    }

    @Override
    public Mono<ServerResponse> findProductById(ServerRequest request) {
      return  productAdapterRepository.findProductById(Integer.valueOf(request.pathVariable("productId")))
                .flatMap(product ->ServerResponse.ok().bodyValue(product))
              .onErrorResume(e -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).bodyValue(e.getMessage()));

    }

    @Override
    public Mono<ServerResponse> findAllProducts(ServerRequest request) {
        return  productAdapterRepository.findAllProducts()
                .collectList()
                .flatMap(allProducts ->ServerResponse.ok().bodyValue(allProducts))
                .onErrorResume(e -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).bodyValue(e.getMessage()));

    }
}
