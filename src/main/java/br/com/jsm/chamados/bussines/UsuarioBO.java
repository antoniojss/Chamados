package br.com.jsm.chamados.bussines;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import br.com.jsm.chamados.models.UsuarioModel;

public class UsuarioBO
{
  public String encryptPassword(String usrSenha) throws Exception
  {
	  MessageDigest  messageDigest = MessageDigest.getInstance("MD5");
	  BigInteger hash = new BigInteger(1,messageDigest.digest(usrSenha.getBytes()));
	  return hash.toString(16);
  }

  public boolean ChkEmailUnico(int usrId,  String usrEmail, EntityManager entityManager) 
  {
	  String query = "from                      ";
	  query +=" UsuarioModel u                  ";
	  query +=" where  u.usrEmail = :UsrEmail   ";
	  query +=" and    u.usrId <> :UsrId        ";
	  UsuarioModel usuario = null;
	  try 
	  {
		usuario = (UsuarioModel) entityManager
			.createQuery(query)
			.setParameter("UsrEmail", usrEmail)
			.setParameter("UsrId", usrId)
			.setFirstResult(0)
			.setMaxResults(1)
			.getSingleResult();
	  } 
	  catch (NoResultException noResult)
	  { 
		return true;  
	  }
	  catch (NonUniqueResultException noUnique) {
	 
	  }
      if (usuario !=null) 
	  {			
	    return false;
      }
    
      return true;
    }

	public UsuarioModel GetUsuario(String usrEmail, String usrSenha, EntityManager entityManager) {
		
		String query = "from                        ";
		  query +=" UsuarioModel u                  ";
		  query +=" where  u.usrEmail = :UsrEmail   ";
		  UsuarioModel usuario = null;
		  try 
		  {
			usuario = (UsuarioModel) entityManager
				.createQuery(query)
				.setParameter("UsrEmail", usrEmail)
				.setFirstResult(0)
				.setMaxResults(1)
				.getSingleResult();
		  } 
		  catch (NoResultException noResult)
		  { 
			
		  }
		  catch (NonUniqueResultException noUnique) 
	        {
		    noUnique.printStackTrace();
		  }
	    
	    return usuario;
	}
	  
}