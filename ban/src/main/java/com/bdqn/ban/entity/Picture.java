package com.bdqn.ban.entity;

public class Picture {

	private int id;
	
	private String pic;

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "picture [id=" + id + ", pic=" + pic + "]";
	}

	
	
	
}
