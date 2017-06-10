package com.resources.api.impl;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dto.UsuarioDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resources.ejbean.EJBInterface;
import com.resources.jwt.JWTManager;

public class UsuarioImpl {

	/**
	 * Obtiene una lista de usuarios
	 * 
	 * @param String: json con parametros de entrada
	 * @return Response: respuesta Http
	 */
	public static Response getUsuariosImpl(String token, String usuario) {
		String jsonResponse = "";
		try{
			//Valido token de acceso
			JWTManager.validateToken(token, usuario);
			
			EJBInterface ejbInterface = EJBInterface.getInstance();
			List<UsuarioDTO> listaUsuarios = ejbInterface.getUsuariosEJB();
			
			//Parseo de Objeto a JSON
			ObjectMapper mapper = new ObjectMapper();
			jsonResponse = mapper.writeValueAsString(listaUsuarios);
			
			return Response.ok(jsonResponse, MediaType.APPLICATION_JSON).build();
		}catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}
	
	/**
	 * Crea un nuevo Usuario
	 * 
	 * @param String: json con parametros de entrada
	 * @return Response: respuesta Http
	 */
	public static Response createUserImpl(String jsonUsuario) {
		try{
			EJBInterface ejbInterface = EJBInterface.getInstance();
			
			//Parseo de JSON a Objeto
			ObjectMapper objectMapper = new ObjectMapper();
			UsuarioDTO usuario = objectMapper.readValue(jsonUsuario, new TypeReference<UsuarioDTO>() { });
			
			ejbInterface.createUser(usuario);
			
			return Response.status(Status.CREATED).entity("Usuario creado exitosamente").build();
		}catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}
	
	/**
	 * Realiza el login de un usuario
	 * 
	 * @param String: json con parametros de entrada
	 * @return Response: respuesta Http
	 */
	public static Response loginUserImpl(String usuario, String contrasenia){
		String jsonResponse = "";
		try{
			EJBInterface ejbInterface = EJBInterface.getInstance();
			UsuarioDTO usuarioDto = ejbInterface.loginUser(usuario,contrasenia);
			
			//Genero token de acceso
			jsonResponse = JWTManager.generateToken(usuarioDto.getNomCompleto(), usuario);
			
			return Response.ok(jsonResponse, MediaType.APPLICATION_JSON).build();
		}catch(Exception ex){
			return Response.status(Response.Status.UNAUTHORIZED).entity(ex.getMessage()).build();
		}
	}
	
}
