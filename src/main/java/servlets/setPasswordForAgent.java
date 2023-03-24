package servlets;

import java.io.IOException;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javaClasses.AccessAgent;
import javaClasses.AccessCompany;
import javaClasses.AccessTeam;
import javaClasses.Agent;

@WebServlet("/setPasswordForAgent")
public class setPasswordForAgent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String EncryptedEmail = request.getParameter("email");
		String password = request.getParameter("password");
		String email = new String(Base64.getDecoder().decode(EncryptedEmail.getBytes()));
		String EncryptedPassword =  new String(Base64.getEncoder().encode(password.getBytes()));
		 Agent agent = null;
		for(int i=0;i<AccessAgent.agentList.size();i++) {
		  if(AccessAgent.agentList.get(i).getEmail().equals(email)) {
			  AccessAgent.agentList.get(i).setStatus("accepted");
			  AccessAgent.agentList.get(i).setPassword(EncryptedPassword);
		      agent = AccessAgent.agentList.get(i);
		  }
		  
	  }

	  int index = AccessTeam.getTeamIndex(email);
	 
	  AccessCompany.company.getDeptList().get(index).getAgents().add(agent);
	  
		
		AccessAgent.setPasswordForAgent(email, EncryptedPassword);
	}

}
