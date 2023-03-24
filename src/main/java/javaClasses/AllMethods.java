package javaClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AllMethods {
	   //This method will generate the id for the ticket
       public static String generateId() throws SQLException {
    	   int id=100;
    	   PreparedStatement pstm =  AppilicationVariables.dbConnection.prepareStatement("select * from ticket");
    	   ResultSet rstm = pstm.executeQuery();
    	   while(rstm.next()) {
    		   id++;
    	   }
    	   return "#"+id;
       }
      
       public static boolean checkSessionId(String str) {
    	   try {
    		   PreparedStatement pstm =  AppilicationVariables.dbConnection.prepareStatement("select * from sessionId");
        	   ResultSet rstm = pstm.executeQuery();
        	   while(rstm.next()) {
        		   if(rstm.getString(1).equals(str)) {
        			   return true;
        		   }
        	   }
        	  
    	   }catch(Exception ex){
    		   System.out.println("Exception in AllMethods");
    		   ex.printStackTrace();
    	   }
    	   return false;
    	  
       }
       //
       public static String getAgentMail(String str) {
    	   try {
    		   PreparedStatement pstm =  AppilicationVariables.dbConnection.prepareStatement("select * from AgentsessionId");
        	   ResultSet rstm = pstm.executeQuery();
        	   while(rstm.next()) {
        		   if(rstm.getString(1).equals(str)) {
        			   return rstm.getString(2);
        		   }
        	   }
        	  
    	   }catch(Exception ex){
    		   System.out.println("Exception in AllMethods");
    		   ex.printStackTrace();
    	   }
    	   return null;
    	  
       }
       //
       public static void changeStatus(String id,String value) {
    	   //System.out.println(id+"--"+value);
    	   try {
    		   PreparedStatement pstm =  AppilicationVariables.dbConnection.prepareStatement("update ticket set status = ? where ticketId = ?");
        	  pstm.setString(1, value);
        	  pstm.setString(2, id);
        	  pstm.executeUpdate();
    	   }catch(Exception ex){
    		   System.out.println("Exception in AllMethods");
    		   ex.printStackTrace();
    		   
    	   }
       }
       public static void changePriority(String id,String value) {
    	   try {
    		   //System.out.println(id+"--"+value);
    		   PreparedStatement pstm =  AppilicationVariables.dbConnection.prepareStatement("update ticket set priority = ? where ticketId = ?");
        	  pstm.setString(1, value);
        	  pstm.setString(2, id);
        	  pstm.executeUpdate();
    	   }catch(Exception ex){
    		   System.out.println("Exception in AllMethods");
    		   ex.printStackTrace();
    		   
    	   }
       }
       public static void changeClassification(String id,String value) {
    	   try {
    		   //System.out.println(id+"--"+value);
    		   PreparedStatement pstm =  AppilicationVariables.dbConnection.prepareStatement("update ticket set classification = ? where ticketId = ?");
        	  pstm.setString(1, value);
        	  pstm.setString(2, id);
        	  pstm.executeUpdate();
    	   }catch(Exception ex){
    		   System.out.println("Exception in AllMethods");
    		   ex.printStackTrace();
    		   
    	   }
       }
       //
       public static void addReply(Description desc) {
    	   try {
    		   //System.out.println(id+"--"+value);
    		   PreparedStatement pstm =  AppilicationVariables.dbConnection.prepareStatement("INSERT INTO ticketDescription VALUES (?,?,?,?)");
        	  pstm.setString(1, desc.getDesp());
        	  pstm.setString(2, desc.getName());
        	  pstm.setString(3, desc.getTime());
        	  pstm.setString(4, desc.getWho());
        	  pstm.executeUpdate();
    	   }catch(Exception ex){
    		   System.out.println("Exception in AllMethods");
    		   ex.printStackTrace();
    		   
    	   }
       }
      public static void changePriorityAndAgent(String id,String priority,String email) {
    	  //
    	  int index=0;
  		try {
  			index = AccessTeam.getTeamIndex(email);	
  		} catch (Exception e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
   
    	  Agent agentObject = AccessCompany.company.getDeptList().get(index).getAgents().get().data;
  		String agentEmail = agentObject.getEmail();
  			while(true) {
  				agentObject = AccessCompany.company.getDeptList().get(index).getAgents().get().data;
  			  if(agentObject.getRoll().equals("MLS")) {
  				  agentEmail = agentObject.getEmail();
  				  break;
  			  }
  			}
  		    
    	  //
    	  try {
    		
    	  PreparedStatement pstm =  AppilicationVariables.dbConnection.prepareStatement("update ticket set priority = ?, agentEmail = ? where ticketId = ?");
       	  pstm.setString(1, priority);
       	  pstm.setString(2, agentEmail);
       	  pstm.setString(3, id);
       	  
       	  pstm.executeUpdate();
   	   }catch(Exception ex){
   		   System.out.println("Exception in AllMethods");
   		   ex.printStackTrace();
   		   
   	   }
      }
       
}
