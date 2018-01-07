package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.sun.java_cup.internal.runtime.Scanner;

import entities.Adresse;
import entities.Personne;
import entities.Sport;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// fait appel à la fabrique entitymanager pour creer une fabrique
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJPA");

		// cree une entité manager grace à la frabrique crée
		//EntityManager em = emf.createEntityManager();

		
	/*	  //Insertion
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJPA");
			EntityManager em = emf.createEntityManager();
		  
		  Personne p = new Personne();
		  p.setNum(5);
		  p.setNom("Faure");
		 p.setPrenom("Pierre");
		 
		 EntityTransaction transaction = em.getTransaction();
		 transaction.begin();
		 em.persist(p);
		 transaction.commit();
		 em.close();
		 emf.close();*/
		 

		/*
		 * //Mise à jour et modif nom
		 * 
		 * Personne p = em.find(Personne.class, 10);
		 * 
		 * EntityTransaction transaction = em.getTransaction(); transaction.begin();
		 * 
		 * if(p==null) { System.out.println("Personne non trouvée dans la base"); }else
		 * { p.setNom("paul"); em.flush(); }
		 * 
		 * transaction.commit(); em.close(); emf.close();
		 */

		/*
		 * //effacer une personne Personne p = em.find(Personne.class, 10);
		 * 
		 * EntityTransaction transaction = em.getTransaction(); transaction.begin();
		 * 
		 * if(p==null) { System.out.println("Personne non trouvée dans la base"); }else
		 * {
		 * 
		 * em.remove(p); }
		 * 
		 * transaction.commit(); em.close(); emf.close();
		 */

		/*
		 * // récupère les résultas du tableau String str= "SELECT * FROM personne";
		 * Query query=em.createNativeQuery(str, entities.Personne.class);
		 * List<Personne> personnes= (List<Personne>) query.getResultList();
		 * 
		 * //récupère chaque ligne de la liste et l'affecte à p for(Personne p :
		 * personnes) { System.out.println("nom = "+ p.getNom() +" / prénom = " +
		 * p.getPrenom()); }
		 * 
		 * em.close(); emf.close();
		 */

		/*
		 * // chercher par nom et prenomn et afficher en passant par requete jpql
		 * 
		 * Query query = em.createNamedQuery("findByNomPrenom");
		 * query.setParameter("nom", "faure"); query.setParameter("prenom", "pierre");
		 * 
		 * List<Personne> personnes= (List<Personne>) query.getResultList();
		 * for(Personne p : personnes) { System.out.println("nom = "+ p.getNom()
		 * +" / prénom = " + p.getPrenom()+ " avec le numéro de ligne = "+ p.getNum());
		 * }
		 */

		/*
		 * // test du OneToOne avec le joint rue
		 * 
		 * Adresse a = new Adresse(); a.setRue("Lyo"); a.setCodePostal("13015");
		 * a.setVille("Marseille"); Personne p = new Personne(); p.setAdresse(a);
		 * p.setNum(23); p.setNom("paul"); p.setPrenom("richard"); EntityTransaction t
		 * =em.getTransaction(); t.begin(); em.persist(p); t.commit();
		 * System.out.println("insertion reussie "); em.close(); emf.close();
		 */

		// inserer plusieurs adresse pour 1 personnes
		/*Adresse a1 = new Adresse();
		a1.setRue("Lyon");
		a1.setCodePostal("13015");
		a1.setVille("Marseille");
		Adresse a2 = new Adresse();
		a2.setRue("Paradis");
		a2.setCodePostal("13003");
		a2.setVille("Marseille");
		Personne p1 = new Personne();
		p1.setNum(30);
		p1.setNom("Wick");
		p1.setPrenom("John");
		p1.add(a1);
		p1.add(a2);
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(p1);
		t.commit();
		System.out.println("insertion reussie ");
		em.close();
		emf.close();*/
		
		
		/*ajout personne et sports
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJPA");
		EntityManager em = emf.createEntityManager();
		
		Personne p1 = new Personne();
		Personne p2 = new Personne();
		p1.setNum(30);
		p1.setNom("Wick");
		p1.setPrenom("John");
		p2.setNum(31);
		p2.setNom("Bob");
		p2.setPrenom("Joe");
		Sport s1 = new Sport();
		Sport s2 = new Sport();
		Sport s3 = new Sport();
		s1.setNom("football");
		s2.setNom("tennis");
		s3.setNom("box");
		s1.setType("collectif");
		s2.setType("individuel");
		s3.setType("collectif ouindividuel");
		p1.addSport(s1);
		p1.addSport(s3);
		p2.addSport(s1);
		p2.addSport(s2);
		p2.addSport(s3);
		EntityTransaction t =em.
		getTransaction();
		t.begin();
		em.persist(p1);
		em.persist(p2);
		t.commit();
		System.out.println("insertionreussie ");
		em.close();
		emf.close();*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJPA");
		EntityManager em = emf.createEntityManager();
		
		
		Personne p1 = new Personne();
		p1.setNum(1);
		p1.setNom("Wick");
		p1.setPrenom("John");
		em.getTransaction().begin();
		em.persist(p1);
		em.getTransaction().commit();
		System.out.println("nbrMAJ = " + p1.getNbrMAJ());
		// affiche nbrMAJ = 0
		p1.setNom("Travolta");
		em.getTransaction().begin();
		em.flush();
		em.getTransaction().commit();
		p1.setNom("Abruzzi");
		em.getTransaction().begin();
		em.flush();
		em.getTransaction().commit();
		System.out.println("nbrMAJ = " + p1.getNbrMAJ());
		// affiche nbrMAJ = 2
		em.close();
		emf.close();
		
	}

	
	
}
