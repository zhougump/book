package com.bdqn.ban.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.ban.dao.PictureMapper;
import com.bdqn.ban.entity.Book;
import com.bdqn.ban.entity.Picture;
import com.bdqn.ban.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureMapper pm;
	
	@Override
	public int insert(Map map) {
		System.out.println("增加图片");
		int p=pm.insert(map);
		return p;
	}
	
	@Override
	public Picture selectByPrimaryKey(Integer id) {
		
		return pm.selectByPrimaryKey(id);
	}

	@Override
	public List<Picture> selectByList() {
		
		return pm.selectByList();
	}


	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return pm.deleteByPrimaryKey(id);
	}
	
}
