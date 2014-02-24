package com.iie.database;

public class Movie {

	String id;
	String duration;
	String name;
	String director;
	String actor;
	String discription;
	String WHR;
	String clicks;
	String priority;
	
	public Movie(){}
	
	
	
	
	public Movie(String id,String duration,String name,String director,String actor,String discription,String WHR,String clicks,String priority){
		this.id = id;
		this.duration = duration;
		this.name = name;
		this.director = director;
		this.actor = actor;
		this.discription = discription;
		this.WHR = WHR;
		this.clicks = clicks;
		this.priority = priority;
	}
	
	
	
	public String getid(){
		return id;
	}
	public void setid(String id){
		this.id = id;
	}
	
	
	public String getduration(){
		return duration;
	}
	public void setduration(String duration){
		this.duration = duration;
	}
	
	public String getname(){
		return name;
	}
	public void setname(String name){
		this.name = name;
	}
	
	public String getdirector(){
		return director;
	}
	public void setdirector(String director){
		this.director = director;
	}
	
	
	public String getactor(){
		return actor;
	}
	public void setactor(String actor){
		this.actor = actor;
	}
	
	
	
	public String getdiscription(){
		return discription;
	}
	public void setdiscription(String discription){
		this.discription = discription;
	}
	
	
	
	public String getWHR(){
		return WHR;
	}
	public void setWHR(String WHR){
		this.WHR = WHR;
	}
	
	
	public String getclicks(){
		return clicks;
	}
	public void setclicks(String clicks){
		this.clicks = clicks;
	}
	
	public String getpriority(){
		return priority;
	}
	public void setpriority(String priority){
		this.priority = priority;
	}
	
	
} 
