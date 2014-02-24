package com.iie.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Hashtable;



public class ReadData {

	public ReadData(){
		
	}
	Connection connection;
	public  ReadData(DataBase dbcon)throws Exception{
	
			String driver = "com.mysql.jdbc.Driver"; // 驱动
			String ip = dbcon.getip();  // 数据库连接
			String dbname = dbcon.getdbname();  // 数据库连接
			String user = dbcon.getuser(); // 用户名		
			String password = dbcon.getpassword();  // 数据库密码	
			String url = "jdbc:mysql://"+ip+"/"+dbname;
			Class.forName(driver); // 加载驱动		
			connection = DriverManager.getConnection(url, user, password);  // 获取链接	
		
		
	}
	
	
	public Connection getcon(){
		return connection;
	}


	public Hashtable<Integer,String> readdatabase(String str)throws Exception{
		
//		String driver = "com.mysql.jdbc.Driver"; // 驱动
//		
//		String ip = dbcon.getip();  // 数据库连接
//		String dbname = dbcon.getdbname();  // 数据库连接
//		String user = dbcon.getuser(); // 用户名		
//		String password = dbcon.getpassword();  // 数据库密码	
//		String url = "jdbc:mysql://"+ip+"/"+dbname;
//		
////		String url = "jdbc:mysql://localhost:3306/test";  jdbc:mysql://159.226.94.32:3306/wb// 数据库连接
////		String user = "root"; // 用户名		
////		String password = "12345";  // 数据库密码	
////		String url = "jdbc:mysql://192.168.110.216/wb";  // 数据库连接
////		String user = "root"; // 用户名		
////		String password = "526156";  // 数据库密码	
//		
//		Class.forName(driver); // 加载驱动		
//		Connection connection = DriverManager.getConnection(url, user, password);  // 获取链接		
		
		
		String sql= "select * from"+" "+str;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);  // 创建查询声明			
		ResultSet resultSet = preparedStatement.executeQuery();  // 获取结果		 
		ResultSetMetaData metaData = resultSet.getMetaData(); // 获取各个列的信息
		
		Hashtable<Integer,String> row = new Hashtable<Integer, String>();
		
		for (int i = 1; i <= metaData.getColumnCount(); i++) {
			System.out.println(str+"数据库第"+i+"列名字："+metaData.getColumnName(i));
			row.put(i-1,metaData.getColumnName(i));
		}
		
//		resultSet.close();
//		preparedStatement.close();
//		connection.close();
		return row;
		
	}
	
	
	
	
	public int getrecordnum(String str) throws Exception{
		
		String sql1= "select * from"+" "+str;
		PreparedStatement preparedStatement1 = connection.prepareStatement(sql1); 
		ResultSet resultSet = preparedStatement1.executeQuery();  // 获取结果		 
		resultSet.last();
		int record = resultSet.getRow()+1;
		
		
		System.out.println("数据库的记录数"+resultSet.getRow());
		int firstid= resultSet.getRow()+1;
		System.out.println("初始id:"+firstid);
		

//		resultSet.close();
//		preparedStatement1.close();
//		connection.close();
		
		return record;

	}




	
	
}

