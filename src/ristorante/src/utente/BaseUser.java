package Java.ristorante.src.utente;

public class BaseUser extends User {

	int baseUserId;

	public BaseUser(String username, String password, int baseUserId) {
		super(username, password);

	}

	public int getBaseUserId() {
		return baseUserId;
	}

	public void setBaseUserId(int baseUserId) {
		this.baseUserId = baseUserId;
	}

	@Override
	public String toString() {
		return "Basic User: "+super.toString();
	}
}
