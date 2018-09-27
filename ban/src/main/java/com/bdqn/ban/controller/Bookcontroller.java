package com.bdqn.ban.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bdqn.ban.entity.Book;
import com.bdqn.ban.service.BookService;

@Controller
@RequestMapping("/book")
public class Bookcontroller {

	@Autowired
	private BookService bs;

	@RequestMapping("/MHchaxun")
	public String chazhao(String chazhao,Model m, HttpServletRequest  request)
	{
		System.out.println("查找页面controller");
		List<Book> book=bs.selectBykeyword(chazhao);//chazhao对应大括号里的
		if(!book.isEmpty() && book.size()>0)
		{
			m.addAttribute("book", book);
			System.out.println("controller里得到数据"+book);
			return "chazhao";
		}
		else
		{
			request.setAttribute("cha", "不到数据");
			return "chazhao";
		}
	}
	
	@RequestMapping(value="/add")
	public String add()
	{
		System.out.println("增加界面Controller");
		return "bookinput";
	}
	
	@RequestMapping(value="/zcyh")
	public String zcyh()
	{
		System.out.println("注册");
		return "zc";
	}
	
	@RequestMapping(value="/p")
	public String p()
	{
		System.out.println(22222);
		return "fileupload.do";
	}

}
