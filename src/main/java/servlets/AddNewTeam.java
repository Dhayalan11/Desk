package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaClasses.AccessCompany;
import javaClasses.AccessTeam;
import javaClasses.AppilicationVariables;
import javaClasses.Department;


/**
 * Servlet implementation class AddNewTeam
 */
@WebServlet("/AddNewTeam")
public class AddNewTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamName = request.getParameter("teamName");
		String teamDesc = request.getParameter("teamDesc");
		
		Department team =  new Department(teamName,teamDesc);
		AccessCompany.company.getDeptList().add(team);
		AccessTeam.addTeamToDB(team);
	}

}
