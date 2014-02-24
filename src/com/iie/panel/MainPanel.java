package com.iie.panel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.iie.database.DataBase;
import com.iie.database.ReadData;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

public class MainPanel{
	
	JFrame allframe= new JFrame("数据库录入系统");	
	Button operateb = new Button("     开  始  操  作     ");
	Button exitb = new Button("     退  出  系  统    ");
	JLabel j = new JLabel("欢迎使用数据库录入系统",SwingConstants.CENTER);
	
//	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3  = new Panel();
	Panel p31 = new Panel();
	Panel p32 = new Panel();
	
	
	private JTextField ipf=new JTextField();//账号
	private JTextField dbnamef=new JTextField();//
	private JTextField rootf=new JTextField();//账号

	
	
	private JPasswordField passwordf=new JPasswordField();//密码
	private Button connectb = new Button("       数 据 库 连 接     ");	//确定
	private Button emptyb = new Button("         清        空         ");	//确定
	public MainPanel(){
		allframe.setBounds(100, 30, 1150, 650);
		allframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		allframe.add(p2, BorderLayout.CENTER);	//设置p1置中部
		allframe.add(p3, BorderLayout.SOUTH);	//设置p1置中部
		
		

		ipf.setText("192.168.110.248");
		dbnamef.setText("wb");
		rootf.setText("root");
		passwordf.setText("526156");
	
//		ipf.setText("localhost:3306");
//		dbnamef.setText("test");
//		rootf.setText("root");
//		passwordf.setText("12345");
		
		


		p2.setBackground(new Color(156,217,222));//设置背景色
		p2.setLayout(new GridLayout(1,1,0,20));
		p2.add(j);//文本
		j.setFont(new   java.awt.Font("Dialog",0,35)); 
		
		
		
		p3.setLayout(new BorderLayout());
		p3.add(p31,BorderLayout.NORTH);
		p3.add(p32,BorderLayout.CENTER);
		
		
		p31.setLayout(new GridLayout(10,4,0,20));
		p31.setBackground(new Color(156,217,222));//设置背景色
		
		
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		
		

		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("主机IP地址:",SwingConstants.CENTER));//账号标签
		p31.add(ipf);
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("数据库名称:",SwingConstants.CENTER));//账号标签
		p31.add(dbnamef);
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		
		 
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("用户名:",SwingConstants.CENTER));//账号标签
		p31.add(rootf);
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("密码:",SwingConstants.CENTER));//密码标签
		p31.add(passwordf);
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		p31.add(new JLabel("",SwingConstants.CENTER));//空标签
		
		FlowLayout f = new FlowLayout(FlowLayout.CENTER,130,22);
		p32.setLayout(f);
		
		p32.add(emptyb);
		p32.add(connectb);
//		p32.add(operateb);
		p32.add(exitb);
		
		allframe.setVisible(true);
		allframe.setResizable(false);
		
		listeners();// 调用监听方法
	}

	

	public Button getexitb() {
		return exitb;
	}
	
	public Button getoperateb() {
		return operateb;
	}
	
	public Button getemptyb() {
		return emptyb;
	}
	
	public Button getconnectb() {
		return connectb;
	}
	
	

	
	String ip;
	String dbname;
	String user;
	String password;
	DataBase dbcon;
	ReadData readdata = new ReadData();

	
	
	
	
	void listeners(){
		this.getexitb().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//退出系统
			}
		});

		
		this.getconnectb().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					ip =ipf.getText();
					dbname =dbnamef.getText();
					user =rootf.getText();
					password=new String(passwordf.getPassword());

					
					dbcon =new DataBase(ip,dbname,user,password);
					readdata = new ReadData(dbcon);
					JOptionPane.showMessageDialog(allframe.getContentPane(),
						       "数据连接成功，请继续操作！", "系统信息", JOptionPane.INFORMATION_MESSAGE);
					
					new OperatePanel(readdata);
					allframe.dispose();
					
					
				} catch (MySQLSyntaxErrorException e1) {
					JOptionPane.showMessageDialog(allframe.getContentPane(),
						       "连接信息错误，请检查主机名和数据库名称！", "系统信息", JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e2) {
					
					JOptionPane.showMessageDialog(allframe.getContentPane(),
						       "登陆信息错误，请检查用户名和密码！", "系统信息", JOptionPane.ERROR_MESSAGE);
				}catch (Exception ee) {
					ee.printStackTrace();
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(allframe.getContentPane(),
						       "其他错误，请检查输入信息！", "系统信息", JOptionPane.ERROR_MESSAGE);
				}
				
				System.out.println("ip:"+dbcon.getip());
				System.out.println("dbname:"+dbcon.getdbname());
				System.out.println("user:"+dbcon.getuser());
				System.out.println("password:"+dbcon.getpassword());
				
//				url =conf.getText();
//				user =idf.getText();
//				name =namef.getText();
//				password=new String(passwordf.getPassword());
//
//				
//				dbcon =new DataBase(url,user,name,password);
//				System.out.println("url:"+dbcon.geturl());
//				System.out.println("url:"+dbcon.getname());
//				System.out.println("user:"+dbcon.getuser());
//				System.out.println("password:"+dbcon.getpassword());
//				new OperatePanel(dbcon);
//				allframe.dispose();
////				String url = "jdbc:mysql://localhost:3306/test";  // 数据库连接
////				String user = "root"; // 用户名		
////				String password = "12345";  // 数据库密码	
				
			}
		});
		
		
		this.getemptyb().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {	
				ipf.setText("");
				dbnamef.setText("");
				rootf.setText("");
				passwordf.setText("");
			}
		});
		
	}
	
	
	public DataBase getDatabase (){
		return dbcon;
		
	}
	
	public static void main(String[] args) {
	 new MainPanel();
	}
	


	
}