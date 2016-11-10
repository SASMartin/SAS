package com.facade;

import java.util.List;

import javax.ejb.Remote;

import com.dto.PaisesDTO;

@Remote
public interface PaisesFacadeRemote {

	public void crearPais (PaisesDTO pai );
	public List<PaisesDTO> obtenerPaises ();
	public PaisesDTO  obtenerUnPaisDTO (String nombre);
}
