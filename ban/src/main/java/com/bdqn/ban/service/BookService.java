package com.bdqn.ban.service;

import java.util.List;
import java.util.Map;

import com.bdqn.ban.entity.Book;
import com.github.pagehelper.PageInfo;

public interface BookService {

	public List<Book> selectAll();
	
	int insert (Map  map);     //增加方法
	
	int deleteByPrimaryKey(Integer id);    //删除
	
	public List<Book> selectBykeyword(String str);		//条件查询
	
	Book selectByPrimaryKey(Integer id);      //修改里用的查找

	int bookUpdate(Map map);		//修改全部

	public List<Book> selectByList();	//分页显示全部
	
}
