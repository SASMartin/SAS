package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Personas
 *
 */
@Entity
@Table (name = "PERSONAS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Personas implements Serializable {
	private static final long serialVersionUID = 1L;
	   @Id
	   @SequenceGenerator(name="Personas_GEN", sequenceName = "SEQ_ID_PERSONAS" ,allocationSize=1 )
	   @GeneratedValue(strategy=GenerationType.SEQUENCE , generator= "Personas_GEN")
	   @Column (name="ID_PERSONA")
	   private Long codigo;
	   private String nombre ;
	   private String apellido ;
	   private String  documento ;
	   private String  telefono;
	   private String correo;
	   
	   @ManyToOne(fetch=FetchType.LAZY)
	   @JoinColumn(name = "ID_PAIS",nullable=true)
	   private Paises pais;
	   
	   @Column(name="FECHA_NAC")
	   private Date fechaNac;
	   
	public Personas() {
		super();
	}

	
	
	
	

	/*public Personas(String nOMBRE, String aPELLIDO, String dOCUMENTO, String tELEFONO, String cORREO, Paises pais,
			Date fechaNac) {
		super();
		NOMBRE = nOMBRE;
		APELLIDO = aPELLIDO;
		DOCUMENTO = dOCUMENTO;
		TELEFONO = tELEFONO;
		CORREO = cORREO;
		this.pais = pais;
		this.fechaNac = fechaNac;
	}*/



	public Personas(String nombre, String apellido, String documento, String telefono, String correo, Paises pais,
			Date fechaNac) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.telefono = telefono;
		this.correo = correo;
		this.pais = pais;
		this.fechaNac = fechaNac;
	}


	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Paises getPais() {
		return pais;
	}

	public void setPais(Paises pais) {
		this.pais = pais;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



   
}
