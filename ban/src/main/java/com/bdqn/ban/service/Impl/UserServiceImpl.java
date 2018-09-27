package com.bdqn.ban.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.ban.dao.UserMapper;
import com.bdqn.ban.entity.User;
import com.bdqn.ban.service.UserService;

@Service  //封装Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper ud;
	
	@Override
	public User login(String username, String password) {
		
		return ud.login(username, password);
	}

	@Override
	public int insert(Map map) {
		int cz=ud.insert(map);
		return cz;
	}
}
