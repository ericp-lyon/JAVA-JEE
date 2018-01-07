package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Sport
 *
 */
@Entity

public class Sport implements Serializable {

	   
	@Id
	private String nom;
	private String type;
	private static final long serialVersionUID = 1L;

	
	//version bidirectionnelle
		@ManyToMany (mappedBy="sports")
		private List <Personne> personnes = new ArrayList <Personne>();
		
		
		
	public boolean addPersonne(Personne e) {
			return personnes.add(e);
		}
		public boolean removePersonne(Object o) {
			return personnes.remove(o);
		}
	public Sport() {
		super();
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
}
