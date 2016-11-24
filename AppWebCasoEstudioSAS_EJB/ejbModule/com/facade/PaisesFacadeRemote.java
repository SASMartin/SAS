package com.facade;

import java.sql.SQLException;
import java.util.List;


import javax.ejb.Remote;

import com.dto.PaisesDTO;

@Remote
public interface PaisesFacadeRemote {

	public List<PaisesDTO> listaPaises() throws SQLException;
	public void crearPais (PaisesDTO pai );
	public PaisesDTO  obtenerUnPaisDTO (String nombre);
	
}
