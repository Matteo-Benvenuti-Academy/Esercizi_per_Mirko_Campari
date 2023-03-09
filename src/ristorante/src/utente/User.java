package Java.ristorante.src.utente;

public class User {

	private String username;
	private String password;

	public User(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return username + " " + password;
	}

	@Override
	public boolean equals(Object obj) {

		// If the object is compared with itself then return true
		if (obj == this) {
			return true;
		}

		/*
		 * Check if o is an instance of user or not
		 * "null instanceof [type]" also returns false
		 */
		if (!(obj instanceof User)) {
			return false;
		}

		// typecast o to User so that we can compare data members
		User user = (User) obj;

		// Compare the data members and return accordingly
		return (user.getUsername().equals(this.getUsername())) && user.getPassword().equals(this.getPassword());
	}

}
