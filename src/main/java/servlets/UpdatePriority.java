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
 * Servlet implementation class UpdatePriority
 */
@WebServlet("/UpdatePriority")
public class UpdatePriority extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String priority = request.getParameter("value");
		String email = request.getParameter("email");
		if(priority.equals("high")){
			AllMethods.changePriorityAndAgent(id, priority,email);
			History his = new History("The ticket priority is changed to "+priority+".",id);
			AccessTicket.addHistory(his);
			his = new History("The ticket is reassigned to the MLS in the team.",id);
			AccessTicket.addHistory(his);
		}
		else {
			AllMethods.changePriority(id,priority);			
			History his = new History("The ticket priority is changed to "+priority+".",id);
			AccessTicket.addHistory(his);
		}
		
		
	}

}
