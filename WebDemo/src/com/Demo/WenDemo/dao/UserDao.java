package com.Demo.WenDemo.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.Demo.WenDemo.domain.User;
import com.Demo.WenDemo.utils.DataSourceUtils;

public class UserDao {
	public void addUser(User user) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into users values(null,?,?,?,'0',?,null)";
		try {
			runner.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getActivecode());
			System.out.println("添加用户成功");
		} catch (SQLException e) {
			System.out.println("DAO层addUser错误");
			e.printStackTrace();
		}
	}
	public User findUserByActiveCode(String activecode) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "select name from users where activecode = ?";
		
		return runner.query(sql, new BeanHandler<User>(User.class), activecode);
	}
	public void activeUserByActivecode(String activecode) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "update users set state = 1 where activecode = ?";
			runner.update(sql,activecode);
	}
	public User findUserByUserNameAndPassword(String username, String password) throws SQLException {
		// 1.创建QueryRunner
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from users where username=? and password=?";
		
		return runner.query(sql, new BeanHandler<User>(User.class),username,password);
	}
}
