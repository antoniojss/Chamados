package br.com.jsm.chamados.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
@Entity
@Table(name ="CHAMADO")
public class ChamadoModel 
{

	public int getChaId() {
		return chaId;
	}

	public void setChaId(int chaId) {
		this.chaId = chaId;
	}

	public String getChmDescricao() {
		return chmDescricao;
	}

	public void setChmDescricao(String chmDescricao) {
		this.chmDescricao = chmDescricao;
	}

	public Date getChmDt() {
		return chmDt;
	}

	public void setChmDt(Date chmDt) {
		this.chmDt = chmDt;
	}

	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}

	public StatusModel getStatusModel() {
		return statusModel;
	}

	public void setStatusModel(StatusModel statusModel) {
		this.statusModel = statusModel;
	}

	public SetorModel getSetorModel() {
		return setorModel;
	}

	public void setSetorModel(SetorModel setorModel) {
		this.setorModel = setorModel;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chaId;
	private String chmDescricao;
	
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date chmDt;
	
	@OneToOne
	@JoinColumn(name="usrId")
	private UsuarioModel usuarioModel;
	
	@OneToOne
	@JoinColumn(name="staId")
	private StatusModel statusModel;
	
	@Transient
	private int staIdFix;
	
		
	public int getStaIdFix() {
		return staIdFix;
	}

	public void setStaIdFix(int staIdFix) {
		this.staIdFix = staIdFix;
	}


	@OneToOne
	@JoinColumn(name="setId")
    private SetorModel setorModel;
	
	public Collection<AcompanhamentoModel> getAcompanhamentoModelList() {
		return acompanhamentoModelList;
	}

	public void setAcompanhamentoModelList(Collection<AcompanhamentoModel> acompanhamentoModelList) {
		this.acompanhamentoModelList = acompanhamentoModelList;
	}

	@OneToMany(mappedBy="chamadoModel")
	private Collection<AcompanhamentoModel> acompanhamentoModelList;

	
}