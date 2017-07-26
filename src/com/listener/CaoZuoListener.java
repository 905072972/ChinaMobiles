package com.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CaoZuoListener implements HttpSessionAttributeListener{

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("�������");
		System.out.println(arg0.getName());
		System.out.println(arg0.getSession().getAttribute(arg0.getName()));
		
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
	System.out.println("�Ƴ�����");
		
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("��������");
		
	}


}
