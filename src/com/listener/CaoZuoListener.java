package com.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CaoZuoListener implements HttpSessionAttributeListener{

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("添加属性");
		System.out.println(arg0.getName());
		System.out.println(arg0.getSession().getAttribute(arg0.getName()));
		
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
	System.out.println("移除属性");
		
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("更改属性");
		
	}


}
