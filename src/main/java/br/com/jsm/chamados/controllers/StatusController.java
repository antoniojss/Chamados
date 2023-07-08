package br.com.jsm.chamados.controllers;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.jsm.chamados.bussines.MontaComboStatus;
import br.com.jsm.chamados.models.StatusModel;

@Controller
public class StatusController
{ 
		MontaComboStatus montaComboStatus;
	    @Inject
		private Validator validator;
	
	    @Inject
	    private EntityManager entityManager ;
	    
	    
	    @Inject
	    private Result result;
	    
	    public void  edit(StatusModel status)
	    {
	    	result.include("status", status);
	    }
	    public void list()
	    {
	    	montaComboStatus = new MontaComboStatus(); 
	    	result.include("statusLst", montaComboStatus.getListStatus(entityManager));
	    }
	    public void salvar(StatusModel status)
	    {
	       	validator.validate(status);
	    	validator.onErrorForwardTo(this).edit(status);
	 	    	
	    	if (status.getStaId() ==0) 
	    	{
	    	    create(status);
	    	}
		    else
		    {
		    	update(status);
		    }
	    }
	    
	    public void create(StatusModel status) 
	    {
	    	this.entityManager.persist(status);
	    	validator.add(new SimpleMessage("success", "success.create", Severity.SUCCESS)); 
	    	result.forwardTo(this).edit(null);
   	
	    }
	    
	    public void read(StatusModel status) 
	    {
	    	StatusModel statusDbMysql = this.entityManager.find(StatusModel.class, status.getStaId());
	    	result.forwardTo(this).edit(statusDbMysql);
	    }
	    
	    public void update(StatusModel status) 
	    {
	       	this.entityManager.merge(status);
	    	validator.add(new SimpleMessage("success", "success.update", Severity.SUCCESS)); 
	    	result.forwardTo(this).edit(null);
	    } 
	    
	    public void delete(StatusModel status) 
	    {
	    	StatusModel statusDbMysql = this.entityManager.find(StatusModel.class, status.getStaId());
	    	this.entityManager.remove(statusDbMysql);
	    	validator.add(new SimpleMessage("success", "success.delete", Severity.SUCCESS)); 
	    	result.forwardTo(this).edit(null);
	    }
	    
	    public void clear(StatusModel status) 
	    {
	    	result.forwardTo(this).edit(null);
	    	
	    }
	    
	
}
