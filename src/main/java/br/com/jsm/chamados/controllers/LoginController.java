package br.com.jsm.chamados.controllers;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.jsm.chamados.bussines.AuxSession;
import br.com.jsm.chamados.bussines.UsuarioBO;
import br.com.jsm.chamados.models.UsuarioModel;
@Controller
public class LoginController
{
	
	@Inject
	private Validator validator;
	
    @Inject
    private EntityManager entityManager ;
    
	@Inject
     private Result result;
	
	@Inject
	private AuxSession auxSession;
	
	
  	
	 public void formLogin()
	 {
	    	       	
	 }
	    
	 public void check(String UsrEmail, String UsrSenha ) throws Exception
	
	 {   	
		 UsuarioBO usuarioBO = new UsuarioBO();
		 UsrSenha = usuarioBO.encryptPassword(UsrSenha);
		    
	    	UsuarioModel usuario  = usuarioBO.GetUsuario(UsrEmail, UsrSenha, entityManager);
		
	    	if (usuario == null || !usuario.getUsrSenha().equals(UsrSenha)) 
		    {
	                validator.add(new I18nMessage("Login", "login.invalid")); 
	    	}

	       	validator.onErrorForwardTo(LoginController.class).formLogin();
	  	 	auxSession.setUsuario(usuario);
	        result.forwardTo(ChamadoController.class).list();        
			
	 }
	 
	 public void logout() 
	 {   UsuarioModel usuario  = null;
		 auxSession.setUsuario(usuario); 
		 result.forwardTo(LoginController.class).formLogin();
		 
	 }
}