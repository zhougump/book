package com.bdqn.ban.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bdqn.ban.entity.Book;
import com.bdqn.ban.entity.Picture;
import com.bdqn.ban.service.PictureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import util.PopUtil;


@Controller
@RequestMapping("file")
public class filecontroller  {
			
	@Autowired
	private PictureService ps;
	
	@RequestMapping("/fileupload.do")

 	 /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    public String  fileUpload(@RequestParam("file") CommonsMultipartFile file ) throws IOException {         
       
	 //用来检测程序运行时间
        long  startTime=System.currentTimeMillis();
        String filename = file.getOriginalFilename();
        System.out.println("fileName："+file.getOriginalFilename());
        Map<String,String> map = new HashMap<>();
         
        try {
            //获取输出流
            OutputStream os=new FileOutputStream(PopUtil.getPop("path")+"/image/"+filename);
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
           os.flush();
           os.close();
           is.close();
         
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        map.put("pic", "/image/"+filename);
        long  endTime=System.currentTimeMillis();
        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
        
        int p=ps.insert(map);
		if(p!=0)
		{
			return "sc";
		}
		return "error";
    }
		 
	@RequestMapping("delete")
	public void bookdelete(Integer id,HttpServletResponse response)
	{
		int a=ps.deleteByPrimaryKey(id);
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
			e.printStackTrace();
		}
	}
		 
	 @RequestMapping("upload.do")
		public String booklist(@RequestParam(required=true,defaultValue="1")Integer page,HttpServletRequest request,Model model)
		{
			PageHelper.startPage(page, 4);
			List<Picture> pictureList=ps.selectByList();
			PageInfo<Picture> p=new PageInfo<Picture>(pictureList);
			model.addAttribute("page", p);
			model.addAttribute("pictureList", pictureList);
			return "upload";
		}
	 
	 
	 @RequestMapping("/down")
	 public void down(Integer id,Model m,HttpServletRequest  request,HttpServletResponse  response)throws Exception
	 {
		  Picture a=ps.selectByPrimaryKey(id);
		  m.addAttribute("a", a.getPic());
		 
		 String fileName = PopUtil.getPop("path")+a.getPic();
		 //InputSource是输入源
		  InputStream bis = new BufferedInputStream(new FileInputStream

(new File(fileName))); 
		 String[] split = fileName.split("/");
		 String filename = split[3];  
		 //转码，中文乱码
		 filename=URLEncoder.encode(filename,"UTF-8");
		 //filename = new String(filename .getBytes(), "ISO-8859-1");
		 //设置文件下载头
		 response.addHeader("Content-Disposition", "attachment;filename="+ filename);
		//1.设置文件ContentType类型，自动判断下载文件类型    
	        response.setContentType("multipart/form-data");   
	        BufferedOutputStream out = new BufferedOutputStream

(response.getOutputStream());  
	        int len = 0;  
	        while((len = bis.read()) != -1){  
	            out.write(len);  
	            out.flush();  
	        }  
	        out.close();
	    } 
	 
	 /*public static void main(String[] args) {
		    String agent=request.getHeader("User-Agent").toLowerCase();
		    System.out.println(agent);
		    System.out.println("浏览器版本："+getBrowserName(agent));
		}
		public String getBrowserName(String agent) {
		    if(agent.indexOf("msie 7")>0){
		        return "ie7";
		    } else if(agent.indexOf("msie 8")>0){
		        return "ie8";
		    } else if(agent.indexOf("msie 9")>0){
		        return "ie9";
		    } else if(agent.indexOf("msie 10")>0){
		        return "ie10";
		    } else if(agent.indexOf("msie")>0){
		        return "ie";
		    } else if(agent.indexOf("opera")>0){
		        return "opera";
		    } else if(agent.indexOf("opera")>0){
		        return "opera";
		    } else if(agent.indexOf("firefox")>0){
		        return "firefox";
		    } else if(agent.indexOf("webkit")>0){
		        return "webkit";
		    } else if(agent.indexOf("gecko")>0 && agent.indexOf("rv:11")>0){
		        return "ie11";
		    } else{
		        return "Others";
		    }
		}*/
	
}
