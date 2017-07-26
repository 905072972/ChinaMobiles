package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("������session����"+arg0.getSession().getId());
		
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("������session����"+arg0.getSession().getId());
		ServletContext application=arg0.getSession().getServletContext();
		Integer count=(Integer) application.getAttribute("online");
		count--;
		application.setAttribute("online",count);
	}

}
