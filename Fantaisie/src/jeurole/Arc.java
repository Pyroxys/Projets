package jeurole;


public class Arc extends Arme {
	
	private int nbFleche;

	public Arc(int nbFleche) {
		super("Arc", 30);
		this.nbFleche = nbFleche;
	}
	
	@Override
	public void attaque(Dragon dragon) {
		nbFleche --;
		if(nbFleche > 0 ) {
			super.attaque(dragon);
		} else {
			_livre.ecrire("Malheuresment" + getProprietaire().getNom() + "ne poss�dait plus de fl�ches");
		}
	}
}
