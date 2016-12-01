package com.beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.dto.PaisesDTO;
import com.facade.PaisesFacade;

@ManagedBean
@ApplicationScoped
public class ListarPaises {
	
	@EJB
	private PaisesFacade servicioPais;
	private List<SelectItem> paisSeleccionado ;
	private List<PaisesDTO> paises;
	
	
	public List<PaisesDTO> getPaises() {
		return paises;
	}
	public void setPaises(List<PaisesDTO> paises) {
		this.paises = paises;
	}
	public PaisesFacade getServicioPais() {
		return servicioPais;
	}
	public void setServicioPais(PaisesFacade servicioPais) {
		this.servicioPais = servicioPais;
	}
	public List<SelectItem> getPaisSeleccionado() {
		return paisSeleccionado;
	}
	public void setPaisSeleccionado(List<SelectItem> paisSeleccionado) {
		this.paisSeleccionado = paisSeleccionado;
	}
	
	@PostConstruct
	public void inicializar () throws SQLException{
		try {
			if(paises==null)
				paises = servicioPais.listaPaises();
		} catch (Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al intentar listar los Paises"));
		}
	}
	
	
}
