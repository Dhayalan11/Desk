package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javaClasses.AccessTicket;
import javaClasses.Description;

/**
 * Servlet implementation class GetDescription
 */
@WebServlet("/GetDescription")
public class GetDescription extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		           JSONArray jsonArr = new JSONArray();          
		           JSONObject json = new JSONObject();
		           String id = request.getParameter("ticketId");
	               List<Description> desc = AccessTicket.getDesc(id);
	               for(int i=0;i<desc.size();i++) {
	               json.put("name", desc.get(i).getName());
	               json.put("desp", desc.get(i).getDesp());
	               json.put("time", desc.get(i).getTime());
	               json.put("who",desc.get(i).getWho());
	               jsonArr.add(json);
	               json = new JSONObject();
	               }
	               response.getWriter().append(jsonArr.toJSONString());
	}

}
