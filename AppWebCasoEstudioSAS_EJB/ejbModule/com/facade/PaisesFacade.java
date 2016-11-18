package com.facade;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;

//import java.awt.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import com.dto.PaisesDTO;

import com.entities.Paises;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Session Bean implementation class PaisesFacade
 */


@Stateless
@LocalBean
public class PaisesFacade implements PaisesFacadeRemote {

	@PersistenceContext
	private EntityManager em ;
    /**
     * Default constructor. 
     */
    public PaisesFacade() {
        // TODO Auto-generated constructor stub
    	
    	}
    
    public void crearPais (PaisesDTO pai ) {
		
		Paises p = new Paises(pai.getNombre());
		em.persist(p);
    
    }
        
    @Override
    public List<PaisesDTO> listaPaises(){
    	TypedQuery<Paises> query = em.createQuery("FROM Paises", Paises.class);
    	List<PaisesDTO> paisesDTO = new ArrayList<PaisesDTO>();
    	for(Paises pai:query.getResultList()){
    		PaisesDTO paiDTO = new PaisesDTO(pai.getNOMBRE());
    		paisesDTO.add(paiDTO);
    	}
    	return paisesDTO;
    }
    
    
    
    //corregir este metodo para encontrar un pais pasandole en nombre 
    public PaisesDTO  obtenerUnPaisDTO (String nombre){
    		
    	Query query = em.createQuery("select new com.dto.PaisesDTO( P.ID_PAIS , P.NOMBRE) from Paises p where p.NOMBRE = :a " );
    		 query.setParameter("a", nombre);
    		PaisesDTO pais = (PaisesDTO) query.getSingleResult() ;
    		 
    		return pais ;
    	 }

    
    
    

}
