package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Personne {

	private String nom;
	private String prenom;
	private char sexe;

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

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public String toString() {
		//return nom + " "+ prenom;
		return "Personne [nom=" + nom + ", prenom=" + prenom + "," + " sexe=" + (sexe == 'f' ? "femme" : "homme") + "]";

	}

	public void addPersonne() {

		Connection c = Connexion.loadConnexion();

		try {
			PreparedStatement ps = c.prepareStatement( "INSERT INTO Perso(nom, prenom) VALUES (?, ?);" );
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

	public static Personne recupPersonne(String nomSearch) {
		Connection c = Connexion.loadConnexion();

		try {
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM perso;");

			while (result.next()) {
				System.out.println(result.getString("nom") + " " + result.getString("prenom"));
				Personne p = new Personne();
				p.setNom(result.getString("nom"));
				p.setPrenom(result.getString("prenom"));
				return p;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void effacerPersonne(String nomSup) {
		Connection c = Connexion.loadConnexion();

		try {
			//Statement st = c.createStatement();
			PreparedStatement ps = c.prepareStatement("DELETE FROM perso where nom = '" + this.nom + "';");
			//String chaineTransmis;
			//chaineTransmis = "DELETE FROM perso where id= '" + nomSup + "';";
			//st.executeUpdate(chaineTransmis);
			//ps.setString(2,this.nom);
			int nbr = ps.executeUpdate();
			if( nbr == 1)
				System.out.println("suppression reussi");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean Modifier(String modifNum, String modifNom, String modifPrenom, String modifSexe) {
		Connection c = Connexion.loadConnexion();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}

		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		
		Statement statement;
		try {
			
			statement = c.createStatement();

			// insertion de données dans la table
			String chaineEnvoi;
			chaineEnvoi = "DELETE TP2 FROM personne WHERE (\"" + modifNum + "\");";
			int nbr = statement.executeUpdate(chaineEnvoi);

			chaineEnvoi = "INSERT INTO personne (num,nom,prenom,sexe) VALUES (\"" + modifNum + "\", \"" + modifNom
					+ "\",\"" + modifPrenom + "\",\"" + modifSexe + "\");";
			nbr = statement.executeUpdate(chaineEnvoi);
			
			if (0 != nbr) {
				System.out.println("Modification reussie");
			}return true;

		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			if (c != null)
				try {
					c.close();
				} catch (SQLException ignore) {
					ignore.printStackTrace();
				}
		}return false;

}


}