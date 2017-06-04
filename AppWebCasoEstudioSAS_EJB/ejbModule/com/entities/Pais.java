package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Paises
 *
 */
@Entity
@Table(name = "PAISES")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_ID_PAIS",sequenceName="SEQ_ID_PAIS",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_PAIS")
	@Column(name="ID_PAIS")
	private Long ID_PAIS;
	
	@Column(nullable=false ,unique = true)
	private String NOMBRE ;
	
	public Pais() {
		super();
	}

	public Pais(String nOMBRE) {
		super();
		NOMBRE = nOMBRE;
	}
	
	

	public Pais(Long iD_PAIS, String nOMBRE) {
		super();
		ID_PAIS = iD_PAIS;
		NOMBRE = nOMBRE;
	}

	public Long getID_PAIS() {
		return ID_PAIS;
	}

	public void setID_PAIS(Long iD_PAIS) {
		ID_PAIS = iD_PAIS;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
