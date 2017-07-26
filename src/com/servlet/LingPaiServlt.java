package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LingPaiServlt extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code=(int)(Math.random()*100);
		request.setAttribute("kouling",code);
		HttpSession session=request.getSession();
		session.setAttribute("kouling", code);
		request.getRequestDispatcher("resource.jsp").forward(request, response);
	}
}
