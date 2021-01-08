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
 * Servlet implementation class AmiServlet
 */
@WebServlet("/AmiServlet")
public class AmiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmiServlet() {
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
		ArrayList<String> friends = new ArrayList<>();
		HttpSession session = request.getSession();
		SQLConnector sc = new SQLConnector();
		UserBean user = (UserBean) session.getAttribute("current_user");
		friends = sc.getFriendRequest(user.getLogin()); // passer le login de l'ami
		for(String friend : friends) {
			user.getFriendsRequest().add(friend);
			System.out.println(friend);
		}
		session.setAttribute("current_user",user);
		request.setAttribute("current_user",user);
		
		response.sendRedirect("/WebCovid/JSP_Pages/amis.jsp");
	}

}
