package com.iie.panel;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.iie.database.Movie;
import com.iie.database.Mytable;
import com.iie.database.ReadData;

public class MoviePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6192856658403429720L;
	public JTable t;
	
	MoviePanel(){
		this.setBorder(new EmptyBorder(5,5,5,5));
		this.setLayout(new BorderLayout());
		
	}	
	
	
	MoviePanel(ReadData readdate){
		this.setBorder(new EmptyBorder(5,5,5,5));
		this.setLayout(new BorderLayout());
		
		JPanel p=new JPanel();
		
		Hashtable<Integer, String> rowname;
		int num;
		try {
//			ReadData readdate = new  ReadData(dbcon);
			rowname = readdate.readdatabase("movie");
			num = readdate.getrecordnum("movie");
			t = new Mytable().settable(rowname,num);	
			p.add(t);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	this.add(p);
	}

	


	public  List<Movie> getmovie(){
		
		
		try {
			
			List<Movie> movies=new ArrayList<Movie>();
			
			for(int i=1;i<2;i++){
				Movie movie=new Movie();				
					movie.setid(t.getValueAt(i, 0).toString());// 取得第i行第一列的数据
					movie.setduration((String)t.getValueAt(i, 1));// 取得第i行第一列的数据
					movie.setname((String)t.getValueAt(i, 2));// 取得第i行第一列的数据
					movie.setdirector((String)t.getValueAt(i, 3));// 取得第i行第一列的数据
					movie.setactor((String)t.getValueAt(i, 4));// 取得第i行第一列的数据
					movie.setdiscription((String)t.getValueAt(i, 5));// 取得第i行第一列的数据
					movie.setWHR((String)t.getValueAt(i, 6));// 取得第i行第一列的数据
					movie.setclicks((String)t.getValueAt(i, 7));// 取得第i行第一列的数据
					movie.setpriority((String)t.getValueAt(i, 8));// 取得第i行第一列的数据		
					movies.add(movie);
			}
			return movies;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		}
		
		
		}
		


	
	
}
