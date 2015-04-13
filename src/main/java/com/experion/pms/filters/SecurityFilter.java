package com.experion.pms.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(final FilterConfig arg0) throws ServletException {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)	 */
	
	public void doFilter(final ServletRequest request,
			final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		
		final HttpSession session = ((HttpServletRequest) request)
				.getSession(false);
		final String contextName = ((HttpServletRequest) request)
				.getContextPath();
		final String requestURI = ((HttpServletRequest) request)
				.getRequestURI();
		//System.out.println("facility---------"+session.getAttribute("facilityId"));
		final boolean dtoInSession = session != null && session.getAttribute("userId") != null && session.getAttribute("facilityId") != null;
		if ((dtoInSession || requestURI.equals(contextName) 
				|| requestURI.startsWith(contextName+"/pms") 
				|| requestURI.equals(contextName+"/index.jsp")				
				|| requestURI.endsWith(".css") 
				|| requestURI.endsWith(".gif")
				|| requestURI.endsWith(".jpg")				
				|| requestURI.endsWith(".jsp") 
				|| requestURI.endsWith(".js")
				|| requestURI.endsWith(".pdf") 
				|| requestURI.endsWith(".jpeg")
				|| requestURI.endsWith(".png") 
				|| requestURI.equals(contextName+ "/"))){			
			chain.doFilter(request, response);
			
		} else{
			((HttpServletRequest) request).getSession().invalidate();
			((HttpServletResponse) response).sendRedirect(contextName
					+ "/pms/login");					
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// do nothing
		System.out.println("sdfhsdkfhsdkfhdskfhksd");
	}

}