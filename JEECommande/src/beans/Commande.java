package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Commande {
	
	
	private String date;
	private String numeroC;
	private int id;
	
	
	public String getNumeroC() {
		return numeroC;
	}
	public void setNumeroC(String numeroC) {
		this.numeroC = numeroC;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public void AjouttCommande() {

		Connection c = MaBase.loadConnexion();

		try {

			// on prepare la requete en utilisant PreparedStatement
			PreparedStatement ps = c.prepareStatement("INSERT INTO commande (numeroC, date, id) VALUES (?, ?);");

			// on utilise le joker ?
			// on ajoute les element qui remplace les joker
		
			ps.setString(1, this.date);
			ps.setInt(2, this.id);

			// selon le type on utilise setType
			int nbr = ps.executeUpdate();
			if (nbr == 1)
				System.out.println("insertion reussie");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void SupprCommande() {

		Connection c = MaBase.loadConnexion();

		try {
			// suppression des lignes de commande ayant ce numero de commande
			PreparedStatement ps1 = c.prepareStatement("DELETE FROM lignecommande WHERE numeroC = ?;");
			ps1.setString(1, this.numeroC);
			ps1.executeUpdate();

			// suppression des commandes ayant ce numero de commande
			PreparedStatement ps2 = c.prepareStatement("DELETE FROM commande WHERE numeroC = ?;");
			ps2.setString(1, this.numeroC);
			ps2.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<String> RecupCommande() {
		Connection c = MaBase.loadConnexion();
		

		try {

			// recherche de la totalité des commandes
			PreparedStatement ps = c.prepareStatement("SELECT * FROM commande;");
			ResultSet result = ps.executeQuery();

			// chaque commande est mise dans un tableau de String
			// puis retourné
			ArrayList<String> tabCommandes = new ArrayList<String>();
			while (result.next()) {
				tabCommandes.add("Commande n° " + result.getString("numeroC") + " du " + result.getString("date"));
			}

			return tabCommandes;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String InfoCommandeClient() {
		Connection c = MaBase.loadConnexion();
	

		try {

			// exctraction de la totalité des commandes pour un client id
			PreparedStatement ps1 = c.prepareStatement("SELECT id FROM commande WHERE numeroC = ?;");
			ps1.setString(1, this.numeroC);
			ResultSet result = ps1.executeQuery();
			result.next();

			// exctraction du nom du client de l'id
			PreparedStatement ps2 = c.prepareStatement("SELECT nom FROM client WHERE id = ?;");
			ps2.setString(1, result.getString("id"));
			ResultSet resultNom = ps2.executeQuery();
			resultNom.next();

			// exctraction du prenom du client de l'id
			PreparedStatement ps3 = c.prepareStatement("SELECT prenom FROM client WHERE id = ?;");
			ps3.setString(1, result.getString("id"));
			ResultSet resultPrenom = ps3.executeQuery();
			resultPrenom.next();
			String PrenomNom = (resultPrenom.getString("prenom") + " " + resultNom.getString("nom"));

			// retourne la chaine de caractere à afficher
			return PrenomNom;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public int InfoCommandeTotal() {
		Connection c = MaBase.loadConnexion();
		

		try {
			int prix, quantite, total = 0;
			// exctraction de la totalité des infos d'un commande de la ligne de commande
			PreparedStatement ps1 = c.prepareStatement("SELECT * FROM lignecommande WHERE numeroC = ?;");
			ps1.setString(1, this.numeroC);
			ResultSet result = ps1.executeQuery();

			// exctraction de la totalité des infos des articles
			PreparedStatement ps2 = c.prepareStatement("SELECT * FROM article;");
			ResultSet resultArticles = ps2.executeQuery();

			// boucle de calcul du montant totla des articles en fonction de leur quantité
			while (result.next()) {
				while (resultArticles.next()) {
					System.out.println("boucle article");
					if (resultArticles.getString("codeA").equals(result.getString("codeA"))) {

						prix = Integer.parseInt(resultArticles.getString("prixU"));
						quantite = Integer.parseInt(result.getString("quantite"));
						total = total + (prix * quantite);
					}
				}
				// recharchement des articles dans la table article pour x comparaisons
				resultArticles = ps2.executeQuery();
			}
			return total;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
	

}
