package com.iie.database;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;






public class Mytable {
	
	
	DefaultTableCellRenderer dtc = new DefaultTableCellRenderer() {
	    /**
		 * 
		 */
		private static final long serialVersionUID = -1798758713193664580L;

		
		
		public Component getTableCellRendererComponent(JTable table,
	            Object value, boolean isSelected, boolean hasFocus,
	            int row, int column) {
	     if(row == 0)
	     setBackground(new Color(185,207,230));
	     else
	     setBackground(Color.white);
	     return super.getTableCellRendererComponent(table, value,
	               isSelected, hasFocus, row, column);
	   
	    }
	};
	


	
	
	
//	
	String[] imgpaths ;
	
	public JTable settable(Hashtable<Integer, String> row,int num){
		System.out.println("表格建立列数："+row.size());
		String[] headers= new String[row.size()];
		Object[][] cellData = new Object[4][row.size()]; 
		for (int j=0;j<row.size();j++){
			row.get(j);
			System.out.println(row.get(j));
			headers[j]=row.get(j);
			
		}
		for (int i=0;i<2;i++){	
			if(i==0){
				for(int j=0;j<row.size();j++){
					cellData[i][j]=row.get(j);
				}
			}
			else{
					
				for(int j=1;j<row.size();j++){
					cellData[i][j]="";
				}
			}
		}
		
		DefaultTableModel model = new DefaultTableModel(cellData, headers) {	
		/**
			 * 
			 */
			private static final long serialVersionUID = 8244034073359228979L;

			public boolean isCellEditable(int row, int column) {
				
			    return true;
			}		
		};
		JTable table = new JTable(model);
		
		table.setRowHeight(50);//设置行高
		for(int i =0 ;i<row.size();i++){
			table.getColumnModel().getColumn(i).setCellRenderer(dtc); 
			
		}
		return table;
	}
	
	
	MTableModel2 andtablem;
	JTable andtable;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	
	public JTable setmovieandtable(Hashtable<Integer, String> row,int num,Map<Integer,Movie> movies,String localpaths[]){
		
		int len = localpaths.length;
		Vector columnNames = new Vector();
		for (int j=0;j<row.size();j++){
			row.get(j);
			System.out.println(row.get(j));
			columnNames.add(row.get(j));
		}
		  
		  columnNames.add("VIEDO(*.mp4)");
		  columnNames.add("ICON(*.jpg)");
		  columnNames.add("POSTER(*.jpg)");

		  
		  
		  Vector[] rows = new Vector[len];
		  
		  Vector cells = new Vector();

		  ImageIcon icon = null ;
		  FileCheck fc = new FileCheck();
		  String getpath[][] = fc.YesNo(localpaths);


		  
		  
		  
		  for(int i=0;i<len;i++){
			 String cellData=getpath[i][0];
			 String emptystr = "";
			  

			 icon = new ImageIcon(localpaths[i]+"\\1.jpg");
			 Image img = icon.getImage();
		     img = img.getScaledInstance(80, 45, Image.SCALE_DEFAULT); 
		     ImageIcon newicon = new ImageIcon(img);
			 rows[i] = new Vector();
			  
			 double rannumd=Math.random();
			 long rannuml= Math.round(rannumd*100)+100;
			 String rannum = String.valueOf(rannuml);
			 double rannumd2=Math.random();
			 long rannuml2= Math.round(rannumd2*100)+200;
			 String rannum2 = String.valueOf(rannuml2);
			 
			 
			 String numstr = String.valueOf(num+i);  
			 
			  
			rows[i].add(numstr);
			rows[i].add(movies.get(i).getduration());
			rows[i].add(movies.get(i).getdiscription());
			rows[i].add(emptystr);
			rows[i].add(emptystr);
			rows[i].add(movies.get(i).getdiscription());
			rows[i].add(movies.get(i).getWHR());
			rows[i].add(rannum);
			rows[i].add(rannum2);
			  
			  rows[i].add(cellData);
			  rows[i].add(newicon);
			  rows[i].add(newicon);
			  rows[i].add(emptystr);
			  cells.add(rows[i]);
		  }
		  
		  int zonglen=row.size()+3;
		  andtablem = new MTableModel2(cells,columnNames);
		  
		  

		  
		  andtable = new JTable(andtablem);
		  andtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		  
		  for (int i=0;i<zonglen;i++){
				TableColumn column=andtable.getColumnModel().getColumn(i);
				column.setPreferredWidth(90);//设置第一列的宽度
			}
		  
		 JTableHeader tou =  andtable.getTableHeader();
		  tou.setResizingAllowed(true);
		  tou.setPreferredSize(new Dimension(zonglen*90,50));
		  tou.setBackground(new Color(185,207,230));
		  andtable.setRowHeight(50);//设置行高
		  
		  return andtable;
		
		
	}
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	
	public JTable setbookandtable(Hashtable<Integer, String> row,int num,String[] name,String localpaths[]){
		
		int len = localpaths.length;
		Vector columnNames = new Vector();
		for (int j=0;j<row.size();j++){
			row.get(j);
			System.out.println(row.get(j));
			columnNames.add(row.get(j));
		}
		  
		  columnNames.add("ICON(*.jpg)");

		  
		  
		  Vector[] rows = new Vector[len];
		  
		  Vector cells = new Vector();

		  ImageIcon icon = null ;
		 

		  
		  
		  
		  for(int i=0;i<len;i++){
			 
			  

			 icon = new ImageIcon(localpaths[i]+"\\icon.jpg");
			 Image img = icon.getImage();
		     img = img.getScaledInstance(80, 45, Image.SCALE_DEFAULT); 
		     ImageIcon newicon = new ImageIcon(img);
			 rows[i] = new Vector();
			  
			
			 
			 String numstr = String.valueOf(num+i);  
			 
			  
			rows[i].add(numstr);
			rows[i].add(name[i]);			
			rows[i].add(newicon);
			
			
			  cells.add(rows[i]);
		  }
		  
		 
		  andtablem = new MTableModel2(cells,columnNames);
		  
		  

		  
		  andtable = new JTable(andtablem);
		  andtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		  
		  for (int i=0;i<3;i++){
				TableColumn column=andtable.getColumnModel().getColumn(i);
				column.setPreferredWidth(90);//设置第一列的宽度
			}
		  
		 JTableHeader tou =  andtable.getTableHeader();
		  tou.setResizingAllowed(true);
		  tou.setPreferredSize(new Dimension(3*90,50));
		  tou.setBackground(new Color(185,207,230));
		  andtable.setRowHeight(50);//设置行高
		  
		  return andtable;
		
		
	}
	
	
	
	
	
//	MTableModel2 mtablem;
//	JTable mtable;
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public JTable setmovie2table(String localpaths[]){
//		
//		int len = localpaths.length;
//		Vector columnNames = new Vector();
//		
//		  columnNames.add("VIEDO(*.mp4)");
//		  columnNames.add("ICON(*.jpg)");
//		  columnNames.add("POSTER(*.jpg)");
//		  columnNames.add("状态");
//
//		  
//		  
//		  Vector[] rows = new Vector[len];
//		  
//		  Vector cells = new Vector();
//
//		  ImageIcon icon = null ;
//		  FileCheck fc = new FileCheck();
//			String getpath[][] = fc.YesNo(localpaths);
//
//
//		  
//		  
//		  
//		  for(int i=0;i<len;i++){
//			  
//			  
//			 String cellData=getpath[i][0];
//			 String emptystr = "";
//			  
////			 if(choose==0){
//				icon = new ImageIcon(localpaths[i]+"\\1.jpg");
////			 } 
////			 if(choose==1){
////				icon = new ImageIcon(localpaths[i]+"\\2.jpg");
////			 } 
////			 if(choose==2){
////				icon = new ImageIcon(localpaths[i]+"\\3.jpg");
////			 } 
//			 
////			 ImageIcon icon = new ImageIcon(localpaths[i]+"\\1.jpg");
//			 Image img = icon.getImage();
//		     img = img.getScaledInstance(80, 45, Image.SCALE_DEFAULT); 
//		     ImageIcon newicon = new ImageIcon(img);
//			  rows[i] = new Vector();
//			  rows[i].add(cellData);
//			  rows[i].add(newicon);
//			  rows[i].add(newicon);
//			  rows[i].add(emptystr);
//			  cells.add(rows[i]);
//		  }
//		  
//		  mtablem = new MTableModel2(cells,columnNames);
//		  mtable = new JTable(mtablem);
//		  mtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		  
//		  for (int i=0;i<4;i++){
//				TableColumn column=mtable.getColumnModel().getColumn(i);
//				column.setPreferredWidth(90);//设置第一列的宽度
//			}
//		  
//		 
//		  
//		 JTableHeader tou =  mtable.getTableHeader();
//		  tou.setResizingAllowed(true);
//		  tou.setPreferredSize(new Dimension(360,50));
//		  tou.setBackground(new Color(185,207,230));
//		  mtable.setRowHeight(50);//设置行高
//		  
//		  return mtable;
//		  
//		
//	}
//	
//	
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
	
	
	
	
	
	
	
	
	
	
	

	public JTable setmovietable(Hashtable<Integer, String> row,int num,Map<Integer,Movie> movies,int length){
		

		System.out.println("表格建立列数："+row.size());
		String[] headers= new String[row.size()];
		Object[][] cellData = new Object[length][row.size()]; 
		for (int j=0;j<row.size();j++){
			row.get(j);
			System.out.println(row.get(j));
			headers[j]=row.get(j);
			
		}
		
		for(int j=0;j<row.size();j++){
			cellData[0][j]=row.get(j);
		}
		
		
		for (int i=1;i<length;i++){	
			cellData[i][0]=num+i-1;
			cellData[i][1]=movies.get(i-1).getduration();
			cellData[i][2]=movies.get(i-1).getdiscription();
			cellData[i][3]="";
			cellData[i][4]="";
			cellData[i][5]=movies.get(i-1).getdiscription();
			cellData[i][6]=movies.get(i-1).getWHR();
			cellData[i][7]="100";
			cellData[i][8]="100";

		}
		
		DefaultTableModel model = new DefaultTableModel(cellData, headers) {	
		/**
			 * 
			 */
			private static final long serialVersionUID = 8244034073359228979L;
			 
		

			public boolean isCellEditable(int row, int column) {
				
			    return true;
			}		
			
		};
		JTable table = new JTable(model);
		
		table.setRowHeight(50);//设置行高
		
		
		
		
		for(int i =0 ;i<row.size();i++){
			table.getColumnModel().getColumn(i).setCellRenderer(dtc); 
		}
		
		return table;
	}
	
	
	
	public JTable setbooktable(Hashtable<Integer, String> row,int num,String[] name,int length){
		System.out.println("表格建立列数："+row.size());
		String[] headers= new String[row.size()];
		Object[][] cellData = new Object[length][row.size()]; 
		for (int j=0;j<row.size();j++){
			row.get(j);
			System.out.println(row.get(j));
			headers[j]=row.get(j);
			
		}
		
		for(int j=0;j<row.size();j++){
			cellData[0][j]=row.get(j);
		}
		
		
		for (int i=1;i<length;i++){	
			
			cellData[i][0]=num+i-1;
			cellData[i][1]=name[i-1];
			
		}
		
		DefaultTableModel model = new DefaultTableModel(cellData, headers) {	
		/**
			 * 
			 */
			private static final long serialVersionUID = 8244034073359228979L;

			public boolean isCellEditable(int row, int column) {
				
			    return true;
			}		
			
		};
		JTable table = new JTable(model);
		
		table.setRowHeight(50);//设置行高
		for(int i =0 ;i<row.size();i++){
			table.getColumnModel().getColumn(i).setCellRenderer(dtc); 
			
		}
		return table;
	}
	
	
	
	
	
	
//	JLabel label;
//	class MyTableCellRenderer  implements TableCellRenderer{	
//
//		public Component getTableCellRendererComponent(JTable table,
//				Object value, boolean isSelected, boolean hasFocus, int row,
//				int column) { 
//			   if(row ==0 && column == 1) {
//				   
//				   	ImageIcon icon = new ImageIcon("D:\\Workspaces\\MyEclipse 10\\Database\\touming.png");
//					label = new JLabel(icon);
//					label.setOpaque(true);
////					label.setForeground(new Color(0,0,0,0));
////					label.setBackground(new Color(0,0,0,0));
//					
//		            return label;
//		          } 
//				 if(row ==0 && column == 2) {
//					 label = new JLabel("POSTER(*.jpg)");
//		              label.setOpaque(false);
//		               return label;
//		          } 
//
//				 
//				 else{
//					 for (int r= 0;r<imgpaths.length;r++){
//						 for(int c= 1;c<3;c++){
//							 if(row==r+1&& column==c){
//								 
//								 
//								 ImageIcon icon = new ImageIcon(imgpaths[r]+"\\1.jpg");
//								 Image img = icon.getImage();
//							     img = img.getScaledInstance(80, 45, Image.SCALE_DEFAULT); 
//							     ImageIcon newicon = new ImageIcon(img);
//								 label = new JLabel(newicon);
//								 label.setOpaque(false);
//								 return label;
//							}
//						 }	  
//						 
//					}
//						return label;
//				 }
//				 
//			 
//		   }
//		}	
//	
//	
//	class MyTableCellRenderer2  implements TableCellRenderer{	
//
//		public Component getTableCellRendererComponent(JTable table,
//				Object value, boolean isSelected, boolean hasFocus, int row,
//				int column) { 
//			   if(row ==0 && column == 1) {
//				   label = new JLabel("ICON(*.jpg)");
//		              label.setOpaque(false);
//		               return label;
//		          } 
//				 if(row ==0 && column == 2) {
//					 label = new JLabel("POSTER(*.jpg)");
//		              label.setOpaque(false);
//		               return label;
//		          } 
//
//				 
//				 else{
//					 for (int r= 0;r<imgpaths.length;r++){
//						 for(int c= 1;c<3;c++){
//							 if(row==r+1&& column==c){
//								 
//								 
//								 ImageIcon icon = new ImageIcon(imgpaths[r]+"\\2.jpg");
//								 Image img = icon.getImage();
//							     img = img.getScaledInstance(80, 45, Image.SCALE_DEFAULT); 
//							     ImageIcon newicon = new ImageIcon(img);
//								 label = new JLabel(newicon);
//								 label.setOpaque(false);
//								 return label;
//							}
//						 }	  
//						 
//					}
//						return label;
//				 }
//				 
//			 
//		   }
//		}	
	

	}

	
	
	







