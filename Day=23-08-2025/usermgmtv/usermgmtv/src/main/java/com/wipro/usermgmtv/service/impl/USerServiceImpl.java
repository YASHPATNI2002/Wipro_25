package com.wipro.usermgmtv.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.http.HttpStatus;                  // ✅ add this
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wipro.usermgmtv.common.AppConstant;
import com.wipro.usermgmtv.dto.Token;
import com.wipro.usermgmtv.entity.User;
import com.wipro.usermgmtv.repo.UserRepo;
import com.wipro.usermgmtv.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class USerServiceImpl implements UserService {
	// private static final String SECRET = "d3No4uat7HEgU6RHjJ902G+gTj3+qHNZZ/CN6BUeCa4cKFSkp1AGFXH7ODj3A+fPDf1WQB2x6Yknr6VFh5ySyw==";


	@Autowired
	UserRepo userRepo;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		Optional<User> userOpt= userRepo.findById(id);
		if(userOpt.isPresent())
		{
			return userOpt.get();
		}
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}

	 @Override
	    public Token login(User user) {
	        User userData = userRepo.findByEmailAndPassWord(user.getEmail(), user.getPassWord());
	        if (userData == null) {
	            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");  
	        }
	        String jwt = getJWTToken(user.getEmail());   
	        return new Token(jwt);
	    }

	    private String getJWTToken(String username) {
	        Key key = Keys.hmacShaKeyFor(AppConstant.SECRET.getBytes(StandardCharsets.UTF_8));
	        List<String> roles = List.of("ROLE_USER");

	        return Jwts.builder()
	            .setId("jwtExample")
	            .setSubject(username)
	            .claim("authorities", roles)
	            .setIssuedAt(new Date())
	            .setExpiration(new Date(System.currentTimeMillis() + AppConstant.EXP_MS))
	            .signWith(key, SignatureAlgorithm.HS256)
	            .compact();
	    }

}