package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Article {
	
	
	private String designation;
	private int prixU;
	private int stock;
	private String codeA;
	
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getPrixU() {
		return prixU;
	}
	public void setPrixU(int prixU) {
		this.prixU = prixU;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	public String getCodeA() {
		return codeA;
	}
	public void setCodeA(String codeA) {
		this.codeA = codeA;
	}
	public void addArticle() {
		Connection c = MaBase.loadConnexion();
		
		try {
			PreparedStatement ps = c.prepareStatement( "INSERT INTO article(designation, prixU, stock) VALUES (?, ?, ?);" );
			//Statement st = c.createStatement();
			ps.setString(1, this.designation);
			ps.setInt(2, this.prixU);
			ps.setInt(3, this.stock);
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
		
		
	
	public void deleteArticle(String designation2) {
		Connection c = MaBase.loadConnexion();

		try {
			//Statement st = c.createStatement();
			PreparedStatement ps = c.prepareStatement("DELETE FROM article WHERE designation = ?;");
			//String chaineTransmis;
			//chaineTransmis = "DELETE FROM perso where id= '" + nomSup + "';";
			//st.executeUpdate(chaineTransmis);
			ps.setString(1,this.designation);
			ps.executeUpdate(); 
			int nbr = ps.executeUpdate();
			if( nbr == 1)
		    System.out.println("suppression reussi");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// via recherche commande
		public void SupprArticle() {

			Connection c = MaBase.loadConnexion();
			String numC;
			try {
				// recherche des commandes ayant cet article
				PreparedStatement ps1 = c.prepareStatement("SELECT numeroC FROM lignecommande WHERE codeA = ?;");
				ps1.setString(1, this.codeA);
				ResultSet result = ps1.executeQuery();
				Commande commande = new Commande();

				// Boucle pour trouver et supprimer les commandes ayant cet article
				while (result.next()) {
					numC = result.getString("numeroC");
					commande.setNumeroC(numC);
					commande.SupprCommande();
				}

				// suppression de l'article par la suite
				PreparedStatement ps2 = c.prepareStatement("DELETE FROM article WHERE codeA = ?;");
				ps2.setString(1, this.codeA);
				ps2.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		
		public int EtatStock() {
			Connection c = MaBase.loadConnexion();

			try {
				// recherche du stock lié à l'article this.codeA
				PreparedStatement ps = c.prepareStatement("SELECT stock FROM article WHERE codeA = ?;");
				ps.setString(1, this.codeA);
				ResultSet result = ps.executeQuery();
				result.next();

				// resulat enregistré dans stock puis retourné
				int stock = Integer.parseInt(result.getString("stock"));
				return stock;

			} catch (SQLException e) {
				System.out.println("exception stock");
				e.printStackTrace();
			}
			return 0;
		}

		public int codeArticle() {
			Connection c = MaBase.loadConnexion();

			try {
				// recherche de l'article lié à l'article this.codeA
				PreparedStatement ps = c.prepareStatement("SELECT stock FROM codeA WHERE designation = ?;");
				ps.setString(1, this.designation);
				ResultSet result = ps.executeQuery();
				result.next();

				// resulat enregistré dans codeA puis retourné
				int codeA = Integer.parseInt(result.getString("codeA"));
				return codeA;

			} catch (SQLException e) {
				System.out.println("stock expédié");
				e.printStackTrace();
			}
			return 0;
		}

		public void ModifStock(int newStock) {
			// System.out.println("entré etat stock");
			Connection c = MaBase.loadConnexion();

			try {
				// requette sql pour modifier le stock correspondant au codeA
				PreparedStatement ps = c.prepareStatement("UPDATE article SET stock = ? WHERE codeA = ?;");
				ps.setInt(1, newStock);
				ps.setString(2, this.codeA);
				ps.executeUpdate();

			} catch (SQLException e) {
				System.out.println("exception stock");
				e.printStackTrace();
			}

		}

		public static ArrayList<String> RecupArticle() {

			Connection c = MaBase.loadConnexion();

			try {

				// recherche de la totalité des articles
				PreparedStatement ps = c.prepareStatement("SELECT * FROM article;");
				ResultSet result = ps.executeQuery();

				// chaque articles (code+designation+prix) sont mise dans un tableau de String
				// puis retourné
				ArrayList<String> tabArticles = new ArrayList<String>();
				while (result.next()) {
					tabArticles.add(result.getString("codeA") + " " + result.getString("designation") + " prix: "
							+ result.getString("prixU") + " €");
				}

				return tabArticles;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}
	
	
		
	}
	
		

