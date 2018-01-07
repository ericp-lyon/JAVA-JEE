package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	
	static String url = "jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false";
	static String user = "eric";
	static String password = "eric";
	static Connection connexion = null;

	
	public static Connection loadConnexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			}
		try {
			connexion = DriverManager.getConnection(url, user, password);
			return connexion;

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnexion() {

		if (connexion != null)
			try {
				connexion.close();
			} catch (SQLException ignore) {
				ignore.printStackTrace();
			}
	}
}

