package com.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nomUsuario;
	private String contrasenia;
	private String nomCompleto;
	
	public UsuarioDTO() {
		super();
	}
	
	

	public UsuarioDTO(String nomUsuario, String contrasenia, String nomCompleto) {
		super();
		this.nomUsuario = nomUsuario;
		this.contrasenia = contrasenia;
		this.nomCompleto = nomCompleto;
	}



	public UsuarioDTO(Long id, String nomUsuario, String contrasenia, String nomCompleto) {
		super();
		this.id = id;
		this.nomUsuario = nomUsuario;
		this.contrasenia = contrasenia;
		this.nomCompleto = nomCompleto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
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
