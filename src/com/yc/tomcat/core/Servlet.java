package com.yc.tomcat.core;

public interface Servlet {
	public void init();
	
	public void service(ServletRequest request, ServletResponse response);
	
	public void deGet(ServletRequest request, ServletResponse response);
	
	public void dePost(ServletRequest request, ServletResponse response);

}
