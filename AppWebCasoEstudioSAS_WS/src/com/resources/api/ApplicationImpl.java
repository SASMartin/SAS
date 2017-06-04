package com.resources.api;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dto.DocenteDTO;
import com.dto.EstudianteDTO;
import com.dto.PaisDTO;
import com.dto.UsuarioDTO;
import com.resources.ejbean.EJBInterface;

public class ApplicationImpl {
	
	/**
	 * Obtiene una lista de paises
	 * 
	 * @param String: json con parametros de entrada
	 * @return Response: respuesta Http
	 */
	public static Response getPaisesImpl(String jsonRequest){
		String jsonResponse = "";
		try{
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
	 * Obtiene una lista de usuarios
	 * 
	 * @param String: json con parametros de entrada
	 * @return Response: respuesta Http
	 */
	public static Response getUsuariosImpl(String jsonRequest) {
		String jsonResponse = "";
		try{
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
	 * Realiza el login de un usuario
	 * 
	 * @param String: json con parametros de entrada
	 * @return Response: respuesta Http
	 */
	public static Response loginImpl(String jsonRequest){
		String jsonResponse = "";
		try{
			//TODO: llamar a ejbean y retornar token
			
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

	/**
	 * Crea un nuevo Usuario
	 * 
	 * @param String: json con parametros de entrada
	 * @return Response: respuesta Http
	 */
	public static Response createUserImpl(String jsonRequest) {
		try{
			EJBInterface ejbInterface = EJBInterface.getInstance();
			
			//Parseo de JSON a Objeto
			ObjectMapper objectMapper = new ObjectMapper();
			UsuarioDTO usuario = objectMapper.readValue(jsonRequest, new TypeReference<UsuarioDTO>() { });
			
			ejbInterface.createUser(usuario);
			
			return Response.status(Status.CREATED).entity("Usuario creado exitosamente").build();
		}catch(Exception ex){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}
	
}
