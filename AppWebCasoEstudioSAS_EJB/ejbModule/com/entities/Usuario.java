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
	private Long ID_USUARIO;
	
	@Column(nullable=false ,unique = true)
	   private String USUARIO ;
	
	@Column(nullable=false )
	   private String CONTRASENIA ;
	
	@Column(nullable=false )
	   private String NOM_COMPLETO ;

	public Usuario() {
		super();
	}

	public Usuario(String uSUARIO, String cONTRASENIA, String nOM_COMPLETO) {
		super();
		USUARIO = uSUARIO;
		CONTRASENIA = cONTRASENIA;
		NOM_COMPLETO = nOM_COMPLETO;
	}

	public Long getID_USUARIO() {
		return ID_USUARIO;
	}

	public void setID_USUARIO(Long iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
	}

	public String getUSUARIO() {
		return USUARIO;
	}

	public void setUSUARIO(String uSUARIO) {
		USUARIO = uSUARIO;
	}

	public String getCONTRASENIA() {
		return CONTRASENIA;
	}

	public void setCONTRASENIA(String cONTRASENIA) {
		CONTRASENIA = cONTRASENIA;
	}

	public String getNOM_COMPLETO() {
		return NOM_COMPLETO;
	}

	public void setNOM_COMPLETO(String nOM_COMPLETO) {
		NOM_COMPLETO = nOM_COMPLETO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
   
}
