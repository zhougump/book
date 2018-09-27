package com.bdqn.ban.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.bdqn.ban.entity.Book;

public interface BookMapper {

	public List<Book>  selectAll();
	
	int  deleteByPrimaryKey(Integer id);   //删除
	
	public List<Book> selectBykeyword(String str);  //条件查找
	
	Book selectByPrimaryKey (Integer id);    //修改里用到的查找
	
	int insert(Map map);  	//增加全部
	//int bookUpdate(Book book); 
	
	int bookUpdate (Map map);		//修改全部
	
	int updateByPrimaryKey(Book record);

	public List<Book> selectByList();	//分页list显示
	
	
}
