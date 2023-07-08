package br.com.jsm.chamados.controllers;

import java.util.Date;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.jsm.chamados.bussines.AuxSession;
import br.com.jsm.chamados.bussines.MontaComboSetor;
import br.com.jsm.chamados.bussines.MontaComboStatus;
import br.com.jsm.chamados.bussines.MontaListaChamados;
import br.com.jsm.chamados.models.ChamadoModel;
import br.com.jsm.chamados.models.UsuarioModel;

@Controller
public class ChamadoController 
{
	private MontaComboStatus montaComboStatus ;
	private MontaComboSetor  montaComboSetor;
	private MontaListaChamados montaListaChamados;
	
	@Inject
	private Validator validator;
	
    @Inject
    private EntityManager entityManager ;
    
    
    @Inject
    private Result result;  
    
    @Inject
    private AuxSession auxSession;
    

    public void  edit(ChamadoModel chamado)
    {
    	montaComboSetor = new MontaComboSetor(); 
    	result.include("setoresLst", montaComboSetor.getListSetor(entityManager));
    	
    	montaComboStatus = new MontaComboStatus(); 
    	result.include("statusLst", montaComboStatus.getListStatus(entityManager));
    	
    	result.include("chamado", chamado); 
 
    }
    
    public void list()
    {
    	UsuarioModel usuario = auxSession.getUsuario();
    	int UsrId = usuario.getUsrId();

    	montaListaChamados = new MontaListaChamados(); 
    	result.include("chamadosLst", montaListaChamados.getListChamado(entityManager,UsrId));
    }
    
    public void salvar(ChamadoModel chamado) throws Exception
    {
    	validator.validate(chamado);
    	
    	if (chamado.getChaId() ==0) {
    		chamado.setUsuarioModel(auxSession.getUsuario());  	     
    	}
    
    	
    	if (chamado.getSetorModel().getSetId() ==0) 
    	{
    		validator.add(new I18nMessage("SetId", "not.blank")); 
    	}
    	
    	if (chamado.getStatusModel().getStaId() ==0) 
    	{
    		validator.add(new I18nMessage("StaId", "not.blank")); 
    	}
  	 	
    	
    	if (chamado.getUsuarioModel().getUsrId() ==0) 
    	{
    		validator.add(new I18nMessage("UsrId", "not.blank")); 
    	}
  	
    	
    	validator.onErrorForwardTo(this).edit(chamado);
        
    	
    	if (chamado.getChaId() ==0) 
    	{
     	    create(chamado);
    	}
	    else
	    {
	    	update(chamado);
	    }
    }
    
    public void create(ChamadoModel chamado) 
    {
    	Date timestamp = new Date();  	    	   	   	    	 
    	chamado.setChmDt(timestamp);
    	
    	this.entityManager.persist(chamado);
    	validator.add(new SimpleMessage("success", "success.create", Severity.SUCCESS)); 
    	result.forwardTo(this).edit(null);
    	
    }
    
    public void read(ChamadoModel chamado) 
    {
    	ChamadoModel chamadoDbMysql = this.entityManager.find(ChamadoModel.class, chamado.getChaId());
    	result.forwardTo(this).edit(chamadoDbMysql);
    }
    
    public void update(ChamadoModel chamado) 
    {
       	this.entityManager.merge(chamado);
       	validator.add(new SimpleMessage("success", "success.update", Severity.SUCCESS)); 
    	result.forwardTo(this).edit(null);
    } 
    
    public void delete(ChamadoModel chamado) 
    {
    	ChamadoModel chamadoDbMysql = this.entityManager.find(ChamadoModel.class, chamado.getChaId());
    	this.entityManager.remove(chamadoDbMysql);
     	validator.add(new SimpleMessage("success", "success.delete", Severity.SUCCESS)); 
      	result.forwardTo(this).edit(null);
    }
    public void clear(ChamadoModel chamado) 
    {
       result.forwardTo(this).edit(null);
    } 

}
