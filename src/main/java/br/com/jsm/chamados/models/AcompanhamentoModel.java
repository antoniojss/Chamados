package br.com.jsm.chamados.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name ="ACOMPANHAMENTO")
public class AcompanhamentoModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int acoId;
	private String acoDsSolucao;
	
	
	@Temporal(value= TemporalType.TIMESTAMP)
    private Date acoDataSolucao;
	
	@OneToOne
	@JoinColumn(name="chaId")
	private ChamadoModel chamadoModel;
	
	@OneToOne
	@JoinColumn(name="usrId")
	private UsuarioModel usuarioModel;


	public int getAcoId() {
		return acoId;
	}


	public void setAcoId(int acoId) {
		this.acoId = acoId;
	}


	public String getAcoDsSolucao() {
		return acoDsSolucao;
	}


	public void setAcoDsSolucao(String acoDsSolucao) {
		this.acoDsSolucao = acoDsSolucao;
	}


	public Date getAcoDataSolucao() {
		return acoDataSolucao;
	}


	public void setAcoDataSolucao(Date acoDataSolucao) {
		this.acoDataSolucao = acoDataSolucao;
	}


	public ChamadoModel getChamadoModel() {
		return chamadoModel;
	}


	public void setChamadoModel(ChamadoModel chamadoModel) {
		this.chamadoModel = chamadoModel;
	}


	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}


	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}

}
