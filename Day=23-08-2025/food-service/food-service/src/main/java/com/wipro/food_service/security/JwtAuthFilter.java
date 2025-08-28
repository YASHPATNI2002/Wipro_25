package com.wipro.food_service.security;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.Key;
@Component
public class JwtAuthFilter extends OncePerRequestFilter {
  private Key key() {
    String secret = "u6g0zF6k0y1hN1H9Wk0yBf0F5jG9pP5sYQwqXbKf3S2q9mQZk0i9bO1pQ4s8T2aL";
    return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
  }
  @Override
  protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
      throws ServletException, IOException {
    String h = req.getHeader(HttpHeaders.AUTHORIZATION);
    if (h != null && h.startsWith("Bearer ")) {
      String token = h.substring(7);
      try {
        var claims = Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody();
        var auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null, List.of());
        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
        SecurityContextHolder.getContext().setAuthentication(auth);
      } catch (Exception ignore) {}
    }
    chain.doFilter(req, res);
  }
}