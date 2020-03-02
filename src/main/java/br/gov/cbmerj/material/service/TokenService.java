package br.gov.cbmerj.material.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.cbmerj.material.model.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;	

	public String gerarToken(Authentication authentication) {
		
		User logado = (User) authentication.getPrincipal();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		String result = "";
		try {
			String writeValueAsString = objectMapper.writeValueAsString(logado);
			result =  Jwts.builder()
					.setIssuer("API material cbmerj")
					.setSubject(objectMapper.writeValueAsString(logado))
					.setIssuedAt(hoje)
					.setExpiration(dataExpiracao)
					.signWith(SignatureAlgorithm.HS256, secret)
					.compact();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		return result;
	}

}
