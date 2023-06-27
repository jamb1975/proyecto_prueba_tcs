package com.emyasa.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {
	
	/* @Bean
	    @CrossOrigin(origins = "'http://localhost:4200")
	    public RouterFunction<ServerResponse> routesClientes(GlClienteUseCaseRepository glClientUseCase) {

	        return route(POST("/api/clientes"), glClientUseCase::save)
	                .andRoute(DELETE("/api/clientes/{id}"), glClientUseCase::delete)
	                .andRoute(GET("/api/clientes/{patttern}"), glClientUseCase::findClientes)
	                .andRoute(PUT("/api/clientes"), glClientUseCase::save);

	    }*/

}
