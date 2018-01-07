package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Client {
	
	private String id;
	private String nom;
	private String prenom;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public Client() {
	
	}
	
	public Client(String id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void addClient() {
		Connection c = MaBase.loadConnexion();
		
		try {
			PreparedStatement ps = c.prepareStatement( "INSERT INTO client(nom, prenom) VALUES (?, ?);" );
			//Statement st = c.createStatement();
			ps.setString(1, this.nom);
			ps.setString(2, this.prenom);
			
			//String chaineTransmis;
			//chaineTransmis = "INSERT INTO perso(nom, prenom) VALUES ('" + this.nom + "' , '" + this.prenom + "');";
			//st.executeUpdate(chaineTransmis);
			int nbr = ps.executeUpdate();
			if( nbr == 1)
			System.out.println("insertion reussi");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void deleteClient(String nom) {
		Connection c = MaBase.loadConnexion();

		try {
			//Statement st = c.createStatement();
			PreparedStatement ps = c.prepareStatement("DELETE FROM client WHERE nom = ?;");
			//String chaineTransmis;
			//chaineTransmis = "DELETE FROM perso where id= '" + nomSup + "';";
			//st.executeUpdate(chaineTransmis);
			ps.setString(1,this.nom);
			ps.executeUpdate(); 
			int nbr = ps.executeUpdate();
			if( nbr == 1)
		    System.out.println("suppression reussi");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> RecupClient() {

		Connection c = MaBase.loadConnexion();

		try {

			// recherche de la totalité des clients
			PreparedStatement ps = c.prepareStatement("SELECT * FROM client;");
			ResultSet result = ps.executeQuery();

			ArrayList<String> tab = new ArrayList<String>();
			// chaque clients sont mis dans un tableau de String
			// puis retourné
			while (result.next()) {
				tab.add(result.getString("id") + " " + result.getString("nom") + " " + result.getString("prenom"));
			}

			return tab;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String toString() {
		return "nom: " + nom + ", prenom: " + prenom;
	}
	
	
	
}
