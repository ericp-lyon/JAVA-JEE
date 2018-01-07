package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LigneCommande {

	private int quantite;
	private int numeroC;
	private int codeA;
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getNumeroC() {
		return numeroC;
	}
	public void setNumeroC(int numeroC) {
		this.numeroC = numeroC;
	}
	public int getCodeA() {
		return codeA;
	}
	public void setCodeA(int codeA) {
		this.codeA = codeA;
	}
	
	public void AjtLigneCmd() {
		Connection c = MaBase.loadConnexion();
		
		try {

			// on prepare la requete en utilisant PreparedStatement
			PreparedStatement ps = c
					.prepareStatement("INSERT INTO lignecommande (codeA, numeroC, quantite) VALUES (?, ?, ?);");
			// on utilise le joker ?
			// on ajoute les element qui remplace les joker
			System.out.println("codeA : " + this.codeA);
			System.out.println("numeroC: " + this.numeroC);
			System.out.println("quantite: " + this.quantite);
			ps.setInt(1, this.codeA);
			ps.setInt(2, this.numeroC);
			ps.setInt(3, this.quantite);
			// selon le type on utilise setType
			int nbr = ps.executeUpdate();
			if (nbr == 1)
				System.out.println("insertion reussie");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean verifLigneCmd() {
		/* méthode pour vérifier si une commande ne comporte pas déja cet article */
		Connection c = MaBase.loadConnexion();
		

		try {

			// recherche des commandes numeroC et les articles codeA
			PreparedStatement ps = c.prepareStatement("SELECT * FROM lignecommande WHERE codeA = ? AND numeroC = ?");
			ps.setInt(1, this.codeA);
			ps.setInt(2, this.numeroC);
			ResultSet result = ps.executeQuery();

			// boucle de recherche si une commande ne comprend pas déja l'article codeA
			// si c'est le cas, retournera true
			while (result.next()) {

				if (this.codeA == result.getInt("codeA")  && this.numeroC == (result.getInt("numeroC"))) {
					return true;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	
}
