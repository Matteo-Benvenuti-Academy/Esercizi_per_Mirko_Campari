package Java.ristorante.src.utente;

public class Admin extends User {

	private int adminId;

	public Admin(String username, String password, int adminId) {
		super(username, password);
		this.setAdminId(adminId);
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Admin: " + super.toString();
	}

}
