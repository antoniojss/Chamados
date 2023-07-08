package br.com.jsm.chamados.controllers;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.jsm.chamados.bussines.MontaComboSetor;
import br.com.jsm.chamados.bussines.MontaComboStatus;
import br.com.jsm.chamados.bussines.UsuarioBO;
import br.com.jsm.chamados.models.UsuarioModel;
import br.com.jsm.chamados.types.TpUsuario;
/*
 * classe que cria o crud no banco de dados, este EntityManager e o que acessa o banco.
 * CDI - > inject direct controller
 * Vraptor 
 * 
 */
@Controller
public class UsuarioController 
{
	private UsuarioBO  usuarioBO; 
	private MontaComboStatus montaComboStatus ;
	private MontaComboSetor  montaComboSetor;
		
	@Inject
	private Validator validator;
	
    @Inject
    private EntityManager entityManager ;
    
    
    @Inject
    private Result result;
    
    public void  edit(UsuarioModel usuario)
    {
    	
    	montaComboSetor = new MontaComboSetor(); 
    	result.include("setoresLst", montaComboSetor.getListSetor(entityManager));
    	
    	montaComboStatus = new MontaComboStatus(); 
    	result.include("statusLst", montaComboStatus.getListStatus(entityManager));
    	
    	result.include("tpUsuariosLst", TpUsuario.values());
        
    	result.include("usuario", usuario);

    }
    
    
    @SuppressWarnings("unchecked")
	public void list()
    {
    	Query query = this.entityManager.createQuery("from UsuarioModel");
    	List<UsuarioModel> usuarios = query.getResultList();
    	result.include("usuarios", usuarios);
    }
    
    public void salvar(UsuarioModel usuario) throws Exception
    {
    	validator.validate(usuario);
    	if (usuario.getSetorModel().getSetId() ==0) 
    	{
    		validator.add(new I18nMessage("SetId", "not.blank")); 
    	}
       	if (usuario.getStatusModel().getStaId() ==0) 
    	{
    		validator.add(new I18nMessage("StaId", "not.blank")); 
    	}
       	if (usuario.getTpuId().equals(TpUsuario.SELECIONE)) 
    	{
    		validator.add(new I18nMessage("TpuId", "not.blank")); 
    	}
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
	    else
	    {
	    	update(usuario);
	    }
    }
    
    public void create(UsuarioModel usuario) 
    {
    	this.entityManager.persist(usuario);
    	validator.add(new SimpleMessage("success", "success.create", Severity.SUCCESS)); 
    	result.forwardTo(this).edit(null);
    	
    }
    
    public void read(UsuarioModel usuario) 
    {
    	UsuarioModel usuarioDbMysql = this.entityManager.find(UsuarioModel.class, usuario.getUsrId());
    	result.forwardTo(this).edit(usuarioDbMysql);
    }
    
    public void update(UsuarioModel usuario) 
    {
       	this.entityManager.merge(usuario);
       	validator.add(new SimpleMessage("success", "success.update", Severity.SUCCESS)); 
    	result.forwardTo(this).edit(null);
    } 
    
    public void delete(UsuarioModel usuario) 
    {
    	UsuarioModel usuarioDbMysql = this.entityManager.find(UsuarioModel.class, usuario.getUsrId());
    	this.entityManager.remove(usuarioDbMysql);
     	validator.add(new SimpleMessage("success", "success.delete", Severity.SUCCESS)); 
      	result.forwardTo(this).edit(null);
    }
    public void clear(UsuarioModel usuario) 
    {
       result.forwardTo(this).edit(null);
    } 

}
