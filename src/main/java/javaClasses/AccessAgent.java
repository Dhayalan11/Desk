package javaClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class AccessAgent {
  public static ArrayList<Agent> agentList = new ArrayList<>();
  
  
  public static void addAgentInDB(Agent agent) {
	  PreparedStatement pstm = null;
		
		try {
			
				 pstm = AppilicationVariables.dbConnection.prepareStatement("insert into agent values(?,?,?,?,?,?)");
				pstm.setString(1, agent.getName());
				pstm.setString(2, agent.getEmail());
				pstm.setString(3, null );
				pstm.setString(4, agent.getTeam());
				pstm.setString(5, "requested");
				pstm.setString(6, "MTS");
				
				pstm.execute();
			
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			System.out.println("Execption in AddNewAgent");
			e.printStackTrace();
		}
		
  }
  
  public static Agent getAgentFromDB(String email) {
	    PreparedStatement pst = null;
		ResultSet rs = null;
		
		Agent obj =null;
		
		int count = 0;
		try {
			
			pst = AppilicationVariables.dbConnection.prepareStatement("Select * from agent where email like ?");
		  pst.setString(1,email);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				obj = new Agent( rs.getString(1),rs.getString(2),null,rs.getString(4),rs.getString(5),0);
				
			}
		pst = AppilicationVariables.dbConnection.prepareStatement("Select * from ticket where agentEmail = ?");
		  pst.setString(1,email);
		rs = pst.executeQuery();
		while(rs.next()) {
			count++;
		}
		obj.setCountOfTicket(count);
		
		
		
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception in InsideAgentServlet");
		}
		return obj;
		
  }
  //
  public static List<Agent> getAllAgent(){
	  List<Agent> arrList = new ArrayList<>();
	  
	    PreparedStatement pst = null;
		ResultSet rs = null;
		String name=null;
		
		try {
			
			pst = AppilicationVariables.dbConnection.prepareStatement("Select * from agent");
		
			rs = pst.executeQuery();
			
			while(rs.next()) {
				if(!rs.getString(5).equals("requested")) {
					Agent agent = new Agent(rs.getString(1),rs.getString(2));
					arrList.add(agent);	
				}
				
			}
			
		}catch(Exception ex) {
			System.out.println("Exception in AccessAgent");
		}
		return arrList;

	  
  }
  public static String getAgent(String agentEmail) throws SQLException {
	  PreparedStatement pst = null;
		ResultSet rs = null;
	  try {
			
			pst = AppilicationVariables.dbConnection.prepareStatement("Select * from agent where email = ?");
			pst.setString(1, agentEmail);
			rs = pst.executeQuery();
			
		
			
		}catch(Exception ex) {
			System.out.println("Exception in AccessAgent");
		}
	  if(rs == null) {
		  return null;
	  }
	  return (String)rs.getString(1);
  }
  public static void setPasswordForAgent(String email,String password) {
	  PreparedStatement pst = null;
		
	  try {
			
			pst = AppilicationVariables.dbConnection.prepareStatement("update agent set password = ?,status = 'accepted' where email = ?");
			pst.setString(1, password);
			pst.setString(2, email);
			pst.execute();
		}catch(Exception ex) {
			System.out.println("Exception in AccessAgent");
		}
  }
}
