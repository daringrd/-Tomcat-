package com.yc.tomcat.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;

public class ServerService implements Runnable {
	private Socket sk;
	private InputStream is;
	private OutputStream os;
	
	public ServerService(Socket sk) {
		this.sk=sk;
	}
	

	@Override
	public void run() {
		try {
			this.is=sk.getInputStream();
			this.os=sk.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		ServletRequest request =new HttpServletRequest(is);
		
		request.parse();
		
		
		String url=request.getUrl();
		
		ServletResponse response = new HttpServletResponse(os);
		
		String clazz = ParseUrlPattern.getClass(url);
		if(clazz == null || "".equals(clazz)) {
			response.sendRedirect(url);
			return;
		}
		
		
		URLClassLoader loader=null;
		URL classPath=null;
		
		url=url.substring(1);
		String projectName=url.substring(0,url.indexOf("/"));
		
		try {
			classPath =new URL("file",null,TomcatConstants.BASE_PATH +"\\" +projectName + "\\ bin");
		    loader =new URLClassLoader(new URL[] {classPath});
		    
		    Class<?> cls=loader.loadClass(clazz);
		    Servlet servlet=(Servlet) cls.newInstance();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		

	}

}
