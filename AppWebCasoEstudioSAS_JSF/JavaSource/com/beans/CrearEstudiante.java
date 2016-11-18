package com.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dto.EstudianteDTO;
import com.facade.ServiciosFacade;

@ManagedBean
@SessionScoped
public class CrearEstudiante {
	
	@EJB
	private ServiciosFacade serviciosFacade ;
	private EstudianteDTO estudiante;
	
	public CrearEstudiante (){
		if(estudiante ==null){
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
	
	public String  crear(){
		serviciosFacade.crearEstudiante(estudiante);;
		System.out.println("CREADO EXITOSAMENTE");
		return "anda";
	}

}
