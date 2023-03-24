package servlets;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javaClasses.AccessTicket;
import javaClasses.AllMethods;
import javaClasses.Description;
import javaClasses.History;

/**
 * Servlet implementation class AddReply
 */
@WebServlet("/AddReply")
public class AddReply extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("ticketId");
	String desc = request.getParameter("desc");
	Description description = new Description(id,desc,""+new Date(),"Agent");
	AllMethods.addReply(description);
    History his = new History("Agent has replied to the ticket.",id);
    AccessTicket.addHistory(his);
	String email = AccessTicket.getEmail(id);
	
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
      sender.put("email", "dhayalanfrn2@gmail.com");
      payload.put("sender", sender);
      
      JSONObject to = new JSONObject();
      
      JSONObject reciver = new JSONObject();
      reciver.put("email", email);
      JSONArray arr = new JSONArray();
      arr.add(reciver);
      payload.put("to", arr);
      payload.put("subject", "Request received");
      payload.put("textContent", "Thanks for contacting zsDesk. Soon you will receive reply from our agents.");
      OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
      writer.write(payload.toString());
      writer.flush();
      writer.close();
      int responseCode = con.getResponseCode();
      System.out.println("Response code: " + responseCode);
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	}

	

}
