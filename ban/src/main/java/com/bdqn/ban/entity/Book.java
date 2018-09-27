package com.bdqn.ban.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Book {
    private Integer id;

    private String name;

    private String author;

    private String publish;

    private Date publishdate;

    private Integer page;

    private Integer price;

  
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public Date getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	
	

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publish=" + publish + ", publishdate="
				+ publishdate + ", page=" + page + ", price=" + price + ", file=" + "]";
	}

	
    
    
}