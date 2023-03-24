package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaClasses.AllMethods;


/**
 * Servlet Filter implementation class Authorization
 */
@WebFilter(urlPatterns = {"/SelectTicket","/AddDepartmentInAgentForm","/AddNewAgent","/AddNewTeam","/CompanyLogOut","/InsideAgent","/SelectCompanyClosedTickets","/SelectCompanyEscalatedTicket","/SelectCompanyOnholdTicket","/SelectCompanyOpenTicket","/ShowAgent","/showInsideTeam","/ShowTeams","/TicketInformation"})
public class Authorization extends HttpFilter implements Filter {
       
  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
//		chain.doFilter(request, response);
//		HttpServletRequest req = (HttpServletRequest)request;
//		HttpServletResponse res = (HttpServletResponse)response;
//		Cookie[] cookies = req.getCookies();
//		String Session =null;
//		boolean allow = false;
//	
//		for(Cookie c : cookies) {
//			if(c.getName().equals("sessionId")) {
//				Session = c.getValue();
//			}
//		}
//		 allow = AllMethods.checkSessionId(Session);
//		
//		if(allow){
//			chain.doFilter(request, response);
//		}
//		else {
//			System.out.println("checking");
//			request.getRequestDispatcher("./companySignIn.html").forward(request, response);
//			
//			
//			//res.sendRedirect("./companySignIn.html");
//			
//		}
		}
}
