package com.fx.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fx.beans.User;
import com.fx.service.UserService;
import com.fx.service.impl.UserServiceImpl;
import com.fx.utils.MD5Utils;

public class UserServlet extends HttpServlet {


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer uid = Integer.valueOf(request.getParameter("uid"));
		
		switch (uid) {
		case 1:
			this.login(request, response);
			break;
		case 2:
			this.logout(request, response);
			break;
		case 3:
			this.upPwd(request, response);
			break;

		default:
			break;
		}
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		UserService userService = new UserServiceImpl();
		
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		User user = userService.login(uname, pwd);
		if(user == null){
			//登录失败
			request.setAttribute("msg", "用户名或者密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		//登录成功   设置登录成功标志
		request.getSession().setAttribute("user", user);
		
		if(user.getLevel() == 1){
			//管理员跳到这个界面
			response.sendRedirect("love_gy_gyal.jsp");
		}else{
			//非管理员
			response.sendRedirect("love_xq_znxx.jsp");
		}
			
	}
	
	
	
	/**
	 * 用户注销
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.getSession().invalidate();
		response.sendRedirect("login.jsp");
	}
	
	
	
	
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void upPwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		UserService userService = new UserServiceImpl();
		
		User user = new User();
		try {
			//封装 pwd 新密码 确认密码
			BeanUtils.populate(user, request.getParameterMap());
			
			//从session中拿过来的用户
			User u = (User) request.getSession().getAttribute("user");
			user.setU_id(u.getU_id());
			
			if(u.getPwd().equals(MD5Utils.md5(user.getPwd()))){
				//输入的旧密码正确
				//继续检查两次输入的密码是否一致
				if(user.getNewPassword().equals(user.getConfrimPassword())){
					//一致  数据库更新
					userService.updatePwd(user);
					request.setAttribute("msg", "修改成功");
					request.getRequestDispatcher("changePassword.jsp").forward(request, response);
				}else{
					request.setAttribute("msg", "输入的密码不一致，请重新输入！");
					request.getRequestDispatcher("changePassword.jsp").forward(request, response);
				}
			}else{
				//密码输入错误
				request.setAttribute("msg", "请输入正确的密码！");
				request.getRequestDispatcher("changePassword.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
	
	
}
