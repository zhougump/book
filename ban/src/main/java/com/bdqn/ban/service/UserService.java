package com.bdqn.ban.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bdqn.ban.entity.User;

public interface UserService {

	public User login(@Param("username")String username,@Param("password")String  password);

	int insert(Map map);
		
}
