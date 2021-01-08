package BeanPackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserBean {
	private String nom;
	private String prenom;
	private String rang;
	private String password;
	private String login;
	private String date_birth;
	private ArrayList<String> friendsRequest = new ArrayList<>();
	private ArrayList<UserBean> friends = new ArrayList<>();
	private ArrayList<Activities> activities = new ArrayList<>();
	private boolean toCovid = false;
	

	public UserBean() {
	}

	public UserBean(String login) {
		this.login = login;
		toCovid = false;
	}
	
	

	public ArrayList<Activities> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<Activities> activities) {
		this.activities = activities;
	}

	public ArrayList<String> getFriendsRequest() {
		return friendsRequest;
	}

	public void setFriendsRequest(ArrayList<String> friendsRequest) {
		this.friendsRequest = friendsRequest;
	}

	public ArrayList<UserBean> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<UserBean> friends) {
		this.friends = friends;
	}

	public boolean isToCovid() {
		return toCovid;
	}

	public void setToCovid(boolean notified) {
		this.toCovid = notified;
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
