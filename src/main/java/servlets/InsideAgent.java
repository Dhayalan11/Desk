package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javaClasses.AccessAgent;
import javaClasses.Agent;
import javaClasses.AppilicationVariables;

/**
 * Servlet implementation class InsideAgent
 */
@WebServlet("/InsideAgent")
public class InsideAgent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("agentEmail");
		Agent obj = AccessAgent.getAgentFromDB(email);
		JSONObject json = new JSONObject();
		if(obj!=null) {
			
			json.put("agentName",obj.getName());
			json.put("agentMail", obj.getEmail());
			json.put("agentteam", obj.getTeam());
			json.put("agentReq",obj.getStatus());
			json.put("ticketCount", obj.getCountOfTicket());
			response.getWriter().append(json.toJSONString());
		}
		else {
			
			response.getWriter().append("Invalid input.");
		}
		

	}

}
