package com.fx.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fx.beans.Person;
import com.fx.beans.User;
import com.fx.service.PersonService;
import com.fx.service.impl.PersonServiceImpl;

public class PersonServlet extends HttpServlet {

	private PersonService personService = new PersonServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer pid = Integer.valueOf(request.getParameter("pid"));
		
		switch (pid) {
		case 1:
			this.findPero(request, response);
			break;

		case 2:
			this.updatePero(request, response);
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * �����û�id���Ҹ�����Ϣ�Ͳ���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findPero(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		User user = (User) request.getSession().getAttribute("user");
		
		Map<String, String> map =  this.personService.findByUid(user.getU_id());
		request.getSession().setAttribute("map", map);
		request.getRequestDispatcher("empcenter.jsp").forward(request, response);
	}
	
	/**
	 * �޸ĸ�����Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updatePero(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		try {
			//Date���͵����������޸�
			String bir = request.getParameter("bir");
			Date birth = new SimpleDateFormat("yyyy-MM-dd").parse(bir);
			
			Person person = new Person();
			//��װ�������� pid, name, age, sal, phone, address, 
			BeanUtils.populate(person, request.getParameterMap());
			person.setBirth(birth);
			
			//����service�������ݿ�
			this.personService.updatePer(person);
			
			//���»ص���������ҳ��
			findPero(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	

}
