package com.resources.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.resources.api.impl.DocenteImpl;

@Path("/docente/")
public class Docente {

	@GET
	@Path("/getDocentes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDocentes(
			@QueryParam("token") String token, 
			@QueryParam("usuario") String usuario) {
		return DocenteImpl.getDocentesImpl(token, usuario);
	}
	
	@POST
	@Path("/createDocente")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createDocente(
			@QueryParam("token") String token,
			@QueryParam("usuario") String usuario, 
			@QueryParam("jsonDocente") String jsonDocente) {
		return DocenteImpl.createDocenteImp(token, usuario, jsonDocente);
	}
	
}
