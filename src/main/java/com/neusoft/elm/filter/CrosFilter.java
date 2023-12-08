package com.neusoft.elm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class CrosFilter implements Filter {

	

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) arg1;
		// 设置允许跨域访问，并且设置允许什么样的url进行跨域访问。
		response.setHeader("Access-Control-Allow-Origin", " http://localhost:8081");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
		response.setHeader("Access-Control-Max-Age", "3628800");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
		
		arg2.doFilter(arg0, arg1);

	}
	
	
	
	
	
    @Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
