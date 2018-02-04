package com.Demo.WenDemo.service;

import com.Demo.WenDemo.domain.User;
import com.Demo.WenDemo.exception.LoginException;

public interface UserService {
	// 注册
	public void regist(User user);

	// 激活
	public void activeUser(String activecode);

	// 登录操作
	public User login(String username, String password) throws LoginException;
}
