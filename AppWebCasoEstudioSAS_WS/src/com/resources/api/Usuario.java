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
	public Response getUsuarios(
			@QueryParam("token") String token, 
			@QueryParam("usuario") String usuario) {
		return UsuarioImpl.getUsuariosImpl(token, usuario);
	}
	
	@POST
	@Path("/createUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(
			@QueryParam("jsonUsuario") String jsonUsuario) {
		return UsuarioImpl.createUserImpl(jsonUsuario);
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUser(
			@QueryParam("usuario") String usuario, 
			@QueryParam("contrasenia") String contrasenia) {
		return UsuarioImpl.loginUserImpl(usuario, contrasenia);
	}
	
}
