package Entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personne
 *
 */
@Entity


public class Personne implements Serializable {

	   
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Integer num;
	private String nom;
	private String prenom;
	
	private static final long serialVersionUID = 1L;

	public Personne() {
		super();
	}   
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
   
}
