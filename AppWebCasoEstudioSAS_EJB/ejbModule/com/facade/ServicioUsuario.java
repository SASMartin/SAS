package com.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.dto.UsuarioDTO;
import com.entities.Usuario;

/**
 * Session Bean implementation class ServicioUsuario
 */
@Stateless
@LocalBean
public class ServicioUsuario implements ServicioUsuarioRemote {


	@PersistenceContext
	private EntityManager em ;
	
    public ServicioUsuario() {
        // TODO Auto-generated constructor stub
    }
    
    public void crearUsuario (UsuarioDTO usu){
    	try{
    		Usuario u = new Usuario(usu.getUsuario(), usu.getContrasenia(), usu.getNomCompleto()) ;
    		Query q = em.createNativeQuery("select SEQ_ID_USUARIO.nextval from dual");
	    	BigDecimal codigo = (BigDecimal) q.getSingleResult();
	    	u.setID_USUARIO(codigo.longValue());
	    	em.persist(u);
    		
    	}catch(PersistenceException ex){
    		System.out.println("Error SQL: " + ex.getMessage());
    	}
    	
    }
    
    @Override
    public List<UsuarioDTO> otenerUsuarios(){
    	List<UsuarioDTO> usuarioDTO = null;
    	try{
    		usuarioDTO = new ArrayList<UsuarioDTO>();
    		TypedQuery<Usuario> query = em.createQuery("FROM Usuarios",Usuario.class);
    			for(Usuario usu:query.getResultList()){
    				UsuarioDTO usuDTO = new UsuarioDTO(usu.getUSUARIO(),usu.getCONTRASENIA(), usu.getNOM_COMPLETO());
    			usuarioDTO.add(usuDTO);
    			}
    		
    		
    	}catch(PersistenceException ex){
    		System.out.println("Error SQL: " + ex.getMessage());
    	} return usuarioDTO;
    	
    }

}
