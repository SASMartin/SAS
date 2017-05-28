package com.resources.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/resources/")
public class Application {

	@GET
	@Path("/getPaises")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaises(@QueryParam("jsonRequest") String jsonRequest) {
		return ApplicationImpl.getPaisesImpl(jsonRequest);
	}
	
	@GET
	@Path("/getDocentes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDocentes(@QueryParam("jsonRequest") String jsonRequest) {
		return ApplicationImpl.getDocentesImpl(jsonRequest);
	}
	
	@GET
	@Path("/getEstudiantes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEstudiantes(@QueryParam("jsonRequest") String jsonRequest) {
		return ApplicationImpl.getEstudiantesImpl(jsonRequest);
	}
	
	@GET
	@Path("/getUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarios(@QueryParam("jsonRequest") String jsonRequest) {
		return ApplicationImpl.getUsuariosImpl(jsonRequest);
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@QueryParam("jsonRequest") String jsonRequest) {
		return ApplicationImpl.loginImpl(jsonRequest);
	}
	
	@POST
	@Path("/createDocente")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createDocente(@QueryParam("jsonRequest") String jsonRequest) {
		return ApplicationImpl.createDocenteImp(jsonRequest);
	}
	
	@POST
	@Path("/createEstudiante")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEstudiante(@QueryParam("jsonRequest") String jsonRequest) {
		return ApplicationImpl.createEstudianteImpl(jsonRequest);
	}
	
	@POST
	@Path("/createUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(@QueryParam("jsonRequest") String jsonRequest) {
		return ApplicationImpl.createUserImpl(jsonRequest);
	}
	
}
