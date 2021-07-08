package com.santiago.courses.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Course")
public class Course {

	private long id;
	private String name;
	private String taughtBy;
	private int rating;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaughtBy() {
		return taughtBy;
	}
	public void setTaughtBy(String taughtBy) {
		this.taughtBy = taughtBy;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		if(rating<=5 & rating>0){
		this.rating = rating;
		}else {
			System.out.println("Rating number not valid (0-5)");
		}
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", taughtBy=" + taughtBy + ", rating=" + rating + "]";
	}
	
	
	
	
	
	
}
