package com.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.dto.EstudianteDTO;
import com.facade.ServiciosFacade;

@ManagedBean
@SessionScoped
public class CrearEstudiante {
	
	@EJB
	private ServiciosFacade serviciosFacade ;
	private EstudianteDTO estudiante;
	
	public CrearEstudiante(){
		if(estudiante == null){
			estudiante = new EstudianteDTO();			
		}
	}

	public ServiciosFacade getServiciosFacade() {
		return serviciosFacade;
	}

	public void setServiciosFacade(ServiciosFacade serviciosFacade) {
		this.serviciosFacade = serviciosFacade;
	}

	public EstudianteDTO getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(EstudianteDTO estudiante) {
		this.estudiante = estudiante;
	}
	
	public void crear(){
		try {
			serviciosFacade.crearEstudiante(estudiante);
			FacesContext.getCurrentInstance().addMessage("form:MensajeLbl", 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Estudiante creado exitosamente"));
			estudiante=null;
			
		} catch (Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al intentar crear un Estudiante"));
			
			List<EstudianteDTO> lEstudiante = new ArrayList<>();
			lEstudiante = serviciosFacade.obtenerEstudiantes();
			for(EstudianteDTO estudiantes : lEstudiante){
				if (estudiantes.getDocumento().equals(estudiante.getDocumento())){
					
					FacesContext.getCurrentInstance().addMessage("form:MensajeLbl", 
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El documento ya existe en el Systema"));
			
				}
			}
		}	
	}
	
	public String cancelar(){
		
		return "index";
	}

}
