//package com.iie.panel;
//
//import java.awt.AWTException;
//import java.awt.BorderLayout;
//import java.awt.Button;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Graphics;
//import java.awt.GraphicsDevice;
//import java.awt.GraphicsEnvironment;
//import java.awt.Image;
//import java.awt.Panel;
//import java.awt.Rectangle;
//import java.awt.Robot;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.InputEvent;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionAdapter;
//import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;
//import java.awt.image.BufferedImage;
//import java.awt.image.RescaleOp;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//
//
//public class ImagePanel extends JFrame{
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 569525721803261367L;
//	JFrame allimgframe= new JFrame("图片操作");
//	Panel p1 = new Panel();
//	Panel p2 = new Panel();
//	Panel p21 = new Panel();
//	Panel p22 = new Panel();
//
//	private Button startb = new Button("        截      图        ");	//确定
//	private Button scaniconb = new Button("    查    看  ICON    ");	//确定
//	JLabel ll1;
//	JLabel ll2;
//	JLabel ll3;
//	JLabel llbig;
//	ImageIcon icon1;
//	ImageIcon icon2;
//	ImageIcon icon3;
//	ImageIcon icon;
//	
//	public ImagePanel(){
//		allimgframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//	}
//	
//	public ImagePanel(final String localPath){	
//		
//		allimgframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		allimgframe.setBounds(100, 30, 770, 650);
//		icon1 = new ImageIcon(localPath+"\\1.jpg");
//		icon2 = new ImageIcon(localPath+"\\2.jpg");
//		icon3 = new ImageIcon(localPath+"\\3.jpg");
//		 
//		Image img1 = icon1.getImage();
//	    img1 = img1.getScaledInstance(160, 100, Image.SCALE_DEFAULT); 
//	    ImageIcon newicon1 = new ImageIcon(img1);
//	    
//	    Image img2 = icon2.getImage();
//	    img2 = img2.getScaledInstance(160, 100, Image.SCALE_DEFAULT); 
//	    ImageIcon newicon2 = new ImageIcon(img2);
//	    
//	    Image img3 = icon3.getImage();
//	    img3 = img3.getScaledInstance(160, 100, Image.SCALE_DEFAULT); 
//	    ImageIcon newicon3 = new ImageIcon(img3);
//	    
//		ll1 =new JLabel(newicon1);
//		ll2 =new JLabel(newicon2);
//		ll3 =new JLabel(newicon3);
//		
//		
//		Image img1b = icon1.getImage();
//	    img1b = img1b.getScaledInstance(500, 320, Image.SCALE_DEFAULT); 
//	    ImageIcon newicon1b = new ImageIcon(img1b);
//	    llbig =new JLabel(newicon1b);
//		
//		FlowLayout f = new FlowLayout(FlowLayout.CENTER,50,25);
//		p1.setLayout(f);
//		p1.add(ll1);
//		p1.add(ll2);
//		p1.add(ll3);
//	
//		
//		FlowLayout f21 = new FlowLayout(FlowLayout.CENTER,50,25);
//		p21.setLayout(f21);
//		p21.add(startb);
//		p21.add(scaniconb);
//		
//		
//		FlowLayout f22 = new FlowLayout(FlowLayout.CENTER,50,15);
//		p22.setLayout(f22);
//		p22.add(llbig);
//		
//		p2.add(p21,BorderLayout.NORTH);
//		p2.add(p22,BorderLayout.CENTER);
//		
//		
//		
//		
//		allimgframe.add(p1, BorderLayout.NORTH);	//设置p1置中部
//		allimgframe.add(p2, BorderLayout.CENTER);	//设置p1置中部
//		allimgframe.setVisible(true);
//		allimgframe.setResizable(true);
//		allimgframe.addWindowListener(new MyWindowListener()); 
//	
//		ll1.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mouseClicked(java.awt.event.MouseEvent e) { 
//				Image img1b = icon1.getImage();
//			    img1b = img1b.getScaledInstance(500, 320, Image.SCALE_DEFAULT); 
//			    ImageIcon newicon1b = new ImageIcon(img1b);
//			    
//			    llbig.setIcon(newicon1b);
//				p22.add(llbig);
//				p22.repaint();
//			}
//		 });
//		
//		
//		ll2.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mouseClicked(java.awt.event.MouseEvent e) { 
//				Image img2b = icon2.getImage();
//			    img2b = img2b.getScaledInstance(500, 320, Image.SCALE_DEFAULT); 
//			    ImageIcon newicon2b = new ImageIcon(img2b);
//			    
//			    llbig.setIcon(newicon2b);
//				p22.add(llbig);
//				p22.repaint();
//			}
//		 });
//		
//		
//		ll3.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mouseClicked(java.awt.event.MouseEvent e) { 
//				
//				Image img3b = icon3.getImage();
//			    img3b = img3b.getScaledInstance(500, 320, Image.SCALE_DEFAULT); 
//			    ImageIcon newicon3b = new ImageIcon(img3b);
//			    
//			    llbig.setIcon(newicon3b);
//				p22.add(llbig);
//				p22.repaint();
//			}
//		 });
//		
//		
//		
//		
//		
//		
////		this.addWindowListener(new java.awt.event.WindowAdapter() {
////			@Override
////			public void windowClosing(java.awt.event.WindowEvent e) { 
////				
////				System.out.println("guanbi ?");
////			}
////			
////			@Override
////			public void windowClosed(java.awt.event.WindowEvent e) { 
////				
////				System.out.println("guanbi dd?");
////			}
////		 });
//		
//		
//		
//		this.startb.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//		 
//				PrintScreen rd = new PrintScreen(localPath);
//				GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
//			                .getDefaultScreenDevice();
//				gd.setFullScreenWindow(rd);
//			}
//		});
//		
//	}//ImagePanel(final String localPath)
//	
//	
//	class MyWindowListener implements WindowListener{
//
//		@Override
//		public void windowOpened(WindowEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void windowClosing(WindowEvent e) {
//			// TODO Auto-generated method stub
//			System.out.println("guanbi?");
//		}
//
//		@Override
//		public void windowClosed(WindowEvent e) {
//			// TODO Auto-generated method stub
//			System.out.println("guanbi dd?");
//		}
//
//		@Override
//		public void windowIconified(WindowEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void windowDeiconified(WindowEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void windowActivated(WindowEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void windowDeactivated(WindowEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		}
//	
//	
//	
//	class PrintScreen extends JFrame  {
//		
//		private static final long serialVersionUID = 1L;
//	    int orgx, orgy, endx, endy;
//	    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//	    BufferedImage image;
//	    BufferedImage tempImage;
//	    BufferedImage saveImage;
//	    Graphics g;
//	 
//	    @Override
//	    public void paint(Graphics g) {
//	        RescaleOp ro = new RescaleOp(0.8f, 0, null);
//	        tempImage = ro.filter(image, null);
//	        g.drawImage(tempImage, 0, 0, this);
//	    }
//	 
//	    
//	    
//	    public  PrintScreen(final String localPath) {
//	        snapshot();
//	        setVisible(true);
//	        // setSize(d);//最大化窗口
//	        setDefaultCloseOperation(EXIT_ON_CLOSE);
//	        this.addMouseListener(new MouseAdapter() {
//	            public void mousePressed(MouseEvent e) {
//	                orgx = e.getX();
//	                orgy = e.getY();
//	            }
//	        });
//	        this.addMouseMotionListener(new MouseMotionAdapter() {
//	            public void mouseDragged(MouseEvent e) {
//	                endx = e.getX();
//	                endy = e.getY();
//	                g = getGraphics();
//	                g.drawImage(tempImage, 0, 0, PrintScreen.this);
//	                int x = Math.min(orgx, endx);
//	                int y = Math.min(orgy, endy);
//	                int width = Math.abs(endx - orgx)+1;
//	                int height = Math.abs(endy - orgy)+1;
//	                // 加上1，防止width或height为0
//	                g.setColor(Color.BLUE);
//	                g.drawRect(x-1, y-1, width+1, height+1);
//	                //减1，加1都是为了防止图片将矩形框覆盖掉
//	                saveImage = image.getSubimage(x, y, width, height);
//	                g.drawImage(saveImage, x, y, PrintScreen.this);
//	            }
//	        });
//	        
//	        
//	        this.addMouseListener(new MouseAdapter() {
//	        	public void mouseClicked(MouseEvent evt) {
//	        		 if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
//	        			 
//	        			saveToFile(localPath);
//	        			dispose();
//	        			icon= new ImageIcon(localPath+"\\Icon.jpg");
//	    		 		Image imgposter = icon.getImage();
//	    		        imgposter = imgposter.getScaledInstance(100, 100, Image.SCALE_DEFAULT); 
//	    			    ImageIcon newposter = new ImageIcon(imgposter);
//	    			    
//	    			    llbig.setIcon(newposter);
//	    			    p22.add(llbig);
//	    			    p22.repaint();
//	        			 
//	        		} 
//	            }
//	        });
//	        
//	        this.addKeyListener(new KeyAdapter() {
//	            @Override
//	            public void keyReleased(KeyEvent e) {
//	                // 按Esc键退出
//	                if (e.getKeyCode() == 27) {
//	                    System.exit(0);
//	                }
//	            }
//	        });
//	        
//	        
//	    }//PrintScreen(final String localPath)
//
//
//	    
//	    
//	    
//	    public String saveToFile(String path) {
//	        String format = "jpg";
//	        File f = new File(path + File.separator + "Icon" + "." + format);
//	        try {
//	            ImageIO.write(saveImage, format, f);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	        return null;
//	    }
//	 
//	    public void snapshot() {
//	        try {
//	            Robot robot = new Robot();
//	            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//	            image = robot.createScreenCapture(new Rectangle(0, 0, d.width,
//	                    d.height));
//	        } catch (AWTException e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//	}//class PrintScreen
//	
//	
//	
//	
//}
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
//
//
//
