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
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		//获得验证码
		String valistr = (String) request.getSession().getAttribute("valistr");
		String vali = request.getParameter("vali");
		if(vali.equalsIgnoreCase(valistr)){
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
		}else{
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
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
	

	/**
	 * 根据用户名找回密码 判断这个用户名是否存在
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
			request.setAttribute("msg", "请输入正确的用户名");
			request.getRequestDispatcher("pwdBack.jsp").forward(request, response);
		}else{
			//有这个用户  根据用户的id把密码问题进行回显
			request.getSession().setAttribute("bkuser", user);
			
			QuestionService questionService = new QuestionServiceImpl();
			List<Question> list =  questionService.findByUid(user.getU_id());
			request.setAttribute("list", list);
			request.getRequestDispatcher("pwdBack2.jsp").forward(request, response);
		}
	}
	
	
	
	/**
	 * 找回密码  密码初始化为 123456
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
		request.setAttribute("msg", "修改密码成功 密码为初始密码");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	
	
	/**
	 * 查询所有的员工 等级为2
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
	 * 添加一个员工
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
			request.setAttribute("msg", "添加成功");
		}else{
			request.setAttribute("msg", "用户名已经存在");
		}
		request.getRequestDispatcher("addStaff.jsp").forward(request, response);
	}
	
	
	/**
	 * 初始化密码 123456
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
	 * 删除一个员工
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
	 * 上传头像
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void uplogo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		try {
			//1.上传文件
			String upload = this.getServletContext().getRealPath("image");
			String temp = this.getServletContext().getRealPath("image/temp");
			Map pmap = new HashMap();
			
			
			
			//--创建工厂设置内存缓冲区的大小和临时文件夹的位置
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*100);
			factory.setRepository(new File(temp));
			
			//--获取文件上传核心类,解决文件名乱码/设置文件大小限制
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setHeaderEncoding("utf-8");
			fileUpload.setFileSizeMax(1024*1024*100);
			fileUpload.setSizeMax(1024*1024*200);
			
			//--检查是否是正确的文件上传表单
			if(!fileUpload.isMultipartContent(request)){
				throw new RuntimeException("请使用正确的表单进行上传!");
			}
			
			//--解析request
			List<FileItem> list = fileUpload.parseRequest(request);
			
			//--遍历list,获取FileItem进行解析
			for(FileItem item : list){
				if(item.isFormField()){//普通字段项
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					pmap.put(name, value);
				}else{//文件上传
					
					
					String realname = item.getName();
					String savename = "xiaoren10.png";
					pmap.put("realname", realname);
					pmap.put("savename", savename);
					
					//--获取输入流
					InputStream in = item.getInputStream();
					
					
					//--获取输出流
					OutputStream out = new FileOutputStream(new File(upload,savename));
					
					//--流对接上传
					IOUtils.In2Out(in, out);
					IOUtils.close(in, out);
					
					//--删除临时文件
					item.delete();
				}
				
			}
			
			//重定向回主页
			response.sendRedirect("love_gy_gyal.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
