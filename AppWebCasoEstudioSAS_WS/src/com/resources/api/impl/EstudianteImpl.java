package com.resources.api.impl;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dto.EstudianteDTO;
import com.resources.ejbean.EJBInterface;

public class EstudianteImpl {

	/**
	 * Obtiene una lista de Estudiantes
	 * 
	 * @param String: json con parametros de entrada
	 * @return Response: respuesta Http
	 */
	public static Response getEstudiantesImpl(String jsonRequest) {
		String jsonResponse = "";
		try{
			EJBInterface ejbInterface = EJBInterface.getInstance();
			List<EstudianteDTO> listaEstudiantes = ejbInterface.getEstudiantesEJB();
			
			//Parseo de Objeto a JSON
			ObjectMapper mapper = new ObjectMapper();
			jsonResponse = mapper.writeValueAsString(listaEstudiantes);
			
			return Response.ok(jsonResponse, MediaType.APPLICATION_JSON).build();
		}catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}
	
	/**
	 * Crea un nuevo Estudiante
	 * 
	 * @param String: json con parametros de entrada
	 * @return Response: respuesta Http
	 */
	public static Response createEstudianteImpl(String jsonRequest) {
		try{
			EJBInterface ejbInterface = EJBInterface.getInstance();
			
			//Parseo de JSON a Objeto
			ObjectMapper objectMapper = new ObjectMapper();
			EstudianteDTO estudiante = objectMapper.readValue(jsonRequest, new TypeReference<EstudianteDTO>() { });
			
			ejbInterface.createEstudiante(estudiante);
			
			return Response.status(Status.CREATED).entity("Estudiante creado exitosamente").build();
		}catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}

}
