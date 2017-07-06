package by.epam.barkou.bean;

public class User {

	String id;
	String email;
	String password;
	int role;

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User(String id, String email, String password, int role) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(String id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
