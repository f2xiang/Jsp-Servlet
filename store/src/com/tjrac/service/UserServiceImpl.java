package com.tjrac.service;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.tjrac.dao.UserDao;
import com.tjrac.domain.User;
import com.tjrac.factory.BasicFactory;

public class UserServiceImpl implements UserService{

	private UserDao dao = BasicFactory.getFactory().getInstance(UserDao.class);
	
	@Override
	public void regist(User user) {
		//校验用户名是否已经存在
		if(dao.findUserByName(user.getUsername()) != null){
			throw new RuntimeException("用户名已经存在");
		}
		
		//dao添加用户 -- 因为前台封装的数据 没有以下几个值 所以我在service中进行继续添加
		//好让dao进行保存到数据库
		user.setRole("user");
		user.setState(0);
		user.setActivecode(UUID.randomUUID().toString());
		dao.addUser(user);
		
		
		//发送激活邮件
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.host", "localhost");
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.debug", "true");
		Session session = Session.getInstance(prop);
		
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("aa@local.com"));
			msg.setRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));
			msg.setSubject(user.getUsername()+",来自estore的激活邮件");
			msg.setText("点击如下链接激活账户：或者复制到浏览器  http://localhost:8080/Activecode?activecode="+user.getActivecode());
			//激活邮件 TODO
			Transport ts = session.getTransport();
			ts.connect("aa", "123");
			ts.send(msg, msg.getAllRecipients());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} 
	}

	@Override
	public User findUserByUP(String name, String pwd) {
		return dao.findUserByUP(name, pwd);
	}

}
