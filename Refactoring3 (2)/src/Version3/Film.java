package Version3;
public class Film {
	public static final int ENFANT = 2;
	public static final int NOUVEAUTE = 1;
	public static final int NORMAL = 0;
	
	private String titre;
	private Prix codePrix;
	
	public Film(String titre, int codePrix) {
		this.titre = titre;
		setCodePrix(codePrix);
	}

	public String getTitre() {
		return this.titre;
	}

	public void setCodePrix(int codePrix) {
		switch (codePrix) {
		case NORMAL:
			this.codePrix = new PrixNormal();
		break;
		case NOUVEAUTE:
			this.codePrix = new PrixNouveaute();
		break;
		case ENFANT:
			this.codePrix = new PrixEnfant();
		break;
		}
	}

	public Prix getCodePrix() {
		return this.codePrix;
	}
}