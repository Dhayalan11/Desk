package javaClasses;

import java.util.ArrayList;
import java.util.List;

public class Company {
      String companyName;
      String companyEmail;
      String comoanyNumber;
      String companyPassword;
      List<Department> deptList = new ArrayList<Department>();
      
      
      
	public Company(String companyName, String companyEmail, String comoanyNumber, String companyPassword) {
		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.comoanyNumber = comoanyNumber;
		this.companyPassword = companyPassword;
	}
	
	public List<Department> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getComoanyNumber() {
		return comoanyNumber;
	}
	public void setComoanyNumber(String comoanyNumber) {
		this.comoanyNumber = comoanyNumber;
	}
	public String getCompanyPassword() {
		return companyPassword;
	}
	public void setCompanyPassword(String companyPassword) {
		this.companyPassword = companyPassword;
	}
      
}
