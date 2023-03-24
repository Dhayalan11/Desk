package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaClasses.AppilicationVariables;

/**
 * Servlet implementation class AgentSignIn
 */
@WebServlet("/AgentSignIn")
public class AgentSignIn extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		String email = request.getParameter("agentEmail");
		String password = request.getParameter("agentPassword");
		String EncryptedPassword =  new String(Base64.getEncoder().encode(password.getBytes()));
		PreparedStatement pst = null;
		ResultSet rs = null;
		Cookie cookie = null;
		UUID uuid = UUID.randomUUID(); 
		
		
		try {
			
				pst = AppilicationVariables.dbConnection.prepareStatement("select * from agent where email = ? and password = ?");
				pst.setString(1, email);
				pst.setString(2,EncryptedPassword);
				rs = pst.executeQuery();
				
				if(rs.next()) {
					
					cookie = new Cookie("sessionId",""+uuid);
					pst = AppilicationVariables.dbConnection.prepareStatement("insert into AgentsessionId values(?,?)");
					pst.setString(1,""+uuid);
					pst.setString(2,email);
					pst.execute();
					response.addCookie(cookie);
					response.getWriter().append("200");	
				}
				else {
					response.getWriter().append("500");
				}
				
        }
        catch(Exception ex) {
        	System.out.println("Exception in CompanySignIn");
        }

		
	}

}


		

