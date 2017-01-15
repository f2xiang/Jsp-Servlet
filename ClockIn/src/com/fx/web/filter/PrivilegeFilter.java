package com.fx.web.filter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fx.beans.User;

public class PrivilegeFilter implements Filter{

	private List<String> admin_list = new ArrayList<String>();
	private List<String> user_list = new ArrayList<String>();
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		
		if(admin_list.contains(uri) || user_list.contains(uri)){
			//˵����ǰ��Դ��ҪȨ��
			if(req.getSession(false)==null || req.getSession().getAttribute("user")== null){
				response.getWriter().write("��ǰ��Դ��ҪȨ��,���ȵ�¼!");
				return;
			}
			User user = (User) req.getSession().getAttribute("user");
			
			if(admin_list.contains(uri) && ("1".equals(user.getLevel()) || user.getLevel() == 1)){
				chain.doFilter(request, response);
			}else if(user_list.contains(uri) && ("2".equals(user.getLevel()) || user.getLevel() == 2)){
				chain.doFilter(request, response);
			}else{
				throw new RuntimeException("�������ж�Ӧ��Ȩ��!!!");
			}
		}else{
			//����ҪȨ��
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext context = filterConfig.getServletContext();
		try {
			BufferedReader adminReader = new BufferedReader(new FileReader(context.getRealPath("WEB-INF/admin.txt")));
			String line = null;
			while((line=adminReader.readLine())!=null){
				admin_list.add(line);
			}
			
			BufferedReader userReader = new BufferedReader(new FileReader(context.getRealPath("WEB-INF/emp.txt")));
			line = null;
			while((line=userReader.readLine())!=null){
				user_list.add(line);
			}
			System.out.println(admin_list+"==="+user_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
