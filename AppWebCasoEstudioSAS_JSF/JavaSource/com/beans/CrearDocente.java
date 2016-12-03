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

import com.dto.DocenteDTO;
import com.dto.PaisesDTO;
import com.facade.ServiciosFacade;

@ManagedBean
@SessionScoped
public class CrearDocente {

	@EJB
	private ServiciosFacade serviciosFacade;
	private DocenteDTO docente;
	private List<SelectItem> paisSeleccionado ;
	
	public CrearDocente(){
		if(docente==null){
			docente = new DocenteDTO();
			docente.setPais(new PaisesDTO());
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
	
	public DocenteDTO getDocente() {
		return docente;
	}

	public void setDocente(DocenteDTO docente) {
		this.docente = docente;
	}
	
	public void crear(){
		try {			
			serviciosFacade.crearDocente(docente);
			FacesContext.getCurrentInstance().addMessage("form:MensajeLbl", 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Docente creado exitosamente"));
			docente=null;
		} catch (Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al intentar crear un Docente"));			
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
