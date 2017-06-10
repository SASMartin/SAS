package com.resources.api.impl;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dto.PaisDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resources.ejbean.EJBInterface;
import com.resources.jwt.JWTManager;

public class PaisImpl {

	/**
	 * Obtiene una lista de paises
	 * 
	 * @param String: json con parametros de entrada
	 * @return Response: respuesta Http
	 */
	public static Response getPaisesImpl(String token, String usuario){
		String jsonResponse = "";
		try{
			//Valido token de acceso
			JWTManager.validateToken(token, usuario);
			
			EJBInterface ejbInterface = EJBInterface.getInstance();
			List<PaisDTO> listaPaises = ejbInterface.getPaisesEJB();
			
			//Parseo de Objeto a JSON
			ObjectMapper mapper = new ObjectMapper();
			jsonResponse = mapper.writeValueAsString(listaPaises);
			
			return Response.ok(jsonResponse, MediaType.APPLICATION_JSON).build();
		}catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}
	
}
