package com.iie.exception;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ImageTest {
	
	JFrame allframe= new JFrame("图片操作");
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	
	 
	 
	public ImageTest(){
		allframe.setBounds(100, 30, 1250, 650);
		allframe.add(p1, BorderLayout.CENTER);	//设置p1置中部
		allframe.add(p2, BorderLayout.SOUTH);	//设置p1置中部
		allframe.setVisible(true);
		allframe.setResizable(true);
		
		
		JLabel label;
		
		ImageIcon icon = new ImageIcon("D:\\Workspaces\\MyEclipse 10\\Database\\0movie\\1.jpg");
		 Image img = icon.getImage();
	     img = img.getScaledInstance(80, 45, Image.SCALE_DEFAULT); 
	     ImageIcon newicon = new ImageIcon(img);
		 label = new JLabel(newicon);

		 label.repaint();
		 JTable table = new JTable(2, 3);
		 JTable table2 = new Tabletext().getTabletext();

		p1.add(table);
//		p1.add(table2);
		
		
		 JScrollPane scrollPane = new JScrollPane(table2,
				    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		 
		 scrollPane.setPreferredSize(new Dimension(200, 100));
				  
		 p1.add(scrollPane);
		
		allframe.add(p1);
	}
	

	

	
	
	public static void main(String[] args) {
		 new ImageTest();
		}
}
