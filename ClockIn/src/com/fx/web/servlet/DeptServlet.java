package com.fx.web.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fx.beans.Dept;
import com.fx.service.DeptService;
import com.fx.service.impl.DeptServiceImpl;

public class DeptServlet extends HttpServlet {
	
	private DeptService deptService = new DeptServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer did = Integer.valueOf(request.getParameter("did"));
		
		switch (did) {
		case 1:
			this.addDept(request, response);
			break;

		case 2:
			this.deptList(request, response);
			break;
		case 3:
			this.updateDept(request, response);
			break;
			
		case 4:
			this.delDept(request, response);
			break;
		default:
			break;
		}
	}
	
	
	/**
	 * ��Ӳ���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addDept(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String dname =  request.getParameter("dname");
		 this.deptService.addDept(dname);
		 request.setAttribute("msg", "�ɹ�����");
		 request.getRequestDispatcher("addDept.jsp").forward(request, response);
	}
	
	
	
	/**
	 * ��ѯ���в�����Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deptList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Dept> allDept =  this.deptService.findAll();
		request.setAttribute("allDept", allDept);
		request.getRequestDispatcher("deptManager.jsp").forward(request, response);
	}
	
	
	/**
	 * ���²�����Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateDept(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 Integer d_id = Integer.valueOf(request.getParameter("d_id"));
		 String dname = request.getParameter("dname");
		 this.deptService.updateDept(d_id, dname);
		 this.deptList(request, response);
	}
	
	
	/**
	 * ɾ��������Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delDept(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 Integer d_id = Integer.valueOf(request.getParameter("d_id"));
		 this.deptService.delDept(d_id);
		 deptList(request, response);
	}
	
}
