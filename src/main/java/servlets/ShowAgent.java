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

import javaClasses.AccessAgent;
import javaClasses.Agent;
import javaClasses.AppilicationVariables;

/**
 * Servlet implementation class ShowAgent
 */
@WebServlet("/ShowAgent")
public class ShowAgent extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Agent> arrList = AccessAgent.getAllAgent();
			JSONArray jsonArr = new JSONArray();
			JSONObject json = new JSONObject();
			
			for(int i=0;i<arrList.size();i++) {
				json.put("agentName",arrList.get(i).getName());
				json.put("agentMail",arrList.get(i).getEmail());
				jsonArr.add(json);
				json = new JSONObject();
			
			}
			
		response.getWriter().append(jsonArr.toJSONString());

		}

}
