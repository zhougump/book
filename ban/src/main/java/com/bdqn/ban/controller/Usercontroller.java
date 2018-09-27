package com.bdqn.ban.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bdqn.ban.entity.Book;
import com.bdqn.ban.entity.User;
import com.bdqn.ban.service.BookService;
import com.bdqn.ban.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller  //封装包
@RequestMapping("user")
public class Usercontroller {
	
	@Autowired
	private UserService us;
	@Autowired
	private BookService bs;
	
	@RequestMapping("login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("getlogin")
	public String getlogin(@RequestParam(required=true,defaultValue="1")Integer page,String username,String password ,Model model)
	{
		System.out.println("first");
		User user=us.login(username, password);
		if(user!=null)
		{
			System.out.println(username+password);
			return "forward:welcomePage";    //forward跳转（服务器端跳转）
		}
		else
		{
			System.out.println("GG");
			return  "error";
		}
	}	
	@RequestMapping("welcomePage")
	public String booklist(@RequestParam(required=true,defaultValue="1")Integer page,HttpServletRequest request,Model model)
	{
		PageHelper.startPage(page, 5);
		List<Book> bookList=bs.selectByList();
		PageInfo<Book> p=new PageInfo<Book>(bookList);
		model.addAttribute("page", p);
		model.addAttribute("bookList", bookList);
		return "welcome";
	}
	@RequestMapping("/bookDelete")
	public void bookdelete(Integer id,HttpServletResponse response)
	{
		System.out.println("删除界面CONTROLLER");
		int a=bs.deleteByPrimaryKey(id);
		System.out.println(a);
		try {
			if(a!=0)
			{
				System.out.println("删除成功");
				response.getWriter().write("success");
			}
			else
			{
				System.out.println("失败");
				response.getWriter().write("failed");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("welcome")
	public String welcome(HttpServletRequest request,HttpServletResponse response)
	{
		return "welcome";
	}
	
	@InitBinder   // 时间格式化
	protected void initBinder(WebDataBinder binder) {
	binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
	}

	@RequestMapping(value="bookinput")		//从页面中获取value值
	public String bookadd(Book book,HttpServletRequest request)
	{
		System.out.println("增加页面UserController");
		System.out.println(book);
		
		Map<String, Object> map=new HashMap<>();
		map.put("name", book.getName());
		map.put("author", book.getAuthor());
		map.put("publish", book.getPublish());
		map.put("publishdate", book.getPublishdate());
		map.put("page", book.getPage());
		map.put("price", book.getPrice());
		
		int a=bs.insert(map);
		if(book!=null)
		{
			return "redirect:welcomePage";
		}
		else
		{
			return "error";
		}
	}
	@RequestMapping("welcomePagg")
	public String wp(HttpServletRequest request,HttpServletResponse response)
	{
		return "welcome";
	}
	@RequestMapping(value="bookUpdate")         //点击按钮获得信息
	public String bookUpdate(Integer id,Model m,HttpServletRequest request)
	{
		System.out.println("进入修改页面02");
		request.setAttribute("id", id);     //在jsp里获取数据
		System.out.println(id);
		Book bookUpdate=bs.selectByPrimaryKey(id);
		System.out.println(id);
		m.addAttribute("bookUpdate", bookUpdate);   //通过model获取对象
		return "bookUpdate";
	}
	
	@RequestMapping("bookupd")
	public String bookUpdate(Integer id,Book bookUpdate,HttpServletRequest request)
	{
		Map<String,Object>map=new HashMap<>();
		map.put("id", bookUpdate.getId());
		map.put("name", bookUpdate.getName());
		map.put("author", bookUpdate.getAuthor());
		map.put("publish", bookUpdate.getPublish());
		map.put("publishdate", bookUpdate.getPublishdate());
		map.put("page", bookUpdate.getPage());
		map.put("price", bookUpdate.getPrice());
		
		int i=bs.bookUpdate(map);
		System.out.println(i);
		
		return "redirect:welcomePage";
		
	}
	

	@RequestMapping(value="zc")
	public String zcadd(User user,HttpServletRequest request)
	{
		if(user!= null){
			System.out.println("用户注册");
			Map<String,Object> map=new HashMap<>();
			map.put("username", user.getUsername());
			map.put("password", user.getPassword());
			us.insert(map);
			System.out.println("ok");	
			return "zccg";
		}
		else
		{
			return "error";
		}
	}
}
