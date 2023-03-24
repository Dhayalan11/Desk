package javaClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccessCompany {
  public static Company company = new Company("asrf","asrf@amail.com","7904245832","asrf@123");
    
  public static void addDepartmentInCompany(Company company) {
	  PreparedStatement pstm1=null;
		ResultSet rs1 = null;
	  try {
		  PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from team");
		 
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Department dept = new Department(rs.getString(1),rs.getString(2));
				pstm1 = AppilicationVariables.dbConnection.prepareStatement("select * from agent where team like ?");
			    pstm1.setString(1,dept.name);
				rs1 = pstm1.executeQuery();
				while(rs1.next()) {
	                if(!(rs1.getString(5).equals("requested"))) {
	                	Agent agent = new Agent(rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getString(6));
						dept.agents.add(agent);
	                }
					
				}
				company.deptList.add(dept);
				
				
			}
	  }catch(Exception ex) {
		  ex.printStackTrace();
	  }
  }
  
  
}
