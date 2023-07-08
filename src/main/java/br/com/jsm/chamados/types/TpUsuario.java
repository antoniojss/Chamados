package br.com.jsm.chamados.types;

public enum TpUsuario
{
	SELECIONE(0), ADMIN(1), USUARIO(2);
	 
	private final int value;

	TpUsuario(int value) 
	{
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
