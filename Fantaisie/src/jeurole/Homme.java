package jeurole;

public class Homme extends EtreVivant{
	protected Arme maPossession;
	
	public Homme(String nom) {
		super(100, nom);
	}
	
	public void parler(String texte) {
		_livre.ecrire(super.nom + " : " + texte);
	}
	
	@Override
	public void mourir() {
		if(this.qteVie <= 0) {
			if (this.maPossession != null) {
				this.lacher();
			}
			this.bataille.eliminer(this);
		}
		_livre.ecrire("c'est ainsi que le courageux " + this.nom + " mourut.\n");
	}
	
	@Override
	public void rejointBataille(Bataille bataille) {
		super.rejointBataille(bataille);
		this.bataille.ajouter(this);
	}
	
	public void lacher() {
		maPossession.lacher();
		_livre.ecrire(this.getNom() + "A lach� " + maPossession.getNature());
		maPossession = null;
	}
	
	public void prendre(Arme arme) {
		if(maPossession != null) {
			maPossession.lacher();
			this.lacher();
		}
		
		if(arme.estPris()) {
			Homme hommeProp = arme.getProprietaire();
			this.parler((hommeProp.getNom() + "peux-tu me laisser ton" + arme.getNature() + " ?"));
			hommeProp.parler("\nPas de soucis, cela me permettra de reprendre mon souffle." );
			hommeProp.lacher();
			arme.lacher();
			
		}
		this.parler("Je prend !" + arme.getNature());
		
		if(arme instanceof Epee) {
			this.prendreEpee((Epee)arme);
		}
		this.maPossession = arme;
		arme.prendre(this);
	}
	
	public void combattre(Dragon dragon) {
		if (this.maPossession == null) {
			this.mourir();
		} else {
			maPossession.attaque(dragon);
		}
	}
	
	public void prendreEpee(Epee epee) {
		this.qteVie = qteVie - 10;
		this.parler("Je prend l'Ep�e meme si pour cela je dois perdre des forces");
		_livre.ecrire(this.getNom() + "� voulu prendre l epee mais son etat ne lui permettait pas cet ultime effort, il en est mort");
		this.mourir();
	}
}
