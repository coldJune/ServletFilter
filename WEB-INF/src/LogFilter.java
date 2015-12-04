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
			System.out.println("��ʼ����");
			HttpServletRequest hrequest  = (HttpServletRequest)request;
			System.out.println("Filter�Ѿ��ػ��û�������ĵ�ַ:"+hrequest.getServletPath());
			chain.doFilter(request,response);
			long after = System.currentTimeMillis();
			System.out.println("���˽���");
			System.out.println("���󱻶�λ����"+hrequest.getRequestURI()+"������ʱ�䣺"+(after-before));
	}
	
}
