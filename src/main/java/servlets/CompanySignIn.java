package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import javaClasses.AppilicationVariables;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/CompanySignIn")
public class CompanySignIn extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("companyEmail");
		String password = request.getParameter("companyPassword");
		PreparedStatement pst = null;
		ResultSet rs = null;
		Cookie cookie = null;
		UUID uuid = UUID.randomUUID(); 
		
		//System.out.println(email+"--"+password);
		
		
		try {
			
				pst = AppilicationVariables.dbConnection.prepareStatement("select * from company where email = ? and password = ?");
				pst.setString(1, email);
				pst.setString(2,password);
				rs = pst.executeQuery();
				
				if(rs.next()) {
					
					cookie = new Cookie("sessionId",""+uuid);
					pst = AppilicationVariables.dbConnection.prepareStatement("insert into sessionId values(?,?)");
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
