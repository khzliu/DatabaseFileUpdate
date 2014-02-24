package com.iie.exception;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;



public class Tabletext  {
	
	MyTableModel mtablem;
	JTable mtable;
	
	
	public JTable getTabletext(){
		
		Vector columnNames = new Vector();
		  columnNames.add("索引");
		  columnNames.add("圖片");
		  columnNames.add("描述");
		  columnNames.add("時間");
		  ImageIcon icon = new ImageIcon("D:\\Workspaces\\MyEclipse 10\\Database\\0movie\\1.jpg");
		  
		  Vector rowData = new Vector();
		  Vector rowData2 = new Vector();
		  rowData.add("7月");
		  rowData.add("7月");
		  rowData.add("7月");
		  rowData.add("2011-09-02");
		  
		  rowData2.add(1);
		  rowData2.add(icon);
		  rowData2.add("7月");
		  rowData2.add("2011-09-02");
		  Vector cells = new Vector();
		  
		  cells.add(rowData);
		  cells.add(rowData2);
		  
		  mtablem = new MyTableModel(cells,columnNames);
		  mtable = new JTable(mtablem);
		  mtable.setBounds(0, 0, 200, 400);
		  
//		  mtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		 
		  
		  return mtable;
		
		
	}
	
	class MyTableModel extends DefaultTableModel{
		 /**
		 * 
		 */
		private static final long serialVersionUID = -281256122235978617L;
		
		
		public MyTableModel(Vector cells,Vector columnNames){
			 super(cells,columnNames);
		 }
		
		public Class getColumnClass(int col){
			  Vector v = (Vector) super.dataVector.elementAt(0);
			  if(v.elementAt(col)!=null){
				  return v.elementAt(col).getClass();
			  }else{
				  return "".getClass();
			  }
		 }
		 public boolean isCellEditable(int row,int col){
		  return false;
		 }
	}
	
//	DefaultTableCellRenderer dtc = new DefaultTableCellRenderer() {
//	    /**
//		 * 
//		 */
//		private static final long serialVersionUID = -1798758713193664580L;
//
//		
//		
//		public Component getTableCellRendererComponent(JTable table,
//	            Object value, boolean isSelected, boolean hasFocus,
//	            int row, int column) {
//	     if(row == 0)
//	     setBackground(new Color(185,207,230));
//		   	if(row == 1 && column == 2) {
//		   		
//		   		ImageIcon icon = new ImageIcon("D:\\Workspaces\\MyEclipse 10\\Database\\0movie\\1.jpg");
////		    	JLabel label = new JLabel(icon); 
////		   		Image img = icon.getImage();
////			    img = img.getScaledInstance(80, 45, Image.SCALE_DEFAULT); 
////			    newicon = new ImageIcon(img);
//			    JLabel label = new JLabel(icon);    
//		   		label.setOpaque(false);
//	               return label;
//	          }
//		   	
//		   	
//		    else
//			     setBackground(Color.white);
//	     return super.getTableCellRendererComponent(table, value,
//	               isSelected, hasFocus, row, column);
//	   
//	    }
//	};
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//public JTable setmovie2table(){
//		String[] headers= new String[3];
//		Object[][] cellData = new Object[4][3];
//		headers[0]="VIEDO(*。mp4)";
//		headers[1]="ICON(*。jpg)";
//		headers[2]="POSTER(*.jpg)";
//		cellData[0][0]="VIEDO(*.mp4)";
//		cellData[0][1]="ICON(*.jpg)";
//		cellData[0][2]="POSTER(*.jpg)";
//	
//
//		for(int i=1;i<4;i++){
//			
//			cellData[i][0]="111";
//			cellData[i][1]="222";
//			cellData[i][2]="333";
//			
//		}
//		JLabel label;
//		ImageIcon icon = new ImageIcon("D:\\Workspaces\\MyEclipse 10\\Database\\0movie\\1.jpg");
//		 Image img = icon.getImage();
//	     img = img.getScaledInstance(80, 45, Image.SCALE_DEFAULT); 
//	     ImageIcon newicon = new ImageIcon(img);
//		 label = new JLabel(newicon);
//		 label.setOpaque(false);
//		
//		 cellData[1][1]=label;
//		
//		
//		
//		DefaultTableModel model = new DefaultTableModel(cellData, headers) {	
//			/**
//				 * 
//				 */
//				private static final long serialVersionUID = 8244034073359228979L;
//				@Override
//				public Class<?> getColumnClass(int c){
//			           return getValueAt(0,c).getClass();
//			  }
//				
//				public boolean isCellEditable(int row, int column) {
//				    return true;
//				}		
//				
//			};
//			
//			
//			
//			JTable table = new JTable(model);
//			
//			for (int i=0;i<3;i++){
//				TableColumn column=table.getColumnModel().getColumn(i);
//				column.setPreferredWidth(90);//设置第一列的宽度
//			}
//			
//			table.setRowHeight(50);//设置行高
//			
//			for(int i =0 ;i<3;i++){
//				table.getColumnModel().getColumn(i).setCellRenderer(dtc); 
//				
//			}
//	
//			
//			return table;
//		
//		
//		
//		
//	}


}



