package com.iie.database;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

public class FileCheck {
	
	public FileCheck(){}
	
	@SuppressWarnings("unused")
	public String[][] YesNo(String[] paths) {
	    
		System.out.println("路径的数目："+paths.length);
		String yesno[][]= new String[paths.length][3];
		
	    for (int i=0;i<paths.length;i++){
	    	String filePath = paths[i];
	    	System.out.println("当前的路径："+i+":"+paths[i]);
		    File root = new File(filePath);
		
		    File[] files = root.listFiles();
		    int len=files.length;
		    System.out.println("文件个数："+len);
		    
		    if(len==0){
		    	yesno[i][0] ="视频不存在";
		    	yesno[i][1] ="图片不存在";
	    		yesno[i][2] ="图片不存在";	
		    }
		    
		    for(int j=0;j<len;j++){
		    
		    	
		    	if(files[j].getName().equals("video.mp4")){
		    		yesno[i][0] ="video.mp4";
		    		break;
		    	}
		    	else{
		    		yesno[i][0] ="视频不存在";
		    	}
		    }
    	
		     for(int j=0;j<len;j++){
		    	if(files[j].getName().equals("1.jpg")){
		    		Image im;
		    		im=Toolkit.getDefaultToolkit().getImage("D:\\Workspaces\\MyEclipse 10\\Database\\1MOVIE\\1.jpg");
		    		yesno[i][1] ="1.jpg";
		    		yesno[i][2] ="1.jpg";
		    		break;
		    	}
		    	
		    	else if(files[j].getName().equals("2.jpg")){
		    		yesno[i][1] ="2.jpg";
		    		yesno[i][2] ="2.jpg";
		    		break;
		    	}
		    	
		    	else if(files[j].getName().equals("3.jpg")){
		    		yesno[i][1] ="3.jpg";
		    		yesno[i][2] ="3.jpg";	
		    		break;
		    	}  
		    	else{
		    		yesno[i][1] ="图片不存在";
		    		yesno[i][2] ="图片不存在";	
		    		break;
		    	}
		    
		  }
	    }
	    
	    return yesno;
	   }
		
	 
	
}
