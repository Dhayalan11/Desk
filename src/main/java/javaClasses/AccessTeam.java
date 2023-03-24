package javaClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AccessTeam {
      //public static ArrayList<Team> teamList = new ArrayList<>(); 
      
      public static void addTeamToDB(Department team) {
    	  try {
  			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("insert into team values(?,?)");
  			pstm.setString(1, team.getName());
  			pstm.setString(2, team.getDescription());
  			pstm.execute();
  		}catch(Exception ex) {
  			System.out.println(ex.getMessage());
  		}
      }
      
      public static List<Department> teamObject() {
    	  List<Department> arrList= new ArrayList<>();
    	  JSONArray jsonArr = new JSONArray();
  		JSONObject json = new JSONObject();
  		Department team =null;
  		ResultSet rs =null;
    	  try {
  			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from team");
//  			pstm.setString(1, "team");
  			 rs = pstm.executeQuery();
  			
  			
  			while(rs.next()) {
  			
  				 team = new Department(rs.getString(1),rs.getString(2));
  				arrList.add(team);

  				
  			}
  			
  			
  		}
  		catch(Exception ex) {
  			System.out.println("Exception in AccessTeam");
//  			ex.printStackTrace();
  		}
    	  return arrList;
    	  
      }
      public static int getAgentEmail(String teamName) {
//    	  AccessCompany.company.getDeptList()
    	  for(int i=0;i<AccessCompany.company.getDeptList().size();i++) {
    		  if(AccessCompany.company.getDeptList().get(i).getName().equals(teamName)){
    			  return i;
    		  }
    	  }
    	  
    	  
    	  
    	  return 0 ;
      }
      public static int getTeamIndex(String email){
    	  String teamName = null;
    	  //Want to check the agent table and find the agent team ad them want to return the index for that team in the list.
    	  try {
    		    PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from agent where email = ?");
    			pstm.setString(1, email);
    			ResultSet rs = pstm.executeQuery();
    			if(rs.next()) {
    				teamName = rs.getString(4);
    			}
    		  
    	  }catch(Exception ex) {
    		 ex.printStackTrace(); 
    	  }
    	  return getAgentEmail(teamName);
      }
      
}
