package Java.ristorante.src.generale;

import java.util.ArrayList;

import Java.ristorante.src.ristorante.GestioneRistorante;
import Java.ristorante.src.ristorante.Pietanza;
import Java.ristorante.src.utente.GestioneUser;
import Java.ristorante.src.utils.MyRandom;

public class GestioneGenerale {

	public static void main(String[] args) {

		GestioneUser gestioneUser = new GestioneUser();
		gestioneUser.addAdmin("a", "a");
		gestioneUser.addBasicUser("u", "u");

		ArrayList<Pietanza> listaPietanze = new ArrayList<Pietanza>();
		String[] ingredienti1 = { "patate", "salsiccia" };
		listaPietanze.add(new Pietanza("Pizza patate e salsiccia", 9.0, ingredienti1));
		String[] ingredienti2 = { "pomodoro", "mozzarella" };
		listaPietanze.add(new Pietanza("Pizza rossa", 8.0, ingredienti2));
		GestioneRistorante gestioneRistorante = new GestioneRistorante(listaPietanze);

		boolean exitLogin = false;
		boolean exitResturant = false;
		boolean exitAdminResturant = false;

		while (!exitLogin) {
			exitLogin = !gestioneUser.menu();

			if (gestioneUser.getUserLog() != null && !exitLogin) {
				gestioneRistorante.setBudget(MyRandom.randomRange(10, 100));
				while (!exitResturant) {
					exitResturant = !gestioneRistorante.menu();
				}
				exitResturant = false;
				while (gestioneUser.getAdminLog() && !exitAdminResturant){
					exitAdminResturant = !gestioneRistorante.adminMenu();
				}
			}
		}
	}
}
