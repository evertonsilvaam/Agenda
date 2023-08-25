package model;

public class Utilizador {

	private String idUtilizador;
	private String usuario;
	private String senha;

	public Utilizador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilizador(String idUtilizador, String usuario, String senha) {
		super();
		this.idUtilizador = idUtilizador;
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getIdUtilizador() {
		return idUtilizador;
	}

	public void setIdUtilizador(String idUtilizador) {
		this.idUtilizador = idUtilizador;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
