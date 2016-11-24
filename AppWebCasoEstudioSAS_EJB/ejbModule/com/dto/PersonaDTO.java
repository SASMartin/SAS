package com.dto;

import java.io.Serializable;
import java.util.Date;

public class PersonaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id ;
	private String nombre ;
	private String telefono ;
	private String documento ;
	private String apellido;
	private Date fechaNac ;
	private String correo ;
	private PaisesDTO pais ;
	
	public PersonaDTO() {
		super();
	}
	
	public PersonaDTO(String nombre, String telefono, String documento, String apellido, Date fechaNac, String correo,
			PaisesDTO paisDTO) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.documento = documento;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.correo = correo;
		this.pais = paisDTO;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public PaisesDTO getPais() {
		return pais;
	}
	public void setPais(PaisesDTO pais) {
		this.pais = pais;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
