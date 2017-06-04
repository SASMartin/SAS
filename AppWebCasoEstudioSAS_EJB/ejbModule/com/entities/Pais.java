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
	private Long id_pais;
	
	@Column(nullable=false ,unique = true)
	private String nombre ;
	
	public Pais() {
		super();
	}

	public Pais(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Pais(Long id_pais, String nombre) {
		super();
		this.id_pais = id_pais;
		this.nombre = nombre;
	}

	public Long getId_pais() {
		return id_pais;
	}

	public void setId_pais(Long id_pais) {
		this.id_pais = id_pais;
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
