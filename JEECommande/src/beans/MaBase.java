package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaBase {
	///bien penser a mettre le nom de la table en question
	//bien penser à mettre le connector java dans lib/ passerelle
	static String url = "jdbc:mysql://localhost:3306/m2i?autoReconnect=true&useSSL=false";
	static String user = "admin";
	static String password = "admin";
	static Connection MaBase = null;

	
	public static Connection loadConnexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			}
		try {
			MaBase = DriverManager.getConnection(url, user, password);
			return MaBase;

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnexion() {

		if (MaBase != null)
			try {
				MaBase.close();
			} catch (SQLException ignore) {
				ignore.printStackTrace();
			}
	}

}
