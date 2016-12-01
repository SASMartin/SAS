package com.beans;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("validacionF")
public class ValidacionFecha implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent componente, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		
		if(value==null){
			return;
		}
		
		Object fechaInicioValue = componente.getAttributes().get("fIng");
			System.out.println("Fecha obtenida : " + fechaInicioValue);
			if(fechaInicioValue==null){
				return ;
			}
		
			Date fechaInicio = (Date)fechaInicioValue;
			Date fechaFinal = (Date)value;
			
			if(fechaFinal.before(fechaInicio)){
				
				throw new ValidatorException( new FacesMessage(FacesMessage.SEVERITY_FATAL ,"Fecha de egreso no puede ser mayor a fecha de ingreso  !! ", null));
			}
			
	}

	
	
}
