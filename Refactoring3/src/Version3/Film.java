package Version3;
public class Film {
	public static final int ENFANT = 2;
	public static final int NOUVEAUTE = 1;
	public static final int NORMAL = 0;
	
	private Prix unPrix;
	
	private String titre;
	private int codePrix;
	
	public Film(String titre, int codePrix) {
		this.titre = titre;
		this.codePrix = codePrix;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setCodePrix(int codePrix) {
		this.codePrix = codePrix;
	}

	public int getCodePrix() {
		return this.codePrix;
	}

	protected double getMontant(Location location) {
		double du = 0;
		switch (location.getFilm().getCodePrix()) {
		case Film.NORMAL:
			du += 2;
			if (location.getNbJours() > 2) 
				du += (location.getNbJours() - 2) * 1.5;
			break;
		case Film.NOUVEAUTE:
			du += location.getNbJours() * 3;
			break;
		case Film.ENFANT:
			du += 1.5;
			if (location.getNbJours() > 3)
				du += (location.getNbJours() - 3) * 1.5;
			break;
		}
		return du;
	}

	int getPointsFidelite(Location location) {
		int pointsFidelite = 0;
		pointsFidelite++;
		// ajout d'un bonus pour les nouveautes louees depuis au moins deux jours
		if ((location.getFilm().getCodePrix() == Film.NOUVEAUTE) && location.getNbJours() > 1) 
			pointsFidelite++;
		return pointsFidelite;
	}
	
}