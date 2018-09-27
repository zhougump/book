package com.bdqn.ban.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bdqn.ban.entity.User;


public interface UserMapper {

	public User login(@Param("username")String  username,@Param("password")String password);
 
	int insert(Map map);
	
}
