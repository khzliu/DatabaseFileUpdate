package com.iie.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.iie.database.Book;
import com.iie.database.Mytable;
import com.iie.database.ReadData;

public class BookPanel2  extends JPanel{
	private static final long serialVersionUID = 773061692801494906L;
	public JTable t;
	JTextArea sb2 = new JTextArea();
	Hashtable<Integer, String> rowname;
	JTextField romotepath=new JTextField();
	int num;
	
	BookPanel2(){
		this.setBorder(new EmptyBorder(5,5,5,5));
		this.setLayout(new BorderLayout());
		
	}
	BookPanel2(String[] name,int length,ReadData readdate,String[] localPath){
		this.setBorder(new EmptyBorder(5,5,5,5));
		this.setLayout(new BorderLayout());

		
		romotepath.setText("/usr/local/apache-tomcat/webapps/ROOT/data/reading/book/");
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p12=new JPanel();
		JPanel p3=new JPanel();
		
		p1.setLayout(new  GridLayout(2,1,0,10));
		
		p12.setLayout(new  GridLayout(1,3,0,10));
		p12.add(new JLabel("远程上传路径:   ",SwingConstants.RIGHT));
		p12.add(romotepath);
		p12.add(new JLabel(" "));

		p1.add(new JLabel("                                                                                                " +
				"本地文件路径:   "+localPath[0],SwingConstants.LEFT));
		p1.add(p12);
		this.add(p1,BorderLayout.NORTH);
		
		
		
		try {
			rowname = readdate.readdatabase("book");
			num = readdate.getrecordnum("book");
			t=new Mytable().setbookandtable(rowname,num,name,localPath);	
			
			t.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) { 
					
					 if(t.getValueAt(t.getSelectedRow(),0)!=null){
						 String s  = (String) t.getValueAt (t.getSelectedRow(),1);
						 sb2.setText(s);
//						 System.out.println("鼠标事件||||||||||||||"+s);
					 }
					 repaint();
				}
			 });
			
			JScrollPane scrollPane = new JScrollPane(t,
				    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
			int rownum = localPath.length+1;
			int rowlen = rownum*51+1;
		 
			int zong = rowname.size()+1;
		 scrollPane.setPreferredSize(new Dimension(zong*90+3, rowlen));

		p2.add(scrollPane);
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	    
	this.add(p2,BorderLayout.CENTER);

	
	FlowLayout ff = new FlowLayout(FlowLayout.CENTER,300,12);
	p3.setLayout(ff);
	sb2.setPreferredSize(new Dimension (900,55));
	sb2.setLineWrap(true); 
	
	sb2.setText("点击每行显示当前行的名字信息");
	
	JScrollPane jsp = new JScrollPane();
    jsp.getViewport().add(sb2);
    jsp.setBounds(new Rectangle(120, 40, 200, 200));
    jsp	.setPreferredSize(new Dimension (900,55));
    p3.add(jsp);
   this.add(p3,BorderLayout.SOUTH);
	
	}

	
	
	 public String getremotep(){
	    	return romotepath.getText();
	    }
	

	public  List<Book> getbook(int length){
		
		
		try {
			
			List<Book> books=new ArrayList<Book>();
			
			for(int i=0;i<length;i++){
				Book book=new Book();				
				book.setid(t.getValueAt(i, 0).toString());// 取得第i行第一列的数据
				book.setname((String)t.getValueAt(i, 1));// 取得第i行第一列的数据
				books.add(book);
			}
			return books;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		}
		
		
		}

}
