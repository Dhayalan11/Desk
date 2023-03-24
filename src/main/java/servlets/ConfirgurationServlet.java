package servlets;

import java.io.IOException;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaClasses.AccessCompany;
import javaClasses.AppilicationVariables;

/**
 * Servlet implementation class ConfirgurationServlet
 */
@WebServlet(urlPatterns = "/ConfirgurationServlet",loadOnStartup=0,initParams = { @WebInitParam(name = "dbName", value = "desk"),
@WebInitParam(name = "dbUserName", value = "root"),@WebInitParam(name = "dbPassword", value = "root")})

public class ConfirgurationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public void init() {
    	
    	try {
    		String dbName = getServletConfig().getInitParameter("dbName");
    		String dbUsername = getServletConfig().getInitParameter("dbUserName");
    		String dbPassword = getServletConfig().getInitParameter("dbPassword");
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3306/"+dbName;
			AppilicationVariables.dbConnection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			AccessCompany.addDepartmentInCompany(AccessCompany.company);
    	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
	

}
