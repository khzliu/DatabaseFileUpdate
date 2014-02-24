package com.iie.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadInformation {

	public String[] get2elements(String filePath){
		String[] durandw = new String[2];
		String readline;
        try { 
        	   String encoding="UTF-8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    readline=bufferedReader.readLine();
                    read.close();
                    String[] strArray = readline.split("   ");
                    durandw[0] = strArray[2];
                    durandw[1] = strArray[4];
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
		
		return durandw;
	}
}
