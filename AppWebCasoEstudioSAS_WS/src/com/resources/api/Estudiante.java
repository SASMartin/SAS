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
	public Response getEstudiantes(@QueryParam("jsonRequest") String jsonRequest) {
		return EstudianteImpl.getEstudiantesImpl(jsonRequest);
	}

	@POST
	@Path("/createEstudiante")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEstudiante(@QueryParam("jsonRequest") String jsonRequest) {
		return EstudianteImpl.createEstudianteImpl(jsonRequest);
	}
	
}
