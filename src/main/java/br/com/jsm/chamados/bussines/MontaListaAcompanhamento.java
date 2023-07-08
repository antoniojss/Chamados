package br.com.jsm.chamados.bussines;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.jsm.chamados.models.AcompanhamentoModel;

public class MontaListaAcompanhamento 
{
	@SuppressWarnings("unchecked")
	public List<AcompanhamentoModel> getListAcompanhamento(EntityManager entityManager, int ChaId)
    {   
			Query query =  entityManager.createQuery("from AcompanhamentoModel where chaId =:chaId ");
			query.setParameter("chaId", ChaId);
			List<AcompanhamentoModel> acompanhamentoLst  = query.getResultList();
	    	return acompanhamentoLst;

    }
}
