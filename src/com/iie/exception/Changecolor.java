package com.iie.exception;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Changecolor {
	JFrame allframe= new JFrame("表格变色处理");
	Panel p1 = new Panel();
	Button scaniconb = new Button("    点  击  开  始  变  色    ");	//确定
	
	ColorTable ctable = new ColorTable();
	JTable table = ctable.setmovieandtable();
	
	
	
	public Changecolor(){
	
		
		
		allframe.setBounds(100, 30, 1250, 650);
		allframe.setVisible(true);
		allframe.setResizable(true);
		p1.add(scaniconb);
		
		JScrollPane scrollPane = new JScrollPane(table,
			    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		int rownum = 3;
		int rowlen = rownum*51+1;
	 
	 scrollPane.setPreferredSize(new Dimension(4*90+3, rowlen));
		p1.add(table);
		allframe.add(p1);
		
		listeners();// 调用监听方法
		
		
		
		
	}
	public Button getscaniconb() {
		return scaniconb;
	}
	
	
	void listeners(){
		this.getscaniconb().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Wugui wugui = new Wugui();
				wugui.begin();
			}
		});
	}
	
	
	
	

	
	
	public class Wugui {
	    private Thread thread;

	    public void begin() {
	        thread = new Thread(new Runnable() {
	            public void run() {
					
					table.setRowSelectionInterval(0, 0);
					table.setSelectionBackground(Color.pink);
					table.repaint();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					


					table.setRowSelectionInterval(1, 1);
					table.setSelectionBackground(Color.green);
					table.repaint();
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					table.setRowSelectionInterval(2, 2);
					table.setSelectionBackground(Color.pink);
					table.repaint();
					
	            }
	        });
	        thread.start();
	    }
	  
	}

	

	 
	public static void main(String[] args) {
		 new Changecolor();
		}
	
	
	
}
