package com.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.validation.ValidationException;
import com.dto.UsuarioDTO;
import com.facade.ServiciosFacade;

@ManagedBean
@RequestScoped
public class ListarUsuario {
	
	@EJB
	private ServiciosFacade serviciosFacade ;
	private List<UsuarioDTO> usuario ;
	
	
	public ListarUsuario() {
		super();
	}

	public ServiciosFacade getServiciosFacade() {
		return serviciosFacade;
	}

	public void setServiciosFacade(ServiciosFacade serviciosFacade) {
		this.serviciosFacade = serviciosFacade;
	}

	public List<UsuarioDTO> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<UsuarioDTO> usuario) {
		this.usuario = usuario;
	}
	
	public String cancelar(){
		return "index";
	}
	
	@PostConstruct
	public void inicializar () throws SQLException{
		try{
			if(usuario==null)
				usuario = serviciosFacade.obtenerUsuarios();
		}catch (Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al intentar listar los Usuarios"));
		}
	}
	
	public void validate(FacesContext arg0 , UIComponent arg1 , Object arg2) throws ValidationException{
		List<UsuarioDTO> lusuario = new ArrayList<>();
		String usuarioNom ;
		lusuario = serviciosFacade.obtenerUsuarios();
		for(UsuarioDTO usuario: lusuario){
			usuarioNom= usuario.getNomUsuario();
			if(((String)arg2).equals(usuarioNom)){				
				throw new ValidatorException( new FacesMessage(FacesMessage.SEVERITY_FATAL ,"El nombre de usuario ya fue ingresado al sistema !! ", null));
			}
		}
	}
		
}
