package br.com.jsm.chamados.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import br.com.jsm.chamados.types.TpUsuario;

@Entity
@Table(name ="USUARIO")
public class UsuarioModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usrId;
	@NotBlank
	private String usrNome;
	@NotBlank
	private String usrEmail;
	@NotBlank
	private String usrTelefone;
	 
	private String usrSenha;
	@OneToOne
	@JoinColumn(name="setId")
	private SetorModel setorModel;
	
	// para nao ir para o banco de dados ser apenas uma variavel 
	@Transient
	private String usrSenhaConf;
	
	@Enumerated(EnumType.ORDINAL)
	private TpUsuario tpuId;

	public TpUsuario getTpuId() {
		return tpuId;
	}

	public void setTpuId(TpUsuario tpuId) {
		this.tpuId = tpuId;
	}



	@OneToOne
	@JoinColumn(name="staId")
	private StatusModel statusModel;
	
	public String getUsrSenhaConf() {
		return usrSenhaConf;
	}

	public void setUsrSenhaConf(String usrSenhaConf) {
		this.usrSenhaConf = usrSenhaConf;
	}


	public int getUsrId() {
		return usrId;
	}


	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}


	public String getUsrNome() {
		return usrNome;
	}


	public void setUsrNome(String usrNome) {
		this.usrNome = usrNome;
	}


	public String getUsrEmail() {
		return usrEmail;
	}


	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}


	public String getUsrTelefone() {
		return usrTelefone;
	}


	public void setUsrTelefone(String usrTelefone) {
		this.usrTelefone = usrTelefone;
	}


	public String getUsrSenha() {
		return usrSenha;
	}


	public void setUsrSenha(String usrSenha) {
		this.usrSenha = usrSenha;
	}


	public SetorModel getSetorModel() {
		return setorModel;
	}


	public void setSetorModel(SetorModel setorModel) {
		this.setorModel = setorModel;
	}


	public StatusModel getStatusModel() {
		return statusModel;
	}


	public void setStatusModel(StatusModel statusModel) {
		this.statusModel = statusModel;
	}



	public Collection<ChamadoModel> getChamadoModelList() {
		return chamadoModelList;
	}


	public void setChamadoModelList(Collection<ChamadoModel> chamadoModelList) {
		this.chamadoModelList = chamadoModelList;
	}



	@OneToMany(mappedBy="usuarioModel")
	private Collection<ChamadoModel> chamadoModelList;

}