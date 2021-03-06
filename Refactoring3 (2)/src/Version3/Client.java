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
        String result;

        Iterator forEach = locations.iterator();
        result = "Situation du client: " + getNom() + "\n";

        // ajout des points de fidelite et le montant total
        while (forEach.hasNext()) {
            Location each = (Location) forEach.next();
            result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(each.unFilm.getCodePrix().getMontant(each)) + "\n";

        }
        result += "Total du " + String.valueOf(getMontantTotal()) + "\n";
        result += "Vous gagnez " + String.valueOf(getPointsFidelitesTotal()) + " points de fidelite\n";


        return result;
    }

    protected int getPointsFidelitesTotal() {
        Iterator forEach = locations.iterator();
        int pointsFidelites = 0;
        while (forEach.hasNext()) {
            Location each = (Location) forEach.next();
            pointsFidelites += each.unFilm.getCodePrix().getPointsFidelite(each);
        }
        return pointsFidelites;
    }

    protected double getMontantTotal() {
        Iterator forEach = locations.iterator();
        double totalDu = 0;
        while (forEach.hasNext()) {
            Location each = (Location) forEach.next();
            totalDu += each.unFilm.getCodePrix().getMontant(each);
        }
        return totalDu;
    }
}