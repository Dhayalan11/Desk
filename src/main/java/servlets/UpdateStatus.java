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
 * Servlet implementation class UpdateStatus
 */
@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String status = request.getParameter("value");
		AllMethods.changeStatus(id,status);
		History his = new History("The ticket status is changed to "+status+".",id);
		AccessTicket.addHistory(his);
	}

}
