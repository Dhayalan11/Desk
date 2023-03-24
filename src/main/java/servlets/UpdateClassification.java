package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaClasses.AccessTicket;
import javaClasses.AllMethods;
import javaClasses.History;

/**
 * Servlet implementation class UpdateClassification
 */
@WebServlet("/UpdateClassification")
public class UpdateClassification extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String classification = request.getParameter("value");
		AllMethods.changeClassification(id,classification);
		History his = new History("The ticket classification is changed to "+classification+".",id);
		AccessTicket.addHistory(his);
	}

}
