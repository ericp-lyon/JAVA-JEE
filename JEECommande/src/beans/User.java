package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

	private String nom;
	private String mdp;

	public User(String nom, String mdp) {
		super();
		this.nom = nom;
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public boolean verification() {

		Connection c = MaBase.loadConnexion();

		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM user WHERE nom = ? AND mdp = ?");
			ps.setString(1, this.nom);
			ps.setString(2, this.mdp);
			ResultSet result = ps.executeQuery();

			while (result.next()) {

				if (this.nom.equals(result.getString("nom")) && this.mdp.equals(result.getString("mdp"))) {
					return true;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;

	}

}
