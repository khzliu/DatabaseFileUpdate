package com.iie.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class SetData {
	
	
	public  void insertmoviedatabase(String str,Movie movie,Connection connection)throws Exception{
		
		
//		String driver = "com.mysql.jdbc.Driver"; // 驱动
//		String url = "jdbc:mysql://localhost:3306/test";  // 数据库连接
//		String user = "root"; // 用户名		
//		String password = "12345";  // 数据库密码		 
//		Class.forName(driver); // 加载驱动		
//		Connection connection = DriverManager.getConnection(url, user, password);  // 获取链接		
		
		
		String sql1= "select * from"+" "+str;
		PreparedStatement preparedStatement1 = connection.prepareStatement(sql1); 
		ResultSet resultSet = preparedStatement1.executeQuery();  // 获取结果		 
		resultSet.last();
		int record = resultSet.getRow()+1;
		
		
		String sql= "insert into "+" "+str+" values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);  // 创建查询声明		
		
		System.out.println("数据库的记录数"+resultSet.getRow());
		int firstid= resultSet.getRow()+1;
		System.out.println("初始id:"+firstid);
//		System.out.println(movies.size());
//		for(int i=0;i<movies.size();i++){
//			Movie movie=movies.get(i);
			String recordid = record+"";
			preparedStatement.setString(1,recordid);
			preparedStatement.setString(2,movie.getduration());
			preparedStatement.setString(3,movie.getname());
			preparedStatement.setString(4,movie.getdirector());
			preparedStatement.setString(5,movie.getactor());
			preparedStatement.setString(6,movie.getdiscription());
			preparedStatement.setFloat(7,Float.parseFloat(movie.getWHR()));
			preparedStatement.setInt(8,Integer.parseInt(movie.getclicks()));
			preparedStatement.setInt(9,Integer.parseInt(movie.getpriority()));
			record++;
//		}f
		preparedStatement.executeUpdate();
		
//		ResultSet resultSet = preparedStatement.executeQuery();  // 获取结果		 
//		ResultSetMetaData metaData = resultSet.getMetaData(); // 获取各个列的信息
		
		
		
//		new Mytable(row);
		
		
		
		resultSet.close();
		preparedStatement.close();
//		connection.close();
//		System.out.println("一条数据");


	}
	
	
public  void insertbookdatabase(String str,Book book,Connection connection)throws Exception{
		

		String sql1= "select * from"+" "+str;
		PreparedStatement preparedStatement1 = connection.prepareStatement(sql1); 
		ResultSet resultSet = preparedStatement1.executeQuery();  // 获取结果		 
		resultSet.last();
		int record = resultSet.getRow()+10;
		
		
		String sql= "insert into "+" "+str+" values(?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);  // 创建查询声明		
		
		System.out.println("数据库的记录数"+resultSet.getRow());
		int firstid= resultSet.getRow()+1;
		System.out.println("初始id:"+firstid);

			String recordid = record+"";
			preparedStatement.setString(1,recordid);
			preparedStatement.setString(2,book.getname());
			
			record++;

		preparedStatement.executeUpdate();

		
		resultSet.close();
		preparedStatement.close();
//		connection.close();


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public  void insertdatabase(String str,List<Movie> movies)throws Exception{
//		String driver = "com.mysql.jdbc.Driver"; // 驱动
//		String url = "jdbc:mysql://localhost:3306/test";  // 数据库连接
//		String user = "root"; // 用户名		
//		String password = "12345";  // 数据库密码		 
//		Class.forName(driver); // 加载驱动		
//		Connection connection = DriverManager.getConnection(url, user, password);  // 获取链接		
//		
//		
//		String sql1= "select * from"+" "+str;
//		PreparedStatement preparedStatement1 = connection.prepareStatement(sql1); 
//		ResultSet resultSet = preparedStatement1.executeQuery();  // 获取结果		 
//		resultSet.last();
//		int record = resultSet.getRow()+1;
//		
//		
//		String sql= "insert into "+" "+str+" values(?,?,?,?,?,?,?,?,?)";
//		PreparedStatement preparedStatement = connection.prepareStatement(sql);  // 创建查询声明		
//		
//		System.out.println("数据库的记录数"+resultSet.getRow());
//		int firstid= resultSet.getRow()+1;
//		System.out.println("初始id:"+firstid);
//		System.out.println(movies.size());
//		for(int i=0;i<movies.size();i++){
//			Movie movie=movies.get(i);
//			String recordid = record+"";
//			preparedStatement.setString(1,recordid);
//			preparedStatement.setString(2,movie.getduration());
//			preparedStatement.setString(3,movie.getname());
//			preparedStatement.setString(4,movie.getdirector());
//			preparedStatement.setString(5,movie.getactor());
//			preparedStatement.setString(6,movie.getdiscription());
//			preparedStatement.setFloat(7,Float.parseFloat(movie.getWHR()));
//			preparedStatement.setInt(8,Integer.parseInt(movie.getclicks()));
//			preparedStatement.setInt(9,Integer.parseInt(movie.getpriority()));
//			record++;
//		}
//		preparedStatement.executeUpdate();
//		
////		ResultSet resultSet = preparedStatement.executeQuery();  // 获取结果		 
////		ResultSetMetaData metaData = resultSet.getMetaData(); // 获取各个列的信息
//		
//		
//		
////		new Mytable(row);
//		
//		
//		
//		resultSet.close();
//		preparedStatement.close();
//		connection.close();
//
////		return record;
//	}
	

}
