package ServletPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BeanPackage.UserBean;
import SQLPackage.SQLConnector;

/**
 * Servlet implementation class AjoutAmiServlet
 */
@WebServlet("/AjoutAmiServlet")
public class AjoutAmiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutAmiServlet() {
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
		String friendLogin = request.getParameter("login");
		
		HttpSession session = request.getSession();
		SQLConnector sc = new SQLConnector();
		
		UserBean user = (UserBean) session.getAttribute("current_user");
		if ((friendLogin != "") && (friendLogin != null)){
			UserBean ami = sc.getUser(friendLogin);
			// Gérer le cas si l'utilisateur n'existe pas
			ami.getFriendsRequest().add(user.getLogin());
			System.out.println(ami.getFriendsRequest());
		}
		
		request.getRequestDispatcher( "/JSP_Pages/profil.jsp" ).forward( request, response );
	}

}
