package com.yc.tomcat.core;

import java.io.PrintWriter;

public interface ServletResponse {
	
	public PrintWriter getWriter();
	
	/**
	 * 重定向的方法
	 */
	public void sendRedirect(String url);

}
