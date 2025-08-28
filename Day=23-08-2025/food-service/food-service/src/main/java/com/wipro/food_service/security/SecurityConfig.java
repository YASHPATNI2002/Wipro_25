package com.wipro.food_service.security;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

private final JwtAuthFilter jwtFilter;
public SecurityConfig(JwtAuthFilter jwtFilter) { this.jwtFilter = jwtFilter; }

@Bean
SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
 http
   .csrf(csrf -> csrf.disable())
   .cors(cors -> cors.disable()) // CORS only at Gateway
   .formLogin(form -> form.disable())
   .httpBasic(basic -> basic.disable())
   .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
   .authorizeHttpRequests(auth -> auth
       .requestMatchers("/actuator/**").permitAll()
       .requestMatchers("/food/**").authenticated()   

       .anyRequest().permitAll()
   )
   .exceptionHandling(ex -> ex
       .authenticationEntryPoint((req, res, e) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED))
       .accessDeniedHandler((req, res, e) -> res.sendError(HttpServletResponse.SC_FORBIDDEN))
   )
   .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
 return http.build();
}
}

