package br.com.jsm.chamados.bussines;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import br.com.jsm.chamados.models.UsuarioModel;
@Named
@SessionScoped
public class AuxSession implements Serializable {
	 
	private static final long serialVersionUID = -6003593341476903543L;
    private UsuarioModel usuario;
	public UsuarioModel getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
