package javaClasses;

public class Agent {
	private String name;
	private String email;
	private String password;
	private String team;
	private String status;
	private String roll;
	private int countOfTicket;

	public Agent(String name, String email, String password, String team, String status,int countOfTicket) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.team = team;
		this.status = status;
		this.countOfTicket = countOfTicket;
	}
	public Agent(String name, String email, String password, String team, String status,String roll) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.team = team;
		this.status = status;
		this.roll = roll;
		
	}
	public Agent(String name, String email,  String team, String status,int countOfTicket) {
		this.name = name;
		this.email = email;
		this.team = team;
		this.status = status;
		this.countOfTicket = countOfTicket;
		
	}
	
	public Agent(String string, String string2) {
		name = string;
		email = string2;
	}
	
	

	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public int getCountOfTicket() {
		return countOfTicket;
	}

	public void setCountOfTicket(int countOfTicket) {
		this.countOfTicket = countOfTicket;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
