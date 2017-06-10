package com.resources.api.impl;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dto.DocenteDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resources.ejbean.EJBInterface;

public class DocenteImpl {

	/**
	 * Obtiene una lista de Docentes
	 * 
	 * @param String: json con parametros de entrada
	 * @return Response: respuesta Http
	 */
	public static Response getDocentesImpl(String jsonRequest) {
		String jsonResponse = "";
		try{
			EJBInterface ejbInterface = EJBInterface.getInstance();
			List<DocenteDTO> listaDocentes = ejbInterface.getDocentesEJB();
			
			//Parseo de Objeto a JSON
			ObjectMapper mapper = new ObjectMapper();
			jsonResponse = mapper.writeValueAsString(listaDocentes);
			
			return Response.ok(jsonResponse, MediaType.APPLICATION_JSON).build();
		}catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}
	
	/**
	 * Crea un nuevo Docente
	 * 
	 * @param String: json con parametros de entrada
	 * @return Response: respuesta Http
	 */
	public static Response createDocenteImp(String jsonRequest) {
		try{
			EJBInterface ejbInterface = EJBInterface.getInstance();
			
			//Parseo de JSON a Objeto
			ObjectMapper objectMapper = new ObjectMapper();
			DocenteDTO docente = objectMapper.readValue(jsonRequest, new TypeReference<DocenteDTO>() { });
			
			ejbInterface.createDocente(docente);
			
			return Response.status(Status.CREATED).entity("Docente creado exitosamente").build();
		}catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}
	
}
