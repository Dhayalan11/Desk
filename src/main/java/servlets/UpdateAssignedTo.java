package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaClasses.AccessTicket;
import javaClasses.History;

@WebServlet("/UpdateAssignedTo")
public class UpdateAssignedTo extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String value = request.getParameter("value");
		AccessTicket.updateAssignedTo(id, value);
	    History his = new History("The ticket is Reassigned to a agent.",id);
	    AccessTicket.addHistory(his);
  			
	}
}




