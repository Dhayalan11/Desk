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
import javaClasses.AllMethods;
import javaClasses.History;

/**
 * Servlet implementation class UpdateClassification
 */
@WebServlet("/ShowHistory")
public class ShowHistory extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		List<History> arrList = AccessTicket.getHistory(id);
		JSONArray jsonArr = new JSONArray();
		JSONObject json = new JSONObject();
		
			for(int i = 0;i<arrList.size();i++) {
				json.put("ticketHistory",arrList.get(i).getHistoryContent());
				json.put("ticketTime",arrList.get(i).getTime());
				jsonArr.add(json);
				json = new JSONObject();
			}
		
		response.getWriter().append(jsonArr.toJSONString());
	}

}
