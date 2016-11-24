package com.facade;

import java.util.List;
import javax.ejb.Remote;
import com.dto.DocenteDTO;
import com.dto.EstudianteDTO;

@Remote
public interface ServiciosFacadeRemote {
	
	public void crearEstudiante (EstudianteDTO est);
	public void crearDocente (DocenteDTO doc);
	List<DocenteDTO> obtenerDocentes();
	public List<EstudianteDTO> obtenerEstudiantes();
	
}
