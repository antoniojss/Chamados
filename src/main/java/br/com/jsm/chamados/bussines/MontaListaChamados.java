package br.com.jsm.chamados.bussines;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.jsm.chamados.models.ChamadoModel;

public class MontaListaChamados 
{  
	 
	@SuppressWarnings("unchecked")
	public List<ChamadoModel> getListChamado(EntityManager entityManager, int UsrId)
    {   
		if (UsrId == 1) 
	    {
		 	Query query =  entityManager.createQuery("from ChamadoModel");
	    	List<ChamadoModel> chamadosLst  = query.getResultList();
	    	return chamadosLst;
	    }
	    else 
	    {
		 	Query query = entityManager.createQuery("from ChamadoModel where usrId =:usrId");
			query.setParameter("usrId", UsrId);
	    	List<ChamadoModel> chamadosLst  = query.getResultList();
	    	return  chamadosLst;

	    }
	    
    }
}
