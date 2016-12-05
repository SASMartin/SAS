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
import com.dto.DocenteDTO;
import com.dto.EstudianteDTO;
import com.dto.PaisesDTO;
import com.entities.Docentes;
import com.entities.Estudiantes;
import com.entities.Paises;

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
    
    public void crearEstudiante (EstudianteDTO est){
    	try{
    		PaisesDTO dtoPais = obtenerPais(est.getPais().getNombre());
    		Paises p = new Paises(dtoPais.getId(), dtoPais.getNombre());
	    	Estudiantes e = new Estudiantes (est.getNombre() , est.getApellido() , est.getDocumento() , est.getTelefono() ,est.getCorreo(), p, est.getFechaNac() , est.getFechaPrimerMat());
	    	e.setFechaPrimerMat (est.getFechaPrimerMat() );
	    	
	    	Query q = em.createNativeQuery("select SEQ_ID_ESTUDIANTE.nextval from dual");
	    	BigDecimal codigo = (BigDecimal) q.getSingleResult();
	    	e.setID(codigo.longValue());
	    	em.persist(e);
    	}catch(PersistenceException ex){
    		System.out.println("Error SQL: " + ex.getMessage());
    	}
    }
    
    public void crearDocente (DocenteDTO doc){
    	try{    	    	
    		PaisesDTO dtoPais = obtenerPais(doc.getPais().getNombre());
    		Paises p = new Paises(dtoPais.getId(), dtoPais.getNombre());	
	    	Docentes d = new Docentes(doc.getNombre(), doc.getApellido(), doc.getDocumento(), doc.getTelefono(), doc.getCorreo(), p, doc.getFechaNac(),doc.getFechaIngreso(),doc.getFechaEgreso());
	    	d.getFechaEgreso();
	    	d.getFechaIngreso();
	    	Query q = em.createNativeQuery("select SEQ_ID_DOCENTE.nextval from dual");
	    	BigDecimal codigo = (BigDecimal) q.getSingleResult();
	    	d.setID(codigo.longValue());
	    	em.persist(d);
    	}catch(PersistenceException ex){
    		System.out.println("Error SQL: " + ex.getMessage());
    	}
    }
    
    
    @Override
	public List<DocenteDTO> obtenerDocentes(){
    	List<DocenteDTO> docenteDTO = null;
    	try{
    		docenteDTO = new ArrayList<DocenteDTO>();
			TypedQuery<Docentes> query = em.createQuery("FROM Docentes",Docentes.class); 		
	
			for(Docentes doc:query.getResultList()){
				DocenteDTO docDTO = new DocenteDTO(doc.getNombre(),doc.getTelefono(), doc.getDocumento(),doc.getApellido(),doc.getFechaNac(),
						doc.getCorreo(),new PaisesDTO(doc.getPais().getID_PAIS(), doc.getPais().getNOMBRE()),doc.getFechaEgreso(),doc.getFechaIngreso());
					
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
	    	TypedQuery<Estudiantes> query = em.createQuery("FROM Estudiantes",Estudiantes.class);	   		
	   		
	   		for(Estudiantes est:query.getResultList()){
	   			EstudianteDTO estDTO = new EstudianteDTO(est.getNombre(),est.getTelefono(), est.getDocumento(),est.getApellido(),est.getFechaNac(),
	   					est.getCorreo(),new PaisesDTO(est.getPais().getID_PAIS(), est.getPais().getNOMBRE()), est.getFechaPrimerMat());
	   				
	   			estudianteDTO.add(estDTO);
	   		}
   		}catch(PersistenceException ex){
    		System.out.println("Error SQL: " + ex.getMessage());
    	}
   		return estudianteDTO;
   	}

    @Override
   	public List<PaisesDTO> obtenerPaises(){
    	List<PaisesDTO> paisDTO = null;
    	try{
    		paisDTO = new ArrayList<PaisesDTO>();
	    	TypedQuery<Paises> query = em.createQuery("FROM Paises ORDER BY NOMBRE",Paises.class);	   		
	   		
	   		for(Paises paises:query.getResultList()){
	   			PaisesDTO estDTO = new PaisesDTO(paises.getID_PAIS(), paises.getNOMBRE());	   				
	   			paisDTO.add(estDTO);
	   		}
   		}catch(PersistenceException ex){
    		System.out.println("Error SQL: " + ex.getMessage());
    	}
   		return paisDTO;
   	}
    
    @Override
    public PaisesDTO obtenerPais(String nombre){    		
    	Query query = em.createQuery("select new com.dto.PaisesDTO( P.ID_PAIS , P.NOMBRE) from Paises p where p.NOMBRE like :nombre " );
		query.setParameter("nombre", nombre);
		PaisesDTO pais = (PaisesDTO) query.getSingleResult() ;		 
		return pais ;
	 }
    
}
