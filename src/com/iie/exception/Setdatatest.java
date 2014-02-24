package com.iie.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Setdatatest {

	
	public static void main(String[]args) throws Exception{
		
		String driver = "com.mysql.jdbc.Driver"; // 驱动
		String url = "jdbc:mysql://localhost:3306/test";  // 数据库连接
		String user = "root"; // 用户名		
		String password = "12345";  // 数据库密码		 
		Class.forName(driver); // 加载驱动		
		Connection connection = DriverManager.getConnection(url, user, password);  // 获取链接		
		String sql= "insert into movie values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);  // 创建查询声明		
		
		
			preparedStatement.setString(1,"1234");
			preparedStatement.setString(2,"2234");
			preparedStatement.setString(3,"3234");
			preparedStatement.setString(4,"4234");
			preparedStatement.setString(5,"5234");
			preparedStatement.setString(6,"6234");
			preparedStatement.setFloat(7,(float) 1.11);
			preparedStatement.setInt(8,222);
			preparedStatement.setInt(9,124);
		
			

		preparedStatement.executeUpdate();
			
		
		preparedStatement.close();
		connection.close();

		
	}
		
			
	
	

}
