package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TmobilesDao;

public class TmobileServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		boolean isRepeat=isRepeatSumbit(request);
//		if(isRepeat==true){
//			request.setAttribute("MSG", "请不要重复提交");
//			System.out.println("请不要重复提交");
//			request.getRequestDispatcher("/Msg.jsp").forward(request, response);
//			return;
//		}
//		request.getSession().removeAttribute("taken");
//		request.setAttribute("MSG","处理提交");
//		request.getRequestDispatcher("/Msg.jsp").forward(request, response);
//		System.out.println("处理提交请求");
			doPost(request, response);
			
	}

//	private boolean isRepeatSumbit(HttpServletRequest request) {
//		String client_token=request.getParameter("token");
//		if(client_token==null){
//			return true;
//		}
//		String server_token=(String) request.getSession().getAttribute("token");
//		if(server_token==null){
//			return true;
//		}
//		if(!client_token.equals(server_token)){
//			return true;
//		}
//		return false;
//	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
			String type=request.getParameter("Mtype");
			String start=request.getParameter("T1");
			String end =request.getParameter("T2");
			String lingpai=request.getParameter("lingpai");
			HttpSession session=request.getSession();
			Integer sessionlingpai=(Integer) session.getAttribute("kouling");
			System.out.println("session lingpai"+sessionlingpai);
			if(lingpai.equals(sessionlingpai+"")){
				session.setAttribute("kouling", sessionlingpai+sessionlingpai);
				TmobilesDao td=new TmobilesDao();
				td.piliangtianjia(start, end, type);
				request.getRequestDispatcher("main.jsp").forward(request, response);				
			}else{
				response.getWriter().write("请不要重复提交");
			}
			
			//request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
