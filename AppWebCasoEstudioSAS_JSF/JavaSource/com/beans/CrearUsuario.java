package com.beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.dto.UsuarioDTO;
import com.facade.ServiciosFacade;

@ManagedBean
@SessionScoped
public class CrearUsuario {

	@EJB
	private ServiciosFacade serviciosFacade ;
	private UsuarioDTO usuario ;
	
	
	public CrearUsuario() {
		
	}

	

	public ServiciosFacade getServiciosFacade() {
		return serviciosFacade;
	}



	public void setServiciosFacade(ServiciosFacade serviciosFacade) {
		this.serviciosFacade = serviciosFacade;
	}



	public UsuarioDTO getUsuario() {
		if(usuario==null){
			usuario = new UsuarioDTO();
		}
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	
	public void crear(){
		try{
			serviciosFacade.crearUsuario(usuario);
			FacesContext.getCurrentInstance().addMessage("form:MensajeLbl", 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuario creado exitosamente"));
			usuario=null;
			
		}catch(Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al intentar crear un Usuario"));			
		}
		
	}
	
	public String cancelar(){
		return "index";
	}
	
	@PostConstruct
	public void init(){
		if(usuario==null){
			usuario = new UsuarioDTO();
			
		}
	}
	
	
}
