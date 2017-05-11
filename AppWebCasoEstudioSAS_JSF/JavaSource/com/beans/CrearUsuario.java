package com.beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.dto.UsuarioDTO;
import com.facade.ServicioUsuario;

@ManagedBean
@SessionScoped
public class CrearUsuario {

	@EJB
	private ServicioUsuario serviciosUsuarios ;
	private UsuarioDTO usuario ;
	
	
	public CrearUsuario() {
		super();
	}

	public ServicioUsuario getServiciosUsuarios() {
		return serviciosUsuarios;
	}

	public void setServiciosUsuarios(ServicioUsuario serviciosUsuarios) {
		this.serviciosUsuarios = serviciosUsuarios;
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
			serviciosUsuarios.crearUsuario(usuario);
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
