package com.briup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.User;
import com.briup.dao.IUserDao;

@Service("userService")
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	
	@Override
	public void register(User user) throws Exception {
		if(userDao.findUserByName(user.getName())==null){
			userDao.saveUser(user);
		}
//		throw new Exception("我的事务测试....");
	}

	@Override
	public User findUserByName(String name) throws Exception {
		return userDao.findUserByName(name);
	}

	@Override
	public List<User> findAllUser() throws Exception {
		return userDao.findAllUsers();
	}
	

}
