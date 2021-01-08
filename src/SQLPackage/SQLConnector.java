package SQLPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BeanPackage.Activities;
import BeanPackage.UserBean;

public class SQLConnector {
	public SQLConnector() {
	}

	public UserBean getUser(String login, String password) {

		UserBean user = null;

		String rqString = "Select * from User where login='" + login + "' and password='" + password + "';";
		ResultSet res = doRequest(rqString);
		int i = 0;
		try {
			while (res.next()) {
				if (i == 0) {
					user = new UserBean();
					user.setLogin(res.getString("login"));
					user.setPassword(res.getString("password"));
					user.setNom(res.getString("name"));
					user.setPrenom(res.getString("surname"));
					user.setRang(res.getString("role"));
					user.setDate(res.getString("dateBirth"));
					if (res.getInt("toCovid") == 0)
						user.setToCovid(false);
					else
						user.setToCovid(true);
					i++;
				} else {
					i++;
					arret("Plus d'un utilisateur ayant le meme login ???");
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public ArrayList<UserBean> getFriends(String loginUser) {
		ArrayList<UserBean> friends = new ArrayList<>();
		Connection con = connect();
		// select * from user_database.friend where login="lala" and test="lala"
		String rqString = "Select loginUser from friend where loginFriend='" + loginUser + "' and isFriend=1";
		ResultSet res = doRequest(rqString);
		int i = 0;
		try {
			while (res.next()) {
				UserBean friend = new UserBean(res.getString("loginUser"));
				friends.add(friend);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return friends;
	}

	public void makeCovid(String login) {
		Connection con = connect();

		try {
			// create our java preparedstatement using a sql update query
			PreparedStatement ps = con.prepareStatement("UPDATE user SET toCovid = 1 WHERE login ='" + login + "'");

			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public UserBean getUser(String login) {

		UserBean user = null;

		String rqString = "Select * from user where login='" + login + "';";
		ResultSet res = doRequest(rqString);
		int i = 0;
		try {
			while (res.next()) {
				if (i == 0) {
					user = new UserBean();
					user.setLogin(res.getString("login"));
					user.setPassword(res.getString("password"));
					user.setNom(res.getString("name"));
					user.setPrenom(res.getString("surname"));
					user.setRang(res.getString("role"));
					user.setDate(res.getString("dateBirth"));
					if (res.getInt("toCovid") == 0)
						user.setToCovid(false);
					else
						user.setToCovid(true);
					i++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public ArrayList<String> getFriendRequest(String loginUser) {
		ArrayList<String> friends = new ArrayList<>();
		Connection con = connect();
		// select * from user_database.friend where login="lala" and test="lala"
		String rqString = "Select loginUser from friend where loginFriend='" + loginUser + "' and isFriend=0";
		ResultSet res = doRequest(rqString);
		int i = 0;
		try {
			while (res.next()) {
				if (i == 0) {
					friends.add(res.getString("loginUser"));
					i++;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return friends;
	}

	public void addFriend(String loginFriend, String loginUser) {
		// mettre le booleen à 1
		// ajouter une ligne avec l'inverse de celle de base
		Connection con = connect();

		try {
			// create our java preparedstatement using a sql update query
			PreparedStatement ps = con.prepareStatement("UPDATE friend SET isFriend = 1 WHERE loginFriend ='"
					+ loginUser + "' AND loginUser='" + loginFriend + "'");
			PreparedStatement pss = con.prepareStatement("INSERT INTO friend (loginUser,loginFriend,isFriend) VALUES ('"
					+ loginUser + "','" + loginFriend + "', 1)");
			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			ps.close();
			pss.executeUpdate();
			pss.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addFriendRequest(String loginFriend, String loginUser) {

		Connection con = connect();

		try {
			Statement stmt = con.createStatement();
			String rqString = "INSERT INTO friend (loginUser,loginFriend,isFriend) VALUES ('" + loginUser + "','"
					+ loginFriend + "', 0)";
			stmt.executeUpdate(rqString);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void setUser(String old_login, String login, String password, String name, String surname, String date) {
		Connection con = connect();

		try {
			// create our java preparedstatement using a sql update query
			PreparedStatement ps = con.prepareStatement(
					"UPDATE User SET login = ?, password = ?, name = ?, surname = ?, dateBirth = ? WHERE login = ?");

			// set the preparedstatement parameters
			ps.setString(1, login);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, surname);
			ps.setString(5, date);
			ps.setString(6, old_login);

			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void createUser(String login, String password, String nom, String prenom, String date) {

		Connection con = connect();

		try {
			Statement stmt = con.createStatement();
			String rqString = "INSERT INTO User (role,toCovid,login,password,name,surname,dateBirth) VALUES ('basic_user', '0', '"
					+ login + "','" + password + "','" + prenom + "','" + nom + "','" + date + "')";
			stmt.executeUpdate(rqString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet doRequest(String sql_string) {
		ResultSet results = null;
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			results = stmt.executeQuery(sql_string);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	public void notifyFriend(String login) {
		Connection con = connect();

		try {
			Statement stmt = con.createStatement();
			String rqString = "INSERT INTO User (notified) VALUES (true)";
			stmt.executeUpdate(rqString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection connect() {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			arret("Impossible de charger le pilote jdbc");
		}

		affiche("connexion a la base de données");

		try {
			String DBurl = "jdbc:mysql://localhost:3306/user_database?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
			con = DriverManager.getConnection(DBurl, "root", "motdepasse");
			affiche("connexion réussie");
		} catch (SQLException e) {
			System.out.println(e);
			arret("Connection à la base de données impossible");
		}

		return con;
	}

	public void createActivity(String login,String name, String date, String begin, String end) {
		Connection con = connect();

		try {
			Statement stmt = con.createStatement();
			String rqString = "INSERT INTO activity (name,date,begin,end,login) VALUES ('" + name + "','" + date + "','"
					+ begin + "','" + end +"','" + login + "')";
			stmt.executeUpdate(rqString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Activities> getActivities(String login){
		ArrayList<Activities> activities = new ArrayList<>();
		Connection con = connect();
		Activities a = new Activities();
		String rqString = "Select * from activity where login='" + login + "'";
		ResultSet res = doRequest(rqString);
		
		int i = 0;
		try {
			while (res.next()) {
					a = new Activities();
					a.setName(res.getString("name"));
					a.setDate(res.getString("date"));
					a.setHdebut(res.getString("begin"));
					a.setHfin(res.getString("end"));
					activities.add(a);
					System.out.println(i);
					i++;
				}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return activities;
	}

	


	private static void affiche(String message) {
		System.out.println(message);
	}

	private static void arret(String message) {
		System.err.println(message);
		System.exit(99);
	}

}
