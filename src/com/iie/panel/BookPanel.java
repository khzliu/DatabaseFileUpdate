package com.iie.panel;

import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.iie.database.Mytable;
import com.iie.database.ReadData;

public class BookPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4694968332463565717L;
	BookPanel(){
		this.setBorder(new EmptyBorder(5,5,5,5));
		this.setLayout(new BorderLayout());
	}
	BookPanel(ReadData readdate){
		this.setBorder(new EmptyBorder(5,5,5,5));
		this.setLayout(new BorderLayout());
		
		JPanel p=new JPanel();
		int num;
		Hashtable<Integer, String> rowname;
		try {
//			ReadData readdate = new ReadData();
			rowname = readdate.readdatabase("book");
			num = readdate.getrecordnum("book");
			System.out.println("______________"+num);
			JTable t = new Mytable().settable(rowname,num);					
			p.add(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		this.add(p);
		}


}
