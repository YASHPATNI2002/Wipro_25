package com.wipro.apigateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

  @Bean
  SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    return http
        .csrf(ServerHttpSecurity.CsrfSpec::disable)
        .cors(cors -> {}) // keep CORS at gateway
        .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
        .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
        .authorizeExchange(ex -> ex
            .pathMatchers(HttpMethod.OPTIONS, "/**").permitAll()          // preflight
            .pathMatchers("/USERMGMTV2-MS/user/login").permitAll()        // login open
            .pathMatchers("/actuator/**").permitAll()
            .anyExchange().permitAll()                                    // let services enforce JWT
        )
        .build();
  }
}
