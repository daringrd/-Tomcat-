package com.yc.clothshop.servlet;

import com.yc.tomcat.core.HttpServlet;
import com.yc.tomcat.core.ServletRequest;
import com.yc.tomcat.core.ServletResponse;

public class LoginServlet extends HttpServlet{
      public void doGet(ServletRequest request, ServletResponse response) {
    	  doPost(request, response);
	}

	public void doPost(ServletRequest request, ServletResponse response) {
		System.out.println("id=" + request.getParameter("id"));
		System.out.println("name=" + request.getParameter("name"));

		response.sendRedirect("/clothshop/index.html");
	}
}
