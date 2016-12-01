package com.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.validation.ValidationException;

import org.primefaces.context.RequestContext;

import com.dto.DocenteDTO;
import com.dto.PaisesDTO;
import com.entities.Paises;
import com.facade.PaisesFacade;
import com.facade.ServiciosFacade;

@ManagedBean
@SessionScoped
public class CrearDocente {
	
	@EJB
	private PaisesFacade servicioPais;
	private ServiciosFacade serviciosFacade ;
	private DocenteDTO docente;
	private List<SelectItem> paisSeleccionado ;
	
	public PaisesFacade getServicioPais() {
		return servicioPais;
	}


	public void setServicioPais(PaisesFacade servicioPais) {
		this.servicioPais = servicioPais;
	}

	

	public void setPaisSeleccionado(List<SelectItem> paisSeleccionado) {
		this.paisSeleccionado = paisSeleccionado;
	}

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
			
		}
		
	}
	
public String cancelar(){
		
		return "Menu";
	}


public List<SelectItem> getPaisSeleccionado() throws SQLException {
	if(paisSeleccionado==null){
		
		paisSeleccionado = new ArrayList<SelectItem>();
	
		List<PaisesDTO> paises = servicioPais.listaPaises();
		//paises.clear();
		
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
