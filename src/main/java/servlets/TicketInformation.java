package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javaClasses.*;


/**
 * Servlet implementation class TicketInformation
 */
@WebServlet("/TicketInformation")
public class TicketInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("dhaya");
		JSONObject jObj = new JSONObject();
		
		  String id = request.getParameter("id");

	      Ticket tic = AccessTicket.getTicketDetails(id);
	      jObj.put("ticketId", tic.getTicketId());
	      jObj.put("ticketName", tic.getTicketName());
	      jObj.put("ticketOwner", tic.getTicketOwnerName());
	      jObj.put("ticketDate", tic.getTicketDueDate());
	      jObj.put("ticketPriority", tic.getTicketPriority());
	      jObj.put("ticketClassification", tic.getTicketClassification());
	      jObj.put("ticketStatus", tic.getTicketStatus());
	      jObj.put("ticketAgentEmail", tic.getAgentEmail());
	      jObj.put("ticketTime", tic.getCreatedTime());
	      jObj.put("ticketOwnerEmail", tic.getOwnerEmail());
	     // System.out.println(jObj);
	      response.getWriter().append(jObj.toJSONString());
	      
	}

}
