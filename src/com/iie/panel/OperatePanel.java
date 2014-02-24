package com.iie.panel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import ch.ethz.ssh2.SFTPException;

import com.iie.database.Book;
import com.iie.database.FileUpdown;
import com.iie.database.Movie;
import com.iie.database.MyFile;
import com.iie.database.MyFileChooser;
import com.iie.database.ReadData;
import com.iie.database.ReadInformation;
import com.iie.database.SetData;






public class OperatePanel {

	JFrame allframe= new JFrame("数据库录入系统");	
	CardLayout cardlayout = new CardLayout();
	MoviePanel moviepanel = new MoviePanel();
	MoviePanel2 moviepanel2 = new MoviePanel2();
	
	BookPanel bookpanel = new BookPanel();
	BookPanel2 bookpanel2 = new BookPanel2();
	CityPanel citypanel = new CityPanel();
	EmptyPanel emptypanel = new EmptyPanel();
	
	private JComboBox  jcb; 	//下拉菜单择账户类型
	Button scanb = new Button("        浏     览         ");
	Button backb = new Button("            退         出             ");
//	Button databaseb = new Button("      录 入 数 据 库      ");
	Button changenameb = new Button("            确         定             ");
	Button reupdownb = new Button("      重新上传错误文件      ");
//	JTextArea sb = new JTextArea();


	
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	
	 
	String dataname;
	
	
	ReadData newreaddata = new ReadData();
	Connection newconn;
	
	
	public OperatePanel(ReadData readdata){
		
		
	     
		jcb=new JComboBox();
		jcb.addItem("        请   选   择         ");
		jcb.addItem("movie");
//		jcb.addItem("city");
		jcb.addItem("book");
				

		
		
		allframe.setBounds(100, 30, 1150, 650);
		allframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		allframe.add(p1, BorderLayout.NORTH);	//设置p1置顶端
		allframe.add(p2, BorderLayout.CENTER);	//设置p1置中部
		allframe.add(p3, BorderLayout.SOUTH);	//设置p1置中部
		allframe.setVisible(true);
		allframe.setResizable(false);
		
		FlowLayout f1 = new FlowLayout(FlowLayout.CENTER,50,12);
		p1.setLayout(f1);
		p1.setBackground(new Color(222,222,222));//设置背景色	
		p1.add(new JLabel(" ",SwingConstants.CENTER));
		p1.add(new JLabel("数据库名称:",SwingConstants.CENTER));
		p1.add(jcb);
		p1.add(new JLabel("                  ",SwingConstants.CENTER));
		p1.add(new JLabel("                  ",SwingConstants.CENTER));
		p1.add(new JLabel("                  ",SwingConstants.CENTER));
		p1.add(scanb);
		p1.add(new JLabel(" ",SwingConstants.CENTER));
		

		
		
		p2.setLayout(cardlayout);	//把p2设置成card格式
		p2.setBackground(new Color(156,217,222));//设置背景色
		p2.add("empty", emptypanel);	// 用户登录界面	
//		p2.add("city",citypanel );	//用户开户界面
		p2.add("book", bookpanel);	// 用户登录界面	


		
		FlowLayout f3 = new FlowLayout(FlowLayout.CENTER,110,22);
		p3.setLayout(f3);
		p3.add(changenameb);
		p3.add(reupdownb);
		p3.add(backb);
		
		
		jcb.addItemListener(choose);  
		listeners();
		newreaddata = readdata;
		newconn = newreaddata.getcon();
		
	}
	
	
	 ItemListener  choose  =  new  ItemListener(){  
			public  void  itemStateChanged(ItemEvent  e){  
				if(e.getStateChange()==ItemEvent.SELECTED)  
				{  
					if(jcb.getSelectedItem().toString().trim().equals("movie"))  
					{  
						System.out.println("开始读取movie数据库");
						dataname="movie";
						moviepanel = new MoviePanel(newreaddata);
						p2.add("movie", moviepanel);	//初始化界面
						cardlayout.show(p2, "movie");
						System.out.println("choose___dataname="+dataname);
					}  
//					else  if(jcb.getSelectedItem().toString().trim().equals("city"))
//					{  
//						System.out.println("开始读取city数据库"); 
//						dataname="city";
//						citypanel = new CityPanel(newreaddata);
//						p2.add("city", citypanel);	//初始化界面
//						cardlayout.show(p2, "city");
//						
//					}
					else  if(jcb.getSelectedItem().toString().trim().equals("book"))
					{  
						
						dataname="book";
						System.out.println("book数据库");
						bookpanel = new BookPanel(newreaddata);
						p2.add("book", bookpanel);	//初始化界面
						cardlayout.show(p2, "book");
					}  
					else  
					{  
						
						dataname="none";
						cardlayout.show(p2, "empty");
						System.out.println("wrong"); 
					}  
				}   
			}  
		}; 
	
	
	
	Map <Integer,Movie> oldmm = new HashMap<Integer,Movie>();
	Map <Integer,Movie> wrongmm = new HashMap<Integer,Movie>();
	List<Movie> mm;
	List<Book> bb;
	String[] strpath;
	
	String[] strname;
	String[] newstrname;
	String[] rootpath;
	
	int wrong[];
	
	String[] wrongstrpath;
	int right[];
	int rightcount=0;
	public class Changecol {
	    private Thread thread;

	    public void begin() {
	        thread = new Thread(new Runnable() {
	            public void run() {
	            	int length = strpath.length;
					int wrongcount=0;
					 wrong = new int[length];
					
					right = new int[length];
	            	if (dataname.equals("movie")){
		            	try{	
							newstrname =new String[length];
							rootpath =new String[length];
							System.out.println("lenghr-----------="+length);
							
							for (int j =0; j<strpath.length;j++){
								System.out.println("path-----------="+j+strpath[j]);
//								File delfile = new File(strpath[j]+"//1.jpg");  
//								File delfile2 = new File(strpath[j]+"//2.jpg");  
//								File delfile3 = new File(strpath[j]+"//3.jpg");  
//								File delfile4 = new File(strpath[j]+"//information.txt");  
//							    if (delfile.exists()) {  
//							    	delfile.delete();  
//							    }  
//							    if (delfile2.exists()) {  
//							    	delfile2.delete();  
//							    }  
//							    if (delfile3.exists()) {  
//							    	delfile3.delete();  
//							    }  
//							    if (delfile4.exists()) {  
//							    	delfile4.delete();  
//							    }
							    
							    
								File oldFile = new File(strpath[j]);
								 if(!oldFile.exists()){
									  try {
										oldFile.createNewFile();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								  }
								  System.out.println("修改前文件名称是："+oldFile.getName());
								  String rootPath = oldFile.getParent();
								  System.out.println("根路径是："+rootPath);
								
								  rootpath[j]=rootPath;
								  String newnames[] = moviepanel2.getchangename(strpath.length);
								  File newFile = new File(rootPath + File.separator + newnames[j].replaceAll(" ", ""));
								  System.out.println("修改后文件名称是："+newFile.getName());
								  newstrname[j]=newFile.getName();
								  
								  if (oldFile.renameTo(newFile)) {
									  System.out.println("修改成功");
								  } 
								  else{
									  System.out.println("修改失败");
								  }
							}
							
							for(int j =0; j<length;j++){
								wrong[j]=0;
							}
							
							
							allframe.setEnabled(false);
//							allframe.setFocusable(false);
							
							
							JDialog jDialog =new JDialog();
							JLabel l=new JLabel();
							ImageIcon icon=new ImageIcon("D:\\Workspaces\\MyEclipse 10\\Database\\transmit.jpg");     //在此直接创建对象
							l.setIcon(icon);
							
							jDialog.setLayout(new BorderLayout());
							jDialog.add(l,BorderLayout.WEST);
							
							jDialog.add(new JLabel("    正在传输，请稍后......"),BorderLayout.CENTER);
							
							jDialog.setSize(300, 120);
							jDialog.setLocationRelativeTo(null);
//							jDialog.setModal(true);
							jDialog.setVisible(true);
							jDialog.setAlwaysOnTop(true);
						

							for (int j =0; j<strpath.length;j++){
								int tag=0;	
								 try{
									 String remotep=moviepanel2.getremotep();
						
									 
									 @SuppressWarnings("unused")
									 FileUpdown fileup = new FileUpdown(remotep,rootpath[j]+"\\"+newstrname[j],newstrname[j],dataname);
								
									 
									
									 
								 
								 }catch (SFTPException stfe3) {
									 System.out.println("SFTPException");
									 stfe3.printStackTrace();
									 tag=1;
									 wrong[wrongcount]=j;
									 wrongcount++;
									 JOptionPane.showMessageDialog(allframe.getContentPane(),
										       "远程服务端已存在同名文件，请核实后重新传输，谢谢！", "系统信息", JOptionPane.ERROR_MESSAGE);
									
									 
									
									 
								 }catch (Exception ee) {
									 ee.printStackTrace();
									 tag=1;
									 wrong[wrongcount]=j;
									 wrongcount++;
									 JOptionPane.showMessageDialog(allframe.getContentPane(),
										       "传输失败，数据库未录入，请核实相关信息，谢谢！", "系统信息", JOptionPane.ERROR_MESSAGE);
								 }
								 	
	
								 if(tag==0){
									 SetData dd=new SetData();
										mm = moviepanel2.getmovie(strpath.length);
	
											try {
												dd.insertmoviedatabase("movie",mm.get(j),newconn);
												
											} catch (Exception e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											} 
											
											
											 right[rightcount]=j;
											 rightcount++;
											moviepanel2.issuccess(wrong,wrongcount,j);
											
								 }
								
									
							}
							jDialog.dispose();
							allframe.setEnabled(true);
					  }catch(NullPointerException nullpointerex){
						  nullpointerex.printStackTrace(); 
					  }
	            	
		            	wrongstrpath=new String[wrongcount];
						wrongmm=moviepanel2.wrongmms(wrong, wrongcount);
						for(int i=0;i<wrongcount;i++){
							wrongstrpath[i] =strpath[wrong[i]];
							
						}
	            	}
	            	
	            	
	            	else{
//						JOptionPane.showMessageDialog(allframe.getContentPane(),
//							       "该数据库禁止修改文件名", "系统信息", JOptionPane.ERROR_MESSAGE);
						allframe.setEnabled(false);
						JDialog jDialog =new JDialog();
						JLabel l=new JLabel();
						ImageIcon icon=new ImageIcon("D:\\Workspaces\\MyEclipse 10\\Database\\transmit.jpg");     //在此直接创建对象
						l.setIcon(icon);
						
						jDialog.setLayout(new BorderLayout());
						jDialog.add(l,BorderLayout.WEST);
						
						jDialog.add(new JLabel("    正在传输，请稍后......"),BorderLayout.CENTER);
						
						jDialog.setSize(300, 120);
						jDialog.setLocationRelativeTo(null);
						
						jDialog.setVisible(true);
						jDialog.setAlwaysOnTop(true);
						
						
						for (int j =0; j<strpath.length;j++){
							 
							int tag=0;	
							 try{
								 File oldFile = new File(strpath[j]);
								 
								
								  String rootPath = oldFile.getParent();
								  System.out.println("根路径是："+rootPath);
								  
								  rootpath =new String[length];
								  rootpath[j]=rootPath;
								  
								 String remotep=bookpanel2.getremotep();
								 System.out.println(rootpath[j]+"\\"+strname[j]);
								 @SuppressWarnings("unused")
								 FileUpdown fileup = new FileUpdown(remotep,rootpath[j]+"\\"+strname[j],strname[j],dataname);
							
								
							 
							 }catch (SFTPException stfe3) {
								 System.out.println("SFTPException");
								 stfe3.printStackTrace();
								 tag=1;
								 wrong[wrongcount]=j;
								 wrongcount++;
								 JOptionPane.showMessageDialog(allframe.getContentPane(),
									       "远程服务端已存在同名文件，请核实后重新传输，谢谢！", "系统信息", JOptionPane.ERROR_MESSAGE);
								
								 
								
								 
							 }catch (Exception ee) {
								 ee.printStackTrace();
								 tag=1;
								 wrong[wrongcount]=j;
								 wrongcount++;
								 JOptionPane.showMessageDialog(allframe.getContentPane(),
									       "传输失败，数据库未录入，请核实相关信息，谢谢！", "系统信息", JOptionPane.ERROR_MESSAGE);
							 }
							 	

							 if(tag==0){
								 SetData dd=new SetData();
								 
								 
									bb = bookpanel2.getbook(strpath.length);
									 System.out.println("ddddddddddddddd"+bb.size());
									
									
										try {
											dd.insertbookdatabase("book",bb.get(j),newconn);
											
										} catch (Exception e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} 
										
										 right[rightcount]=j;
										 rightcount++;
//										moviepanel2.issuccess(wrong,wrongcount,j);
										
							 }
							
								
						}
						jDialog.dispose();
						allframe.setEnabled(true);
					}
	            	
	    
	            }
	        });
	        thread.start();
	    }
	  
	}
	
	
	
	
	
	
	public class Changecol2 {
	    private Thread thread;

	    public void begin() {
	        thread = new Thread(new Runnable() {
	            public void run() {
	            	int length2 = wrongstrpath.length;
					int wrongcount2=0;
					int wrong2[] = new int[length2];
	            	
	            	if (dataname=="movie"){
		            	try{	
							newstrname =new String[length2];
							rootpath =new String[length2];
							System.out.println("lenghr----------22-="+length2);
							for (int j =0; j<length2;j++){
								System.out.println("lenghr-----wrongstrpath----22--="+wrongstrpath[j]);
								File oldFile = new File(wrongstrpath[j]);
								 if(!oldFile.exists()){
									  try {
										oldFile.createNewFile();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								  }
								  System.out.println("修改前文件名称是："+oldFile.getName());
								  String rootPath = oldFile.getParent();
								  System.out.println("根路径是："+rootPath);
								  rootpath[j]=rootPath;
								  String newnames[] = moviepanel2.getchangename2(wrong,wrongstrpath.length);

								  System.out.println("lenghr--newnames-----22----="+newnames[j]);
								  
								  File newFile = new File(rootPath + File.separator + newnames[j].replaceAll(" ", ""));
								  System.out.println("修改后文件名称是："+newFile.getName());
								  newstrname[j]=newFile.getName();
								  
								  if (oldFile.renameTo(newFile)) {
									  System.out.println("修改成功");
								  } 
								  else{
									  System.out.println("修改失败");
								  }
							}
							
							for(int j =0; j<length2;j++){
								wrong2[j]=0;
							}
							
							
							JDialog jDialog =new JDialog();
							JLabel l=new JLabel();
							ImageIcon icon=new ImageIcon("D:\\Workspaces\\MyEclipse 10\\Database\\transmit.jpg");     //在此直接创建对象
							l.setIcon(icon);
							
							jDialog.setLayout(new BorderLayout());
							jDialog.add(l,BorderLayout.WEST);
							
							jDialog.add(new JLabel("    正在传输，请稍后......"),BorderLayout.CENTER);
							
							jDialog.setSize(300, 120);
							jDialog.setLocationRelativeTo(null);
							
							jDialog.setVisible(true);
						
							for (int j =0; j<wrongstrpath.length;j++){
								 
								int tag=0;	
								 try{
									 String remotep=moviepanel2.getremotep();
									 System.out.println("qqqqqqqqqqqq"+remotep);
									 System.out.println(rootpath[j]+"\\"+newstrname[j]);
									 System.out.println(newstrname[j]);
									 @SuppressWarnings("unused")
									 
									
									 FileUpdown fileup = new FileUpdown(remotep,rootpath[j]+"\\"+newstrname[j],newstrname[j],dataname);
								 }catch (SFTPException stfe3) {
									 System.out.println("SFTPException");
									 stfe3.printStackTrace();
									 tag=1;
									 wrong2[wrongcount2]=j;
									 wrongcount2++;
									 JOptionPane.showMessageDialog(allframe.getContentPane(),
										       "远程服务端已存在同名文件，请核实后重新传输，谢谢！", "系统信息", JOptionPane.ERROR_MESSAGE);
									
									 
									 
								 }catch (Exception ee) {
									 ee.printStackTrace();
									 tag=1;
									 wrong2[wrongcount2]=j;
									 wrongcount2++;
									 JOptionPane.showMessageDialog(allframe.getContentPane(),
										       "传输失败，数据库未录入，请核实相关信息，谢谢！", "系统信息", JOptionPane.ERROR_MESSAGE);
								 }
								 	
	
								 if(tag==0){
									 SetData dd=new SetData();
										mm = moviepanel2.getmovie(wrongstrpath.length);
	
											try {
												dd.insertmoviedatabase("movie",mm.get(j),newconn);
												
											} catch (Exception e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
//											moviepanel2.issuccess(wrong2,wrongcount2,j);
											
								 }
								
									
							}
							jDialog.dispose();
							JOptionPane.showMessageDialog(allframe.getContentPane(),
								       "更正后的信息传输完毕！", "系统信息", JOptionPane.INFORMATION_MESSAGE);
						 
							
					  }catch(NullPointerException nullpointerex){
						  nullpointerex.printStackTrace(); 
					  }
	            	
		            
	            	}
	            	
	            	else{
						JOptionPane.showMessageDialog(allframe.getContentPane(),
							       "该数据库禁止修改文件名", "系统信息", JOptionPane.ERROR_MESSAGE);
					}
	            }
	        });
	        thread.start();
	    }
	  
	}
	
	
	
	
	
	
	
	
	
	
	
	void listeners(){
		
		
		System.out.println("dataname="+dataname);

			this.scanb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					if (dataname=="movie"){
						System.out.println("弹出选择框");
						MyFileChooser mfc = new MyFileChooser();
						MyFile myff = mfc.newMyFileChooser();
						
						strname =myff.getname();
						strpath = myff.getpath();
						int length = strname.length;
						System.out.println("lenghr-----------="+length);
						for (int j =0; j<strname.length;j++){
							Movie mymovie= new Movie();
							System.out.println("lenghr-----------="+strpath[j]);
							String twos[] =new ReadInformation().get2elements(strpath[j]+"//information.txt");
							
							mymovie.setid("");
							mymovie.setduration(twos[0]);
							mymovie.setname(strname[j]);
							mymovie.setactor("");
							mymovie.setdirector("");
							mymovie.setdiscription(strname[j]);
							mymovie.setWHR(twos[1]);
							mymovie.setclicks("");
							mymovie.setpriority("");
							

							oldmm.put(j, mymovie);
						}
						
						moviepanel2 = new MoviePanel2(oldmm,newreaddata,strpath);
						p2.add("movie2", moviepanel2);	//初始化界面
						cardlayout.show(p2, "movie2");
					}
					
					if (dataname=="book"){
						System.out.println("弹出选择框");
						MyFileChooser mfc = new MyFileChooser();
						MyFile myff = mfc.newMyFileChooser();
						
						strname =myff.getname();
						strpath = myff.getpath();
						int length = strname.length;
						System.out.println("lenghr-----------="+length);
						for (int j =0; j<strname.length;j++){
							System.out.println("name-----------="+j+strname[j]);
							System.out.println("path-----------="+j+strpath[j]);
						}
						bookpanel2 = new BookPanel2(strname,length+1,newreaddata,strpath);
						p2.add("book2", bookpanel2);	//初始化界面
						cardlayout.show(p2, "book2");
					}
					
					if (dataname==null){
						JOptionPane.showMessageDialog(allframe.getContentPane(),
							       "请选择数据库！", "系统信息", JOptionPane.INFORMATION_MESSAGE);	
					}
				}
			});
			
	
	
		this.changenameb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dataname=="movie"){
					int tag=0;
					String[] empty1 = new String[strpath.length];
					String[] empty2=new String[strpath.length];
					String[] dises=new String[strpath.length];
					mm = moviepanel2.getmovie(strpath.length);
					for(int i=0;i<strpath.length;i++){
						empty1[i]=mm.get(i).getduration();
						empty2[i]= mm.get(i).getWHR();
						dises[i]= mm.get(i).getdiscription();
						
					}
					
					for(int i=0;i<strpath.length;i++){
						if(empty1[i]==null){
							JOptionPane.showMessageDialog(allframe.getContentPane(),
								       "第"+(i+1)+"行中，数据库中“duration”项不能为空，请手动输入。标准格式：02:02:02.", "系统信息", JOptionPane.ERROR_MESSAGE);
						tag =1;
						}
						
						if(empty2[i]==null){
							JOptionPane.showMessageDialog(allframe.getContentPane(),
									"第"+(i+1)+"行中，数据库中“WHR”项不能为空，请手动输入。标准格式：2.22.", "系统信息", JOptionPane.ERROR_MESSAGE);
							tag =1;
						}
						if(dises[i].length()>200){
							System.out.println("kkkkkkkkk第"+(i+1)+"行中，数据库中“discription”项过长，请输入小于200字。"+dises[i].length());
							JOptionPane.showMessageDialog(allframe.getContentPane(),
									"第"+(i+1)+"行中，数据库中“discription”项过长，当前字数"+dises[i].length()+",请输入小于200字。", "系统信息", JOptionPane.ERROR_MESSAGE);
							tag =1;
						}
						
						
					}
					
					if(tag==0){
						Changecol changecol = new Changecol();
						changecol.begin();
					}
						
					
				}
				
				if(dataname=="book"){
					
						Changecol changecol = new Changecol();
						changecol.begin();
					
				}
				
					
					
			}
			
			
		});
		

		this.reupdownb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				moviepanel2.emptytable(right,rightcount);
				Changecol2 changecol2 = new Changecol2();
				changecol2.begin();
				
//				moviepanel2 = new MoviePanel2(wrongmm,newreaddata,wrongstrpath);
//				p2.add("movie3", moviepanel2);	//初始化界面
//				cardlayout.show(p2, "movie3");
					
			}
			
			
		});
		
		
		
	}

	
	
	
	

	
}

