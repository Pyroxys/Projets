package Version3;

import java.util.Vector;
import java.util.Iterator;

public class Client {
	private String nom;
	private Vector locations = new Vector();

	public Client(String nom) {
		this.nom = nom;
	}

	public void addLocation(Location location) {
		this.locations.add(location);
	}

	public String getNom() {
		return this.nom;
	}

	public String situation() {
		Iterator forEach = locations.iterator();
		String result = "Situation du client: " + getNom() + "\n";
		// ajout des points de fidelite et le montant total
		getPointsFidelitesTotal(forEach, result);
		 getMontantTotal(forEach, result);
		// mise en forme location
		
		// ajouter capitulatif client

		return result;
	}

	protected int getPointsFidelitesTotal(Iterator forEach, String result) {
		int pointsFidelites = 0;
		Location each;
		while (forEach.hasNext()) {
			each = (Location) forEach.next();
			pointsFidelites += each.unFilm.getPointsFidelite(each);
		}
		result += "Vous gagnez " + String.valueOf(pointsFidelites) + " points de fidelite\n";
		return pointsFidelites;
	}

	protected double getMontantTotal(Iterator forEach, String result) {
		double totalDu = 0;
		Location each;
		while (forEach.hasNext()) {
			each = (Location) forEach.next();
			totalDu += each.unFilm.getMontant(each);
			result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(each.unFilm.getMontant(each)) + "\n";
		}
		result += "Total du " + String.valueOf(totalDu) + "\n";
		return totalDu;
	}

}