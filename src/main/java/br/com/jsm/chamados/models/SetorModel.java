
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
@Table(name ="SETOR")
public class SetorModel 
{
	public int getSetId() {
		return setId;
	}

	public void setSetId(int setId) {
		this.setId = setId;
	}
	
	public String getSetNm() {
		return setNm;
	}

	public void setSetNm(String setNm) {
		this.setNm = setNm;
	}

	public Collection<UsuarioModel> getUsuarioModelList() {
		return usuarioModelList;
	}

	public void setUsuarioModelList(Collection<UsuarioModel> usuarioModelList) {
		this.usuarioModelList = usuarioModelList;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int setId;
	
	@NotBlank
	private String setNm;
	
	@OneToMany(mappedBy="setorModel")
	private  Collection<UsuarioModel> usuarioModelList;
	
}
