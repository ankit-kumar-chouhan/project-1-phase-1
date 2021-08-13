

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeMain 
{
	static final String folderpath="C:\\Users\\mkckh\\eclipse-workspace\\VirtualKeyRepository\\main";

	public static void main(String[] args) 
	{
		int proceed=1;
		do {
		Scanner obj=new Scanner(System.in);
		int ch;
		
		//menu
		displayMenu();
		System.out.println("Enter your choice:");
		ch =Integer.parseInt(obj.nextLine());
		
		switch(ch)
		{
		case 1 : getAllFiles();
		            break;
		case 2 : createFiles();
		            break;
		case 3 : deleteFile();
		            break;
		case 4 : searchFile();
		            break;
		case 5 : System.exit(0);
		            break;
		default : System.out.println("Invalid Option");
		            break;
		            
		}
		
		}while(proceed>0);
		
		
	}
	public static void displayMenu()
	{
		// variable declaration
				System.out.println("*****************************************************************");
				System.out.println("           LockedMe.com                    Ankit");
				System.out.println("*****************************************************************");
				System.out.println("1. Display all files");
				System.out.println("2. Add new file");
				System.out.println("3. Delete file");
				System.out.println("4. Search file");
				System.out.println("5. Exit");
				System.out.println("*****************************************************************");
	}
	public static void getAllFiles()
	{
		List<String> fileNames =FileManager.getAllFiles(folderpath);
		
		for(String f:fileNames)
			System.out.println(f);
	}
	public static void createFiles()
	{
		
		//variable declaration
		Scanner obj = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();
		
		//read file name from user
		System.out.println("Enter the file Name:");
		fileName=obj.nextLine();
		
		//read number of lines from user
		System.out.println("Enter how many line in file:");
		linesCount =Integer.parseInt(obj.nextLine());
		
		//read lines from user
		for(int i=1;i<=linesCount;i++)
		{
			System.out.println("Enter line "+i+":");
			content.add(obj.nextLine());
			
		}
		//save content into file
		boolean isSaved = FileManager.createFiles(folderpath, fileName, content);
		
		if(isSaved)
			System.out.println("file and data saved successfully");
		else
			System.out.println("error occured");
		//obj.close();
	}
	public static void deleteFile()
	{
		
		//code for deleting file
		String fileName;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter file to delete");
		fileName =obj.nextLine();
		
		boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
		
		if(isDeleted)
			System.out.println("file deleted successfully");
		else
			System.out.println("file not found or some issue");
		//obj.close();
	}
	public static void searchFile()
	{
		
		//code for deleting file
		String fileName;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter file to search");
		fileName =obj.nextLine();
				
		boolean isFound = FileManager.searchFile(folderpath, fileName);
				
		if(isFound)
			System.out.println("file is present");
		else
			System.out.println("file not found ");
		//obj.close();
	}
		

}
