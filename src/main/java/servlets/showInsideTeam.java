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

import javaClasses.AppilicationVariables;

/**
 * Servlet implementation class showInsideTeam.
 */
@WebServlet("/showInsideTeam")
public class showInsideTeam extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamName = request.getParameter("teamName");
		String teamDesc = null;
		JSONArray jsonArr = new JSONArray();
		JSONObject json = new JSONObject();
		
		boolean flag = true;
		
		
		try {
			
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select a.description,b.name,b.status from team a,agent b where a.name = b.team and  b.team like ?");
			pstm.setString(1, teamName);
			ResultSet rs = pstm.executeQuery();
//			System.out.println(rs);
			while(rs.next()) {
				//System.out.println(1);
				if(!rs.getString(3).equals("requested")) {
					flag = false;
					json.put("teamDesc", rs.getString(1));
					json.put("agentName",rs.getString(2));	 
			
					jsonArr.add(json);
					json = new JSONObject();	
				}
			
				
			}
			if(flag) {
				//System.out.println(2);
				    pstm = AppilicationVariables.dbConnection.prepareStatement("select * from team where name like ?");
				    pstm.setString(1, teamName);
				    rs = pstm.executeQuery();
				rs.next();
				json.put("teamDesc", rs.getString(2));
				jsonArr.add(json);
			}
			
			response.getWriter().append(jsonArr.toJSONString());
			
		}
		catch(Exception ex) {
			System.out.println("Exception in showInSideTeams");
			ex.printStackTrace();
		}
	}

}
