package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personne
 *
 */
@Entity
@NamedQuery(name="findByNomPrenom", query="SELECT p FROM Personne p WHERE p.nom = :nom and p.prenom = :prenom")
// attention au dessus c'est une requete jpql
//apres les : le nom et prenom equivaut au joker pour eviter injection sql 

public class Personne implements Serializable {

	   
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	
	private int num;
	private String nom;
	private String prenom;
	private int nbrMAJ=0;	
		
	private static final long serialVersionUID = 1L;
	
	//@OneToOne (cascade={CascadeType.PERSIST, CascadeType.REMOVE})// tjs faire les cascade sur les 2 pour eviter exception 
	//@JoinColumn (name="rue", referencedColumnName="rue", nullable=false) // permet de faire le join entre les 2 tableaux

	//test avec OneToMany
	
	//@OneToMany (cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	
	//private List <Adresse> adresses = new ArrayList<Adresse>();
	
	// generer dans source add et remove a la place set et get
	
	//public boolean add(Adresse e) {
	//	return adresses.add(e);
	//}
	//public boolean remove(Object o) {
	//	return adresses.remove(o);
	//}

	
	
	/*on enleve attribut adresse unique
	private Adresse adresse;

	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}*/
	
	//test avec ManyToMany avec sport
	
	@ManyToMany (cascade={CascadeType.PERSIST, CascadeType.REMOVE}) // version unidirectionnelle
	private List <Sport> sports = new ArrayList <Sport> ();
	
	
	
	
	
	
	public int getNbrMAJ() {
		return nbrMAJ;
	}

	public void setNbrMAJ(int nbrMAJ) {
		this.nbrMAJ = nbrMAJ;
	}

	@PostUpdate
	public void updateNbrMAJ() {
		this.nbrMAJ++;
		
	}
	public void addSport(Sport s) {
		s.addPersonne(this);
		sports.add(s);
	}
	
	public void rmoveSport(Sport s) {
		s.addPersonne(this);
		sports.remove(s);
		
	}
	
	
	public boolean remove(Object o) {
		return sports.remove(o);
	}
	public List<Sport> getSports() {
		return sports;
	}
	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//public List<Adresse> getAdresses() {
	//	return adresses;
	//}
	//public void setAdresses(List<Adresse> adresses) {
	//	this.adresses = adresses;
	//}
	public Personne() {
		super();
	}   
	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
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
