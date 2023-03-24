package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javaClasses.AccessTicket;
import javaClasses.AllMethods;
import javaClasses.Ticket;

/**
 * Servlet implementation class SelectAgentOpenTicket
 */
@WebServlet("/SelectAgentOpenTicket")
public class SelectAgentOpenTicket extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String Session =null;
		
	
		for(Cookie c : cookies) {
			if(c.getName().equals("sessionId")) {
				Session = c.getValue();
			}
		}
		String email = AllMethods.getAgentMail(Session);
		
		List<Ticket> arrList = AccessTicket.getAgentOpenTicket(email);
		JSONArray jsonArr = new JSONArray();
		JSONObject json = new JSONObject();
		
			for(int i = 0;i<arrList.size();i++) {
				json.put("ticketId",arrList.get(i).getTicketId());
				json.put("ticketName",arrList.get(i).getTicketName());
				json.put("ticketOwnerName",arrList.get(i).getTicketOwnerName());
				json.put("ticketStatus",arrList.get(i).getTicketStatus());
				json.put("ticketTime",arrList.get(i).getCreatedTime());
				jsonArr.add(json);
				json = new JSONObject();
			}
		
		response.getWriter().append(jsonArr.toJSONString());
	}

}
