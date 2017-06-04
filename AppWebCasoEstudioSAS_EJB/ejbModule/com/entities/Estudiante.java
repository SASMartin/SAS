package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Estudiantes
 *
 */
@Entity
@Table(name = "ESTUDIANTES")
@PrimaryKeyJoinColumn(referencedColumnName = "ID_PERSONA",name = "ID_PERSONA")
public class Estudiante extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID_ESTUDIANTE", unique = true)
	private Long id;
	
	@Column(name="FEC_PRIMER_MATR")
	private Date fechaPrimerMat;
	
	public Estudiante(String nOMBRE, String aPELLIDO, String dOCUMENTO, String tELEFONO, String cORREO, Pais pais,
			Date fechaNac, Date fechaPrimerMat) {
		super(nOMBRE, aPELLIDO, dOCUMENTO, tELEFONO, cORREO, pais, fechaNac);
		this.fechaPrimerMat = fechaPrimerMat;
	}

	public Estudiante() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaPrimerMat() {
		return fechaPrimerMat;
	}

	public void setFechaPrimerMat(Date fechaPrimerMat) {
		this.fechaPrimerMat = fechaPrimerMat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
}
