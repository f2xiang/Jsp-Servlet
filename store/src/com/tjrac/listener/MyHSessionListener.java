package com.tjrac.listener;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.tjrac.domain.Product;

public class MyHSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute("carmap", new LinkedHashMap<Product, Integer>());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {

	}

}
