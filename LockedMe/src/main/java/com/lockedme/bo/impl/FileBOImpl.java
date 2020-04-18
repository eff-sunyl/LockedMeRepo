package com.lockedme.bo.impl;
import com.lockedme.bo.FileBO;
import com.lockedme.exception.LockedmeException;
import com.lockedme.model.FileObject;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Scanner;
import com.lockedme.bo.impl.FileBOComparator;

public class FileBOImpl implements FileBO {
	
	private static String abspath=new File("").getAbsolutePath();
	
	
	public static void displayAddFile(Scanner in) throws LockedmeException
	{
		System.out.println("-------------------------File Operations Menu----------------------------");
		System.out.println("You are in Add a file to the main directory option");	
		System.out.println("Enter the name of the file to be created");		
		FileObject fo1=new FileObject(in.nextLine().toLowerCase());
		new FileBOImpl().addFile(fo1,in);
		
	}
	public static void displayDelFile(Scanner in1) throws LockedmeException
	{
		System.out.println("-------------------------File Operations Menu----------------------------");
		System.out.println("Delete a user specified file from the main directory option");	
		System.out.println("Enter the name of the file to be deleted");		
		FileObject fo2=new FileObject(in1.nextLine());
		new FileBOImpl().delFile(fo2,in1);
		
	}
	public static void displaySearchFile(Scanner in1) throws LockedmeException
	{
		System.out.println("-------------------------File Operations Menu----------------------------");
		System.out.println("Search a user specified file from the main directory option");	
		System.out.println("Enter the name of the file to be searched");		
		FileObject fo2=new FileObject(in1.nextLine());
		new FileBOImpl().searchFile(fo2);

		
	}
	
	
	public FileObject addFile(FileObject fo,Scanner in) throws LockedmeException
	{
		//FileObject.
		if((fo==null) || (fo.getFname().isEmpty()))
		{
			throw new LockedmeException("File Object can not be null (or) File name can not be empty");
		}
		else {
		//System.out.println("--add file--");
		File nf= new File(abspath+"/"+fo.getFname());
		boolean b=false;
		try {
			b=nf.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b==false)
		{
			throw new LockedmeException("File name already in use "+fo.getFname()+". Try with a different file name.");
		}
		else
		{
			System.out.println(fo.getFname()+" has been created successfully");
		}
		System.out.println("Do you want to write content to file "+fo.getFname()+"? Type (yes / no) or (y / n)");
		String s=in.nextLine();
		if((s.equalsIgnoreCase("yes"))|| (s.equalsIgnoreCase("y")))
		{
			System.out.println("Enter the contents of the file ");
			System.out.println("Pl type in the console and do not copy / paste");
		    try {
				FileWriter fw= new FileWriter(fo.getFname(),true);
				BufferedWriter bw=new BufferedWriter(fw);
				bw.write(in.nextLine());
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    finally {
		    	System.out.println("You have successfully added content to your file");
		    }
		
		}
		else
		{
		    System.out.println("This file is not saved. ");	
		    System.out.println("Try again from the File operations menu");
		    nf.delete();
			return fo;
		}//File nf=new File()
	   	return fo;
		}
	}
	public FileObject delFile(FileObject fo,Scanner in) throws LockedmeException
	{
		if((fo==null) || (fo.getFname().isEmpty()))
		{
			throw new LockedmeException("File Object can not be null (or) File name can not be empty");
		}
		else
		{
		File nf= new File(abspath+"/"+fo.getFname());
		boolean nfb=false;
		nfb=nf.exists();
		if(nfb==true)
		{
			System.out.println("Found File: " +fo.getFname());
			nf.delete();
			System.out.println("You have deleted the file " +fo.getFname());
			
		}
		else
		{
			System.out.println("File '"+fo.getFname()+"' not found in "+abspath);
			System.out.println("Try again from the File operations menu");
		}
		
		return fo;
	}
	}
	public FileObject searchFile(FileObject fo) throws LockedmeException
	{
		if(fo==null)
		{
			throw new LockedmeException("File object can not be null");
		}
		else {
		//File nf= new File(abspath+"/"+fo.getFname());
		File nf= new File(abspath);
		ArrayList<String> ls=new ArrayList<String>();
		for(int lsk=0;lsk<nf.list().length;lsk++)
		{
			ls.add(nf.list()[lsk]);
		}
		Collections.sort(ls);
		int bs=Collections.binarySearch(ls, fo.getFname().toString());
		//System.out.println(ls);
		//System.out.println("bs:"+bs);
		if (bs>0)
			System.out.println("File " +fo.getFname()+" is found");
		//boolean nfb=false;
		//nfb=nf.exists();
/*		if(nfb)
		{
			
			System.out.println("File " +fo.getFname()+" is found");

			
		}*/

		else
		{
			//System.out.println("File "+fo.getFname()+" not found in "+abspath);
			System.out.println("Try again from the File operations menu");
			throw new LockedmeException("File "+fo.getFname()+" not found in "+abspath);
			
		}
		
		return fo;
		}
	}
	public List<FileObject> getListofFiles() throws LockedmeException
	{
		List<FileObject> l=new ArrayList<FileObject>();
		File nf= new File(abspath);	
		
		//System.out.println(nf.listFiles().length);
		for(int i=0;i<nf.list().length;i++)
		{
			FileObject fo1=new FileObject(nf.list()[i].toString());
			//System.out.println(nf.listFiles()[i].toString());
			l.add(fo1);
			//l.add(nf.listFiles()[i]);
		}
		//System.out.println(l);
		System.out.println("List of files in an Ascending order, found in "+abspath);
		Collections.sort(l,new FileBOComparator());
		
		for(FileObject e: l)
		{
			
			System.out.println(e.getFname());
		}

		
		return l;
	}
	public static void displayListFile() throws LockedmeException
	{
		System.out.println("-------------------------LockedMe.com main menu----------------------------");		
		
		new FileBOImpl().getListofFiles();
		
	}

	}
