package com.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Docentes
 *
 */
@Entity
@Table(name = "DOCENTES")
@PrimaryKeyJoinColumn(referencedColumnName = "ID_PERSONA",name = "ID_PERSONA")
public class Docente extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID_DOCENTE", unique = true)
	private Long ID;
	
	@Column(name = "FEC_INGRESO" )
	private Date fechaIngreso;
	
	@Column(name = "FEC_EGRESO")
	private Date fechaEgreso;
	
	public Docente() {
		super();
	}

	public Docente(String nOMBRE, String aPELLIDO, String dOCUMENTO, String tELEFONO, String cORREO, Pais pais,
			Date fechaNac, Date fechaIngreso, Date fechaEgreso) {
		super(nOMBRE, aPELLIDO, dOCUMENTO, tELEFONO, cORREO, pais, fechaNac);
		this.fechaIngreso = fechaIngreso;
		this.fechaEgreso = fechaEgreso;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
