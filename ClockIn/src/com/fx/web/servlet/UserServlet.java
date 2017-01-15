package com.fx.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.fx.beans.Dept;
import com.fx.beans.Question;
import com.fx.beans.User;
import com.fx.service.DeptService;
import com.fx.service.QuestionService;
import com.fx.service.UserService;
import com.fx.service.impl.DeptServiceImpl;
import com.fx.service.impl.QuestionServiceImpl;
import com.fx.service.impl.UserServiceImpl;
import com.fx.utils.IOUtils;
import com.fx.utils.MD5Utils;
import com.fx.utils.Page;
import com.fx.utils.PageUtils;

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
		case 10:
			this.uplogo(request, response);
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
		
		//�����֤��
		String valistr = (String) request.getSession().getAttribute("valistr");
		String vali = request.getParameter("vali");
		if(vali.equalsIgnoreCase(valistr)){
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
		}else{
			request.setAttribute("msg", "��֤�����");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
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
		//-------------------------------------------
		
//		int currentPage = 0;
//		String currentPageStr = request.getParameter("currentPage");
//		if(currentPageStr == null || "".equals(currentPageStr)){
//			currentPage = 1;
//		}else {
//			currentPage = Integer.parseInt(currentPageStr);
//		}
//		
//		Page page = PageUtils.createPage(1, 2, currentPage);
//		System.out.println(page);
//		UserService userService = new UserServiceImpl();
//		List<User> ulist = 	userService.findAll(page);
//		request.getSession().setAttribute("ulist", ulist);
//		
//		request.getSession().setAttribute("page", page);
				
		
		
		//-------------------------------------------
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
	
	
	
	/**
	 * �ϴ�ͷ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void uplogo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		try {
			//1.�ϴ��ļ�
			String upload = this.getServletContext().getRealPath("image");
			String temp = this.getServletContext().getRealPath("image/temp");
			Map pmap = new HashMap();
			
			
			
			//--�������������ڴ滺�����Ĵ�С����ʱ�ļ��е�λ��
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*100);
			factory.setRepository(new File(temp));
			
			//--��ȡ�ļ��ϴ�������,����ļ�������/�����ļ���С����
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setHeaderEncoding("utf-8");
			fileUpload.setFileSizeMax(1024*1024*100);
			fileUpload.setSizeMax(1024*1024*200);
			
			//--����Ƿ�����ȷ���ļ��ϴ���
			if(!fileUpload.isMultipartContent(request)){
				throw new RuntimeException("��ʹ����ȷ�ı������ϴ�!");
			}
			
			//--����request
			List<FileItem> list = fileUpload.parseRequest(request);
			
			//--����list,��ȡFileItem���н���
			for(FileItem item : list){
				if(item.isFormField()){//��ͨ�ֶ���
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					pmap.put(name, value);
				}else{//�ļ��ϴ�
					
					
					String realname = item.getName();
					String savename = "xiaoren10.png";
					pmap.put("realname", realname);
					pmap.put("savename", savename);
					
					//--��ȡ������
					InputStream in = item.getInputStream();
					
					
					//--��ȡ�����
					OutputStream out = new FileOutputStream(new File(upload,savename));
					
					//--���Խ��ϴ�
					IOUtils.In2Out(in, out);
					IOUtils.close(in, out);
					
					//--ɾ����ʱ�ļ�
					item.delete();
				}
				
			}
			
			//�ض������ҳ
			response.sendRedirect("love_gy_gyal.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
