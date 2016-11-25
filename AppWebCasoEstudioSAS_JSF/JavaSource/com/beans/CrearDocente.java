package com.beans;

import java.util.ArrayList;
import java.util.List;

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
			docente=null;
		} catch (Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al intentar crear un Docente"));
			
			List<DocenteDTO> lDocente = new ArrayList<>();
			lDocente = serviciosFacade.obtenerDocentes();
			for(DocenteDTO docentes : lDocente){
				if (docentes.getDocumento().equals(docente.getDocumento())){
					
					FacesContext.getCurrentInstance().addMessage("form:MensajeLbl", 
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El documento ya existe en el Systema"));
			
				}
			}
		}
		
	}
	
public String cancelar(){
		
		return "index";
	}
	
	/*public void validacionCedula(String doc){
		List<DocenteDTO> lDocente = new ArrayList<>();
		lDocente = serviciosFacade.obtenerDocentes();
		for(DocenteDTO docentes : lDocente){
			if (docentes.getDocumento().equals(doc)){
				
				FacesContext.getCurrentInstance().addMessage("form:MensajeLbl", 
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El documento ya existe en el Systema"));
			}else{
				
				FacesContext.getCurrentInstance().addMessage("form:MensajeLbl", 
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Documento valido"));
				
			}
		}
		
	}*/
	

}
