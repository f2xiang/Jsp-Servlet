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
		//У���û����Ƿ��Ѿ�����
		if(dao.findUserByName(user.getUsername()) != null){
			throw new RuntimeException("�û����Ѿ�����");
		}
		
		//dao����û� -- ��Ϊǰ̨��װ������ û�����¼���ֵ ��������service�н��м������
		//����dao���б��浽���ݿ�
		user.setRole("user");
		user.setState(0);
		user.setActivecode(UUID.randomUUID().toString());
		dao.addUser(user);
		
		
		//���ͼ����ʼ�
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
			msg.setSubject(user.getUsername()+",����estore�ļ����ʼ�");
			msg.setText("����������Ӽ����˻������߸��Ƶ������  http://localhost:8080/Activecode?activecode="+user.getActivecode());
			//�����ʼ� TODO
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
