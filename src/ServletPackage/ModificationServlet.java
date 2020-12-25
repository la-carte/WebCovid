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
 * Servlet implementation class ModificationServlet
 */
@WebServlet("/ModificationServlet")
public class ModificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationServlet() {
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
		SQLConnector sc = new SQLConnector();
		HttpSession session = request.getSession();
		UserBean old_user = (UserBean) session.getAttribute("current_user");
		
		
		String old_login = old_user.getLogin();
		String login = request.getParameter("login");
		String nom = request.getParameter("name");
		String prenom = request.getParameter("surname");
		String password = request.getParameter("password");
		String date = request.getParameter("date");
		
		
		
		if ((password != "") && (password != null)) {

			sc.setUser(old_login,login, password, nom,prenom,date);
			System.out.println("OUI");
			UserBean current_user = sc.getUser(login,password);
			session.setAttribute("current_user",current_user);
			request.setAttribute("current_user",current_user);

		} else {
			session.setAttribute("msg-err", " login ou mot de passe mal formé !");

			session.setAttribute("current_user", null);
			request.setAttribute("current_user", null);

		}

		response.sendRedirect("/WebCovid/BeanServlet");
	}

}
