package ServletPackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BeanPackage.Activities;
import BeanPackage.UserBean;
import SQLPackage.SQLConnector;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		
		
		SQLConnector sc = new SQLConnector();
		ArrayList<String> friendsRequest = new ArrayList<>();
		ArrayList<UserBean> friends = new ArrayList<>();
		ArrayList<Activities> activities = new ArrayList<>();
		if((login != "") && (login != null) && (password != "") && (password != null) ) {
			
			
			UserBean current_user = sc.getUser(login,password);
			
			friendsRequest= sc.getFriendRequest(current_user.getLogin());
			for(String friend : friendsRequest) {
				current_user.getFriendsRequest().add(friend);
			}
			friends = sc.getFriends(current_user.getLogin());
			for(UserBean friend : friends) {
				current_user.getFriends().add(friend);
			}
			
			activities = sc.getActivities(current_user.getLogin());
			for(Activities activity : activities) {
				current_user.getActivities().add(activity);
			}
			

			session.setAttribute("current_user",current_user);
			request.setAttribute("current_user",current_user);

		}
		else {
			session.setAttribute("current_user",null);
			request.setAttribute("current_user",null);
		}
		
		
		
		
		response.sendRedirect("/WebCovid/BeanServlet");

	}

}
