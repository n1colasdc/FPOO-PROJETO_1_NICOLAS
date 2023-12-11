package br.org.sesisp.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	//conectando com o BD
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/sesi";
	
	
	public static Connection criandoconexao() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexao = (Connection)DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		return conexao;
	}
	public static void main (String[] args) throws Exception{
		Connection con = criandoconexao();
		if (con != null ) {
			System.out.println("conectado!...");
			
		}
		con.close();
	}
	
	
}
