package com.bdqn.ban.service;

import java.util.List;
import java.util.Map;


import com.bdqn.ban.entity.Book;
import com.bdqn.ban.entity.Picture;


public interface PictureService {

	int insert (Map map);

	Picture selectByPrimaryKey(Integer id);
	
	public List<Picture> selectByList();
	
	int deleteByPrimaryKey(Integer id);
	
}
