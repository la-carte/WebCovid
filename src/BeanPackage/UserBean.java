package BeanPackage;

public class UserBean {
	private int id;
	private String nom;
	private String prenom;
	private String rang;
	private String password;
	private String login;

	public int getId() {
		return this.id;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public String getPassword() {
		return this.password;
	}

	public String getLogin() {
		return this.login;
	}

	public String getRang() {
		return this.rang;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setRang(String rang) {
		this.rang = rang;
	}

}
