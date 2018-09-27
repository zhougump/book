package ban;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bdqn.ban.dao.BookMapper;
import com.bdqn.ban.entity.Book;
import com.bdqn.ban.service.BookService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationConfig.xml")
public class text01 {

	@Autowired
	private BookMapper bm;
	
	@Autowired
	private BookService bs;
	
	@Test
	public void test() {
				
		/*List<Book>  lb=bm.selectAll();    //Dao层显示全部
		System.out.println(lb);*/
		/*
		List<Book> lb=bs.selectAll();		//Service层显示全部
		System.out.println(lb);*/
		
		/*Map<String,Object> map=new HashMap<>();	//Dao增加方法
		map.put("name", "美国清教文学");
		map.put("author", "约德尔·哈森稀");
		map.put("publish", "美国");	
		map.put("page", 544);
		map.put("price", 34);
		int i=bs.insert(map);
		System.out.println(i);*/
		
		
		/*int a=bm.deleteByPrimaryKey(10);	//Dao层删除
		System.out.println(a);*/
		
	/*	int b=bs.deleteByPrimaryKey(111);	//Service层删除
		System.out.println(b);
	*/
		
		/*
		List<Book> ls=bm.selectBykeyword("的");		Dao里的根据字查找
				System.out.println(ls);*/
		
		/*List<Book> lb=bs.selectBykeyword("杉");    //Service里的根据条件查找
		System.out.println(lb);  */
		
		
/*
		Map<String,Object>map=new HashMap<>();			//DAO修改全部
			map.put("id",11);
			map.put("name", "吉林");
			map.put("author", "死伟");
			map.put("publish", "华业");
			map.put("publishdate","2000-05-08" );
			map.put("page", 88);
			bm.bookUpdate(map);*/
			
			/*Book book = new Book();
			book.setAuthor("杉木岭");
			 book.setId(11);
			 book.setName("空111鹤");
			 book.setPublish("本11");
			 book.setPublishdate(new Date());
			 book.setPage(80);
			 book.setPrice(18);*/
			//bs.bookUpdate(map);
			//bm.bookUpdate(book);
			//System.out.print(i);
	
		
		
	/*Map<String,Object> map=new HashMap<>();  	
	//Dao  增加map方法测试
	//id不是自己加的，主键是自动增长的
		map.put("name", "葛城");
		map.put("author", "万宇");
		map.put("publish", "中国");	
		map.put("publishdate","1988-05-04");
		map.put("page", 60);
		map.put("price", 18);
		int i=bm.insert(map);
		System.out.println(i);*/
		
	}
}
