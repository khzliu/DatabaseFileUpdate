package com.iie.exception;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.iie.panel.OperatePanel;


public class ImageJietu {

	JFrame allframe= new JFrame("图片操作");
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p21 = new Panel();
	Panel p22 = new Panel();
	
//	Panel p3 = new Panel();
	
	private Button startb = new Button("        截      图        ");	//确定
	private Button okb = new Button("        返      回        ");	//确定
	JLabel ll1;
	JLabel ll2;
	JLabel ll3;
	JLabel llbig;
	
//	ImageIcon newicon1b;
//	ImageIcon newicon2b;
//	ImageIcon newicon3b;
	static String lllpa="D:\\Workspaces\\MyEclipse 10\\Database\\0movie";
	
	public ImageJietu(final String localPath){	
		
		allframe.setBounds(100, 30, 770, 650);
		ImageIcon icon1 = new ImageIcon(localPath+"\\1.jpg");
		ImageIcon icon2 = new ImageIcon(localPath+"\\2.jpg");
		ImageIcon icon3 = new ImageIcon(localPath+"\\3.jpg");
		
		Image img1 = icon1.getImage();
	    img1 = img1.getScaledInstance(160, 100, Image.SCALE_DEFAULT); 
	    ImageIcon newicon1 = new ImageIcon(img1);
	    
	    Image img2 = icon2.getImage();
	    img2 = img2.getScaledInstance(160, 100, Image.SCALE_DEFAULT); 
	    ImageIcon newicon2 = new ImageIcon(img2);
	    
	    Image img3 = icon3.getImage();
	    img3 = img3.getScaledInstance(160, 100, Image.SCALE_DEFAULT); 
	    ImageIcon newicon3 = new ImageIcon(img3);
	    
		ll1 =new JLabel(newicon1);
		ll2 =new JLabel(newicon2);
		ll3 =new JLabel(newicon3);
		
		
		Image img1b = icon1.getImage();
	    img1b = img1b.getScaledInstance(500, 320, Image.SCALE_DEFAULT); 
	    ImageIcon newicon1b = new ImageIcon(img1b);
	    llbig =new JLabel(newicon1b);
		
		FlowLayout f = new FlowLayout(FlowLayout.CENTER,50,25);
		p1.setLayout(f);
		p1.add(ll1);
		p1.add(ll2);
		p1.add(ll3);

		
		
		FlowLayout f21 = new FlowLayout(FlowLayout.CENTER,50,25);
		p21.setLayout(f21);
		p21.add(startb);
		p21.add(okb);
		
		
		FlowLayout f22 = new FlowLayout(FlowLayout.CENTER,50,15);
		p22.setLayout(f22);
//		p22.setBackground(new Color(22,33,55));
		p22.add(llbig);
		
		p2.add(p21,BorderLayout.NORTH);
		p2.add(p22,BorderLayout.CENTER);
		
		
		
		
		allframe.add(p1, BorderLayout.NORTH);	//设置p1置中部
		allframe.add(p2, BorderLayout.CENTER);	//设置p1置中部
		allframe.setVisible(true);
		allframe.setResizable(true);

	
		ll1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) { 
				
				
				ImageIcon icon1 = new ImageIcon(localPath+"\\1.jpg");
				Image img1b = icon1.getImage();
			    img1b = img1b.getScaledInstance(500, 320, Image.SCALE_DEFAULT); 
			    ImageIcon newicon1b = new ImageIcon(img1b);
			    
			    llbig.setIcon(newicon1b);
				 p22.add(llbig);
				 p22.repaint();
			}
		 });
		
		
		ll2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) { 
				
				
				ImageIcon icon2 = new ImageIcon(localPath+"\\2.jpg");
				Image img2b = icon2.getImage();
			    img2b = img2b.getScaledInstance(500, 320, Image.SCALE_DEFAULT); 
			    ImageIcon newicon2b = new ImageIcon(img2b);
			    
			    llbig.setIcon(newicon2b);
				 p22.add(llbig);
				 p22.repaint();
			}
		 });
		
		
		ll3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) { 
				
				
				ImageIcon icon3 = new ImageIcon(localPath+"\\3.jpg");
				Image img3b = icon3.getImage();
			    img3b = img3b.getScaledInstance(500, 320, Image.SCALE_DEFAULT); 
			    ImageIcon newicon3b = new ImageIcon(img3b);
			    
			    llbig.setIcon(newicon3b);
				 p22.add(llbig);
				 p22.repaint();
			}
		 });
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	

	
	
	public JLabel getimg1() {
		return ll1;
	}
	
	public JLabel getimg2() {
		return ll2;
	}
	
	public JLabel getimg3() {
		return ll3;
	}
	
	
	
	
	
	

//	void listeners(){
//		this.getimg1().addMouseListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);//退出系统
//			}
//		});
//		
//		this.getoperateb().addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				new OperatePanel(readdata);
//				allframe.dispose();
//
//				
//			}
//		});
//	}
//	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		 new ImageJietu(lllpa);
		}
}
