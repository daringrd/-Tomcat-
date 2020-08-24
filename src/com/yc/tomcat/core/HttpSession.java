package com.yc.tomcat.core;

import java.util.Hashtable;
import java.util.Map;

public class HttpSession {
	public Map<String, Object> session = new Hashtable<String, Object>();
	private String jsessionid=null;
	
	/**
	 * 往session中存值
	 */
	public void setAttribute(String key, Object value) {
		this.setAttribute(key, value);
	}
	
	/**
	 * 从session中根据键获取对应的值
	 */
	public Object getAttribute(String key) {
		if(!session.containsKey(key)) {
			return null;
		}
		
		return session.get(key);
	}
	
	public void setJSessionId(String jsession) {
		this.jsessionid=jsession;
	}

}
