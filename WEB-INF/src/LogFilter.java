package com.jun.filter;

import javax.servlet.Filter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;

@WebFilter(filterName="login",
			urlPatterns={"/*"})
public class LogFilter implements Filter{
	private FilterConfig config;
	public void init(FilterConfig config){
		this.config = config;
	}
	
	public void destroy(){
		this.config=null;
	}
	
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)
		throws IOException,ServletException{
			ServletContext context = this.config.getServletContext();
			long before = System.currentTimeMillis();
			System.out.println("开始过滤");
			HttpServletRequest hrequest  = (HttpServletRequest)request;
			System.out.println("Filter已经截获到用户的请求的地址:"+hrequest.getServletPath());
			chain.doFilter(request,response);
			long after = System.currentTimeMillis();
			System.out.println("过滤结束");
			System.out.println("请求被定位到："+hrequest.getRequestURI()+"所花的时间："+(after-before));
	}
	
}
