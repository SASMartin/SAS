package com.beans;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import com.dto.PaisDTO;
import com.facade.ServiciosFacade;

@FacesConverter(value="paisConverter", forClass=PaisDTO.class)
public class PaisConverter implements Converter{
	
	@EJB
	public ServiciosFacade serviciosPais;
	private List<PaisDTO> paises;
	private PaisDTO pais;

	public ServiciosFacade getServiciosPais() {
		return serviciosPais;
	}

	public void setServiciosPais(ServiciosFacade serviciosPais) {
		this.serviciosPais = serviciosPais;
	}

	public List<PaisDTO> getPaises() {
		return paises;
	}

	public void setPaises(List<PaisDTO> paises) {
		this.paises = paises;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}
	
	public PaisConverter(){
		if(pais==null)
			pais = new PaisDTO() ;
	}

	@PostConstruct
	public void inicializar () throws SQLException{
		try {
			if(paises==null)
				paises = serviciosPais.obtenerPaises();
		} catch (Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al intentar listar los Docentes"));
		}
	}
	
	@Override
	public Object getAsObject(FacesContext context , UIComponent component, String value) throws ConverterException{		
		System.out.println(value+" ConverterValue");
		if(value !=null && value.toString().length()>0){
			pais = serviciosPais.obtenerPais(value);
			return pais;
		}else{		
			System.out.println(value);
			return null;
		}
	}
	
	@Override
	public String getAsString(FacesContext context , UIComponent component,Object value) throws ConverterException{
		if(value != null){
			PaisDTO pais = new PaisDTO();
			return pais.getNombre();
		}
		return null;
	}
	
}
