package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/* Módulo de Conexão */

	/* Parâmetros de Conexão */
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";

	private String user = "root";
	private String password = "Admin";

	/* Método de Conexão */
	private Connection connectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			con = null;
		}
		return con;
	}

	// Teste de conexao
	public void testeConexao() {
		try {
			Connection con = connectar();
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* CRUD CREATE */

	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos(nome,fone,email,idusuario) values(?,?,?,?)";
		try {
			Connection con  = connectar();
			
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdUtilzador());
			
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inserirUsuario(Utilizador utilizador) {
		String create = "insert into usuarios(usuario,senha) values(?,?)";
		try {
			Connection con  = connectar();
			
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, utilizador.getUsuario());
			pst.setString(2, utilizador.getSenha());
	
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void realizaLogin(Utilizador utilizador) {
		String pesquisa = "select * from usuarios where utilizador = '?' and senha='?'";
		try {
			Connection con  = connectar();
			
			PreparedStatement pst = con.prepareStatement(pesquisa);
			
			pst.setString(1, utilizador.getUsuario());
			pst.setString(2, utilizador.getSenha());
	
			pst.execute();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<JavaBeans> obterContatos(Utilizador utilizador) {
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String pesquisa = ""
				+ "select * from contatos "
				+ "where idusuario = ? "
				+ "order by nome desc";
		
		try {
			Connection con  = connectar();
			
			PreparedStatement pst = con.prepareStatement(pesquisa);
			
			pst.setString(1, utilizador.getIdUtilizador());

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				JavaBeans contato = new JavaBeans();
				contato.setIdcontato(rs.getString(1));
				contato.setFone(rs.getString(2));
				contato.setEmail(rs.getString(3));
				contatos.add(contato);
			}

			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return contatos;
	}

}
