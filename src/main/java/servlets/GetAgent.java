package servlets;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * Servlet implementation class GetAgent
 */
@WebServlet("/GetAgent")
public class GetAgent extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Agent> agentList = AccessAgent.getAllAgent();
		JSONArray jsonArr = new JSONArray();
		JSONObject json = new JSONObject();
		 
			for(int i = 0;i<agentList.size();i++) {
				json.put("AgentName",agentList.get(i).getName());
				json.put("AgentEmail",agentList.get(i).getEmail());
				jsonArr.add(json);
				json = new JSONObject();
			}
		
		response.getWriter().append(jsonArr.toJSONString());
	}

}
