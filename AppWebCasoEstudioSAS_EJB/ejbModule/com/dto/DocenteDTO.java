package com.dto;

import java.io.Serializable;
import java.util.Date;

public class DocenteDTO extends PersonaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id ;
	private Date fechaEgreso;
	private Date fechaIngreso;

	public DocenteDTO() {
		super();
	}

	public DocenteDTO(String nombre, String telefono, String documento, String apellido, Date fechaNac, String correo,
			PaisesDTO paisDTO, Date fechaEgreso, Date fechaIngreso) {
		super(nombre, telefono, documento, apellido, fechaNac, correo, paisDTO);
		this.fechaEgreso = fechaEgreso;
		this.fechaIngreso = fechaIngreso;
	}

	public DocenteDTO(String nombre, String telefono, String documento, String apellido, Date fechaNac, String correo,
			PaisesDTO paisDTO, Long id, Date fechaEgreso, Date fechaIngreso) {
		super(nombre, telefono, documento, apellido, fechaNac, correo, paisDTO);
		this.id = id;
		this.fechaEgreso = fechaEgreso;
		this.fechaIngreso = fechaIngreso;
	}
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaEgreso() {
		return fechaEgreso;
	}
	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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
				"\n Fecha de ingreso : " + getFechaIngreso()+
				"\n Fecha de egreso : " + getFechaEgreso()+
				" \n  ===============  ";
				
		
	}

}
