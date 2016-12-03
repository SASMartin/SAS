package com.facade;

import java.util.List;
import javax.ejb.Remote;
import com.dto.DocenteDTO;
import com.dto.EstudianteDTO;
import com.dto.PaisesDTO;

@Remote
public interface ServiciosFacadeRemote {
	
	public void crearEstudiante (EstudianteDTO est);
	public void crearDocente (DocenteDTO doc);
	public List<DocenteDTO> obtenerDocentes();
	public List<EstudianteDTO> obtenerEstudiantes();
	public List<PaisesDTO> obtenerPaises();
	public PaisesDTO obtenerPais(String nombre);
	
}
