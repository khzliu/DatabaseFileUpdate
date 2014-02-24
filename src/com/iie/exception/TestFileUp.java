package com.iie.exception;
import java.io.IOException; 
import java.io.UnsupportedEncodingException;

import ch.ethz.ssh2.Connection; 
import ch.ethz.ssh2.SCPClient; 

public class TestFileUp { 
	
	
	public static String[] filenames;
	
	public static void main(String[] args){   
       
		
		 String localfilePath = "d:\\qr";
		 String localfileName = "北京.txt";
		 String str = localfilePath+"\\"+localfileName;
		 System.out.println("本来的路径："+str);
		
		 String str2 = null;
		 String str3 = null;
		 String user = "root";   
		 String pass = "wsnwsnwsn";   
		 String host = "192.168.110.248"; 
       
		 
		 try {
    	    str2 = new String(str.getBytes("GBK"), "UTF-8");
	        str3 = new String(str.getBytes("ISO8859-1"), "UTF-8");
		 } catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
			 e.printStackTrace();
		 }
         
       System.out.println(str); 
       System.out.println(str2); 
       System.out.println(str3); 
		 
		 
//         Connection con = new Connection(host);   
//         try {   
//            con.connect();   
//            boolean isAuthed = con.authenticateWithPassword(user, pass);   
//            System.out.println("isAuthed===="+isAuthed);   
//            SCPClient scpClient = con.createSCPClient();   
//            scpClient.put(str, "/usr/fandq");
//            con.close();   
//        } catch (IOException e) {   
//            e.printStackTrace();   
//        }   

        
    } 
	
 
	
	









}