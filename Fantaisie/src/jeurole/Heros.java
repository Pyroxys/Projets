package jeurole;

public class Heros extends Homme {

	public Heros(String nom) {
		super(nom);
		super.qteVie = 150;
	}
	
	public void parler(String texte) {
		_livre.ecrire("Le Heros ");
		super.parler(texte);
		
	}
	
	@Override
	public void prendreEpee(Epee epee) {
		this.parler("Je prend Epee " + epee.getNom());
	}
}
