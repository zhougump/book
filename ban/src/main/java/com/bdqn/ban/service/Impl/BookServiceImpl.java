package com.bdqn.ban.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.bdqn.ban.dao.BookMapper;
import com.bdqn.ban.entity.Book;
import com.bdqn.ban.service.BookService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service   //声明SERVICE
//@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper bm;
	
	@Override
	public List<Book> selectAll() {

		return bm.selectAll();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		System.out.println("删除方法   service");
		return bm.deleteByPrimaryKey(id);
	}

	@Override
	public List<Book> selectBykeyword(String str) {
		List<Book> book=bm.selectBykeyword(str);
		if(!book.isEmpty() && book.size()>0)   //isEmpty是空栈
		{
			System.out.println("查询到的是"+book);
			return book;
		}
		else
		{
			System.out.println("失败。找不到");
		}
		return book;		//调用方法
	}



	@Override
	public int insert(Map map) {
		System.out.println("增加方法Service");
		int add=bm.insert(map);
		System.out.println(add);
		return add;
	}



	@Override
	public Book selectByPrimaryKey(Integer id) {
		System.out.println("通过ID查找到的数据是   Service  修改用的");
		return bm.selectByPrimaryKey(id);
	}



	@Override
	public int bookUpdate(Map map) {
		System.out.println("修改页面Service");
		int i=bm.bookUpdate(map);
		if(i==0)
		{
			System.out.println("修改方法成功Service");
		}
		return bm.bookUpdate(map);
	}

	@Override
	public List<Book> selectByList() {
		
		return this.bm.selectByList();
	}
	
	
}
