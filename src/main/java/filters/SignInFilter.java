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
 * Servlet Filter implementation class SignInFilter
 */
@WebFilter("/CompanySignIn")
public class SignInFilter extends HttpFilter implements Filter {
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		Cookie[] cookies = req.getCookies();
		String Session =null;
		boolean allow = false;
	    if(cookies != null) {
		for(Cookie c : cookies) {
			if(c.getName().equals("sessionId")) {
				Session = c.getValue();
			}
		}
		 allow = AllMethods.checkSessionId(Session);
	    }
		if(allow){
		//Want to redirect to the 1st page of the app.(homePage)	
//			while hit the like we want to check if the user is logedIn or not.
		}
		else {
			
			chain.doFilter(request, response);

		}
	}

}
