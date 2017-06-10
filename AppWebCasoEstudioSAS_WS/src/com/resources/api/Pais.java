package com.resources.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.resources.api.impl.PaisImpl;

@Path("/pais/")
public class Pais {

	@GET
	@Path("/getPaises")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaises(
			@QueryParam("token") String token, 
			@QueryParam("usuario") String usuario) {
		return PaisImpl.getPaisesImpl(token, usuario);
	}
	
}
