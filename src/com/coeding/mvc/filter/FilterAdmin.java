package com.coeding.mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Lam Cong Hau
 * Servlet Filter implementation class FilterAdmin
 */
@WebFilter("/admin/*")
public class FilterAdmin implements Filter {

    /**
     * Default constructor. 
     */
    public FilterAdmin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("filter destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filter admin => check login session");
		HttpSession session = ((HttpServletRequest)request).getSession();
		String value = (String)session.getAttribute("auth");
		if( value == null || !value.equals("ADMIN")) {
			System.out.println("Filter admin ==> forward to login ");
			request.getRequestDispatcher("/user/login.do").forward(request, response);
		}else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter init");
	}

}
