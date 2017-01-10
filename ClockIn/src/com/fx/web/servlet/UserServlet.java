package com.fx.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fx.beans.Dept;
import com.fx.beans.Question;
import com.fx.beans.User;
import com.fx.service.DeptService;
import com.fx.service.QuestionService;
import com.fx.service.UserService;
import com.fx.service.impl.DeptServiceImpl;
import com.fx.service.impl.QuestionServiceImpl;
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
		case 4:
			this.bkPwdUI(request, response);
			break;
		case 5:
			this.bkPwd(request, response);
			break;
		case 6:
			this.findAll(request, response);
			break;
		case 7:
			this.addStaff(request, response);
			break;
		case 8:
			this.initPwd(request, response);
			break;
		case 9:
			this.delStaff(request, response);
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
	

	/**
	 * �����û����һ����� �ж�����û����Ƿ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void bkPwdUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String uname = request.getParameter("uname");
		UserService userService = new UserServiceImpl();
		User user = userService.findByUname(uname);
		if(user == null || "".equals(user)){
			request.setAttribute("msg", "��������ȷ���û���");
			request.getRequestDispatcher("pwdBack.jsp").forward(request, response);
		}else{
			//������û�  �����û���id������������л���
			request.getSession().setAttribute("bkuser", user);
			
			QuestionService questionService = new QuestionServiceImpl();
			List<Question> list =  questionService.findByUid(user.getU_id());
			request.setAttribute("list", list);
			request.getRequestDispatcher("pwdBack2.jsp").forward(request, response);
		}
	}
	
	
	
	/**
	 * �һ�����  �����ʼ��Ϊ 123456
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void bkPwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		User user = (User) request.getSession().getAttribute("bkuser");
		UserService userService = new UserServiceImpl();
		user.setNewPassword("123456");
		userService.updatePwd(user);
		request.setAttribute("msg", "�޸�����ɹ� ����Ϊ��ʼ����");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	
	
	/**
	 * ��ѯ���е�Ա�� �ȼ�Ϊ2
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		DeptService deptService = new DeptServiceImpl();
		List<Dept> allDept =deptService.findAll();
		request.getSession().setAttribute("allDept", allDept);
		
		UserService userService = new UserServiceImpl();
		List<User> ulist = 	userService.findAll();
		request.getSession().setAttribute("ulist", ulist);
		request.getRequestDispatcher("staffList.jsp").forward(request, response);
	}
	
	
	
	/**
	 * ���һ��Ա��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String uname = 	request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		UserService userService = new UserServiceImpl();
		
		boolean flag = userService.addUser(uname, pwd);
		if(flag){
			request.setAttribute("msg", "��ӳɹ�");
		}else{
			request.setAttribute("msg", "�û����Ѿ�����");
		}
		request.getRequestDispatcher("addStaff.jsp").forward(request, response);
	}
	
	
	/**
	 * ��ʼ������ 123456
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void initPwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		Integer uid = Integer.valueOf(request.getParameter("u_id"));
		
		UserService userService = new UserServiceImpl();
		User user = userService.findByUid(uid);
		user.setNewPassword("123456");
		
		userService.updatePwd(user);
		
		findAll(request, response);
	}
	
	/**
	 * ɾ��һ��Ա��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		Integer uid = Integer.valueOf(request.getParameter("u_id"));
		UserService userService = new UserServiceImpl();
		userService.delStaff(uid);
		
		findAll(request, response);
	}
	
	
}
