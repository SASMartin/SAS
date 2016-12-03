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

import com.dto.DocenteDTO;
import com.facade.ServiciosFacade;

@ManagedBean
@RequestScoped
public class ListarDocentes {
	
	@EJB
	private ServiciosFacade serviciosFacade ;
	private List<DocenteDTO> docentes;
	
	public ServiciosFacade getServiciosFacade() {
		return serviciosFacade;
	}

	public void setServiciosFacade(ServiciosFacade serviciosFacade) {
		this.serviciosFacade = serviciosFacade;
	}

	public List<DocenteDTO> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<DocenteDTO> docentes) {
		this.docentes = docentes;
	}
	
	@PostConstruct
	public void inicializar () throws SQLException{
		try {
			if(docentes==null)
				docentes = serviciosFacade.obtenerDocentes();
		} catch (Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al intentar listar los Docentes"));
		}
	}
	
	public void validate(FacesContext arg0 , UIComponent arg1 , Object arg2) throws ValidationException{
		
		List<DocenteDTO> lDocente = new ArrayList<>();
		String documento ;
		
		lDocente = serviciosFacade.obtenerDocentes();
		for(DocenteDTO docentes : lDocente){
			documento= docentes.getDocumento();
		if(((String)arg2).equals(documento)){
			
			throw new ValidatorException( new FacesMessage(FacesMessage.SEVERITY_FATAL ,"El documento ya fue ingresado al systema !! ", null));
		}
		}
	}
	

		
}
