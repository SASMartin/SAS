package com.beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.dto.DocenteDTO;
import com.facade.ServiciosFacade;

@ManagedBean
@SessionScoped
public class CrearDocente {
	
	@EJB
	private ServiciosFacade serviciosFacade ;
	private DocenteDTO docente;
	
	public CrearDocente(){
		if(docente==null){
			docente = new DocenteDTO();
		}
	}

	public ServiciosFacade getServiciosFacade() {
		return serviciosFacade;
	}

	public void setServiciosFacade(ServiciosFacade serviciosFacade) {
		this.serviciosFacade = serviciosFacade;
	}

	public DocenteDTO getDocente() {
		return docente;
	}

	public void setDocente(DocenteDTO docente) {
		this.docente = docente;
	}
	
	public void crear(){
		try {
			serviciosFacade.crearDocente(docente);
			//FacesContext.getCurrentInstance().addMessage(null, 
				//	new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Docente creado exitosamente"));
			FacesContext.getCurrentInstance().addMessage("form:MensajeLbl", 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Docente creado exitosamente"));
		} catch (Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al intentar crear un Docente"));
		}
	}
	

}
