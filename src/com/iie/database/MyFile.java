package com.iie.database;

public class MyFile {
	String[] name;
	String[] path;
	
	public MyFile(){}
	
	
	public MyFile(String[] name,String[] path){
		this.path = path;
		this.name = name;
		
	}
	
	
	public String[] getpath(){
		return path;
	}
	public void setpath(String[] path){
		this.path = path;
	}
	
	public String[] getname(){
		return name;
	}
	public void setname(String[] name){
		this.name = name;
	}

}
