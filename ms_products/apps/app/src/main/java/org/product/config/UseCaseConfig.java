package org.product.config;

import org.product.r2dbc.postgresql.gateways.ProductAdapterRepository;
import org.product.r2dbc.postgresql.gateways.ProductUseCaseRepository;
import org.product.repositorios.ProductAdapterRepositoryImpl;
import org.product.repositorios.ProductRepository;
import org.product.usecase.ProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class UseCaseConfig {

    @Bean
    @Primary
    public ProductAdapterRepository productAdapterRepository(ProductRepository productRepository){
        return new ProductAdapterRepositoryImpl(productRepository);
    }
    @Bean
    public ProductUseCaseRepository productUseCaseRepository(ProductAdapterRepository productAdapterRepository){
        return new ProductUseCase(productAdapterRepository);
    }


}
