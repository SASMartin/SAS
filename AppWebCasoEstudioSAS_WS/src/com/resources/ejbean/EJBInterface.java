package com.resources.ejbean;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.dto.DocenteDTO;
import com.dto.EstudianteDTO;
import com.dto.PaisDTO;
import com.dto.UsuarioDTO;
import com.facade.ServiciosFacade;

public class EJBInterface {
	
	private final static String JNDI = "java:global/AppWebCasoEstudioSAS_EAR/APPWebCasoEstudioSAS_EJB/ServiciosFacade!com.facade.ServiciosFacade"; 
	private static EJBInterface ejbInterface = null;
	private static ServiciosFacade serviciosFacade;

	public static EJBInterface getInstance() throws NamingException{
		if(ejbInterface == null){
			ejbInterface = new EJBInterface();
			serviciosFacade = (ServiciosFacade) new InitialContext().lookup(JNDI);
		}
		return ejbInterface;
	}
	
	public List<PaisDTO> getPaisesEJB(){	
		return serviciosFacade.obtenerPaises();
	}
	
	public List<DocenteDTO> getDocentesEJB(){	
		return serviciosFacade.obtenerDocentes();
	}
	
	public List<EstudianteDTO> getEstudiantesEJB(){	
		return serviciosFacade.obtenerEstudiantes();
	}
	
	public List<UsuarioDTO> getUsuariosEJB(){	
		return serviciosFacade.obtenerUsuarios();
	}
	
	public void createDocente(DocenteDTO docente) throws Exception{
		serviciosFacade.crearDocente(docente);
	}
	
	public void createEstudiante(EstudianteDTO estudiante) throws Exception{
		serviciosFacade.crearEstudiante(estudiante);
	}
	
	public void createUser(UsuarioDTO usuario) throws Exception{
		serviciosFacade.crearUsuario(usuario);
	}
	
	public UsuarioDTO loginUser(String usuario, String contrasenia) throws Exception{
		return serviciosFacade.loginUsuario(usuario, contrasenia);
	}
	
}
