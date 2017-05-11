package com.facade;


import java.util.List;

import javax.ejb.Remote;

import com.dto.UsuarioDTO;

@Remote
public interface ServicioUsuarioRemote {
	
	public void crearUsuario (UsuarioDTO usu);
	public List<UsuarioDTO> otenerUsuarios();

}
