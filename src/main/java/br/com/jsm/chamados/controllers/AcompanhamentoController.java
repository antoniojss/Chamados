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
import br.com.jsm.chamados.bussines.MontaComboStatus;
import br.com.jsm.chamados.bussines.MontaListaAcompanhamento;
import br.com.jsm.chamados.bussines.MontaListaChamados;
import br.com.jsm.chamados.models.AcompanhamentoModel;
import br.com.jsm.chamados.models.ChamadoModel;
import br.com.jsm.chamados.models.StatusModel;
import br.com.jsm.chamados.models.UsuarioModel;

@Controller
public class AcompanhamentoController 
{
	

	private MontaComboStatus montaComboStatus ;
	private MontaListaChamados montaListaChamados ;
	private MontaListaAcompanhamento montaListaAcompanhamento ;
	
    
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
  	
    	montaComboStatus = new MontaComboStatus(); 
    	result.include("statusLst", montaComboStatus.getListStatus(entityManager));
    	result.include("chamado", chamado);
    	
    	int ChaId = chamado.getChaId();
      	montaListaAcompanhamento = new MontaListaAcompanhamento(); 
    	result.include("acompanhamentoLst", montaListaAcompanhamento.getListAcompanhamento(entityManager, ChaId));

   	 
    }
    
  
    public void list()
    {
    	UsuarioModel usuario = auxSession.getUsuario();
    	int UsrId = usuario.getUsrId();
    	
    	montaComboStatus = new MontaComboStatus(); 
    	result.include("statusLst", montaComboStatus.getListStatus(entityManager));
    	
    	montaListaChamados = new MontaListaChamados(); 
    	result.include("chamadosLst", montaListaChamados.getListChamado(entityManager, UsrId));
   	   	
 	    
    }
    
    public void salvar(AcompanhamentoModel acompanhamento) throws Exception
    {
    	  	
    	validator.validate(acompanhamento);
    	
		
    	if (acompanhamento.getAcoId() ==0) {
         	UsuarioModel usuario = auxSession.getUsuario();
    	    acompanhamento.setUsuarioModel(usuario);
    	    Date now = new Date();
    	    acompanhamento.setAcoDataSolucao(now);
    	}
    
    	if (acompanhamento.getChamadoModel().getStatusModel().getStaId()==0) 
    	{
    		validator.add(new I18nMessage("StaNm", "not.blank")); 
    	}
    	
    	if (acompanhamento.getAcoDsSolucao() =="") 
    	{
    		validator.add(new I18nMessage("AcoDsSolucao", "not.blank")); 
    	}

      	validator.onErrorForwardTo(this).edit(acompanhamento.getChamadoModel());
        
    	
    	if (acompanhamento.getAcoId() ==0) 
    	{
     	    create(acompanhamento);
    	}
	    
    }
    
    public void create(AcompanhamentoModel acompanhamento) 
    
   {
    	this.entityManager.persist(acompanhamento);
   	
    	ChamadoModel chamado = acompanhamento.getChamadoModel();
     	ChamadoModel chamadoDb = this.entityManager.find(ChamadoModel.class, chamado.getChaId());
    	
     	StatusModel statusModel = new StatusModel();
     	
     	statusModel.setStaId(acompanhamento.getChamadoModel().getStatusModel().getStaId());
    	
   	    chamadoDb.setStatusModel(statusModel);
    	
    	this.entityManager.merge(chamadoDb);
		validator.add(new SimpleMessage("success", "success.create", Severity.SUCCESS)); 
		result.forwardTo(this).read(chamadoDb); 
    	
    }
    
    
    public void read(ChamadoModel chamado) 
    {
    	ChamadoModel chamadoDbMysql = this.entityManager.find(ChamadoModel.class, chamado.getChaId());
    	result.forwardTo(this).edit(chamadoDbMysql);
    }
    
    
    public void clear(ChamadoModel chamado) 
    {
       result.forwardTo(this).edit(null);
    } 


}
