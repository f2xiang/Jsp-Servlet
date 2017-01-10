package com.fx.web.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fx.beans.Question;
import com.fx.beans.User;
import com.fx.service.QuestionService;
import com.fx.service.impl.QuestionServiceImpl;

public class QuestionServlet extends HttpServlet {
	
	private QuestionService questionService = new QuestionServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Integer qid = Integer.valueOf(request.getParameter("qid"));
			
			switch (qid) {
			case 1:
				this.findQuestion(request, response);
				break;
	
			case 2:
				this.insertQuestion(request, response);
				break;
			
			case 3:
				this.checkQuestion(request, response);
				break;
			default:
				break;
		}
	}
	
	
	/**
	 * 根据用户的id查找问题
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");
		List<Question> qlist = this.questionService.findByUid(user.getU_id());
		if(qlist == null || qlist.size() == 0){
			//还没设置密码问题
			request.setAttribute("msg", false);
		}else{
			//已经设置了密码问题 放在request域  数据的回显
			request.setAttribute("msg", true);
			request.getSession().setAttribute("questionList", qlist);
		}
		request.getRequestDispatcher("question.jsp").forward(request, response);

	}
	
	
	/**
	 * 添加密码问题
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void insertQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");
		
		String [] qname = request.getParameterValues("qname");
		String [] aname = request.getParameterValues("aname");
		
		for(int i = 0; i < qname.length; i++){
			this.questionService.insert(aname[i], qname[i], user.getU_id());			
		}
		
		findQuestion(request, response);
		
	}
	
	
	
	/**
	 * 用于验证密码问题 来找回密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void checkQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("bkuser");
		List<Question> questionlist = this.questionService.findByUid(user.getU_id());
		
		String[] aname = request.getParameterValues("aname");
		for (int i = 0; i < aname.length; i++) {
			if(!(questionlist.get(i).getAname().equals(aname[i]))){
				request.setAttribute("msg", "验证密码错误");
				request.getRequestDispatcher("pwdBack2.jsp").forward(request, response);
				return;
			}
		}
		response.sendRedirect("user.do?uid=5");
		return;
		
		
		
	}
}