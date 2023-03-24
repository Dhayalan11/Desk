package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javaClasses.AppilicationVariables;

@WebServlet("/ShowTeams")
public class ShowTeams extends HttpServlet {
	
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray jsonArr = new JSONArray();
		JSONObject json = new JSONObject();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String name=null;
		int count = 0;
		try {
			
			pst = AppilicationVariables.dbConnection.prepareStatement("Select * from team");
		
			rs = pst.executeQuery();
			
			while(rs.next()) {
				json.put("teamName", rs.getString(1));
				jsonArr.add(json);
				json = new JSONObject();
			}
			for(int i=0;i<jsonArr.size();i++) {
				json =(JSONObject)jsonArr.get(i);
				name =(String) json.get("teamName");
				pst = AppilicationVariables.dbConnection.prepareStatement("Select * from agent where team like ?");
				pst.setString(1, name);
				rs = pst.executeQuery();
				while(rs.next()) {
					if(!rs.getString(5).equals("requested")) {
						count++;
					}
				
				}
				json.put("count",count);
				count=0;
			}
			response.getWriter().append(jsonArr.toJSONString());
			
		}catch(Exception ex) {
			System.out.println("Exception in ShowTeamsServlet");
		}

	}

}
