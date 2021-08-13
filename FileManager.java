

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager 
{
	/**
	 * This method will return file names from folder
	 * @param folderpath
	 * @return List<String>
	 */
	public static List<String> getAllFiles(String folderpath)
	{
		//creating file object
		File fl=new File(folderpath);
		
		//getting all files into file array
		File[] listOfFiles=fl.listFiles();
		
		//declare list to store file names
		List<String> fileNames =new ArrayList<String>();
		
		for(File f:listOfFiles)
			fileNames.add(f.getName());
			
			//return the list
		return fileNames;
		
	}
	/**
	 * This method will create or append content into the file specified
	 * @param folderpath
	 * @param fileName
	 * @param content
	 * @return boolean
	 */
	
	public static boolean createFiles(String folderpath,String fileName,List<String> content)
	{
		try
		{
			File fl=new File(folderpath,fileName);
			FileWriter fw=new FileWriter(fl);
			
			for(String s:content)
			{
				fw.write(s+"\n");
			}
			fw.close();
			return true;
				
		}
		catch(Exception Ex)
		{
			return false;
		}
	}
	
	/**
	 * This method to delete file
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean deleteFile(String folderpath,String fileName)
	{
		//creating file object
		File file= new File(folderpath+"\\"+fileName);
		try
		{
			if(file.delete())
				return true;
			else
				return false;
		}
		catch(Exception Ex)
		{
			return false;
		}
	}
		
		/**
		 * This method helps to search file
		 * @param folderpath
		 * @param fileName
		 * @return boolean
		 */
		public static boolean searchFile(String folderpath,String fileName)
		{
			//creating file object
			File file= new File(folderpath+"\\"+fileName);
			
				if(file.exists())
					return true;
				else
					return false;
			
		}
	

}
