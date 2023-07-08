package br.com.jsm.chamados.controllers;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.jsm.chamados.bussines.MontaComboSetor;
import br.com.jsm.chamados.bussines.UsuarioBO;
import br.com.jsm.chamados.models.NovoUsuarioModel;
import br.com.jsm.chamados.models.UsuarioModel;
@Controller
public class NovoUsuarioController 
{
	private UsuarioBO  usuarioBO; 
	private MontaComboSetor  montaComboSetor;
		
	@Inject
	private Validator validator;
	
    @Inject
    private EntityManager entityManager ;
    
    
    @Inject
    private Result result;
    @Path("/novousuario")
    public void  edit(NovoUsuarioModel usuario)
    {
    	
    	montaComboSetor = new MontaComboSetor(); 
    	result.include("setoresLst", montaComboSetor.getListSetor(entityManager));
    	result.include("usuario", usuario);

    }
    
    public void salvar(NovoUsuarioModel usuario) throws Exception
    {
    	validator.validate(usuario);
    	if (usuario.getSetorModel().getSetId() ==0) 
    	{
    		validator.add(new I18nMessage("SetId", "not.blank")); 
    	}
       	 usuario.setStaIdFix(1); 
      	 usuario.setTpuIdFix(1);
    	
    	if (!validator.hasErrors()){
    		 if (usuario.getUsrSenha() !=null && !usuario.getUsrSenha().equals(""))
    		 {
    			 if (!usuario.getUsrSenha().equals(usuario.getUsrSenhaConf()))
    			 {
    				validator.add(new I18nMessage("UsrSenha", "UsrSenhaConf")); 
    			 }
    		 }
	     }  
    	
      	 usuarioBO = new UsuarioBO();
   	  
      	 if (!usuarioBO.ChkEmailUnico(usuario.getUsrId(), usuario.getUsrEmail(), entityManager))
   	     {
   	    	validator.add(new I18nMessage("UsrEmail", "this.email.in.use"));
   	     }
      	 
    	 validator.onErrorForwardTo(this).edit(usuario);
        
		 if (usuario.getUsrSenha() !=null && !usuario.getUsrSenha().equals(""))
		 {
	    	
	    	String usrSenha = usuarioBO.encryptPassword(usuario.getUsrSenha()); 
	    	usuario.setUsrSenha(usrSenha);
		 }
		 else
		 {
			  	if (usuario.getUsrId() !=0) 
			  	{
				   	UsuarioModel usuarioDbMysql = this.entityManager.find(UsuarioModel.class, usuario.getUsrId());
				   	usuario.setUsrSenha(usuarioDbMysql.getUsrSenha());
			  	}
		 }
    	
    	if (usuario.getUsrId() ==0) 
    	{
    	    create(usuario);
    	}
	   
    }
    
     public void create(NovoUsuarioModel usuario) 
    {
    	this.entityManager.persist(usuario);
    	validator.add(new SimpleMessage("success", "success.create", Severity.SUCCESS)); 
    	result.forwardTo(this).edit(null);
    	
    }
    
     public void clear(NovoUsuarioModel usuario) 
    {
       result.forwardTo(this).edit(null);
    } 

}
