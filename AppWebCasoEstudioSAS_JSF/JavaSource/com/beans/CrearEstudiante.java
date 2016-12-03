package com.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.dto.EstudianteDTO;
import com.dto.PaisesDTO;
import com.facade.ServiciosFacade;

@ManagedBean
@SessionScoped
public class CrearEstudiante {
	
	@EJB
	private ServiciosFacade serviciosFacade ;
	private EstudianteDTO estudiante;
	private List<SelectItem> paisSeleccionado ;
	
	public CrearEstudiante(){
		if(estudiante == null){
			estudiante = new EstudianteDTO();		
			estudiante.setPais(new PaisesDTO());
		}
	}

	public ServiciosFacade getServiciosFacade() {
		return serviciosFacade;
	}

	public void setServiciosFacade(ServiciosFacade serviciosFacade) {
		this.serviciosFacade = serviciosFacade;
	}

	public void setPaisSeleccionado(List<SelectItem> paisSeleccionado) {
		this.paisSeleccionado = paisSeleccionado;
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
		}	
	}
	
	public String cancelar(){
		return "index";
	}

	public List<SelectItem> getPaisSeleccionado() throws SQLException {
		if(paisSeleccionado==null){			
			paisSeleccionado = new ArrayList<SelectItem>();		
			List<PaisesDTO> paises = serviciosFacade.obtenerPaises();		
			if(paises != null && !paises.isEmpty()){
				SelectItem item ;
				for(PaisesDTO paisesLista  : paises) {					
					item = new SelectItem(paisesLista,paisesLista.getNombre());					
					paisSeleccionado.add(item);
				}
			}
		}		
		return paisSeleccionado;
	}
	
}
