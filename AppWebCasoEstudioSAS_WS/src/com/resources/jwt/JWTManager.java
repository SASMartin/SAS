package com.resources.jwt;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

public class JWTManager {
	private static final String secret = "supercalifragilisticoespialidoso";
	private static final String iss = "sas+";
	private static final int exp = 30;
	
	/**
	 * Genera nuevo token para acceder a recursos Rest
	 * 
	 * @param usuario
	 * @return token
	 * @throws Exception 
	 * **/
	public static String generateToken(String nombreUsuario, String usuario) throws Exception{
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MINUTE, exp);
			
		    Algorithm algorithm = Algorithm.HMAC256(usuario + secret);
		    String token = JWT.create()
		    	.withClaim("name", nombreUsuario)
		    	.withExpiresAt(calendar.getTime())
		        .withIssuer(iss)
		        .sign(algorithm);
		    return token;
		} catch (UnsupportedEncodingException exception){
			 throw new Exception("Ha ocurrido un error al generar el token");
		} catch (JWTCreationException exception){
			throw new Exception("Ha ocurrido un error al generar el token");
		}
	}
	
	/**
	 * Valida token de acceso
	 * 
	 * @param token
	 * @param usuario
	 * @throws Exception 
	 * **/
	public static void validateToken(String token, String usuario) throws Exception{
		try {
		    Algorithm algorithm = Algorithm.HMAC256(usuario + secret);
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer(iss)
		        .build();
		    verifier.verify(token);
		} catch (UnsupportedEncodingException exception){
		    throw new Exception("El token de acceso no es valido");
		} catch (JWTVerificationException exception){
			throw new Exception("El token de acceso no es valido");
		}
	}
	
}
