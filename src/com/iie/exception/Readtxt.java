package com.iie.exception;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
 
/**
 * @author 码农小江
 * H20121012.java
 * 2012-10-12下午11:40:21
 */
public class Readtxt {
    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     * @param filePath
     */
    public static String[] readRows(String filePath,int rowlen){
    	String [] lineTxts = new String[rowlen];

        try { 
        	   String encoding="UTF-8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    for(int i=0;i<rowlen;i++){
                    	lineTxts[i]=bufferedReader.readLine();
                    	
                    }
                    
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        
        return lineTxts;
     
    }
    
    public static String readRows(String filePath){
//
    	String readline = null;
    	String readchar = null;
        try { 
        	   String encoding="UTF-8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    readline=bufferedReader.readLine();
                    
                    if(readline!=null){
                        for (int i = 0; i < readline.length(); i++) {
                            char c = readline.charAt(i);
                            if (c == 'v') {
                            	System.out.println(readline.charAt(i+1));
                            }
                        }
                    }
                    read.close();
                
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        
        return readline;
     
    }
    
    
    
//    public static int getrow(String filePath) throws Exception{
//    	String encoding="UTF-8";
//        File file=new File(filePath);
//        int sum =0;
//        if(file.isFile() && file.exists()){ //判断文件是否存在
//            InputStreamReader read = new InputStreamReader(
//            new FileInputStream(file),encoding);//考虑到编码格式
//            BufferedReader bufferedReader = new BufferedReader(read);
//            while((bufferedReader.readLine()) != null){
//                sum++;
//            }
//        }
//        return sum;
//    	
//  
//    }
     
    public static void main(String argv[]) throws Exception{
        String filePath = "D:\\Workspaces\\MyEclipse 10\\Database\\0test\\太空中水滴试验 130620\\information.txt";

//        int rowlength = getrow(filePath);
//        System.out.println(rowlength);
        
        String content = readRows(filePath);
        System.out.println("获得的内容：   "+content);
        int len = content.length();
        System.out.println("总的字符串长度："+len);
        
        String[] strArray = content.split("   ");
        String duration = strArray[2];
        String WHR = strArray[4];
        System.out.println(duration);
        System.out.println(WHR);
//        int i = 0,count = 0;
//        while(++i<len){
//         if(content.charAt(i)==' '){
//          count++;
//          if(count==9){
//        	  for(int j= i+1;j<i+9;j++){
//        		  System.out.println(content.charAt(j));
//        	  }
//         }
//          if(count==15){
//        	  for(int j= i+1;j<i+5;j++){
//        		  System.out.println(content.charAt(j));
//        	  }
//         }
//         }
//        }
        
        System.out.println("第一次出现空格："+content.indexOf(' '));

    }
     
     
 
}