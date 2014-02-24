package com.iie.panel;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import com.iie.database.Movie;
import com.iie.database.Mytable;
import com.iie.database.ReadData;

public class MoviePanel2 extends JPanel {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 773061692801494906L;
		public JTable andt;
		int num;

		Hashtable<Integer, String> rowname;
//		public JTable t;
//		public JTable t2;
		JPanel p2=new JPanel();
		JTextArea sb2 = new JTextArea();
//		JPanel myp=new JPanel();
//		CardLayout cardlayout = new CardLayout();
//		public int times=0;
		int times = 0;

		JTextField romotepath=new JTextField();
		
		
		MoviePanel2(){
			this.setBorder(new EmptyBorder(5,5,5,5));
			this.setLayout(new BorderLayout());
			
		}
		MoviePanel2(Map<Integer,Movie> movies,ReadData readdate,final String[] localPath){
			this.setBorder(new EmptyBorder(5,5,5,5));
			this.setLayout(new BorderLayout());
			
//			romotepath.setText("/usr/local/apache-tomcat/webapps/ROOT/data/video/movie/");
			romotepath.setText("/usr/fandq/");
			
			JPanel p1=new JPanel();
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
			
			
//			p12.add(new JLabel("                                                                                  " +
//					"远程上传路径:  "+"/usr/fandq/movie/"));

			this.add(p1,BorderLayout.NORTH);

			
			try {
//				ReadData readdate = new  ReadData();
				rowname = readdate.readdatabase("movie");
				num = readdate.getrecordnum("movie");
//				t = new Mytable().setmovietable(rowname,num,movies,length);	
				andt=new Mytable().setmovieandtable(rowname,num,movies,localPath);
				andt.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) { 
						
						 if(andt.getValueAt(andt.getSelectedRow(),0)!=null){
							 String s  = (String) andt.getValueAt (andt.getSelectedRow(),5);
							 sb2.setText(s);
						 }
						 repaint();
					}
				 });
				
				
			
				JScrollPane scrollPane = new JScrollPane(andt,
					    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				
				int rownum = localPath.length+1;
				int rowlen = rownum*51+1;
			 
				int zong = rowname.size()+3;
			 scrollPane.setPreferredSize(new Dimension(zong*90+3, rowlen));
					  
//			 p1.add(scrollPane);
			
//			p2.add(t);
			p2.add(scrollPane);
			
			
//			p2.add(myp);
				
				
			final String[] str = new String[localPath.length];
				
				andt.addMouseListener(new java.awt.event.MouseAdapter() {
					
					public void mouseClicked(java.awt.event.MouseEvent e) { 
//						int click = e.getClickCount();
						
						int col=andt.getSelectedColumn();
					
					
						
						if (col==10){
							int selnum = andt.getSelectedRow();
						
								@SuppressWarnings("unused")
								ImagePanel imagepanel = new ImagePanel(localPath[selnum],localPath);
								
						}

							if (col==11){
								int selnum = andt.getSelectedRow();
								
								
								times++;
								
								
								if(times%3==1){
									ImageIcon icon = new ImageIcon(localPath[selnum]+"\\2.jpg");
									 Image img = icon.getImage();
								     img = img.getScaledInstance(80, 45, Image.SCALE_DEFAULT); 
								     ImageIcon newicon = new ImageIcon(img);
								     andt.setValueAt(newicon, selnum, 11);
								     str[selnum]=localPath[selnum]+"\\2.jpg";
								}
								 
								if(times%3==2){
									ImageIcon icon = new ImageIcon(localPath[selnum]+"\\3.jpg");
									 Image img = icon.getImage();
								     img = img.getScaledInstance(80, 45, Image.SCALE_DEFAULT); 
								     ImageIcon newicon = new ImageIcon(img);
								     andt.setValueAt(newicon, selnum, 11);
								     str[selnum]=localPath[selnum]+"\\3.jpg";
								}
								if(times%3==0){
									ImageIcon icon = new ImageIcon(localPath[selnum]+"\\1.jpg");
									 Image img = icon.getImage();
								     img = img.getScaledInstance(80, 45, Image.SCALE_DEFAULT); 
								     ImageIcon newicon = new ImageIcon(img);
								     andt.setValueAt(newicon, selnum, 11);
								     str[selnum]=localPath[selnum]+"\\1.jpg";
								}
								
								File file1 =new File(str[selnum]);
								File file2 =new File(localPath[selnum]+"\\poster.jpg");
								try {
									copyFile(file1,file2);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								}
						else{
						}
						 repaint();
					}
					
				 });

				

				
				
				
					//把p2设置成card格式
				

				 
				
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
		
class ImagePanel extends JFrame{
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 569525721803261367L;
			JFrame allimgframe= new JFrame("图片操作");
			Panel p1 = new Panel();
			Panel p2 = new Panel();
			Panel p21 = new Panel();
			Panel p22 = new Panel();

			private Button startb = new Button("        截      图        ");	//确定
//			private Button scaniconb = new Button("    查    看  ICON    ");	//确定
			JLabel ll1;
			JLabel ll2;
			JLabel ll3;
			JLabel llbig;
			ImageIcon icon1;
			ImageIcon icon2;
			ImageIcon icon3;
			ImageIcon icon;
			
			public ImagePanel(){
//				allimgframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
			
			public ImagePanel(final String localPathstr,final String[] localPath){	
				
//				allimgframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				allimgframe.setBounds(100, 30, 770, 650);
				icon1 = new ImageIcon(localPathstr+"\\1.jpg");
				icon2 = new ImageIcon(localPathstr+"\\2.jpg");
				icon3 = new ImageIcon(localPathstr+"\\3.jpg");
				 
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
				
				
				FlowLayout f22 = new FlowLayout(FlowLayout.CENTER,50,15);
				p22.setLayout(f22);
				p22.add(llbig);
				
				p2.add(p21,BorderLayout.NORTH);
				p2.add(p22,BorderLayout.CENTER);
				
				
				
				
				allimgframe.add(p1, BorderLayout.NORTH);	//设置p1置中部
				allimgframe.add(p2, BorderLayout.CENTER);	//设置p1置中部
				allimgframe.setVisible(true);
				allimgframe.setResizable(true);
				
				
				
				allimgframe.addWindowListener(new WindowListener(){

					@Override
					public void windowOpened(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
						
						for(int i=0;i<localPath.length;i++){
							if(new File(localPath[i]+"\\icon.jpg").exists()){
								ImageIcon poster = new ImageIcon(localPath[i]+"\\icon.jpg");
								Image img = poster.getImage();
								img = img.getScaledInstance(45, 45, Image.SCALE_DEFAULT); 
								ImageIcon newposter = new ImageIcon(img);
								andt.setValueAt(newposter, i, 10);
								repaint();
							}
						}
						
						
						
					}

					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				}); 
			
				ll1.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) { 
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
						
						Image img3b = icon3.getImage();
					    img3b = img3b.getScaledInstance(500, 320, Image.SCALE_DEFAULT); 
					    ImageIcon newicon3b = new ImageIcon(img3b);
					    
					    llbig.setIcon(newicon3b);
						p22.add(llbig);
						p22.repaint();
					}
				 });
				
				this.startb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				 
						PrintScreen rd = new PrintScreen(localPathstr);
						GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
					                .getDefaultScreenDevice();
						gd.setFullScreenWindow(rd);
					}
				});
				
			}//ImagePanel(final String localPath)
			
			

			
			
			
			class PrintScreen extends JFrame  {
				
				private static final long serialVersionUID = 1L;
			    int orgx, orgy, endx, endy;
			    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			    BufferedImage image;
			    BufferedImage tempImage;
			    BufferedImage saveImage;
			    Graphics g;
			 
			    @Override
			    public void paint(Graphics g) {
			        RescaleOp ro = new RescaleOp(0.8f, 0, null);
			        tempImage = ro.filter(image, null);
			        g.drawImage(tempImage, 0, 0, this);
			    }
			 
			    
			    
			    public  PrintScreen(final String localPath) {
			        snapshot();
			        setVisible(true);
			        // setSize(d);//最大化窗口
			        setDefaultCloseOperation(EXIT_ON_CLOSE);
			        this.addMouseListener(new MouseAdapter() {
			            public void mousePressed(MouseEvent e) {
			                orgx = e.getX();
			                orgy = e.getY();
			            }
			        });
			        this.addMouseMotionListener(new MouseMotionAdapter() {
			            public void mouseDragged(MouseEvent e) {
			                endx = e.getX();
			                endy = e.getY();
			                g = getGraphics();
			                g.drawImage(tempImage, 0, 0, PrintScreen.this);
			                int x = Math.min(orgx, endx);
			                int y = Math.min(orgy, endy);
			                int width = Math.abs(endx - orgx)+1;
			                int height = Math.abs(endy - orgy)+1;
			                // 加上1，防止width或height为0
			                g.setColor(Color.BLUE);
			                
			                int bianchang=Math.min(width, height);
			                g.drawRect(x-1, y-1, bianchang+1, bianchang+1);
			                saveImage = image.getSubimage(x, y, bianchang, bianchang);
			                
			                
//			                g.drawRect(x-1, y-1, width+1, height+1);
//			                //减1，加1都是为了防止图片将矩形框覆盖掉
//			                saveImage = image.getSubimage(x, y, width, height);
			                g.drawImage(saveImage, x, y, PrintScreen.this);
			            }
			        });
			        
			        
			        this.addMouseListener(new MouseAdapter() {
			        	public void mouseClicked(MouseEvent evt) {
			        		 if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
			        			 
			        			saveToFile(localPath);
			        			dispose();
			        			icon= new ImageIcon(localPath+"\\icon.jpg");
			    		 		Image imgposter = icon.getImage();
			    		        imgposter = imgposter.getScaledInstance(100, 100, Image.SCALE_DEFAULT); 
			    			    ImageIcon newposter = new ImageIcon(imgposter);
			    			    
			    			    llbig.setIcon(newposter);
			    			    p22.add(llbig);
			    			    p22.repaint();
			        			 
			        		} 
			            }
			        });
			        
			        this.addKeyListener(new KeyAdapter() {
			            @Override
			            public void keyReleased(KeyEvent e) {
			                // 按Esc键退出
			                if (e.getKeyCode() == 27) {
			                    System.exit(0);
			                }
			            }
			        });
			        
			        
			    }//PrintScreen(final String localPath)


			    
			    
			    
			    public String saveToFile(String path) {
			        String format = "jpg";
			        File f = new File(path + File.separator + "icon" + "." + format);
			        try {
			            ImageIO.write(saveImage, format, f);
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			        return null;
			    }
			 
			    public void snapshot() {
			        try {
			            Robot robot = new Robot();
			            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			            image = robot.createScreenCapture(new Rectangle(0, 0, d.width,
			                    d.height));
			        } catch (AWTException e) {
			            e.printStackTrace();
			        }
			    }

			}//class PrintScreen
			
			
			
			
		}
		
		
		
		

		public  void copyFile(File sourceFile, File targetFile) throws IOException {
	        BufferedInputStream inBuff = null;
	        BufferedOutputStream outBuff = null;
	        try {
	            // 新建文件输入流并对它进行缓冲
	            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

	            // 新建文件输出流并对它进行缓冲
	            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

	            // 缓冲数组
	            byte[] b = new byte[1024 * 5];
	            int len;
	            while ((len = inBuff.read(b)) != -1) {
	                outBuff.write(b, 0, len);
	            }
	            // 刷新此缓冲的输出流
	            outBuff.flush();
	        } finally {
	            // 关闭流
	            if (inBuff != null)
	                inBuff.close();
	            if (outBuff != null)
	                outBuff.close();
	        }
	    }
		
		public  void changeicon(int selnum,String localPath[]){
			 ImageIcon icon = new ImageIcon(localPath[selnum]+"\\icon.jpg");
			 Image img = icon.getImage();
		     img = img.getScaledInstance(80, 45, Image.SCALE_DEFAULT); 
		     ImageIcon newicon = new ImageIcon(img);
		     andt.setValueAt(newicon, selnum, 10);
			
			}
		
		
		public  void emptytable(int right[],int rightcount){
			for(int i=0;i<rightcount;i++){
				String strem="";
				for(int j=0;j<12;j++){
				     andt.setValueAt(strem, right[i], j);
				}
				
			}
			 
			
			}
		
		public  Map <Integer,Movie>  wrongmms(int wrong[],int count){

			Map <Integer,Movie> wrongmm = new HashMap<Integer,Movie>();
			for(int i=0;i<count;i++){
				Movie mymovie= new Movie();
				mymovie.setid(andt.getValueAt(wrong[i], 0).toString());
				mymovie.setduration(andt.getValueAt(wrong[i], 1).toString());
				mymovie.setname(andt.getValueAt(wrong[i], 2).toString());
				mymovie.setactor(andt.getValueAt(wrong[i], 3).toString());
				mymovie.setdirector(andt.getValueAt(wrong[i], 4).toString());
				mymovie.setdiscription(andt.getValueAt(wrong[i], 5).toString());
				mymovie.setWHR(andt.getValueAt(wrong[i], 6).toString());
				mymovie.setclicks(andt.getValueAt(wrong[i], 7).toString());
				mymovie.setpriority(andt.getValueAt(wrong[i], 8).toString());
				

				wrongmm.put(i, mymovie);
				
			}
		return wrongmm;
			
			
			}
		
		
	    public void issuccess(int[] wrong,int count,int all){
	    		andt.setRowSelectionInterval(0,all);
	    		for(int i=0;i<count;i++){
	    			andt.removeRowSelectionInterval(wrong[i], wrong[i]);
	    		}
		    	andt.setSelectionBackground(new Color(153,243,148));
	    }	

	    
	    public void removerow(){
	    	andt.removeColumn(andt.getColumn(1));
	    	
    }	
		


	    public String getremotep(){
	    	return romotepath.getText();
	    }
	    
		

		
		public String[] getchangename(int length){
			String[] changednames = new String[length];
			for(int i=0;i<length;i++){
				changednames[i]=(String)andt.getValueAt(i, 2);
			}
			
			
			return changednames;
			
			
		}
		
		
		public String[] getchangename2(int wrong[],int length){
			String[] changednames = new String[length];
			for(int i=0;i<length;i++){
				changednames[i]=(String)andt.getValueAt(wrong[i], 2);
			}
			
			
			return changednames;
			
			
		}
		

		public  List<Movie> getmovie(int length){
			
			
			try {
				
				List<Movie> movies=new ArrayList<Movie>();
				
				for(int i=0;i<length;i++){
					Movie movie=new Movie();				
					movie.setid(andt.getValueAt(i, 0).toString());// 取得第i行第一列的数据
					movie.setduration((String)andt.getValueAt(i, 1));// 取得第i行第一列的数据
					movie.setname((String)andt.getValueAt(i, 2));// 取得第i行第一列的数据
					movie.setdirector((String)andt.getValueAt(i, 3));// 取得第i行第一列的数据
					movie.setactor((String)andt.getValueAt(i, 4));// 取得第i行第一列的数据
					movie.setdiscription((String)andt.getValueAt(i, 5));// 取得第i行第一列的数据
					movie.setWHR((String)andt.getValueAt(i, 6));// 取得第i行第一列的数据
					movie.setclicks((String)andt.getValueAt(i, 7));// 取得第i行第一列的数据
					movie.setpriority((String)andt.getValueAt(i, 8));// 取得第i行第一列的数据		
					movies.add(movie);
				}
				return movies;
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
				
			}
			
			
			}

}
