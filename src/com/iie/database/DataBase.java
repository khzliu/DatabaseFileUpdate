package com.iie.database;

public class DataBase {
	String ip;
	String dbname;
	String user;
	String password;
	
	
	public DataBase(String ip,String dbname,String user,String password){
		this.ip = ip;
		this.dbname = dbname;
		this.user = user;
		this.password = password;
		
	}
	
	public String getip(){
		return ip;
	}
	public void setip(String ip){
		this.ip = ip;
	}
	public String getdbname(){
		return dbname;
	}
	public void setdbname(String dbname){
		this.dbname = dbname;
	}
	
	public String getuser(){
		return user;
	}
	public void setuser(String user){
		this.user = user;
	}
	
	public String getpassword(){
		return password;
	}
	public void setpassword(String password){
		this.password = password;
	}
	
	
	

}
