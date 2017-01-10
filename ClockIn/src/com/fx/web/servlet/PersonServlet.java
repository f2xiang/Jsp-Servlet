package com.fx.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fx.beans.Dept;
import com.fx.beans.Person;
import com.fx.beans.User;
import com.fx.service.DeptService;
import com.fx.service.PersonService;
import com.fx.service.impl.DeptServiceImpl;
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
		case 3:
			this.findByUid(request, response);
			break;
		case 4:
			this.saveOrUpdate(request, response);
			break;
		case 5:
			this.query(request, response);
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
	
	/**
	 * ����uid��ѯ��ϸ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findByUid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		Integer uid = Integer.valueOf(request.getParameter("u_id"));
		
		request.getSession().setAttribute("uid", uid);
		
		Map<String, String> map = this.personService.findByUid(uid);
		request.setAttribute("map", map);
		
		DeptService deptService = new DeptServiceImpl();
		List<Dept> alldept =  deptService.findAll();
		request.setAttribute("alldept", alldept);
		
		
		request.getRequestDispatcher("staffInform.jsp").forward(request, response);
	}

	
	
	/**
	 * ��������Ա������ϸ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void saveOrUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		
		try {
			Person person = new Person();
			//p_id=1, name=����, age=13, sal=9999.0, birth=null, phone=1231231234, address=���, u_id=null, d_id=3
			BeanUtils.populate(person, request.getParameterMap());
			String bir = request.getParameter("bir");
			Date birth = new SimpleDateFormat("yyyy-MM-dd").parse(bir);
			person.setBirth(birth);
			
			Integer uid = (Integer) request.getSession().getAttribute("uid");
			person.setU_id(uid);
			
			System.out.println(person);
			Integer pid = person.getP_id();
			
			if("0".equals(pid) || "".equals(pid) || pid == null || pid == 0){
				//û��pid��˵����û�м�¼��Ϣ Ҫ�����Ϣ
				this.personService.addPerson(person);
			}else{
				//��pid˵���Ѿ�������Ϣ  ��Ҫ�޸�
				this.personService.updatePer1(person);
			}
			
			response.sendRedirect("user.do?uid=6");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	
	/**
	 * ��������ѯ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String name = request.getParameter("name");
		Integer d_id = Integer.valueOf(request.getParameter("d_id"));
		
		
		
		StringBuilder sb = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		
		if(name != null || !( "".equals(name))){
			sb.append(" and name like ? ");
			params.add("%"+name+"%");
		}
		
		if("0".equals(d_id) || d_id == 0 )  {
			
		}else{
			sb.append(" and d_id = ?");
			params.add(d_id);
		}
		
		List<Person> personlist =  this.personService.findAll(sb.toString(), params.toArray());
		
		
		request.setAttribute("personlist", personlist);
		request.getRequestDispatcher("staffList.jsp").forward(request, response);
		
		
	}
	
}
