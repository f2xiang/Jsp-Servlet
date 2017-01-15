package com.fx.web.servlet;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fx.beans.Check;
import com.fx.beans.User;
import com.fx.service.CheckService;
import com.fx.service.impl.CheckServiceImpl;

public class CheckServlet extends HttpServlet {
	
	private CheckService checkService = new CheckServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer cid = Integer.valueOf(request.getParameter("cid"));
		
		switch (cid) {
		case 1:
			this.work(request, response);
			break;

		case 2:
			this.home(request, response);
			break;
		case 3:
			this.findAll(request, response);
			break;
		case 4:
			this.del(request, response);
			break;
		case 5:
			this.query(request, response);
			break;
		
		default:
			break;
		}
	}
	
	/**
	 * �ϰ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void work(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user =  (User) request.getSession().getAttribute("user");
		Date date = new Date();
		String worktime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		String worktype = "";
		
		
		Check findcheck =  this.checkService.findByChecktime();
		if(findcheck == null){
			//��û�����
			
			//7~10����ܴ�  10���� ���� 10���� �� ���Լ���  �����ж�
			int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			int min = Calendar.getInstance().get(Calendar.MINUTE);
			
			if(hour < 10 && hour >= 7 || (hour== 10 && min == 0 )){
				//���Դ�
				Check check = new Check();
				check.setu_id(user.getU_id());
				check.setWorktime(worktime);
				
				if(hour < 8 || (hour == 8 && min == 0)){  //8��֮ǰ�ϰ�
					//�����ϰ� û�гٵ�
					worktype = "����";
					check.setWorktype(worktype);
					this.checkService.workCard(check);
					
					request.setAttribute("work", "�����ϰ�");
				}else{
					worktype = "�ٵ�";
					check.setWorktype(worktype);
					this.checkService.workCard(check);
					request.setAttribute("work", "oh��~ �ٵ��ˣ�");
				}
				
				request.getRequestDispatcher("daka.jsp").forward(request, response);
				return ;
			}else{
				request.setAttribute("work", "���˴�ʱ����");
				request.getRequestDispatcher("daka.jsp").forward(request, response);
				return ;
			}
			
		}else{
			//�Ѿ��������
			request.setAttribute("work", "���Ѿ�������� ����ظ���");
			request.getRequestDispatcher("daka.jsp").forward(request, response);
			return ;
			
		}
		
		
	}
	
	
	/**
	 * �°��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void home(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ѯ����Ĵ򿨼�¼
		Check findCheck = this.checkService.findByChecktime();
		User user =  (User) request.getSession().getAttribute("user");
		Date date = new Date();
		String hometime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		
		
		//16~22���ܴ�
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int min = Calendar.getInstance().get(Calendar.MINUTE);
		String hometype = "";
		
		if(hour < 22 && hour >= 16 || hour== 22 && min == 0 ){
			//���Դ�
			if(findCheck == null){
				//��������û���---û�в鵽����Ĵ򿨼�¼  ����һ���°�ʱ��
			
				if(hour >= 5 ){  //5��֮���°�
					//�����ϰ� û�гٵ�
					hometype = "����û��  ��������";
					Check check = new Check();
					check.setu_id(user.getU_id());
					check.setHometime(hometime);
					check.setHometype(hometype);
					this.checkService.homeCard(check);
					
					request.setAttribute("home", "����û��  ��������");
				}else{
					request.setAttribute("home", "oh��~ ���ˣ�");
					hometype = "����";
				}
				
				request.getRequestDispatcher("daka.jsp").forward(request, response);
				return ;
				
			}else{ //���ϴ���� �°�Ҫ��������
				
				if(findCheck.getHometime() == null || "".equals(findCheck.getHometime())){
					//�°໹û���  --����
					hometype = "�����°�";
					Check check = this.checkService.findByChecktime();
					check.setu_id(user.getU_id());
					check.setHometime(hometime);
					check.setHometype(hometype);
					this.checkService.updateHome(check);
					
					request.setAttribute("home", "�����°�");
					request.getRequestDispatcher("daka.jsp").forward(request, response);
					return ;
					
				}else{
					//�°��Ѿ������
					request.setAttribute("home", "���Ѿ�������� ���ظ�");
					request.getRequestDispatcher("daka.jsp").forward(request, response);
					return ;
				}
			}
		}
		else{
			request.setAttribute("home", "���Ǵ�ʱ��Ŷ");
			request.getRequestDispatcher("daka.jsp").forward(request, response);
			return ;
		}
		
	}
	
	
	/**
	 * ��ѯ���д򿨼�¼
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Map<String, String>> list = this.checkService.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("checkList.jsp").forward(request, response);
		
	}
	
	
	
	
	
	
	/**
	 * ɾ���򿨼�¼
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer c_id = Integer.valueOf(request.getParameter("c_id"));
		this.checkService.delByCid(c_id);
		findAll(request, response);
	}
	
	
	
	/**
	 * ������ѯ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String time = request.getParameter("time");
		
		List<Map<String, String>> list = null;
		if(time == null  || "".equals(time)){
			 list = this.checkService.findAll();
		}else{
			 list = this.checkService.findByChecktime(time);
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("checkList.jsp").forward(request, response);
		
	}
	
	

	
}
