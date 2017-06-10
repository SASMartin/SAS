package com.facade;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.dto.DocenteDTO;
import com.dto.EstudianteDTO;
import com.dto.PaisDTO;
import com.dto.UsuarioDTO;
import com.entities.Docente;
import com.entities.Estudiante;
import com.entities.Pais;
import com.entities.Usuario;

/**
 * Session Bean implementation class PersonaFacade
 */

@Stateless
@LocalBean
public class ServiciosFacade implements ServiciosFacadeRemote {
	
	@PersistenceContext
	private EntityManager em ;
	
    public ServiciosFacade() {
        // TODO Auto-generated constructor stub
    }
    
    public void crearEstudiante (EstudianteDTO est) throws Exception{
    	try{
    		PaisDTO dtoPais = obtenerPais(est.getPais().getNombre());
    		Pais p = new Pais(dtoPais.getId(), dtoPais.getNombre());
	    	Estudiante e = new Estudiante (est.getNombre() , est.getApellido() , est.getDocumento() , est.getTelefono() ,est.getCorreo(), p, est.getFechaNac() , est.getFechaPrimerMat());
	    	e.setFechaPrimerMat (est.getFechaPrimerMat() );
	    	
	    	Query q = em.createNativeQuery("select SEQ_ID_ESTUDIANTE.nextval from dual");
	    	BigDecimal codigo = (BigDecimal) q.getSingleResult();
	    	e.setId(codigo.longValue());
	    	
	    	em.persist(e);
	    	em.flush();
    	}catch(PersistenceException ex){
    		throw new Exception("El documento ya está registrado en el sistema");
    	}catch(Exception ex){
    		ex.printStackTrace();
    		throw new Exception("Ha ocurrido un error al intentar crear un Estudiante");
    	}
    }
    
    public void crearDocente (DocenteDTO doc) throws Exception{
    	try{    	    	
    		PaisDTO dtoPais = obtenerPais(doc.getPais().getNombre());
    		Pais p = new Pais(dtoPais.getId(), dtoPais.getNombre());	
	    	Docente d = new Docente(doc.getNombre(), doc.getApellido(), doc.getDocumento(), doc.getTelefono(), doc.getCorreo(), p, doc.getFechaNac(),doc.getFechaIngreso(),doc.getFechaEgreso());
	    	d.getFechaEgreso();
	    	d.getFechaIngreso();
	    	
	    	Query q = em.createNativeQuery("select SEQ_ID_DOCENTE.nextval from dual");
	    	BigDecimal codigo = (BigDecimal) q.getSingleResult();
	    	d.setId(codigo.longValue());
	    	
	    	em.persist(d);
	    	em.flush();
    	}catch(PersistenceException ex){
    		throw new Exception("El documento ya está registrado en el sistema");
    	}catch(Exception ex){
    		ex.printStackTrace();
    		throw new Exception("Ha ocurrido un error al intentar crear un Docente");
    	}
    }
    
    
    @Override
	public List<DocenteDTO> obtenerDocentes(){
    	List<DocenteDTO> docenteDTO = null;
    	try{
    		docenteDTO = new ArrayList<DocenteDTO>();
			TypedQuery<Docente> query = em.createQuery("FROM Docente",Docente.class); 		
	
			for(Docente doc:query.getResultList()){
				DocenteDTO docDTO = new DocenteDTO(doc.getNombre(),doc.getTelefono(), doc.getDocumento(),doc.getApellido(),doc.getFechaNac(),
						doc.getCorreo(),new PaisDTO(doc.getPais().getId_pais(), doc.getPais().getNombre()),doc.getID(),doc.getFechaEgreso(),doc.getFechaIngreso());
					
				docenteDTO.add(docDTO);
			}			
    	}catch(PersistenceException ex){
    		System.out.println("Error SQL: " + ex.getMessage());
    	}
    	return docenteDTO;
	}
    
    @Override
   	public List<EstudianteDTO> obtenerEstudiantes(){
    	List<EstudianteDTO> estudianteDTO = null;
    	try{
    		estudianteDTO = new ArrayList<EstudianteDTO>();
	    	TypedQuery<Estudiante> query = em.createQuery("FROM Estudiante",Estudiante.class);	   		
	   		
	   		for(Estudiante est:query.getResultList()){
	   			EstudianteDTO estDTO = new EstudianteDTO(est.getNombre(),est.getTelefono(), est.getDocumento(),est.getApellido(),est.getFechaNac(),
	   					est.getCorreo(),new PaisDTO(est.getPais().getId_pais(), est.getPais().getNombre()), est.getId(), est.getFechaPrimerMat());
	   				
	   			estudianteDTO.add(estDTO);
	   		}
   		}catch(PersistenceException ex){
    		System.out.println("Error SQL: " + ex.getMessage());
    	}
   		return estudianteDTO;
   	}

    @Override
   	public List<PaisDTO> obtenerPaises(){
    	List<PaisDTO> paisDTO = null;
    	try{
    		paisDTO = new ArrayList<PaisDTO>();
	    	TypedQuery<Pais> query = em.createQuery("FROM Pais ORDER BY DECODE(nombre, 'Uruguay', 1)",Pais.class);	   		
	   		
	   		for(Pais paises:query.getResultList()){
	   			PaisDTO estDTO = new PaisDTO(paises.getId_pais(), paises.getNombre());	   				
	   			paisDTO.add(estDTO);
	   		}
   		}catch(PersistenceException ex){
    		System.out.println("Error SQL: " + ex.getMessage());
    	}
   		return paisDTO;
   	}
    
    @Override
    public PaisDTO obtenerPais(String nombre){    		
    	Query query = em.createQuery("select new com.dto.PaisDTO( p.id_pais , p.nombre) from Pais p where p.nombre like :nombre " );
		query.setParameter("nombre", nombre);
		PaisDTO pais = (PaisDTO) query.getSingleResult() ;		 
		return pais ;
	 }
    
    //Servicios de usuario implementados 4 semestre 
    public void crearUsuario (UsuarioDTO usu) throws Exception{
    	try{
    		//Encriptacion 
    		String plainPass = usu.getContrasenia(); 
    		String encriptedPass = encryptPass(plainPass);
    		Usuario u = new Usuario(usu.getNomUsuario(), encriptedPass, usu.getNomCompleto());
    		
	    	em.persist(u); 		
	    	em.flush();
    	}catch(PersistenceException ex){
    		throw new Exception("El Usuario ya existe en el sistema");
    	}catch(Exception ex){
    		ex.printStackTrace();
    		throw new Exception("Ha ocurrido un error al intentar crear un Usuario");
    	}    	
    }
    
    @Override
    public List<UsuarioDTO> obtenerUsuarios(){
    	List<UsuarioDTO> usuarioDTO = null;
    	try{
    		usuarioDTO = new ArrayList<UsuarioDTO>();
    		TypedQuery<Usuario> query = em.createQuery("FROM Usuario",Usuario.class);
			for(Usuario usu:query.getResultList()){
				UsuarioDTO usuDTO = new UsuarioDTO(usu.getId_usuario(),usu.getUsuario(), null, usu.getNombre());
			usuarioDTO.add(usuDTO);
			}
    	}catch(PersistenceException ex){
    		System.out.println("Error SQL: " + ex.getMessage());
    	} 
    	return usuarioDTO;
    }
    
    @Override
    public UsuarioDTO loginUsuario(String usuario, String contrasenia) throws Exception{
    	UsuarioDTO usuarioDTO = null;
    	try{
    		TypedQuery<Usuario> query = em.createQuery("FROM Usuario WHERE usuario like :usuario",Usuario.class);
    		query.setParameter("usuario", usuario);
    		Usuario usu = query.getSingleResult();
    		
    		if(!encryptPass(contrasenia).equals(usu.getContrasenia()))
    			throw new Exception("Password incorrecto");
    		
    		usuarioDTO = new UsuarioDTO(usu.getId_usuario(),usu.getUsuario(), null, usu.getNombre());
    	}catch(NoResultException ex){
    		throw new Exception("El usuario no existe en el sistema");
    	}catch(PersistenceException ex){
    		System.out.println("Ha ocurrido un error al intentar realizar el login");
    	} 
    	return usuarioDTO;
    }
    
    /**
     *  Funcion auxiliar para encriptar contrasenia
     *  
     *  @param contrasenia plana
     *  @return contrasenia encriptada
     * @throws Exception 
     **/
     private String encryptPass(String plainPass) throws Exception{
    	 String encriptedPass = null;
		 try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(plainPass.getBytes(),0,plainPass.length());
			encriptedPass = (new BigInteger(1,m.digest()).toString(16));
		 }catch (NoSuchAlgorithmException e) {
		 	throw new Exception("Ha ocurrido un error en la encriptación");
		 }
		 return encriptedPass;
     }
       
}
