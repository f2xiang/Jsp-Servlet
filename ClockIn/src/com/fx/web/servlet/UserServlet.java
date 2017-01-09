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
	 * �û���¼
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
			//��¼ʧ��
			request.setAttribute("msg", "�û��������������");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		//��¼�ɹ�   ���õ�¼�ɹ���־
		request.getSession().setAttribute("user", user);
		
		if(user.getLevel() == 1){
			//����Ա�����������
			response.sendRedirect("love_gy_gyal.jsp");
		}else{
			//�ǹ���Ա
			response.sendRedirect("love_xq_znxx.jsp");
		}
			
	}
	
	
	
	/**
	 * �û�ע��
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
	 * �޸�����
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
			//��װ pwd ������ ȷ������
			BeanUtils.populate(user, request.getParameterMap());
			
			//��session���ù������û�
			User u = (User) request.getSession().getAttribute("user");
			user.setU_id(u.getU_id());
			
			if(u.getPwd().equals(MD5Utils.md5(user.getPwd()))){
				//����ľ�������ȷ
				//���������������������Ƿ�һ��
				if(user.getNewPassword().equals(user.getConfrimPassword())){
					//һ��  ���ݿ����
					userService.updatePwd(user);
					request.setAttribute("msg", "�޸ĳɹ�");
					request.getRequestDispatcher("changePassword.jsp").forward(request, response);
				}else{
					request.setAttribute("msg", "��������벻һ�£����������룡");
					request.getRequestDispatcher("changePassword.jsp").forward(request, response);
				}
			}else{
				//�����������
				request.setAttribute("msg", "��������ȷ�����룡");
				request.getRequestDispatcher("changePassword.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
	
	
}
