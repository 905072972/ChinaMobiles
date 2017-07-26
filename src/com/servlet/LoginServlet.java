package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ToperatorDao;
import com.pojo.Toperator;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接调跳
		String loginname = request.getParameter("loginname");
		String pwd = request.getParameter("passwords");
		ToperatorDao td = new ToperatorDao();
		Toperator t = td.login(loginname, pwd);
		Cookie[] cs = request.getCookies();
		Cookie cuname = new Cookie("uname", loginname);
		Cookie cpwd = new Cookie("pwd", pwd);
		for (Cookie c : cs) {
			System.out.println(c.getName() + "--" + c.getValue());
			cuname = new Cookie("uname", loginname);
			cpwd = new Cookie("pwd", pwd);
			cuname.setMaxAge(60 * 60 * 24);
			cpwd.setMaxAge(60 * 24 * 60);
		}

		response.addCookie(cuname);
		response.addCookie(cpwd);
		if (t != null) {
			request.setAttribute("user", t);
			HttpSession session = request.getSession();
			// System.out.println("session"+session.getId());
			ServletContext application=session.getServletContext();
			Integer count = (Integer) application.getAttribute("online");
			if (count == null||count==0) {
				count = new Integer(0);
			}
			count++;
			application.setAttribute("online", count);
			
			
			session.setAttribute("user", t);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "不正确");
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		}
	}
}
