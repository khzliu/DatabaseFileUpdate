package com.iie.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class FileUpdown {
	
	public FileUpdown(String disfilePath,String localfilePath,String filename,String dataname) throws Exception{
		 String[] filenames;

		 filenames = getfiles(localfilePath,dataname);
		 
		 
		 
		 System.out.println("localfilePathmyttttt"+localfilePath);   
	     for (int i = 0;i<filenames.length;i++){
	    	 System.out.println("myttttt"+filenames[i]);   
	     }
	     
	 
//	    String user = "root";   
//	    String pass = "wsn++123";   
//	    String host = "159.226.94.32"; 
	     String user = "root";   
		    String pass = "wsnwsnwsn";   
		    String host = "192.168.110.248"; 
	     
	     
	    
	    Connection con = new Connection(host);   
//        try {   
            con.connect();   
            boolean isAuthed = con.authenticateWithPassword(user, pass);   
            System.out.println("isAuthed===="+isAuthed);   
               
               
            SCPClient scpClient = con.createSCPClient();   
            SFTPv3Client sftpClient = new SFTPv3Client(con);   
          
            
            	disfilePath=disfilePath+filename;
            	System.out.println("isAuthed===="+filenames[0]);   
          	  System.out.println("isAuthed===="+disfilePath);  
          	  
          	  
            	sftpClient.mkdir(disfilePath, 6);    //远程新建目录   
           
            	  
            scpClient.put(filenames, disfilePath); //从本地复制文件到远程目录   
            
            
            Session session = con.openSession();   
            session.execCommand("uname -a && date && uptime && who");   //远程执行命令   
               
               
               
            //显示执行命令后的信息   
            System.out.println("Here is some information about the remote host:");   
            InputStream stdout = new StreamGobbler(session.getStdout());   
  
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));   
  
            while (true){   
                String line = br.readLine();   
                if (line == null)   
                    break;   
                System.out.println(line);   
            }   
  
            /* Show exit status, if available (otherwise "null") */  
  
            System.out.println("ExitCode: " + session.getExitStatus());   
  
            session.close();   
            con.close();   
//        } catch (IOException e) {   
//        	System.out.println("mymymy"); 
//        	e.printStackTrace();  
//             
//        }   
	}
	
    
    
    public String[] getfiles(String fpath,String dataname){
    	
    	File root = new File(fpath);
        File[] files = root.listFiles();
        

        
        if(dataname=="movie"){
        	
        	if(files.length==7){
        		 int i=0;
     	        String nn[] = new String[files.length-4];
     	        for (int j=0;j<files.length;j++){
     	        	if( files[j].getName().equals("icon.jpg")||files[j].getName().equals("poster.jpg")||files[j].getName().equals("video.mp4"))
     	        	{
     			        	 nn[i]=files[j].getAbsolutePath();
     			        	 i++;
     	        	}
     	        	
     	        }
     	        return nn;
        	}
        	else{
            	String nn2[] = new String[files.length];
            	for (int i=0;i<files.length;i++){
            		nn2[i]=files[i].getAbsolutePath();
            	}
            	return nn2;
        	}
	       
        
        }
        
        else{
        	String nn3[] = new String[files.length];
        	for (int i=0;i<files.length;i++){
        		nn3[i]=files[i].getAbsolutePath();
  
        	}
        	return nn3;
        }
        
    	
    }
	
}



