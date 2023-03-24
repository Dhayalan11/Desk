package javaClasses;

public class Ticket {
	
      String ticketId;
      String ticketName;
      String ticketOwnerName;
      String ticketDueDate;
      String ticketPriority;
      String ticketClassification;
      String ticketStatus;
      String agentEmail;
      String ownerEmail;
      String createdTime;
  
      
    
      
	public Ticket(String ticketId, String ticketName, String ticketOwnerName, String ticketDueDate,
			String ticketPriority, String ticketClassification, String ticketStatus, String agentEmail,String time,String ownerEmail) {
		this.ticketId = ticketId;
		this.ticketName = ticketName;
		this.ticketOwnerName = ticketOwnerName;
		this.ticketDueDate = ticketDueDate;
		this.ticketPriority = ticketPriority;
		this.ticketClassification = ticketClassification;
		this.ticketStatus = ticketStatus;
		this.agentEmail = agentEmail;
		createdTime = time;
		this.ownerEmail = ownerEmail;
	}

	public Ticket(String string, String string2, String string3, String string4, String string5) {
		
		ticketId = string;
		ticketName = string2;
	    ticketOwnerName = string3;
	    ticketStatus = string4;
	    createdTime = string5;
	}
    
	
	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public String getTicketOwnerName() {
		return ticketOwnerName;
	}

	public void setTicketOwnerName(String ticketOwnerName) {
		this.ticketOwnerName = ticketOwnerName;
	}

	public String getTicketDueDate() {
		return ticketDueDate;
	}

	public void setTicketDueDate(String ticketDueDate) {
		this.ticketDueDate = ticketDueDate;
	}

	public String getTicketPriority() {
		return ticketPriority;
	}

	public void setTicketPriority(String ticketPriority) {
		this.ticketPriority = ticketPriority;
	}

	public String getTicketClassification() {
		return ticketClassification;
	}

	public void setTicketClassification(String ticketClassification) {
		this.ticketClassification = ticketClassification;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getAgentEmail() {
		return agentEmail;
	}

	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}
      
}
