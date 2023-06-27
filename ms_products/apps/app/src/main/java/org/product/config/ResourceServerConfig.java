package org.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.OAuth2ResourceServerSpec.JwtSpec;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher;

@Configuration
@EnableWebFluxSecurity
public class ResourceServerConfig {

	/* @Bean
	    public JwtSpec securitygWebFilterChain(
	      ServerHttpSecurity http) {

	            return http.authorizeExchange()
	                    .pathMatchers("/products/**").permitAll()
	                    .anyExchange().permitAll()
	                    .and().oauth2ResourceServer().jwt();
	    }*/

	/*@Bean
	public SecurityWebFilterChain apiHttpSecurity(
			ServerHttpSecurity http) {
		http.securityMatcher(new PathPatternParserServerWebExchangeMatcher("/products/**"))
				.authorizeExchange().anyExchange().permitAll();
		return http.build();
	}
	@Bean
	public SecurityWebFilterChain httpSecurity(ServerHttpSecurity http) {
		return http.build();
	}*/
	@Order(Ordered.HIGHEST_PRECEDENCE)
	@Bean
	SecurityWebFilterChain apiHttpSecurity(ServerHttpSecurity http) {
		http
				.securityMatcher(new PathPatternParserServerWebExchangeMatcher("/products/**"))
				.authorizeExchange((exchanges) -> exchanges
						.anyExchange().authenticated()
				)
				.oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
		return http.build();
	}

   
	
	

}
