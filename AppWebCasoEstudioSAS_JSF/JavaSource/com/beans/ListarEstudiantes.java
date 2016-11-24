package com.beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.dto.EstudianteDTO;
import com.facade.ServiciosFacade;

@ManagedBean
@RequestScoped
public class ListarEstudiantes {
	
	@EJB
	private ServiciosFacade serviciosFacade ;
	private List<EstudianteDTO> estudiantes ;
	public ServiciosFacade getServiciosFacade() {
		return serviciosFacade;
	}
	public void setServiciosFacade(ServiciosFacade serviciosFacade) {
		this.serviciosFacade = serviciosFacade;
	}
	public List<EstudianteDTO> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<EstudianteDTO> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	@PostConstruct
	public void inicializar () throws SQLException{
		try {
			if(estudiantes==null)
				estudiantes = serviciosFacade.obtenerEstudiantes();
		} catch (Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al intentar listar los Estudiantes"));
		}
	}
 
}
