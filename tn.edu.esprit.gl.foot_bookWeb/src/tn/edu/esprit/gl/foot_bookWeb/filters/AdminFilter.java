package tn.edu.esprit.gl.foot_bookWeb.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.edu.esprit.gl.foot_bookEJB.model.Admin;
import tn.edu.esprit.gl.foot_bookWeb.ctr.UserCtr;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/pages/admin/*")
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
	HttpServletRequest servletRequest=(HttpServletRequest) request;
	HttpServletResponse servletResponse=(HttpServletResponse)response;
	
	UserCtr userCtr =(UserCtr) servletRequest.getSession().getAttribute("userManager");
	if(userCtr!=null && userCtr.isConnected() && userCtr.getUser().getClass()==Admin.class)
		{
		chain.doFilter(request, response);
		}
	else
	{
		servletResponse.sendRedirect(servletRequest.getContextPath()+"/login.jsf");
	}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
