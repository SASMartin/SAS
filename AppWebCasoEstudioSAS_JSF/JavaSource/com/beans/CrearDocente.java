package com.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
	
	public String crear(){
		
		serviciosFacade.crearDocente(docente);
		
		System.out.println("CREADO EXITOSAMENTE");
		
		return "andubo";
	}
	

}
