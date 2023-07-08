package br.com.jsm.chamados.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name ="USUARIO")
public class NovoUsuarioModel
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
		
	// para nao ir para o banco de dados ser apenas uma variavel 
	@Transient
	private String usrSenhaConf;
	
	@Transient
	private int staIdFix; 
	
	@Transient
	private int tpuIdFix;
	
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

	public String getUsrSenhaConf() {
		return usrSenhaConf;
	}

	public void setUsrSenhaConf(String usrSenhaConf) {
		this.usrSenhaConf = usrSenhaConf;
	}

	public int getStaIdFix() {
		return staIdFix;
	}

	public void setStaIdFix(int staIdFix) {
		this.staIdFix = staIdFix;
	}

	public int getTpuIdFix() {
		return tpuIdFix;
	}

	public void setTpuIdFix(int tpuIdFix) {
		this.tpuIdFix = tpuIdFix;
	}

	public SetorModel getSetorModel() {
		return setorModel;
	}

	public void setSetorModel(SetorModel setorModel) {
		this.setorModel = setorModel;
	}

	@OneToOne
	@JoinColumn(name="setId")
	private SetorModel setorModel;
	
}