package javaClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AccessTicket {
	
	//public static ArrayList<Ticket> ticketList = new ArrayList<>();
	
	public static void addTicketToDB(Ticket ticket) {
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("insert into ticket values(?,?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, ticket.getTicketId());
			pstm.setString(2, ticket.getTicketName());
			pstm.setString(3, ticket.getTicketOwnerName());
			pstm.setString(4, null);
			pstm.setString(5, ticket.getTicketPriority());
			pstm.setString(6, ticket.getTicketClassification());
			pstm.setString(7, ticket.getTicketStatus());
			pstm.setString(8, ticket.getAgentEmail());
			pstm.setString(9, strDate);
			pstm.setString(10, ticket.getOwnerEmail());
			
			
			pstm.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	
		//
		
	}
	//
	public static List<Ticket>  getClosedTicket() {
		List<Ticket> arrList =  new ArrayList<>();
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from ticket where status like 'CLOSED' order by ticketId desc");
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Ticket ticket = new Ticket(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(7),rs.getString(9));
				arrList.add(ticket);	
			}
			
		}
		catch(Exception ex) {
			System.out.println("Exception in AccesTicket(getClosedTicket)");
//			ex.printStackTrace();
		}
		return arrList;
	}
	//
	public static List<Ticket>  getOpenTicket() {
		List<Ticket> arrList =  new ArrayList<>();
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from ticket where status like 'OPEN' order by ticketId desc");
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Ticket ticket = new Ticket(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(7),rs.getString(9));
				arrList.add(ticket);	
			}
			
		}
		catch(Exception ex) {
			System.out.println("Exception in AccesTicket(getOPenTicket)");
//			ex.printStackTrace();
		}
		return arrList;
	}
	//
	public static List<Ticket>  getOnholdTicket() {
		List<Ticket> arrList =  new ArrayList<>();
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from ticket where status like 'ONHOLD' order by ticketId desc");
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Ticket ticket = new Ticket(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(7),rs.getString(9));
				arrList.add(ticket);	
			}
			
		}
		catch(Exception ex) {
			System.out.println("Exception in AccesTicket(getOnholdTicket)");
			ex.printStackTrace();
		}
		return arrList;
	}
	//
	public static List<Ticket>  getEscalatedTicket() {
		List<Ticket> arrList =  new ArrayList<>();
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from ticket where status like 'ESCALATED' order by ticketId desc");
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Ticket ticket = new Ticket(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(7),rs.getString(9));
				arrList.add(ticket);	
			}
			
		}
		catch(Exception ex) {
			System.out.println("Exception in AccesTicket(getEscalatedTicket)");
			ex.printStackTrace();
		}
		return arrList;
	}
	public static List<Ticket>  getAllTicket() {
		List<Ticket> arrList =  new ArrayList<>();
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from ticket order by ticketId desc ");
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Ticket ticket = new Ticket(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(7),rs.getString(9));
				arrList.add(ticket);	
			}
			
		}
		catch(Exception ex) {
			System.out.println("Exception in AccesTicket(getAllTicket)");
			ex.printStackTrace();
		}
		return arrList;
	}
	//
	public static List<Ticket>  getSomeTicket(String agentEmail) {
		List<Ticket> arrList =  new ArrayList<>();
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from ticket where agentEmail = ? order by ticketId desc");
			pstm.setString(1, agentEmail);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Ticket ticket = new Ticket(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(7),rs.getString(9));
				arrList.add(ticket);	
			}
			
		}
		catch(Exception ex) {
			System.out.println("Exception in getSomeTicket(getAllTicket)");
			ex.printStackTrace();
		}
		return arrList;
	}
	//
	public static Ticket getTicketDetails(String id ) {
		Ticket tic = null;
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from ticket where ticketId like ? ");
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()){
		   tic = new Ticket(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
			}
			
		}
		catch(Exception ex) {
			System.out.println("Exception in AccesTicket(getTicketDetails)");
			ex.printStackTrace();
		}
		return tic;
	}
	//
	public static List<Description> getDesc (String id ) {
		List<Description> arrList = new ArrayList<Description>();
		Description desp = null;
		
		String desc = null;
		
		try {
//			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select  * from ticketDescription where ticketId like ?");
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select a.content,a.descTime,b.ticketOwnerName,a.WhoWrite from ticketDescription a,ticket b where a.ticketId = b.ticketId and a.ticketId like ?");
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				desp = new Description( rs.getString(3), rs.getString(1), rs.getString(2),rs.getString(4));
//		    desc = rs.getString(1);
				arrList.add(desp);
		
			}
			
		}
		catch(Exception ex) {
			System.out.println("Exception in AccesTicket(getTicketDetails)");
			ex.printStackTrace();
		}
		return arrList;
	}
	public static void updateAssignedTo(String id,String value) {
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("update ticket set agentEmail = ? where ticketId = ?");
			pstm.setString(1, value);
			pstm.setString(2, id);
			pstm.executeUpdate();
		}
		catch(Exception ex) {
			System.out.println("Exception in AccesTicket");
			
		}
	}
	//
	public static  List<Ticket>  getAgentClosedTicket(String email){
		List<Ticket> arrList =  new ArrayList<>();
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from ticket where status like 'CLOSED' and agentEmail = ? order by ticketId desc");
			pstm.setString(1, email);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Ticket ticket = new Ticket(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(7),rs.getString(9));
				arrList.add(ticket);	
			}
			
		}
		catch(Exception ex) {
			System.out.println("Exception in getAgentClosedTicket()");
			ex.printStackTrace();
		}
		return arrList;
	}
	//
	public static  List<Ticket>  getAgentOpenTicket(String email){
		List<Ticket> arrList =  new ArrayList<>();
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from ticket where status like 'OPEN' and agentEmail = ? order by ticketId desc");
			pstm.setString(1, email);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Ticket ticket = new Ticket(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(7),rs.getString(9));
				arrList.add(ticket);	
			}
			
		}
		catch(Exception ex) {
			System.out.println("Exception in getAgentOpenTicket()");
			ex.printStackTrace();
		}
		return arrList;
	}
	//
	public static  List<Ticket>  getAgentEscalatedTicket(String email){
		List<Ticket> arrList =  new ArrayList<>();
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from ticket where status like 'ESCALATED' and agentEmail = ? order by ticketId desc");
			pstm.setString(1, email);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Ticket ticket = new Ticket(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(7),rs.getString(9));
				arrList.add(ticket);	
			}
			
		}
		catch(Exception ex) {
			System.out.println("Exception in getAgentEscalatedTicket()");
			ex.printStackTrace();
		}
		return arrList;
	}
	//
	public static  List<Ticket>  getAgentOnholdTicket(String email){
		List<Ticket> arrList =  new ArrayList<>();
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from ticket where status like 'ONHOLD' and agentEmail = ? order by ticketId desc");
			pstm.setString(1, email);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Ticket ticket = new Ticket(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(7),rs.getString(9));
				arrList.add(ticket);	
			}
			
		}
		catch(Exception ex) {
			System.out.println("Exception in getAgentOnholdTicket()");
			ex.printStackTrace();
		}
		return arrList;
	}
//
	public static String getEmail(String id) {
		String gmail = null;
		try {
			PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from ticket where ticketId like ? ");
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()){
				gmail = rs.getString(10);
			}
			
		}
		catch(Exception ex) {
			System.out.println("Exception in getAgentOnholdTicket()");
			ex.printStackTrace();
		}
		return gmail;
	}
	//
	public static void addHistory(History his) {
		 SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm aa");
         Date now = new Date();
         String strDate = sdfDate.format(now);
         try {
             PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("insert into historyOfTheTicket values(?,?,?)");
			pstm.setString(1,his.getHistoryContent());
			pstm.setString(2,strDate);
		    pstm.setString(3,his.getId());
		    pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	//
	public static  List<History> getHistory(String id){
		List<History> list = new ArrayList<>();
		History his = null;
		try {
            PreparedStatement pstm = AppilicationVariables.dbConnection.prepareStatement("select * from historyOfTheTicket where ticketId = ? order by time desc;");
			pstm.setString(1,id);
		    ResultSet rs = pstm.executeQuery();
		    while(rs.next()) {
		    	his = new History(rs.getString(1),rs.getString(2),rs.getString(3));
		    	list.add(his);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
