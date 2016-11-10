package com.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Estudiantes
 *
 */
@Entity
@Table(name = "ESTUDIANTES")
@PrimaryKeyJoinColumn(referencedColumnName = "ID_PERSONA",name = "ID_PERSONA")
public class Estudiantes extends Personas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID_ESTUDIANTE", unique = true)
	private Long ID;
	
	@Column(name="FEC_PRIMER_MATR")
	private Date fechaPrimerMat;
	
	public Estudiantes(String nOMBRE, String aPELLIDO, String dOCUMENTO, String tELEFONO, String cORREO, Paises pais,
			Date fechaNac, Date fechaPrimerMat) {
		super(nOMBRE, aPELLIDO, dOCUMENTO, tELEFONO, cORREO, pais, fechaNac);
		this.fechaPrimerMat = fechaPrimerMat;
	}

	
	public Estudiantes() {
		super();
	}



	public Long getID() {
		return ID;
	}


	public void setID(Long iD) {
		ID = iD;
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
