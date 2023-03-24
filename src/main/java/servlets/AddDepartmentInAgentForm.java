package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javaClasses.AccessTeam;
import javaClasses.AppilicationVariables;
import javaClasses.Department;

/**
 * Servlet implementation class AddDepartmentInAgentForm
 */

@WebServlet("/AddDepartmentInAgentForm")
public class AddDepartmentInAgentForm extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Department> arrList = AccessTeam.teamObject();
		JSONArray jsonArr = new JSONArray();
  		JSONObject json = new JSONObject();
		if(arrList == null) {
			response.getWriter().append("Invalid inputs");
		}else {
	  		for(int i=0;i<arrList.size();i++){
	  			
  				json.put("teamName",arrList.get(i).getName());
  				
  				jsonArr.add(json);
  				json = new JSONObject();
  				
  			}
		response.getWriter().append(jsonArr.toJSONString());
		}
	}

}
