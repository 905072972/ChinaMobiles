package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.pojo.Toperator;

public class LoginFilter  implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session=request.getSession();
		Toperator t=(Toperator) session.getAttribute("user");		
		String path=request.getRequestURI();
		System.out.println(path);
		if(t!=null||path.endsWith("/login.do")){
			fc.doFilter(req, response);
		}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);			
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
