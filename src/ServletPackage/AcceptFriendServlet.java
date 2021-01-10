package ServletPackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BeanPackage.UserBean;
import SQLPackage.SQLConnector;

/**
 * Servlet implementation class AcceptFriendServlet
 */
@WebServlet("/AcceptFriendServlet")
public class AcceptFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptFriendServlet() {
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
		ArrayList<String> friendsRequest = new ArrayList<>();
		ArrayList<UserBean> friends = new ArrayList<>();
		String loginFriend = request.getParameter("login");
		HttpSession session = request.getSession();
		SQLConnector sc = new SQLConnector();

		UserBean current_user = (UserBean) session.getAttribute("current_user");
		System.out.println(loginFriend);
		System.out.println(current_user.getLogin());
		sc.addFriend(loginFriend, current_user.getLogin());
		
		friends = sc.getFriends(current_user.getLogin());
		for(UserBean friend : friends) {
			current_user.getFriends().add(friend);
		} 
		
		friendsRequest= sc.getFriendRequest(current_user.getLogin());
		for(String friend : friendsRequest) {
			current_user.getFriendsRequest().remove(loginFriend);
		}
		
		

		session.setAttribute("current_user",current_user);
		request.setAttribute("current_user",current_user);

		
		
		response.sendRedirect("/WebCovid/JSP_Pages/amis.jsp");
		
	}

}
