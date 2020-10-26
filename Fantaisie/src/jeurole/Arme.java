package jeurole;

import livre.EntiteLivre;

public class Arme extends EntiteLivre {
	
	private Homme proprietaire;
	private String nature;
	private int nbDegat;
	
	
	// Constructeur 
	public Arme(String nature, int nbDegat) {
		this.nature = nature;
		this.nbDegat = nbDegat;
	}
	
	public Homme getProprietaire() {
		return proprietaire;
	}


	public String getNature() {
		return nature;
	}
	
	public boolean estPris() {
//		if (this.proprietaire == null) {
//			return false;
//		}
//		return true;
		return proprietaire != null;
	}
	
	public void prendre(Homme proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	public void lacher() {
		this.proprietaire = null;
	}
	
	public void attaque(Dragon dragon) {
		System.out.print(this.getProprietaire().getNom() + "attaque" + dragon.getNom() + "avec son" + this.getNature());
		dragon.subirAttaque(nbDegat);
	}
	
	
}
