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
 * Servlet implementation class ActivityServlet
 */
@WebServlet("/ActivityServlet")
public class ActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActivityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Activities> activities = new ArrayList<>();
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String begin = request.getParameter("timeBegin");
		String end = request.getParameter("timeEnd");
		String place = request.getParameter("place");
		String address = request.getParameter("address");
		HttpSession session = request.getSession();
		SQLConnector sc = new SQLConnector();
		UserBean current_user = (UserBean) session.getAttribute("current_user");
		if ((name != "") && (name != null) && (date != "") && (date != null)) {
			sc.createActivity(current_user.getLogin(), name, date, begin, end);
			activities = sc.getActivities(current_user.getLogin());
			for(Activities activity : activities) {
				current_user.getActivities().add(activity);
			}
			session.setAttribute("current_user",current_user);
			request.setAttribute("current_user",current_user);
			response.sendRedirect("/WebCovid/JSP_Pages/activite.jsp");
		}

	}
}
