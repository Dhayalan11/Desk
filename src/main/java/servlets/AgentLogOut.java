package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaClasses.AppilicationVariables;

/**
 * Servlet implementation class AgentLogOut
 */
@WebServlet("/AgentLogOut")
public class AgentLogOut extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sessionId = null; 
	     Cookie[] cookies = request.getCookies();
	     if(cookies[0].getName().equals("sessionId"))
	      sessionId = cookies[0].getValue();
	      PreparedStatement pst = null;
	  	System.out.println(sessionId);
	   
	     
	      try {
				
				pst = AppilicationVariables.dbConnection.prepareStatement("delete from AgentsessionId where id = ?");
				pst.setString(1,sessionId );
				 pst.execute();
     }
     catch(Exception ex) {
     	System.out.println("Exception in AgentLogOut");
     }
	}

}
