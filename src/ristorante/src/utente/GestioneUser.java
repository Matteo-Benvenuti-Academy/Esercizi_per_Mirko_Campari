package Java.ristorante.src.utente;

import java.util.ArrayList;

import Java.ristorante.src.utils.MyMenu;

public class GestioneUser {

	private ArrayList<Admin> adminArrayList;
	private ArrayList<BaseUser> baseUserArrayList;

	private User userLog;
	private boolean adminLog;

	public GestioneUser() {
		this.adminArrayList = new ArrayList<Admin>();
		this.baseUserArrayList = new ArrayList<BaseUser>();
		this.userLog = null;
		this.adminLog = false;
	}

	public boolean menu() {
		int input = MyMenu.intSelectionMenu("Scegli un opzione:", "Registrati", "Accedi", "Esci");

		switch (input) {

			case 1: {

				if (registration()) {
					System.out.println("Registrazione avvenuta con successo!");
				} else {
					System.out.println("Registrazione non avvenuta!");
				}
				;

				break;
			}
			case 2: {

				if (login()) {
					System.out.println("Accesso avvenuto con successo!");
				} else {
					System.out.println("Accesso fallito!");
				}
				;

				break;
			}
			default: {
				return false;
			}
		}

		return true;
	}

	private boolean registration() {

		int input = MyMenu.intSelectionMenu("Seleziona un opzione: ", "Aggiungi un Admin", "Aggiungi un user base");

		String[] usernameAndPassword = MyMenu.strSelectionMenu("Inserisci username e password separati da uno spazio: ")
				.trim().split(" ");

		String username = usernameAndPassword[0], password = usernameAndPassword[1];

		switch (input) {
			case 1: {
				return addAdmin(username, password);
			}
			case 2: {
				return addBasicUser(username, password);
			}
		}
		return false;
	}

	private boolean login() {

		userLog = null;

		String[] usernameAndPassword = MyMenu.strSelectionMenu("Inserisci username e password separati da uno spazio: ")
				.trim().split(" ");

		User user = new User(usernameAndPassword[0], usernameAndPassword[1]);

		for (Admin a : adminArrayList) {
			if (a.equals(user)) {
				userLog = a;
				adminLog=true;
			}
		}

		for (BaseUser u : baseUserArrayList) {
			if (u.equals(user)) {
				userLog = u;
				adminLog=false;
			}
		}

		return !(userLog == null);
	}

	public boolean addAdmin(String username, String password) {
		if (checkUnambiguity(username) && adminArrayList.size() < 2) {
			adminArrayList.add(new Admin(username, password, adminArrayList.size()));
			return true;
		}
		return false;
	}

	public boolean addBasicUser(String username, String password) {
		if (checkUnambiguity(username)) {
			baseUserArrayList.add(new BaseUser(username, password, baseUserArrayList.size()));
			return true;
		}
		return false;
	}

	private boolean checkUnambiguity(String username) {
		boolean check = true;
		for (Admin a : adminArrayList) {
			if (a.getUsername().equals(username)) {
				check = false;
			}
		}

		for (BaseUser u : baseUserArrayList) {
			if (u.getUsername().equals(username)) {
				check = false;
			}
		}
		return check;
	}

	public User getUserLog() {
		return userLog;
	}

	public boolean getAdminLog() {
		return adminLog;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		for (Admin a : adminArrayList) {
			s.append(a.toString() + "\n");
		}

		for (BaseUser u : baseUserArrayList) {
			s.append(u.toString() + "\n");
		}

		return s.toString();
	}
}
