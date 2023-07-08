package br.com.jsm.chamados.bussines;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.jsm.chamados.models.UsuarioModel;

public class MontaComboUsuario 
{
	@SuppressWarnings("unchecked")
	public List<UsuarioModel> getListUsuario(EntityManager entityManager)
	{
	Query queryusuario = entityManager.createQuery("from UsuarioModel");
	List<UsuarioModel> usuarioLst  = queryusuario.getResultList();
	return usuarioLst;  
	}
}
