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
	 * 上班打卡
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
			//还没打过卡
			
			//7~10点才能打卡  10点多打卡 不算 10点整 算 所以加上  后半句判断
			int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			int min = Calendar.getInstance().get(Calendar.MINUTE);
			
			if(hour < 10 && hour >= 7 || (hour== 10 && min == 0 )){
				//可以打卡
				Check check = new Check();
				check.setu_id(user.getU_id());
				check.setWorktime(worktime);
				
				if(hour < 8 || (hour == 8 && min == 0)){  //8点之前上班
					//正常上班 没有迟到
					worktype = "正常";
					check.setWorktype(worktype);
					this.checkService.workCard(check);
					
					request.setAttribute("work", "正常上班");
				}else{
					worktype = "迟到";
					check.setWorktype(worktype);
					this.checkService.workCard(check);
					request.setAttribute("work", "oh不~ 迟到了！");
				}
				
				request.getRequestDispatcher("daka.jsp").forward(request, response);
				return ;
			}else{
				request.setAttribute("work", "过了打卡时间了");
				request.getRequestDispatcher("daka.jsp").forward(request, response);
				return ;
			}
			
		}else{
			//已经打过卡了
			request.setAttribute("work", "你已经打过卡了 请别重复打卡");
			request.getRequestDispatcher("daka.jsp").forward(request, response);
			return ;
			
		}
		
		
	}
	
	
	/**
	 * 下班打卡
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void home(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//查询今天的打卡记录
		Check findCheck = this.checkService.findByChecktime();
		User user =  (User) request.getSession().getAttribute("user");
		Date date = new Date();
		String hometime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		
		
		//16~22才能打卡
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int min = Calendar.getInstance().get(Calendar.MINUTE);
		String hometype = "";
		
		if(hour < 22 && hour >= 16 || hour== 22 && min == 0 ){
			//可以打卡
			if(findCheck == null){
				//今天上午没打过---没有查到今天的打卡记录  插入一条下班时间
			
				if(hour >= 5 ){  //5点之后下班
					//正常上班 没有迟到
					hometype = "上午没打  下午正常";
					Check check = new Check();
					check.setu_id(user.getU_id());
					check.setHometime(hometime);
					check.setHometype(hometype);
					this.checkService.homeCard(check);
					
					request.setAttribute("home", "上午没打  下午正常");
				}else{
					request.setAttribute("home", "oh不~ 早退！");
					hometype = "早退";
				}
				
				request.getRequestDispatcher("daka.jsp").forward(request, response);
				return ;
				
			}else{ //早上打过了 下班要更新数据
				
				if(findCheck.getHometime() == null || "".equals(findCheck.getHometime())){
					//下班还没打过  --更新
					hometype = "正常下班";
					Check check = this.checkService.findByChecktime();
					check.setu_id(user.getU_id());
					check.setHometime(hometime);
					check.setHometype(hometype);
					this.checkService.updateHome(check);
					
					request.setAttribute("home", "正常下班");
					request.getRequestDispatcher("daka.jsp").forward(request, response);
					return ;
					
				}else{
					//下班已经打过了
					request.setAttribute("home", "你已经打过卡了 别重复");
					request.getRequestDispatcher("daka.jsp").forward(request, response);
					return ;
				}
			}
		}
		else{
			request.setAttribute("home", "不是打卡时间哦");
			request.getRequestDispatcher("daka.jsp").forward(request, response);
			return ;
		}
		
	}
	
	
	/**
	 * 查询所有打卡记录
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
	 * 删除打卡记录
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
	 * 条件查询
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
