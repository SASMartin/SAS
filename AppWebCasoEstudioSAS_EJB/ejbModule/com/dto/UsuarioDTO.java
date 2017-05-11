package com.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String usuario;
	private String contrasenia;
	private String nomCompleto;
	
	public UsuarioDTO() {
		super();
	}
	
	

	public UsuarioDTO(String usuario, String contrasenia, String nomCompleto) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nomCompleto = nomCompleto;
	}



	public UsuarioDTO(Long id, String usuario, String contrasenia, String nomCompleto) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nomCompleto = nomCompleto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNomCompleto() {
		return nomCompleto;
	}

	public void setNomCompleto(String nomCompleto) {
		this.nomCompleto = nomCompleto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
