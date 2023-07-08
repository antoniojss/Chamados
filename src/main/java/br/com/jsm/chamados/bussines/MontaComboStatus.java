package br.com.jsm.chamados.bussines;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.jsm.chamados.models.StatusModel;

public class MontaComboStatus 
{
	@SuppressWarnings("unchecked")
	public List<StatusModel> getListStatus(EntityManager entityManager)
	{
	Query querystatus = entityManager.createQuery("from StatusModel");
	List<StatusModel> statusLst  = querystatus.getResultList();
	return statusLst;  
	}
}
