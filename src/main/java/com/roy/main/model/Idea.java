package com.roy.main.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Idea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String shortdescription;
	private String fulldescription;
	private int love;
	private String username;
	
	
	
	
	
	@Override
	public String toString() {
		return "Idea [id=" + id + ", title=" + title + ", shortdescription=" + shortdescription + ", fulldescription="
				+ fulldescription + ", like=" + love + ", username=" + username + "]";
	}
	public Idea() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Idea(int id, String title, String shortdescription, String fulldescription, int like, String username) {
		super();
		this.id = id;
		this.title = title;
		this.shortdescription = shortdescription;
		this.fulldescription = fulldescription;
		this.love = like;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortdescription() {
		return shortdescription;
	}
	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}
	public String getFulldescription() {
		return fulldescription;
	}
	public void setFulldescription(String fulldescription) {
		this.fulldescription = fulldescription;
	}
	public int getLike() {
		return love;
	}
	public void setLike(int like) {
		this.love = like;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	
	
	
}
