package com.resources.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.resources.api.impl.EstudianteImpl;

@Path("/estudiante/")
public class Estudiante {	

	@GET
	@Path("/getEstudiantes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEstudiantes(
			@QueryParam("token") String token, 
			@QueryParam("usuario") String usuario) {
		return EstudianteImpl.getEstudiantesImpl(token, usuario);
	}

	@POST
	@Path("/createEstudiante")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEstudiante(
			@QueryParam("token") String token,
			@QueryParam("usuario") String usuario, 
			@QueryParam("jsonEstudiante") String jsonEstudiante) {
		return EstudianteImpl.createEstudianteImpl(token, usuario, jsonEstudiante);
	}
	
}
