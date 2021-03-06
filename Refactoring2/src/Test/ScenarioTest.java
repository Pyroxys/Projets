package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Version2.Client;
import Version2.Film;
import Version2.Location;

public class ScenarioTest {
	
	public String testSituation(String nomClient, String nomFilm, int typeFilm, int nbJours ) {
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

	@Test
	public void testLocationNormalLessThan3Days() {
		String attendu  = "Situation du client: un client<br>"
				+ "<p>Taxi Driver</p>2.0<br>"
				+ "Total du 2.0<br>"
				+ "Vous gagnez 1 points de fidelite<br>";
		assertEquals(attendu, testSituation("un client","Taxi Driver",Film.NORMAL,2));
	}

	@Test
	public void testLocationNormal3DaysOrMore() {
		String attendu  = "Situation du client: un client<br>"
				+ "<p>Taxi Driver</p>3.5<br>"
				+ "Total du 3.5<br>"
				+ "Vous gagnez 1 points de fidelite<br>";
		assertEquals(attendu, testSituation("un client","Taxi Driver",Film.NORMAL,3));
	}
	
	@Test
	public void testLocationNouveauteLessThan2Days() {
		String attendu  = "Situation du client: un client<br>"
				+ "<p>11 heures 14</p>3.0<br>"
				+ "Total du 3.0<br>"
				+ "Vous gagnez 1 points de fidelite<br>";
		assertEquals(attendu, testSituation("un client","11 heures 14",Film.NOUVEAUTE,1));
	}
	
	@Test
	public void testLocationNouveaute2DaysOrMore() {
		String attendu  = "Situation du client: un client<br>"
				+ "<p>11 heures 14</p>12.0<br>"
				+ "Total du 12.0<br>"
				+ "Vous gagnez 2 points de fidelite<br>";
		assertEquals(attendu, testSituation("un client","11 heures 14",Film.NOUVEAUTE,4));
	}
	
	@Test
	public void testLocationEnfantLessThan4Days() {
		String attendu  = "Situation du client: un client<br>"
				+ "<p>Cendrillon</p>1.5<br>"
				+ "Total du 1.5<br>"
				+ "Vous gagnez 1 points de fidelite<br>";
		assertEquals(attendu, testSituation("un client","Cendrillon",Film.ENFANT,3));
	}
	
	@Test
	public void testLocationEnfant4DaysOrMore() {
		String attendu  = "Situation du client: un client<br>"
				+ "<p>Cendrillon</p>3.0<br>"
				+ "Total du 3.0<br>"
				+ "Vous gagnez 1 points de fidelite<br>";
		assertEquals(attendu, testSituation("un client","Cendrillon",Film.ENFANT,4));
	}
	
	@Test
	public void testCumul() {

		Client unClient = new Client("client cumul");
		testSituationCumul(unClient, "Taxi Driver", Film.NORMAL, 2);
		testSituationCumul(unClient, "11 heures 14", Film.NOUVEAUTE, 1);
		testSituationCumul(unClient, "Cendrillon", Film.ENFANT, 2);

		assertEquals("Situation du client: client cumul<br>" + "<p>Taxi Driver</p>2.0<br>" + "<p>11 heures 14</p>3.0<br>"
				+ "<p>Cendrillon</p>1.5<br>" + "Total du 6.5<br>" + "Vous gagnez 3 points de fidelite<br>", unClient.situation());
	}
	
	@Test
	public void locationCoffretSeriesTv() {
		String attendu  = "Situation du client: un client<br>"
				+ "<p>Texas Walker Ranger</p>0.5<br>"
				+ "Total du 0.5<br>"
				+ "Vous gagnez 0 points de fidelite<br>";
		assertEquals(attendu, testSituation("un client","Texas Walker Ranger",Film.COFFRET_SERIES_TV,1));
	}
	
	@Test
	public void locationCinephileFor1Day() {
		String attendu  = "Situation du client: un client<br>"
				+ "<p>blabla</p>2.0<br>"
				+ "Total du 2.0<br>"
				+ "Vous gagnez 3 points de fidelite<br>";
		assertEquals(attendu, testSituation("un client","blabla",Film.CINEPHILE,1));
	}
	
	@Test
	public void locationCinephileForMoreThan1Day() {
		String attendu  = "Situation du client: un client<br>"
				+ "<p>blabla</p>6.0<br>"
				+ "Total du 6.0<br>"
				+ "Vous gagnez 0 points de fidelite<br>";
		assertEquals(attendu, testSituation("un client","blabla",Film.CINEPHILE,2));
	}
}
