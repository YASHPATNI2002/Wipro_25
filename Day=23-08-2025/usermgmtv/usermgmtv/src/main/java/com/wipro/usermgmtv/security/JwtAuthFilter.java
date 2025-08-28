package com.wipro.usermgmtv.security;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wipro.usermgmtv.common.AppConstant;

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
    return Keys.hmacShaKeyFor(AppConstant.SECRET.getBytes(StandardCharsets.UTF_8));
  }

  @Override
  protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
      throws ServletException, IOException {

    String header = req.getHeader(HttpHeaders.AUTHORIZATION);
    if (header != null && header.startsWith(AppConstant.PREFIX)) {
      String token = header.substring(AppConstant.PREFIX.length());

      try {
        var claims = Jwts.parserBuilder().setSigningKey(key()).build()
            .parseClaimsJws(token).getBody();
        String username = claims.getSubject();

        var auth = new UsernamePasswordAuthenticationToken(
            username, null, List.of() /* you can map roles from claims if needed */);
        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
        SecurityContextHolder.getContext().setAuthentication(auth);
      } catch (Exception ex) {
        // invalid/expired -> leave context empty; Security will return 401
      }
    }
    chain.doFilter(req, res);
  }
}
