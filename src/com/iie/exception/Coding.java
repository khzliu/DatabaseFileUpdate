package com.iie.exception;

import java.io.UnsupportedEncodingException;

public class Coding {

	public static void main(String[] args) {
		String localfileName = "我dde啊啊";
		byte[] strby2;
		try {
			strby2 = localfileName.getBytes("GB2312");
			String localfileName2 = new String(strby2,"utf-8");
			 System.out.println(localfileName);
			 System.out.println(localfileName2);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
