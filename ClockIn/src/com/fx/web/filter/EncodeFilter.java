package com.fx.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodeFilter implements Filter{
	private FilterConfig config = null;
	private ServletContext context = null;
	private String encode = null;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//响应的乱码
		response.setCharacterEncoding(encode);
		response.setContentType("text/html;charset="+encode);
		
		//请求的乱码
		//利用装饰设计模式改变request对象和请求参数相关的方法 从而解决请求参数的乱码的问题
		
		chain.doFilter(new MyHttpServletRequesr((HttpServletRequest)request), response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		this.context = filterConfig.getServletContext();
		this.encode = context.getInitParameter("encode");
	}

	private class MyHttpServletRequesr extends HttpServletRequestWrapper{
		private HttpServletRequest request = null;
		private boolean isNotEncode = true;
		
		public MyHttpServletRequesr(HttpServletRequest request) {
			super(request);
			this.request = request;
		}
		@Override
		public String getParameter(String name) {
			return getParameterValues(name)== null? null : getParameterValues(name)[0];
		}
		
		@Override
		public Map<String, String[]> getParameterMap() {
			try {
				if(request.getMethod().equalsIgnoreCase("POST")){
					request.setCharacterEncoding(encode);
					return request.getParameterMap();
				}else if(request.getMethod().equalsIgnoreCase("GET")){
					Map<String, String[]> map = request.getParameterMap();
					if(isNotEncode){
						for(Map.Entry<String, String[]> entry : map.entrySet()){
							String [] vs = entry.getValue();
							for (int i = 0; i < vs.length; i++) {
								vs[i] = new String(vs[i].getBytes("ISO-8859-1"),encode);
							}
						}
						isNotEncode = false;
					}
					return map;
				}else{
					return super.getParameterMap();
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		
		@Override
		public String[] getParameterValues(String name) {
			return getParameterMap().get(name);
		}
		
	}
}
