package com.yc.tomcat.core;

public class HttpServlet implements Servlet{
	
	@Override
	public void init() {
	}
	
	public void service(ServletRequest request, ServletResponse response) {
		switch(request.getMethod()) {
		case TomcatConstants.REQUEST_METHOD_GET:deGet(request, response); break;
		case TomcatConstants.REQUEST_METHOD_POST:dePost(request, response); break;
		}
	}

	@Override
	public void deGet(ServletRequest request, ServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dePost(ServletRequest request, ServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
