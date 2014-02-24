package com.iie.panel;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class EmptyPanel  extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 254654738754735727L;

	EmptyPanel(){
		this.setBorder(new EmptyBorder(5,5,5,5));
		this.setLayout(new FlowLayout());
		
		JPanel p=new JPanel();
		
	
		this.add(p);
		}
	

}
