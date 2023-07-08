package br.com.jsm.chamados.controllers;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.jsm.chamados.bussines.MontaComboSetor;
import br.com.jsm.chamados.models.SetorModel;
/*
 * classe que cria o crud no banco de dados, este EntityManager e o que acessa o banco.
 * CDI - > inject direct controller
 * Vraptor 
 * 
 */
@Controller
public class SetorController 
{
	MontaComboSetor montaComboSetor;
	 
	@Inject
	private Validator validator;
	
    @Inject
    private EntityManager entityManager ;
    
    
    @Inject
    private Result result;
    
    public void  edit(SetorModel setor)
    {
    	result.include("setor", setor);
    }
    public void list()
    {
    	montaComboSetor = new MontaComboSetor(); 
    	result.include("setoresLst", montaComboSetor.getListSetor(entityManager));
    	
    }
    public void salvar(SetorModel setor)
    {
    	validator.validate(setor);
    	validator.onErrorForwardTo(this).edit(setor);
    	
    	if (setor.getSetId() ==0) 
    	{
    	    create(setor);
    	}
	    else
	    {
	    	update(setor);
	    }
    }
    
    public void create(SetorModel setor) 
    {
    	this.entityManager.persist(setor);
    	validator.add(new SimpleMessage("success", "success.create", Severity.SUCCESS)); 
    	result.forwardTo(this).edit(null);
    	
    }
    
    public void read(SetorModel setor) 
    {
    	SetorModel setorDbMysql = this.entityManager.find(SetorModel.class, setor.getSetId());
    	result.forwardTo(this).edit(setorDbMysql);
    }
    
    public void update(SetorModel setor) 
    {
       	this.entityManager.merge(setor);
    	validator.add(new SimpleMessage("success", "success.update", Severity.SUCCESS)); 
    	result.forwardTo(this).edit(null);
    } 
    
    public void delete(SetorModel setor) 
    {
    	SetorModel setorDbMysql = this.entityManager.find(SetorModel.class, setor.getSetId());
    	this.entityManager.remove(setorDbMysql);
    	validator.add(new SimpleMessage("success", "success.delete", Severity.SUCCESS)); 
    	result.forwardTo(this).edit(null);
    }
    
    public void clear(SetorModel setor) 
    {
    	result.forwardTo(this).edit(null);
    }
}
