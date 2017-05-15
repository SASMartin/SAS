package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name = "USUARIOS")

public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="SEQ_ID_USUARIO",sequenceName="SEQ_ID_USUARIO",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_ID_USUARIO")
	@Column(name="ID_USUARIO")
	private Long id;
	
	@Column(name = "USUARIO" ,unique = true)
	   private String usuario ;
	
	@Column(name = "CONTRASENIA" )
	   private String contrasenia ;
	
	@Column(name = "NOM_COMPLETO" )
	   private String nomCompleto ;

	public Usuario() {
		super();
	}

	public Usuario(String usuario, String contrasenia, String nomCompleto) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nomCompleto = nomCompleto;
	}

	public Usuario(Long id, String usuario, String contrasenia, String nomCompleto) {
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
