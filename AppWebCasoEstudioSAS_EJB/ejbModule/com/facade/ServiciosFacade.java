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
	
    /**
     * Default constructor. 
     */
    public ServiciosFacade() {
        // TODO Auto-generated constructor stub
    }
    
    public void crearEstudiante (EstudianteDTO est){
    	try{
	    	Paises p = new Paises(new Long(1),"Uruguay");
	    	//Paises p = new Paises(est.getPais().getId(),est.getPais().getNombre());
	    	
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
	    	Paises p = new Paises(new Long(1),"Uruguay");
	    	//Paises p = new Paises(doc.getPais().getId(),doc.getPais().getNombre());
	    	
	    	Docentes d = new Docentes(doc.getNombre(), doc.getApellido(), doc.getDocumento(), doc.getTelefono(), doc.getCorreo(),p, doc.getFechaNac(),doc.getFechaIngreso(),doc.getFechaEgreso());
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
				DocenteDTO estDTO = new DocenteDTO(doc.getNombre(),doc.getTelefono(), doc.getDocumento(),doc.getApellido(),doc.getFechaNac(),
						doc.getCorreo(),new PaisesDTO(doc.getPais().getNOMBRE()),doc.getFechaEgreso(),doc.getFechaIngreso());
					
				docenteDTO.add(estDTO);
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
	   					est.getCorreo(),new PaisesDTO(est.getPais().getNOMBRE()), est.getFechaPrimerMat());
	   				
	   			estudianteDTO.add(estDTO);
	   		}
   		}catch(PersistenceException ex){
    		System.out.println("Error SQL: " + ex.getMessage());
    	}
   		return estudianteDTO;
   	}

}
