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
import com.facade.ServicioUsuario;

@ManagedBean
@RequestScoped
public class ListarUsuario {
	
	@EJB
	private ServicioUsuario serviciosUsuarios ;
	private List<UsuarioDTO> usuario ;
	
	
	public ListarUsuario() {
		super();
	}
	public ServicioUsuario getServiciosUsuarios() {
		return serviciosUsuarios;
	}
	public void setServiciosUsuarios(ServicioUsuario serviciosUsuarios) {
		this.serviciosUsuarios = serviciosUsuarios;
	}
	public List<UsuarioDTO> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<UsuarioDTO> usuario) {
		this.usuario = usuario;
	}
	
	@PostConstruct
	public void inicializar () throws SQLException{
		try{
			if(usuario==null)
				usuario = serviciosUsuarios.otenerUsuarios();
		}catch (Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al intentar listar los Usuarios"));
		}
	}
	
	public void validate(FacesContext arg0 , UIComponent arg1 , Object arg2) throws ValidationException{
		List<UsuarioDTO> lusuario = new ArrayList<>();
		String usuarioNom ;
		lusuario = serviciosUsuarios.otenerUsuarios();
		for(UsuarioDTO usuario: lusuario){
			usuarioNom= usuario.getUsuario();
			if(((String)arg2).equals(usuarioNom)){				
				throw new ValidatorException( new FacesMessage(FacesMessage.SEVERITY_FATAL ,"El nombre de usuario ya fue ingresado al sistema !! ", null));
			}
		}
	}
		
}
