package BeanPackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserBean {
	private int id;
	private String nom;
	private String prenom;
	private String rang;
	private String password;
	private String login;
	private String date_birth;
	private ArrayList<String> friendsRequest = new ArrayList<>();
	private ArrayList<String> friends = new ArrayList<>();
	private boolean notifiedCovid = false;

	
	
	
	public ArrayList<String> getFriendsRequest() {
		return friendsRequest;
	}

	public void setFriendsRequest(ArrayList<String> friendsRequest) {
		this.friendsRequest = friendsRequest;
	}

	public ArrayList<String> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}

	public boolean isNotifiedCovid() {
		return notifiedCovid;
	}

	public void setNotifiedCovid(boolean notified) {
		this.notifiedCovid = notified;
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

}
