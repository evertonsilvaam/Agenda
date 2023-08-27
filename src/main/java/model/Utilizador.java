package model;

public class Utilizador {

	private int idUtilizador;
	private String usuario;
	private String senha;

	public Utilizador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilizador(int idUtilizador, String usuario, String senha) {
		super();
		this.idUtilizador = idUtilizador;
		this.usuario = usuario;
		this.senha = senha;
	}

	public int getIdUtilizador() {
		return idUtilizador;
	}

	public void setIdUtilizador(int idUtilizador) {
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
