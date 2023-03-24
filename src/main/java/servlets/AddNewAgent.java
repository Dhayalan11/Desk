package servlets;

import java.io.BufferedReader;
import javaClasses.AccessAgent;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javaClasses.AccessAgent;
import javaClasses.Agent;
import javaClasses.AppilicationVariables;

/**
 * Servlet implementation class AddNewAgent
 */
@WebServlet("/AddNewAgent")
public class AddNewAgent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader read = request.getReader();
		String str1 ="";
		StringBuffer strb1 = new StringBuffer();
		JSONObject obj = null;
		while((str1 = read.readLine())!=null) {
			strb1.append(str1);
		}
		JSONParser parser = new JSONParser();
		 try {
			obj = (JSONObject)parser.parse(strb1.toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String name =  (String) obj.get("name");
		String email =  (String) obj.get("email");
		 String encryptedEmail = new String(Base64.getEncoder().encode(email.getBytes()));
		//String password = (String) obj.get("password");
		String team = (String) obj.get("team");
		
		Agent agent = new Agent(name,email,team,"requested",0);
        AccessAgent.agentList.add(agent);
        AccessAgent.addAgentInDB(agent);
        //sending the invitation to the mail.
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
          payload.put("subject", "Invitation Request!!");
          payload.put("textContent", "<b>zsDesk is invinting you to join in there "+team+" team </b><a href=\"http://localhost:8080/DeskFinalProject/InvitationPage.html?email="+encryptedEmail+"\"> <div  style=\"width: 150px;height: 32px;background-color: rgb(43 159 43);color: white;display:flex;justify-content: center;align-items:center;border-radius: 3px;cursor: pointer;\">Accept Invitation</div></a>");
          
          OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
          writer.write(payload.toString());
          writer.flush();
          writer.close();
          int responseCode = con.getResponseCode();
          System.out.println("Response code: " + responseCode);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
//		try {
//				JSONObject ans = new JSONObject();
//				ans.put("agentName", obj.get("name"));
//				ans.put("agentEmail", obj.get("email"));
//				response.getWriter().append(ans.toJSONString());
//			 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("Execption in AddNewAgent");
//		}
		
		
	}

}
