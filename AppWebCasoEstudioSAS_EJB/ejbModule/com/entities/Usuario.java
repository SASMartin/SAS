package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuarios
 *
 */
@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="SEQ_ID_USUARIO",sequenceName="SEQ_ID_USUARIO",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_USUARIO")
	@Column(name="ID_USUARIO")
	private Long id_usuario;
	private String usuario ;
	private String contrasenia ;
	private String nombre ;

	public Usuario(String nOMUSUARIO, String cONTRASENIA, String nOMBRE) {
		super();
		usuario = nOMUSUARIO;
		contrasenia = cONTRASENIA;
		nombre = nOMBRE;
	}
	
	public Long getId_usuario() {
		return id_usuario;
	}

	public void setID_USUARIO(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public Usuario() {
		super();
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
