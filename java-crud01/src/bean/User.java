package bean;

public class User {

	private int id;
	private String name;
	private String email;

	public User() {
	}

	public User(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {

		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("名前を入力してください");
		}

		if (name.length() > 100) {
			throw new IllegalArgumentException("名前の制限は100字以内です");
		}

		this.name = name;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

		if (email == null || email.isEmpty()) {
			throw new IllegalArgumentException("メールアドレスを入力してください");
		}

		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
