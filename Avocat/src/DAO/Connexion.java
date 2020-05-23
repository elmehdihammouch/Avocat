package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class  Connexion {
	private static Connection connexion;
	private static Statement statement;
	
	public static void  connect()  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion=DriverManager.getConnection("jdbc:mysql://localhost/pfe","root","");
			statement=connexion.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("problemes lors de la connexion avec la base de données");
		}
	}
	
	public static void disconect()  {
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int  maj( String sql) {
		int res = 0;
		try {
			res=statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public static ResultSet select(String sql)  {
		ResultSet res = null;
		try {
			res=statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
