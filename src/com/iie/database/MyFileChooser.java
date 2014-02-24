package com.iie.database;


	import java.io.File;
	import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

	public class MyFileChooser {
		 

		public MyFile newMyFileChooser(){
			
			MyFile myff= new MyFile();
			String[] pathes = null;
			
			JFileChooser file = new JFileChooser (".");
			file.setAcceptAllFileFilterUsed(true);
			file.setMultiSelectionEnabled(true);

			

			file.addChoosableFileFilter(new TxtFileFilter("mp3"));
			file.addChoosableFileFilter(new TxtFileFilter("mp4"));
			file.addChoosableFileFilter(new TxtFileFilter("txt"));
			file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			
			
			
			int result = file.showOpenDialog(null);
			
			
			
			
			if(result == JFileChooser.APPROVE_OPTION){
				File[] fs=file.getSelectedFiles();
				pathes = new String[fs.length];
			   for(int i =0;i<fs.length ;i++){
				   pathes[i] = fs[i].getAbsolutePath();
			   }
			}
			else{
			    System.out.println("你已取消并关闭了窗口！");
			}
			
			
			File[] fs=file.getSelectedFiles();
			System.out.println("多选的信息");
			System.out.println(fs.length);
			String[] names = new String[fs.length];
			for (int i =0;i<fs.length ;i++){		
				names[i] = fs[i].getName();
			}
			myff.setname(names);
			myff.setpath(pathes);
			

			return myff;
		}

		

		private static class TxtFileFilter extends FileFilter {

			String ext;
			TxtFileFilter(String ext) {
			   this.ext = ext;
			}
			
			
			public boolean accept(File file) {
			   if (file.isDirectory()){
				return true;
			   }
			   String fileName = file.getName();
			   
			   
			   int index = fileName.lastIndexOf('.');
			  
			   
		
			   if (index > 0 && index < fileName.length() - 1){
				  String extension = fileName.substring(index + 1).toLowerCase();
				  if (extension.equals(ext)) return true;
			   }
		   return false;
		   }
			public String getDescription() {
			   if (ext.equals("txt")) {
			    return "文本文件(*.txt)";
			   }
			   if(ext.equals("mp3"))
			   {
			    return "音频文件(*.mp3)";
			   }
			   if(ext.equals("mp4"))
			   {
			    return "视频文件(*.mp4)";
			   }
			   
			   return "文件选择有误";
			}
		}
	}



