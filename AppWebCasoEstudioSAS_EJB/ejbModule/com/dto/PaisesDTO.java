package com.dto;

import java.io.Serializable;

public class PaisesDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id ;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String nombre ;

	
	public PaisesDTO(String nombre) {
		super();
		this.nombre = nombre;
	}

	public PaisesDTO(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString(){
		return "Nombre : " + nombre;
		
	}

	public PaisesDTO() {
		super();
	}
	
	
	

}
