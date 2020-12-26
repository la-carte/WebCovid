package BeanPackage;

import java.util.ArrayList;

public class UserBean {
	private int id;
	private String nom;
	private String prenom;
	private String rang;
	private String password;
	private String login;
	private String date_birth;
	private ArrayList<String> amis = new ArrayList<>();

	public ArrayList<String> getAmis() {
		return amis;
	}

	public void setAmis(ArrayList<String> amis) {
		this.amis = amis;
	}

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

	public String getDate() {
		return date_birth;
	}

	public void setDate(String date) {
		this.date_birth = date;
	}
	
	public void ajouterAmi(String login) {
		this.amis.add(login);
	}
	
	public void retirerAmi(String login) {
		this.amis.remove(login);
	}

}
