package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	/*Módulo de Conexão*/
	
	/*Parâmetros de Conexão*/
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	private String user = "root";
	private String password = "Admin";
	
	/*Método de Conexão*/
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
	
	//Teste de conexao
	public void testeConexao() {
		try {
			Connection con = connectar();
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
