package com.iie.exception;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;



public class ColorTable {
	
	
	
	

	
	
	MTableModel2 andtablem;
	JTable andtable;
	@SuppressWarnings({ "rawtypes", "unchecked" })
public JTable setmovieandtable(){
		
		int len = 3;
		Vector columnNames = new Vector();
		
		  columnNames.add("VIEDO(*.mp4)");
		  columnNames.add("ICON(*.jpg)");
		  columnNames.add("POSTER(*.jpg)");
		  columnNames.add("备注");
		  
		  
		  Vector[] rows = new Vector[len];
		  Vector cells = new Vector();
		  ImageIcon icon = null ;


		  
		  
		  
		  for(int i=0;i<len;i++){
			 String emptystr = "";
			  

			 icon = new ImageIcon("D:\\Workspaces\\MyEclipse 10\\Database\\success.jpg");
			 Image img = icon.getImage();
		     img = img.getScaledInstance(80, 45, Image.SCALE_DEFAULT); 
		     ImageIcon newicon = new ImageIcon(img);
		     
			 rows[i] = new Vector();
			 rows[i].add("100");
			 rows[i].add(newicon);
			 rows[i].add(newicon);
			 rows[i].add(emptystr);
			 cells.add(rows[i]);
		  }
		  
		  andtablem = new MTableModel2(cells,columnNames);
		  andtable = new JTable(andtablem);
		  andtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		  
		  for (int i=0;i<4;i++){
				TableColumn column=andtable.getColumnModel().getColumn(i);
				column.setPreferredWidth(90);//设置第一列的宽度
			}
		  
		 JTableHeader tou =  andtable.getTableHeader();
		  tou.setResizingAllowed(true);
		  tou.setPreferredSize(new Dimension(4*90,50));
		  tou.setBackground(new Color(185,207,230));
		  andtable.setRowHeight(50);//设置行高
		  
		  return andtable;
	
		
	}
	
	@SuppressWarnings("rawtypes")
	class MTableModel2 extends DefaultTableModel{
		 /**
		 * 
		 */
		private static final long serialVersionUID = -281256122235978617L;
		
		
		public MTableModel2(Vector cells,Vector columnNames){
			 super(cells,columnNames);
		 }
		
		public Class<?> getColumnClass(int col){
			  Vector v = (Vector) super.dataVector.elementAt(0);
			  if(v.elementAt(col)!=null){
				  return v.elementAt(col).getClass();
			  }else{
				  return "".getClass();
			  }
		 }
		 public boolean isCellEditable(int row,int col){
		  return true;
		 }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
