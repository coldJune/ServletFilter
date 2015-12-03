package com.jun.filter;
import javax.servlet.*;
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
	
	
}
