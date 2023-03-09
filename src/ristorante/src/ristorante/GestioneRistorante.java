package Java.ristorante.src.ristorante;

import java.util.ArrayList;
import java.util.Collections;

import Java.ristorante.src.utils.MyMenu;

public class GestioneRistorante {

	private Ristorante ristorante;
	private double budget;
	private double guadagno;
	private ArrayList<Pietanza> listaOrdini;

	public GestioneRistorante(ArrayList<Pietanza> listaPietanze) {
		this.ristorante = new Ristorante(listaPietanze);
		this.listaOrdini = new ArrayList<Pietanza>();
		this.budget = 0;
		this.guadagno = 0;
	}

	public boolean menu() {

		int input = MyMenu.intSelectionMenu("Inserisci un numero: ", "Ordina", "Esci");

		switch (input) {
			case 1: {
				orderMenu();
				break;
			}
			case 2: {

				System.out.println("Il Totale è: " + ristorante.getContoAperto() + "\n");
				return false;
			}
		}
		return true;
	}

	private void orderMenu() {

		boolean exitOrderMenu = false;

		int inputOrder;
		int input;

		while (!exitOrderMenu) {

			inputOrder = MyMenu.intSelectionMenu("Inserisci un numero: ", "Ordina", "Visualizza", "Esci");

			switch (inputOrder) {

				case 1: {
					System.out.println("Il tuo budget rimanente è: " + budget);
					System.out.println(ristorante.toString() + "\n");
					input = MyMenu.intSelectionMenu("Ordina un piatto inserendo un numero: ");
					Pietanza pietanza = ristorante.ordina(input - 1, budget);

					if (pietanza != null) {
						listaOrdini.add(pietanza);
						double costo = pietanza.getPrezzo();
						budget -= costo;
						guadagno += costo;
					} else {
						System.out.println("Ordinazione non effettuata");
					}

					break;
				}
				case 2: {
					System.out.println(ristorante.toString() + "\n");
					input = MyMenu.intSelectionMenu("Visualizza gli ingredienti di un piatto inserendo un numero: ");
					ristorante.visualizza(input - 1);
					break;
				}
				case 3: {
					exitOrderMenu = true;
					break;
				}
			}
		}
	}

	public boolean adminMenu() {
		System.out.println("Admin Menu");
		int inputOrder = MyMenu.intSelectionMenu("Inserisci un numero: ", "Modifica", "Statistiche", "Esci");

		switch (inputOrder) {

			case 1: {
				modifyMenu();
				break;
			}
			case 2: {
				statisticMenu();
				break;
			}
			case 3: {
				return false;
			}
		}
		return true;
	}

	private void modifyMenu() {
		boolean exitModyfyMenu = false;

		while (!exitModyfyMenu) {
			int input = MyMenu.intSelectionMenu("Inserisci un numero: ", "Modifica un piatto", "Rimuovi un piatto",
					"Esci");
			int inputMod;
			switch (input) {
				case 1: {
					System.out.println(ristorante.toString());
					inputMod = MyMenu.intSelectionMenu("Seleziona un piatto da modificare: ");
					String nome = MyMenu.strSelectionMenu("Inserisci il nuovo nome del piatto: ");
					ristorante.modificaNome(inputMod - 1, nome);
					break;
				}
				case 2: {
					System.out.println(ristorante.toString());
					inputMod = MyMenu.intSelectionMenu("Seleziona Un piatto da eliminare: ");
					ristorante.rimuoviPietanza(inputMod - 1);
					break;
				}
				case 3: {
					exitModyfyMenu = true;
					break;
				}
			}
		}
	}

	private void statisticMenu() {
		boolean exitStatisticMenu = false;

		while (!exitStatisticMenu) {
			int input = MyMenu.intSelectionMenu("Inserisci un numero: ", "Piatto piu venduto", "Piatto meno venduto",
					"Guadagno totale", "Esci");

			switch (input) {
				case 1: {
					System.out.println("Il piatto piu venduto è : \n" + piattoPiuVenduto());
					break;
				}
				case 2: {
					System.out.println("Il piatto meno venduto è : \n" + piattoMenoVenduto());
					break;
				}
				case 3: {
					System.out.println("Il guadagno totale è: " + guadagno);
					break;
				}
				case 4: {
					exitStatisticMenu = true;
					break;
				}
			}
		}
	}

	private Pietanza piattoMenoVenduto() {
		Pietanza menoComune = null;
		int occorrenzaMinore = listaOrdini.size() + 1;
		for (Pietanza pietanza : ristorante.getListaPietanze()) {
			int occorrenza = Collections.frequency(listaOrdini, pietanza);
			if (occorrenza <= occorrenzaMinore) {
				occorrenzaMinore = occorrenza;
				menoComune = pietanza;
			}
		}
		return menoComune;
	}

	private Pietanza piattoPiuVenduto() {
		Pietanza piuComune = null;
		int occorrenzaMaggiore = -1;
		for (Pietanza pietanza : ristorante.getListaPietanze()) {
			int occorrenza = Collections.frequency(listaOrdini, pietanza);
			if (occorrenza >= occorrenzaMaggiore) {
				occorrenzaMaggiore = occorrenza;
				piuComune = pietanza;
			}
		}
		return piuComune;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}
}
