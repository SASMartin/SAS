package com.facade;

import java.util.List;
import javax.ejb.Remote;
import com.dto.DocenteDTO;
import com.dto.EstudianteDTO;
import com.dto.PaisDTO;
import com.dto.UsuarioDTO;

@Remote
public interface ServiciosFacadeRemote {
	
	public void crearEstudiante (EstudianteDTO est) throws Exception;
	public void crearDocente (DocenteDTO doc) throws Exception;
	public List<DocenteDTO> obtenerDocentes();
	public List<EstudianteDTO> obtenerEstudiantes();
	public List<PaisDTO> obtenerPaises();
	public PaisDTO obtenerPais(String nombre);
	
	public void crearUsuario (UsuarioDTO usu) throws Exception;
	public List<UsuarioDTO> obtenerUsuarios();
}
