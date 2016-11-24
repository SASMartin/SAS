package com.dto;

import java.io.Serializable;
import java.util.Date;

public class EstudianteDTO extends PersonaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date fechaPrimerMat;

	public EstudianteDTO() {
		super();
	}

	public EstudianteDTO(String nombre, String telefono, String documento, String apellido, Date fechaNac,
			String correo, PaisesDTO paisDTO, Date fechaPrimerMat) {
		super(nombre, telefono, documento, apellido, fechaNac, correo, paisDTO);
		this.fechaPrimerMat = fechaPrimerMat;
	}
	
	public EstudianteDTO(String nombre, String telefono, String documento, String apellido, Date fechaNac,
			String correo, PaisesDTO paisDTO, Long id, Date fechaPrimerMat) {
		super(nombre, telefono, documento, apellido, fechaNac, correo, paisDTO);
		this.id = id;
		this.fechaPrimerMat = fechaPrimerMat;
	}

	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaPrimerMat() {
		return fechaPrimerMat;
	}
	public void setFechaPrimerMat(Date fechaPrimerMat) {
		this.fechaPrimerMat = fechaPrimerMat;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString(){
		return "\n Nombre : " + getNombre() + 
				"\n Apellido : " +getApellido()+
				"\n Documento : " +getDocumento()+
				"\n Telefono : " + getTelefono()+
				"\n Pais : " + getPais().getNombre()+
				"\n Fecha de nacimiento :" + getFechaNac()+
				"\n Fecha de egreso : " + getFechaPrimerMat()+
				" \n  ===============  ";
	}
	
}
