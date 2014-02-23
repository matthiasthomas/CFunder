package com.supinfo.supcrowdfunder.filter;

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
import javax.servlet.http.HttpSession;

import com.supinfo.supcrowdfunder.entity.User;

@WebFilter(urlPatterns = "/auth/*")
public class AuthenticateFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hresp = (HttpServletResponse) response;

		HttpSession session = hreq.getSession();
		User user = new User();

		if (session.getAttribute("mail") == null) {
			System.out.println("user et null");
			user = null;
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		if (session.getAttribute("mail") != null) {
			chain.doFilter(request, response);
		} else {
			hresp.setStatus(HttpServletResponse.SC_FORBIDDEN);
			// throw new WebApplicationException(403);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
