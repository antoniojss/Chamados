package br.com.jsm.chamados.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name ="STATUS")
public class StatusModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staId;
	@NotBlank
	private String staNm;
	
	@OneToMany(mappedBy="statusModel")
	private  Collection<UsuarioModel> usuarioModelList;

	public int getStaId() {
		return staId;
	}

	public void setStaId(int staId) {
		this.staId = staId;
	}

	public String getStaNm() {
		return staNm;
	}

	public void setStaNm(String staNm) {
		this.staNm = staNm;
	}

	public Collection<UsuarioModel> getUsuarioModelList() {
		return usuarioModelList;
	}

	public void setUsuarioModelList(Collection<UsuarioModel> usuarioModelList) {
		this.usuarioModelList = usuarioModelList;
	}

	
	
}
