package com.briup.dao;

import java.util.List;

import com.briup.bean.User;

public interface IUserDao {
	public void saveUser(User user);
	public User findUserByName(String name);
	public List<User> findAllUsers();
}
