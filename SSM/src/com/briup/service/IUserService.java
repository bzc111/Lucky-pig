package com.briup.service;

import java.util.List;

import com.briup.bean.User;

public interface IUserService {
	
	public void register(User user)throws Exception;
	public User findUserByName(String name)throws Exception;
	public List<User> findAllUser()throws Exception;
}
