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
	private Long ID_USUARIO;
	private String usuario ;
	private String contrasenia ;
	private String nombre ;

	public Usuario(String nOMUSUARIO, String cONTRASENIA, String nOMBRE) {
		super();
		usuario = nOMUSUARIO;
		contrasenia = cONTRASENIA;
		nombre = nOMBRE;
	}
	
	public Long getID_USUARIO() {
		return ID_USUARIO;
	}

	public void setID_USUARIO(Long iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
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
