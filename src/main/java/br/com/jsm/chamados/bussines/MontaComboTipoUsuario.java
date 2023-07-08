package br.com.jsm.chamados.bussines;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.jsm.chamados.models.SetorModel;

public class MontaComboTipoUsuario 
{
	@SuppressWarnings("unchecked")
	public List<SetorModel> getListSetor(EntityManager entityManager)
	{
 	Query querysetor =  entityManager.createQuery("from SetorModel");
	List<SetorModel> setoresLst = querysetor.getResultList();
	return setoresLst;
	}

}
