package Version3;

import java.util.Iterator;

public class HtmlStatement extends Statement{

	@Override
	public String situation(Client client) {
		String result;

		Iterator forEach = client.getLocations().iterator();
		result = "Situation du client: " + client.getNom() + "<br>";
		
		// ajout des points de fidelite et le montant total
		while (forEach.hasNext()) {
			Location each = (Location) forEach.next();
			result += "<p>" + each.getFilm().getTitre() + "</p>" + String.valueOf(each.unFilm.getCodePrix().getMontant(each)) + "<br>";

		}
		result += "Total du " + String.valueOf(client.getMontantTotal()) + "<br>";
		result += "Vous gagnez " + String.valueOf(client.getPointsFidelitesTotal()) + " points de fidelite<br>";

		
		return result;
		
	}

}
