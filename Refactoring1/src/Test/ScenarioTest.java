package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;

import org.junit.Test;
import Version1.*;

public class ScenarioTest {

	@Before
	public void setUp() throws Exception {

	}

	// test location film normal d'une duree inferieure a 3 jours
	@Test
	public void testLocationFilNormalMoinsDeTroisJours() {
		assertEquals("Situation du client: un client\n" + "\tTaxi Driver\t2.0\n" + "Total du 2.0\n"
				+ "Vous gagnez 1 points de fidelite\n", testSituation("un client", "Taxi Driver", Film.NORMAL, 2));
	}

	// test location film normal d'une duree d'au moins 3 jours
	@Test
	public void testLocationFilmNormalAuMoinsTroisJours() {
		assertEquals("Situation du client: un client\n" + "\tTaxi Driver\t3.5\n" + "Total du 3.5\n"
				+ "Vous gagnez 1 points de fidelite\n", testSituation("un client", "Taxi Driver", Film.NORMAL, 3));
	}

	// test location film nouveaute d'une duree inferieure a 2 jours
	@Test
	public void testLocationFilmNouveauMoinsDeDeuxJours() {
		assertEquals("Situation du client: un client\n" + "\t11 heures 14\t3.0\n" + "Total du 3.0\n"
				+ "Vous gagnez 1 points de fidelite\n", testSituation("un client", "11 heures 14", Film.NOUVEAUTE, 1));
	}

	// test location film nouveaute d'une duree d'au moins 2 jours
	@Test
	public void testLocationFilmNouveauAuMoinsDeuxJours() {
		assertEquals("Situation du client: un client\n" + "\t11 heures 14\t12.0\n" + "Total du 12.0\n"
				+ "Vous gagnez 2 points de fidelite\n", testSituation("un client", "11 heures 14", Film.NOUVEAUTE, 4));
	}

	// test location film enfant d'une duree inferieure e 4 jours
	@Test
	public void testLocationFilmEnfantMoinsDeQuatreJours() {
		assertEquals("Situation du client: un client\n" + "\tCendrillon\t1.5\n" + "Total du 1.5\n"
				+ "Vous gagnez 1 points de fidelite\n", testSituation("un client", "Cendrillon", Film.ENFANT, 3));
	}

	// test location film enfant d'une duree d'au moins 4 jours
	@Test
	public void testLocationFilmEnfantAuMoinsQuatreJours() {
		assertEquals("Situation du client: un client\n" + "\tCendrillon\t3.0\n" + "Total du 3.0\n"
				+ "Vous gagnez 1 points de fidelite\n", testSituation("un client", "Cendrillon", Film.ENFANT, 4));
	}

	// test cumul
	@Test
	public void testCumul() {

		Client unClient = new Client("client cumul");
		testSituationCumul(unClient, "Taxi Driver", Film.NORMAL, 2);
		testSituationCumul(unClient, "11 heures 14", Film.NOUVEAUTE, 1);
		testSituationCumul(unClient, "Cendrillon", Film.ENFANT, 2);

		assertEquals("Situation du client: client cumul\n" + "\tTaxi Driver\t2.0\n" + "\t11 heures 14\t3.0\n"
				+ "\tCendrillon\t1.5\n" + "Total du 6.5\n" + "Vous gagnez 3 points de fidelite\n", unClient.situation());
	}

	public String testSituation(String nomClient, String nomFilm, int typeFilm, int nbJours) {
		Client unClient = new Client(nomClient);
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
		return unClient.situation();
	}

	public void testSituationCumul(Client unClient, String nomFilm, int typeFilm, int nbJours) {
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
	}
}