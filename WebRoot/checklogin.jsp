<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.pojo.Toperator"%>
<%
	Toperator t = (Toperator) session.getAttribute("user");
	//if (t == null) {
		//request.setAttribute("msessage", "重新登录");
		//request.getRequestDispatcher("index.jsp").forward(request,response);
	//}
%>
