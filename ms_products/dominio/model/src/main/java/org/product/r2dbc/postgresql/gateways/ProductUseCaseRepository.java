package org.product.r2dbc.postgresql.gateways;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface ProductUseCaseRepository {
    public Mono<ServerResponse> create(ServerRequest request);
    public Mono<ServerResponse> update(ServerRequest request);
    public Mono<ServerResponse> delete(ServerRequest request);
    public Mono<ServerResponse> findProductById(ServerRequest request);
    public Mono<ServerResponse> findAllProducts(ServerRequest request);
}
