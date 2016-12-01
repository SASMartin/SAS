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
import com.dto.PaisesDTO;
import com.facade.PaisesFacade;




@FacesConverter(forClass=PaisesDTO.class)
public class PaisConverter implements Converter{
	
	@EJB
	public PaisesFacade serviciosPais;
	private List<PaisesDTO> paises;
	private PaisesDTO pais;
	
	
	
	public PaisesFacade getServiciosPais() {
		return serviciosPais;
	}

	public void setServiciosPais(PaisesFacade serviciosPais) {
		this.serviciosPais = serviciosPais;
	}

	public List<PaisesDTO> getPaises() {
		return paises;
	}

	public void setPaises(List<PaisesDTO> paises) {
		this.paises = paises;
	}

	public PaisesDTO getPais() {
		return pais;
	}

	public void setPais(PaisesDTO pais) {
		this.pais = pais;
	}
	
	public PaisConverter(){
		if(pais==null){
			pais = new PaisesDTO() ;
		}
	}

	@PostConstruct
	public void inicializar () throws SQLException{
		try {
			if(paises==null)
				paises = serviciosPais.listaPaises();
		} catch (Exception ex){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ha ocurrido un error al intentar listar los Docentes"));
		}
	}
	
	@Override
	public Object getAsObject(FacesContext context , UIComponent component,String value) throws ConverterException{
		
		System.out.println(value+"ConverterValue");
			if(value !=null && value.toString().length()>0){
				pais =serviciosPais.obtenerUnPaisDTO(value);
				return pais;
				
				
				
			}else{
			
				System.out.println(value);
		return null;
			}
	}
	
	@Override
	public String getAsString(FacesContext context , UIComponent component,Object value) throws ConverterException{
		if(value != null){
			PaisesDTO pais = new PaisesDTO();
			return pais.getNombre();
		}
		return null;
	}
	
}
