package com.beans;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
	
}
