package com.karunsood.InMemoryAuthenticationExample.config;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CustomFilter implements Filter{

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init:Called");
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("doFilter:Called");
		
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		Principal userPrincipal=request.getUserPrincipal();
		System.out.println("UserPrincipal::"+userPrincipal);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		System.out.println("Destroy:Called");
	}

	

}
