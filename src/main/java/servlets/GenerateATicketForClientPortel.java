package servlets;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javaClasses.AccessCompany;
import javaClasses.AccessTeam;
import javaClasses.AccessTicket;
import javaClasses.Agent;
import javaClasses.AllMethods;
import javaClasses.AppilicationVariables;
import javaClasses.History;
import javaClasses.Ticket;

/**
 * Servlet implementation class GenerateATicketForClientPortel
 */
@WebServlet("/GenerateATicketForClientPortel")
public class GenerateATicketForClientPortel extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement pstm =null;
		String desc = request.getParameter("desc");
	 

		String id=null;
		try {
			 id= AllMethods.generateId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String ticketName=request.getParameter("subject");
		String ownerName =request.getParameter("name");
		ownerName = ownerName.substring(0,1).toUpperCase()+ownerName.substring(1);
		String priority = request.getParameter("priority");
		String clasification = request.getParameter("classification");
		String status = "OPEN";
		String email = request.getParameter("email");
		
		
		int index=0;
		try {
			index = AccessTeam.getAgentEmail(request.getParameter("dept"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//want to declar a variable check that a manger and the assign
		 
		Agent agentObject = AccessCompany.company.getDeptList().get(index).getAgents().get().data;
		String agentEmail = agentObject.getEmail();

		if(priority.equals("high") && agentObject.getRoll().equals("MTS")) {
			
			while(true) {
				agentObject = AccessCompany.company.getDeptList().get(index).getAgents().get().data;
			  if(agentObject.getRoll().equals("MLS")) {
				  agentEmail = agentObject.getEmail();
				  break;
			  }
			}
		}
		
		Ticket ticket = new Ticket(id, ticketName, ownerName,null ,priority, clasification, status,agentEmail,null,email);
		
		
	
		AccessTicket.addTicketToDB(ticket);
		
		String api_key ="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";

		try {
			
			URL url = new URL("https://api.sendinblue.com/v3/smtp/email");
          
          HttpURLConnection con = (HttpURLConnection) url.openConnection();
          con.setRequestMethod("POST");
          con.setRequestProperty("Content-Type", "application/json");
          con.setRequestProperty("api-key", api_key);
          con.setDoOutput(true);
          JSONObject payload = new JSONObject();
          
          JSONObject sender = new JSONObject();
          sender.put("email", "zsdesk69@gmail.com");
          payload.put("sender", sender);
          
          JSONObject to = new JSONObject();
          
          JSONObject reciver = new JSONObject();
          reciver.put("email", email);
          JSONArray arr = new JSONArray();
          arr.add(reciver);
          payload.put("to", arr);
          payload.put("subject", "Request received");
          payload.put("textContent", "Thanks for contacting zsDesk. Soon you will receive reply from our agents.");
         // payload.put("textContent", "<b>checking.....</b>");
          OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
          writer.write(payload.toString());
          writer.flush();
          writer.close();
          int responseCode = con.getResponseCode();
          System.out.println("Response code: " + responseCode);
         
          
          pstm = AppilicationVariables.dbConnection.prepareStatement("insert into ticketDescription values(?,?,?,?)");
		  pstm.setString(1,desc);
          pstm.setString(2,id);
          pstm.setString(3, ""+new Date());
          pstm.setString(4,"visitor");
          pstm.executeUpdate();
          
          
          History his = new History("The ticket has been created.",id);
          AccessTicket.addHistory(his);
          
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		

		
	}

}
