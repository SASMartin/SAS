package com.resources.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.resources.api.impl.UsuarioImpl;

@Path("/usuario/")
public class Usuario {

	@GET
	@Path("/getUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarios(@QueryParam("jsonRequest") String jsonRequest) {
		return UsuarioImpl.getUsuariosImpl(jsonRequest);
	}
	
	@POST
	@Path("/createUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(@QueryParam("jsonRequest") String jsonRequest) {
		return UsuarioImpl.createUserImpl(jsonRequest);
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUser(@QueryParam("usuario") String usuario, @QueryParam("contrasenia") String contrasenia) {
		return UsuarioImpl.loginUserImpl(usuario, contrasenia);
	}
	
}
