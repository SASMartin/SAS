package com.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
	
	@Override
	public Object getAsObject(FacesContext context , UIComponent component,String value) throws ConverterException{
		
			if(value !=null && value.toString().length()>0){
				return serviciosPais.obtenerUnPaisDTO(value);
			}else{
			
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
