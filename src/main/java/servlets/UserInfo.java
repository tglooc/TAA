package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entities.User;

@WebServlet(name = "userinfo", urlPatterns = { "/UserInfo" })
public class UserInfo extends HttpServlet {

	private static final long serialVersionUID = 1796858895545644976L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		System.out.println("\n\n----------------------\n\n" + request.toString()+"\n\n-----------");
		if (!request.getParameter("name").isEmpty()) {
			UserDao dao = new UserDao();
			dao.save(new User(request.getParameter("name")));
			out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n" + "<UL>" + " <LI>Name: "
					+ request.getParameter("name") + "\n"
					+ "</UL>\n" + "<H2>Cette personne à été insérée en BDD</H2>\n" + "</BODY></HTML>");
		} else {
			out.println(
					"<HTML>\n<BODY>\n<H1>INCORRECT INFOS</H1><H2>Veuillez inscrire le nom et le mail de la personne à insérer</H2></BODY></HTML>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		UserDao dao = new UserDao();
		List<User> users = dao.findAll();
		out.println("<HTML>\n<BODY>\n" + "<H1>Liste des users de la BDD</H1>\n" + "<UL>");
		for (User u : users) {
			out.println("<LI>" + u.toString());
		}
		out.println("</UL></BODY></HTML>");

	}

}
