package com.Demo.WenDemo.service;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.Demo.WenDemo.dao.UserDao;
import com.Demo.WenDemo.domain.User;
import com.Demo.WenDemo.exception.ActiveUserException;
import com.Demo.WenDemo.exception.LoginException;
import com.Demo.WenDemo.utils.MailUtils;

public class UserServiceImpl implements UserService {

	@Override
	public void regist(User user) {
		try {
			new UserDao().addUser(user);
			String emailMsg = "注册成功，请在12小时内<a href='http://127.0.0.1:8080/WebDemo/user?method=activeuser&activecode="
					+ user.getActivecode() + "'>激活</a>，激活码是" + user.getActivecode();
			MailUtils.sendMail(user.getEmail(), emailMsg);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void activeUser(String activecode) {
		UserDao dao = new UserDao();
		// 进行激活操作
		try {
			dao.activeUserByActivecode(activecode);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				throw new ActiveUserException("激活失败");
			} catch (ActiveUserException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public User login(String username, String password) throws LoginException {
		UserDao dao = new UserDao();
		User user = null;
		try {
			user = dao.findUserByUserNameAndPassword(username, password);
			if(user == null) {
				System.out.println("账号或密码不正确");
				throw new LoginException("账号或密码不正确");
			}
			if(user.getState() == 0) {
				throw new LoginException("用户未激活");
			}
		} catch (SQLException e) {
			throw new LoginException("登录失败");
		}
		return user;
	}

}
